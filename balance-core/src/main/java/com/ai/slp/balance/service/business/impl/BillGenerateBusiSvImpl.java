package com.ai.slp.balance.service.business.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.api.translatorbill.param.*;
import com.ai.slp.balance.dao.mapper.bo.TAccountParam;
import com.ai.slp.balance.dao.mapper.bo.TAccountParamCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IBillGenerateAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountDetailAtomSV;
import com.ai.slp.balance.service.business.interfaces.IBillGenerateBusiSV;
import com.ai.slp.balance.util.DubboUtil;
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
        criteria.andAccountClsEqualTo(param);
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
            //结算时间
            String endDate = addMonth(begindate, accountPeriod)+" 23:59:59";
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
            Long billFee = 0l;
            for (int j = 0;j<orderVos.size();j++){
                boolean b = inTime(begindate, endDate, orderVos.get(j).getFinishTime());
                if (b){
                    //计算账单金额
                    billFee+=orderVos.get(i).getTotalFee();
                    try {
                        //将全部订单的数据汇总插入到结算账单信息表（FUN_ACCOUNT）
                        String billID = billGenerateAtomSV.insertAccount(orderVos.get(j), tAccountParams.get(i), billFee, begindate, endDate);
                        //订单ID查询订单中心的搜索引擎获取到每个订单的信息，插入到账单明细表
                        billGenerateAtomSV.insertAccountDetail(orderVos.get(j),billID);
                    } catch (Exception e) {
                        System.out.println("出错：" + e.getMessage());
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
