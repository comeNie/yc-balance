package com.ai.slp.balance.service.business.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseListResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.translatorbill.param.*;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.TAccountParam;
import com.ai.slp.balance.dao.mapper.bo.TAccountParamCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IBillGenerateAtomSV;
import com.ai.slp.balance.service.business.interfaces.IBillGenerateBusiSV;
import com.ai.slp.balance.util.DubboUtil;
import com.ai.yc.order.api.orderallocation.interfaces.IOrderAllocationSV;
import com.ai.yc.order.api.orderallocation.param.OrdAlloInterperFeeInfoResponse;
import com.ai.yc.order.api.orderallocation.param.OrdAlloInterperFeeRequest;

import com.ai.yc.order.api.orderquery.interfaces.IOrderQuerySV;
import com.ai.yc.order.api.orderquery.param.OrdOrderVo;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRsponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by liquid on 17/2/17.
 */
@Service
@Transactional
public class BillGenerateBusiSvImpl implements IBillGenerateBusiSV {
    private static final Logger LOG = LogManager.getLogger(BillGenerateBusiSvImpl.class);
    private static final IOrderQuerySV iOrderQuerySV = DubboUtil.getIOrderQuerySV();
    private static final IOrderAllocationSV iOrderAllocationSV = DubboUtil.getIOrderAllocationSV();
    /*@Autowired
    private IFunAccountDetailAtomSV funAccountDetailAtomSV;
    @Autowired
    private IFunAccountAtomSV funAccountAtomSV;*/

    @Autowired
    private IBillGenerateAtomSV billGenerateAtomSV;
    @Override
    public Boolean BillGenerate(String param) throws BusinessException, SystemException {

        TAccountParamCriteria example = new TAccountParamCriteria();
        TAccountParamCriteria.Criteria criteria = example.createCriteria();
        criteria.andTargetTypeEqualTo(param);
        List<TAccountParam> tAccountParams = MapperFactory.getTAccountParamMapper().selectByExample(example);
        for (int i = 0;i<tAccountParams.size();i++){
            AccountParamVo accountParamVo = new AccountParamVo();
            accountParamVo.setTarget_Id(tAccountParams.get(i).getTargetId());
            Date today = new Date();
            //计算出上个月日期
            int year;
            int lastMonth = today.getMonth();
            if (lastMonth==0){
                year = today.getYear()-1;
                lastMonth = 12;
            }else {
                year = today.getYear()+1900;
            }
            //结算日
            String day = tAccountParams.get(i).getAccountDay();
            //上个月的结算日期(开始时间)
            String begindate = year+"-"+lastMonth+"-"+day+" 00:00:00";
            //取出结算周期
            int accountPeriod = Integer.parseInt(tAccountParams.get(i).getAccountPeriod());
            Integer tempday = Integer.parseInt(day)-1;
            String temDate = year+"-"+lastMonth+"-"+tempday+" 00:00:00";
            //结算时间
            String endDate = addMonth(temDate, accountPeriod)+" 23:59:59";
            //统计每个译员（INTERPER_ID为结算目标ID）已完成的订单（STATE＝‘90’），完成时间（FINISH_TIME）在结算周期内全部的订单
            QueryOrderRequest queryOrderRequest = new QueryOrderRequest();
            queryOrderRequest.setInterperId(tAccountParams.get(i).getTargetId());
            queryOrderRequest.setState("90");
            queryOrderRequest.setPageNo(1);
            queryOrderRequest.setPageSize(10);
            QueryOrderRsponse queryOrderRsponse1 = iOrderQuerySV.queryOrder(queryOrderRequest);
            int count = queryOrderRsponse1.getPageInfo().getCount();
            queryOrderRequest.setPageSize(count);
            QueryOrderRsponse queryOrderRsponse = iOrderQuerySV.queryOrder(queryOrderRequest);
            List<OrdOrderVo> orderVos = queryOrderRsponse.getPageInfo().getResult();
            //国内账单flag=0
            List<OrdOrderVo> orderVos0 = new ArrayList<>();
            //国外账单flag=1
            List<OrdOrderVo> orderVos1 = new ArrayList<>();
            for (OrdOrderVo orderVo:orderVos){
                if (orderVo.getFlag().equals("0")){
                    orderVos0.add(orderVo);
                }
                if (orderVo.getFlag().equals("1")){
                    orderVos1.add(orderVo);
                }
            }
            if (orderVos0.size()>0){
                Long billFee0 = 0l;
                Long accountAmount0 = 0l;
                Long platFee0 = 0l;
                Long discountFee0 = 0l;
                for (int j = 0;j<orderVos0.size();j++){
                    boolean b = inTime(begindate, endDate, orderVos0.get(j).getFinishTime());
                    if (b){
                        //计算账单金额
                        billFee0+=orderVos0.get(j).getTotalFee();
                        //计算应结金额(译员佣金)
                        accountAmount0+=orderVos0.get(j).getInterperFee();
                        //平台佣金
                        platFee0 += orderVos0.get(j).getPlatFee();
                        //优惠金额
                        discountFee0+=orderVos0.get(j).getDiscountFee();
                    }
                }
                //译员账单(targetType=3)   lsp账单(targetType=4)
                if (param=="3"){
                    //将全部订单的数据汇总插入到结算账单信息表（FUN_ACCOUNT）
                    String billID = billGenerateAtomSV.insertAccount(orderVos0.get(0), tAccountParams.get(i), billFee0,accountAmount0,platFee0, begindate, endDate);
                    for (int j = 0;j<orderVos0.size();j++){
                        boolean b = inTime(begindate, endDate, orderVos0.get(j).getFinishTime());
                        if (b){
                            //订单ID查询订单中心的搜索引擎获取到每个订单的信息，插入到账单明细表
                            billGenerateAtomSV.insertAccountDetail(orderVos0.get(j),billID);
                        }
                    }

                }else if (param=="4"){
                    //lsp译员支出账单中的
                    Long translatorFee = 0l;
                    for (OrdOrderVo orderVo:orderVos0){
                        OrdAlloInterperFeeRequest ordAlloInterperFeeRequest = new OrdAlloInterperFeeRequest();
                        ordAlloInterperFeeRequest.setOrderId(orderVo.getOrderId());
                        OrdAlloInterperFeeInfoResponse ordAlloInterperFeeInfoResponse = iOrderAllocationSV.queryAlloInterperFee(ordAlloInterperFeeRequest);
                        if (ordAlloInterperFeeInfoResponse!=null&&ordAlloInterperFeeInfoResponse.getResponseHeader().getResultCode().equals("000000")){
                            long interperFee = ordAlloInterperFeeInfoResponse.getInterperFee();
                            translatorFee+=interperFee;
                        }
                    }
                    Long accountAmount = billFee0-platFee0-translatorFee;
                    String billID = billGenerateAtomSV.insertAccountLsp(orderVos0.get(0), tAccountParams.get(i), accountAmount, billFee0, translatorFee, platFee0, begindate, endDate);
                    for (int j = 0;j<orderVos0.size();j++){
                        boolean b = inTime(begindate, endDate, orderVos0.get(j).getFinishTime());
                        if (b){
                            //lsp译员支出
                            Long translatorFeeDetail = 0l;
                            OrdAlloInterperFeeRequest ordAlloInterperFeeRequest = new OrdAlloInterperFeeRequest();
                            ordAlloInterperFeeRequest.setOrderId(orderVos0.get(j).getOrderId());
                            OrdAlloInterperFeeInfoResponse ordAlloInterperFeeInfoResponse = iOrderAllocationSV.queryAlloInterperFee(ordAlloInterperFeeRequest);
                            if (ordAlloInterperFeeInfoResponse!=null&&ordAlloInterperFeeInfoResponse.getResponseHeader().getResultCode().equals("000000")){
                                translatorFeeDetail = ordAlloInterperFeeInfoResponse.getInterperFee();
                            }
                            //lsp结余 = 订单金额-译员支出-平台佣金
                            Long lspFee = orderVos0.get(j).getTotalFee()-orderVos0.get(j).getPlatFee()-translatorFeeDetail;
                            //订单ID查询订单中心的搜索引擎获取到每个订单的信息，插入到账单明细表
                            billGenerateAtomSV.insertAccountLspDetail(orderVos0.get(0),billID,translatorFeeDetail,lspFee);
                        }
                    }
                }//企业账单
                else if (param=="1"){
                    Long accountAmountCompany = billFee0-discountFee0;
                    String billID = billGenerateAtomSV.insertCompanyAccount(orderVos0.get(0), tAccountParams.get(i), billFee0,accountAmountCompany,discountFee0, begindate, endDate);
                    for (int j = 0;j<orderVos0.size();j++){
                        boolean b = inTime(begindate, endDate, orderVos0.get(j).getFinishTime());
                        if (b){
                            //订单ID查询订单中心的搜索引擎获取到每个订单的信息，插入到账单明细表
                            billGenerateAtomSV.insertAccountDetail(orderVos0.get(j),billID);
                        }
                    }
                }
            }
            if (orderVos1.size()>0){
                Long billFee1 = 0l;
                Long accountAmount1 = 0l;
                Long platFee1 = 0l;
                Long discountFee1 = 0l;
                for (int j = 0;j<orderVos1.size();j++){
                    boolean b = inTime(begindate, endDate, orderVos1.get(j).getFinishTime());
                    if (b){
                        //计算账单金额
                        billFee1+=orderVos1.get(i).getTotalFee();
                        //计算应结金额(译员佣金)
                        accountAmount1+=orderVos1.get(i).getInterperFee();
                        //平台佣金
                        platFee1 += orderVos1.get(i).getPlatFee();
                        discountFee1+=orderVos1.get(j).getDiscountFee();
                    }
                }
                //译员账单(targetType=3)   lsp账单(targetType=4)
                if (param=="3"){
                    //将全部订单的数据汇总插入到结算账单信息表（FUN_ACCOUNT）
                    String billID = billGenerateAtomSV.insertAccount(orderVos1.get(0), tAccountParams.get(i), billFee1,accountAmount1,platFee1, begindate, endDate);
                    for (int j = 0;j<orderVos0.size();j++){
                        boolean b = inTime(begindate, endDate, orderVos1.get(j).getFinishTime());
                        if (b){
                            //订单ID查询订单中心的搜索引擎获取到每个订单的信息，插入到账单明细表
                            billGenerateAtomSV.insertAccountDetail(orderVos1.get(j),billID);
                        }
                    }

                }else if (param=="4"){
                    //lsp译员支出账单中的
                    Long translatorFee = 0l;
                    for (OrdOrderVo orderVo:orderVos1){
                        OrdAlloInterperFeeRequest ordAlloInterperFeeRequest = new OrdAlloInterperFeeRequest();
                        ordAlloInterperFeeRequest.setOrderId(orderVo.getOrderId());
                        OrdAlloInterperFeeInfoResponse ordAlloInterperFeeInfoResponse = iOrderAllocationSV.queryAlloInterperFee(ordAlloInterperFeeRequest);
                        if (ordAlloInterperFeeInfoResponse!=null&&ordAlloInterperFeeInfoResponse.getResponseHeader().getResultCode().equals("000000")){
                            long interperFee = ordAlloInterperFeeInfoResponse.getInterperFee();
                            translatorFee+=interperFee;
                        }
                    }
                    Long accountAmount = billFee1-platFee1-translatorFee;
                    String billID = billGenerateAtomSV.insertAccountLsp(orderVos1.get(0), tAccountParams.get(i), accountAmount, billFee1, translatorFee, platFee1, begindate, endDate);
                    for (int j = 0;j<orderVos1.size();j++){
                        boolean b = inTime(begindate, endDate, orderVos1.get(j).getFinishTime());
                        if (b){
                            //lsp译员支出
                            Long translatorFeeDetail = 0l;
                            OrdAlloInterperFeeRequest ordAlloInterperFeeRequest = new OrdAlloInterperFeeRequest();
                            ordAlloInterperFeeRequest.setOrderId(orderVos1.get(j).getOrderId());
                            OrdAlloInterperFeeInfoResponse ordAlloInterperFeeInfoResponse = iOrderAllocationSV.queryAlloInterperFee(ordAlloInterperFeeRequest);
                            if (ordAlloInterperFeeInfoResponse!=null&&ordAlloInterperFeeInfoResponse.getResponseHeader().getResultCode().equals("000000")){
                                translatorFeeDetail = ordAlloInterperFeeInfoResponse.getInterperFee();
                            }
                            //lsp结余 = 订单金额-译员支出-平台佣金
                            Long lspFee = orderVos1.get(j).getTotalFee()-orderVos1.get(j).getPlatFee()-translatorFeeDetail;
                            //订单ID查询订单中心的搜索引擎获取到每个订单的信息，插入到账单明细表
                            billGenerateAtomSV.insertAccountLspDetail(orderVos1.get(0),billID,translatorFeeDetail,lspFee);
                        }
                    }
                } else if (param=="1"){
                    Long accountAmountCompany1 = billFee1-discountFee1;
                    String billID = billGenerateAtomSV.insertCompanyAccount(orderVos1.get(0), tAccountParams.get(i), billFee1,accountAmountCompany1,discountFee1, begindate, endDate);
                    for (int j = 0;j<orderVos1.size();j++){
                        boolean b = inTime(begindate, endDate, orderVos1.get(j).getFinishTime());
                        if (b){
                            //订单ID查询订单中心的搜索引擎获取到每个订单的信息，插入到账单明细表
                            billGenerateAtomSV.insertAccountDetail(orderVos1.get(j),billID);
                        }
                    }
                }
            }

        }
        return true;
    }

    private static String addMonth(String s, int n) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar cd = Calendar.getInstance();
            cd.setTime(sdf.parse(s));
            cd.add(Calendar.MONTH, n);//增加一个月

            return sdf.format(cd.getTime());

        } catch (Exception e) {
            return null;
        }
    }
    //比较订单完成时间是否在结算周期内
    private static boolean inTime(String beginTime,String endTime,Timestamp finishTime){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        Timestamp tbeginTime = Timestamp.valueOf(beginTime);
        long btime = tbeginTime.getTime();
        Timestamp tendTime = Timestamp.valueOf(endTime);
        long etime = tendTime.getTime();
        long lfinshTime = finishTime.getTime();
        if (lfinshTime>=btime&&lfinshTime<=etime){
            return true;
        }
        return false;
    }

    @Override
    public String insertParam(AccountParam accountParam) throws BusinessException, SystemException {
        String id = null;
        try {
            id = billGenerateAtomSV.insertParam(accountParam);
        }catch (Exception  e){
            throw new SystemException(ExceptCodeConstants.Special.PARAM_IS_NULL,"0004-配置失败");
        }
        return id;
    }

    @Override
    public PageInfo<FunAccountResponse> funAccountQuery(FunAccountQueryRequest funAccountQueryRequest) {

        PageInfo<FunAccountResponse> funAccountResponsePageInfo = billGenerateAtomSV.funAccountQuery(funAccountQueryRequest);

        return funAccountResponsePageInfo;
    }

    @Override
    public PageInfo<FunAccountDetailResponse> queryFunAccountDetail(FunAccountDetailQueryRequest param) throws BusinessException, SystemException {
        return billGenerateAtomSV.queryFunAccountDetail(param);
    }

    @Override
    public String settleBill(SettleParam param) throws BusinessException, SystemException {

        return billGenerateAtomSV.settleBill(param);
    }
}
