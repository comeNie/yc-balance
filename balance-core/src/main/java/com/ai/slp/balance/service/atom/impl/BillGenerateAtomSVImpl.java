package com.ai.slp.balance.service.atom.impl;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.translatorbill.param.*;
import com.ai.slp.balance.constants.SeqConstants;
import com.ai.slp.balance.dao.mapper.bo.*;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunAccountDetailMapper;
import com.ai.slp.balance.dao.mapper.interfaces.FunAccountMapper;
import com.ai.slp.balance.dao.mapper.interfaces.TAccountParamMapper;
import com.ai.slp.balance.service.atom.interfaces.IBillGenerateAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountDetailAtomSV;
import com.ai.slp.balance.util.DubboUtil;
import com.ai.yc.order.api.orderquery.interfaces.IOrderQuerySV;
import com.ai.yc.order.api.orderquery.param.OrdOrderVo;
import com.ai.yc.order.api.orderquery.param.OrdProdExtendVo;
import com.ai.yc.order.api.orderquery.param.QueryOrderRequest;
import com.ai.yc.order.api.orderquery.param.QueryOrderRsponse;
import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by liquid on 17/2/17.
 */
@Component
public class BillGenerateAtomSVImpl implements IBillGenerateAtomSV {
    private static final Logger log = LogManager.getLogger(BillGenerateAtomSVImpl.class);
    private static final IOrderQuerySV iOrderQuerySV = DubboUtil.getIOrderQuerySV();

    @Autowired
    private IFunAccountDetailAtomSV funAccountDetailAtomSV;
    @Autowired
    private IFunAccountAtomSV funAccountAtomSV;
   /* @Override
    public Boolean queryAccountParamByACCOUNT_CLS(String param) throws BusinessException, SystemException {
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
                        String billID = insertAccount(orderVos.get(j), tAccountParams.get(i), billFee, begindate, endDate);
                        //订单ID查询订单中心的搜索引擎获取到每个订单的信息，插入到账单明细表
                        insertAccountDetail(orderVos.get(j),billID);
                    } catch (Exception e) {
                        System.out.println("出错：" + e.getMessage());
                    }
                }
            }
        }
        return true;
    }*/
   //订单ID查询订单中心的搜索引擎获取到每个订单的信息，插入到账单明细表（FUN_ACCOUNT_DETAIL ）
   public  void insertAccountLspDetail(OrdOrderVo ordOrderVo,String billId,long translatorFeeDetail,long lspFee) {
       FunAccountDetail funAccountDetail = new FunAccountDetail();
       //订单状态
       funAccountDetail.setDetailId(SeqUtil.getNewId(SeqConstants.FUN_ACCOUNT_DETAIL$DETAIL_ID).toString());
       funAccountDetail.setState(ordOrderVo.getState());
       //账单id
       funAccountDetail.setBillId(billId);
       //lsp译员佣金
       funAccountDetail.setTranslatorFee(translatorFeeDetail);
       //LSP结余
       funAccountDetail.setLspFee(lspFee);
       //下单昵称(用户中心)
       funAccountDetail.setNickname(ordOrderVo.getUserName());
       //译员昵称
       funAccountDetail.setNickname2(ordOrderVo.getInterperName());
       //LSP团队
       funAccountDetail.setLspId(ordOrderVo.getLspId());

       //订单编号
       funAccountDetail.setOrderId(ordOrderVo.getOrderId()+"");
       //下单时间
       funAccountDetail.setOrderTime(ordOrderVo.getOrderTime());
       //语言方向(语言对 list)
       String langungePairName="";
       List<OrdProdExtendVo> ordProdExtendList = ordOrderVo.getOrdProdExtendList();
       if (ordOrderVo.getCurrencyUnit().equals("1")){
           for (OrdProdExtendVo ordProdExtendVo: ordProdExtendList) {
               langungePairName = langungePairName + ordProdExtendVo.getLangungePairChName();
           }
       }else {{
           for (OrdProdExtendVo ordProdExtendVo: ordProdExtendList) {
               langungePairName = langungePairName + ordProdExtendVo.getLangungePairEnName();
           }
       }}

       funAccountDetail.setLangungePairName(langungePairName);
//        //币种
       funAccountDetail.setCurrencyUnit(ordOrderVo.getCurrencyUnit());
       //订单金额
       funAccountDetail.setTotalFee(ordOrderVo.getTotalFee());
       //平台佣金
       funAccountDetail.setPlatFee(ordOrderVo.getPlatFee());
       funAccountDetailAtomSV.insertFunAccountFundDetail(funAccountDetail);
   }

    //订单ID查询订单中心的搜索引擎获取到每个订单的信息，插入到账单明细表（FUN_ACCOUNT_DETAIL ）
    public  void insertAccountDetail(OrdOrderVo ordOrderVo,String billId){
        FunAccountDetail funAccountDetail = new FunAccountDetail();
        //订单状态
        funAccountDetail.setDetailId(SeqUtil.getNewId(SeqConstants.FUN_ACCOUNT_DETAIL$DETAIL_ID).toString());
        funAccountDetail.setState(ordOrderVo.getState());
        //账单id
        funAccountDetail.setBillId(billId);
        //译员佣金
        funAccountDetail.setInterperFee(ordOrderVo.getInterperFee());
        //下单昵称(用户中心)
        funAccountDetail.setNickname(ordOrderVo.getUserName());
        //译员昵称
        funAccountDetail.setNickname2(ordOrderVo.getInterperName());
        //LSP团队
        funAccountDetail.setLspId(ordOrderVo.getLspId());

        //订单编号
        funAccountDetail.setOrderId(ordOrderVo.getOrderId()+"");
        //下单时间
        funAccountDetail.setOrderTime(ordOrderVo.getOrderTime());
        //语言方向(语言对 list)
        String langungePairName="";
        List<OrdProdExtendVo> ordProdExtendList = ordOrderVo.getOrdProdExtendList();
        if (ordOrderVo.getCurrencyUnit().equals("1")){
            for (OrdProdExtendVo ordProdExtendVo: ordProdExtendList) {
                langungePairName = langungePairName + ordProdExtendVo.getLangungePairChName();
            }
        }else {{
            for (OrdProdExtendVo ordProdExtendVo: ordProdExtendList) {
                langungePairName = langungePairName + ordProdExtendVo.getLangungePairEnName();
            }
        }}

        funAccountDetail.setDiscountFee(ordOrderVo.getDiscountFee());

        funAccountDetail.setLangungePairName(langungePairName);
//        //币种
        funAccountDetail.setCurrencyUnit(ordOrderVo.getCurrencyUnit());
        //订单金额
        funAccountDetail.setTotalFee(ordOrderVo.getTotalFee());
        //平台佣金
        funAccountDetail.setPlatFee(ordOrderVo.getPlatFee());
        funAccountDetailAtomSV.insertFunAccountFundDetail(funAccountDetail);
    }


    //将全部订单的数据汇总插入到结算账单信息表（FUN_ACCOUNT)  企业账单
    public  String insertCompanyAccount(OrdOrderVo ordOrderVo,TAccountParam tAccountParam,long billFee,long accountAmount0,long discountFee,
                                 String beginTime,String endTime){
        FunAccount funAccount = new FunAccount();
        String billID = SeqUtil.getNewId(SeqConstants.FUN_ACCOUNT$BILL_ID).toString();
        funAccount.setBillId(billID);
        //结算金额(结算账单的时候再填充)
        funAccount.setAccountAmout(accountAmount0);
        //优惠金额
        funAccount.setDiscountFee(discountFee);
        //结算账单类型 1，客户；2，译员；3、LSP；
        funAccount.setAccountCls(tAccountParam.getAccountCls());
        //结算周期（月)
        funAccount.setAccountPeriod(tAccountParam.getAccountPeriod());
        //结算日
        funAccount.setAccountPeriodDay(tAccountParam.getAccountDay());
        //结算目标类型
        funAccount.setTargetType(tAccountParam.getTargetType());
        //本期账单金额
        funAccount.setBillFee(billFee);
        //账单生成时间
        funAccount.setCreateTime(DateUtil.getSysDate());
        //LSP管理员
        funAccount.setLspAdmin(ordOrderVo.getLspName());
        //本周期开始时间
        funAccount.setStartAccountTime(Timestamp.valueOf(beginTime));
        //本周期结束时间
        funAccount.setEndAccountTime(Timestamp.valueOf(endTime));
        //结算状态(1:为=未结算)
        funAccount.setState(1);
        //业务标识
        funAccount.setFlag(ordOrderVo.getFlag());
        //展示页显示名(译员昵称)
        funAccount.setNickname(ordOrderVo.getInterperName());
        //应结算时间(本周期结束时间+1天)
        funAccount.setPlanAccountTime(Timestamp.valueOf(addDay(endTime,1)+" 23:59:59"));
        //用户ID
        funAccount.setTargetId(ordOrderVo.getUserId());
        //用户名称
        funAccount.setTargetName(ordOrderVo.getUserName());
        funAccountAtomSV.insertFunAccountFund(funAccount);
        return funAccount.getBillId();
    }

    //将全部订单的数据汇总插入到结算账单信息表（FUN_ACCOUNT)
    public  String insertAccount(OrdOrderVo ordOrderVo,TAccountParam tAccountParam,long billFee,long accountAmount0,long platFee0,
                                      String beginTime,String endTime){
        FunAccount funAccount = new FunAccount();
        String billID = SeqUtil.getNewId(SeqConstants.FUN_ACCOUNT$BILL_ID).toString();
        funAccount.setBillId(billID);
        //结算金额(结算账单的时候再填充)
        funAccount.setAccountAmout(accountAmount0);
        //结算账单类型 1，客户；2，译员；3、LSP；
        funAccount.setAccountCls(tAccountParam.getAccountCls());
        //结算周期（月)
        funAccount.setAccountPeriod(tAccountParam.getAccountPeriod());
        //结算日
        funAccount.setAccountPeriodDay(tAccountParam.getAccountDay());
        //结算目标类型
        funAccount.setTargetType(tAccountParam.getTargetType());
        //实际结算时间,结算账单的时候再填充
//        funAccount.setActAccountTime(DateUtil.getSysDate());
        //本期账单金额
        funAccount.setBillFee(billFee);
        //平台佣金(订单获取)
        funAccount.setPlatFee(platFee0);
        //账单生成时间
        funAccount.setCreateTime(DateUtil.getSysDate());
        //LSP管理员
        funAccount.setLspAdmin(ordOrderVo.getLspName());
        //本周期开始时间
        funAccount.setStartAccountTime(Timestamp.valueOf(beginTime));
        //本周期结束时间
        funAccount.setEndAccountTime(Timestamp.valueOf(endTime));
        //结算方式,支付宝,微信等(结算的时候再填充)
//        funAccount.setAccountType();
        //结算状态(1:为=未结算)
        funAccount.setState(1);
        /*//结算账户结算的时候沉淀
        funAccount.setSettleAccount();*/
        /*//备注(写什么)结算的时候沉淀
        funAccount.setContent();*/
        //业务标识
        funAccount.setFlag(ordOrderVo.getFlag());
        //展示页显示名(译员昵称)
        funAccount.setNickname(ordOrderVo.getInterperName());
        //应结算时间(本周期结束时间+1天)
        funAccount.setPlanAccountTime(Timestamp.valueOf(addDay(endTime,1)+" 23:59:59"));
        //用户ID
        funAccount.setTargetId(ordOrderVo.getUserId());
        //用户名称
        funAccount.setTargetName(ordOrderVo.getUserName());
        int i = funAccountAtomSV.insertFunAccountFund(funAccount);
        return funAccount.getBillId();
    }
    //将全部订单的数据汇总插入到结算账单信息表（FUN_ACCOUNT)
    public  String insertAccountLsp(OrdOrderVo ordOrderVo,TAccountParam tAccountParam,long accountAmount0,long billFee,long translatorFee,long platFee0,
                                 String beginTime,String endTime){
        FunAccount funAccount = new FunAccount();
        String billID = SeqUtil.getNewId(SeqConstants.FUN_ACCOUNT$BILL_ID).toString();
        funAccount.setBillId(billID);
        //结算金额(结算账单的时候再填充)
        funAccount.setAccountAmout(accountAmount0);
        funAccount.setTranslatorFee(translatorFee);
        //结算账单类型 1，客户；2，译员；3、LSP；
        funAccount.setAccountCls(tAccountParam.getAccountCls());
        //结算周期（月)
        funAccount.setAccountPeriod(tAccountParam.getAccountPeriod());
        //结算日
        funAccount.setAccountPeriodDay(tAccountParam.getAccountDay());
        //结算目标类型
        funAccount.setTargetType(tAccountParam.getTargetType());
        //实际结算时间,结算账单的时候再填充
//        funAccount.setActAccountTime(DateUtil.getSysDate());
        //本期账单金额
        funAccount.setBillFee(billFee);
        //平台佣金(订单获取)
        funAccount.setPlatFee(platFee0);
        //账单生成时间
        funAccount.setCreateTime(DateUtil.getSysDate());
        //LSP管理员
        funAccount.setLspAdmin(ordOrderVo.getLspName());
        //本周期开始时间
        funAccount.setStartAccountTime(Timestamp.valueOf(beginTime));
        //本周期结束时间
        funAccount.setEndAccountTime(Timestamp.valueOf(endTime));
        //结算方式,支付宝,微信等(结算的时候再填充)
//        funAccount.setAccountType();
        //结算状态(1:为=未结算)
        funAccount.setState(1);
        /*//结算账户结算的时候沉淀
        funAccount.setSettleAccount();*/
        /*//备注(写什么)结算的时候沉淀
        funAccount.setContent();*/
        //业务标识
        funAccount.setFlag(ordOrderVo.getFlag());
        //展示页显示名(译员昵称)
        funAccount.setNickname(ordOrderVo.getInterperName());
        //应结算时间(本周期结束时间+1天)
        funAccount.setPlanAccountTime(Timestamp.valueOf(addDay(endTime,1)+" 23:59:59"));
        //用户ID
        funAccount.setTargetId(ordOrderVo.getUserId());
        //用户名称
        funAccount.setTargetName(ordOrderVo.getUserName());
        int i = funAccountAtomSV.insertFunAccountFund(funAccount);
        return funAccount.getBillId();
    }
    private static String addDay(String s, int n) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar cd = Calendar.getInstance();
            cd.setTime(sdf.parse(s));
            cd.add(Calendar.DATE, n);//增加一个月

            return sdf.format(cd.getTime());

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询账单
     * @param funAccountQueryRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    @Override
    public PageInfo<FunAccountResponse> funAccountQuery(FunAccountQueryRequest funAccountQueryRequest) throws BusinessException, SystemException {
        List<FunAccountResponse> funAccountResponses =  new ArrayList<FunAccountResponse>();;
        FunAccountCriteria funAccountCriteria = new FunAccountCriteria();
        FunAccountCriteria.Criteria criteria= funAccountCriteria.createCriteria();
        log.info("查询账单服务实现==============+"+JSON.toJSONString(funAccountQueryRequest));
        String orderByClause = "CREATE_TIME desc";
        funAccountCriteria.setOrderByClause(orderByClause);
        if (!StringUtil.isBlank(funAccountQueryRequest.getFlag())){
            criteria.andFlagEqualTo(funAccountQueryRequest.getFlag());
        }
        if (!StringUtil.isBlank(funAccountQueryRequest.getTargetType())){
            criteria.andTargetTypeEqualTo(funAccountQueryRequest.getTargetType());
        }
        if (funAccountQueryRequest.getState()!=null){
            criteria.andStateEqualTo(funAccountQueryRequest.getState());
        }
        if (!StringUtil.isBlank(funAccountQueryRequest.getLspName())){
            criteria.andLspAdminLike("%"+funAccountQueryRequest.getLspName()+"%");
        }
        if (!StringUtil.isBlank(funAccountQueryRequest.getLspAdmin())){
            criteria.andLspAdminLike("%"+funAccountQueryRequest.getLspAdmin()+"%");
        }
        if (!StringUtil.isBlank(funAccountQueryRequest.getNickName())){
            criteria.andNicknameLike("%"+funAccountQueryRequest.getNickName().trim()+"%");
        }
        if (!StringUtil.isBlank(funAccountQueryRequest.getAcountType())){
            criteria.andAccountTypeEqualTo(funAccountQueryRequest.getAcountType());
        }
        if (!(StringUtil.isBlank(funAccountQueryRequest.getBeginDate())&&StringUtil.isBlank(funAccountQueryRequest.getEndDate()))){
            criteria.andCreateTimeGreaterThanOrEqualTo(Timestamp.valueOf(funAccountQueryRequest.getBeginDate()));
            criteria.andCreateTimeLessThanOrEqualTo(Timestamp.valueOf(funAccountQueryRequest.getEndDate()));
        }
        PageInfo<FunAccountResponse> pageInfo = new PageInfo<FunAccountResponse>();
        FunAccountMapper mapper = MapperFactory.getFunAccountMapper();
        pageInfo.setCount(mapper.countByExample(funAccountCriteria));
        if (funAccountQueryRequest.getPageInfo() == null) {
            pageInfo.setPageNo(1);
            pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
        }else {
            pageInfo.setPageNo(funAccountQueryRequest.getPageInfo().getPageNo());
            pageInfo.setPageSize(funAccountQueryRequest.getPageInfo().getPageSize() == null ? 10
                    : funAccountQueryRequest.getPageInfo().getPageSize());
            funAccountCriteria.setLimitStart(funAccountQueryRequest.getPageInfo()
                    .getStartRowIndex());
            funAccountCriteria.setLimitEnd(funAccountQueryRequest.getPageInfo().getPageSize());
        }
        List<FunAccount> funAccounts = mapper.selectByExample(funAccountCriteria);
        log.info("查询账单服务实现==============+"+JSON.toJSONString(funAccounts));
        if (!CollectionUtil.isEmpty(funAccounts)){

            for (int i=0;i<funAccounts.size();i++){
                FunAccountResponse funAccountResponse = new FunAccountResponse();
                BeanUtils.copyProperties(funAccountResponse,funAccounts.get(i));
                funAccountResponses.add(funAccountResponse);
            }
        }
        pageInfo.setPageNo(pageInfo.getPageNo() == null?1:pageInfo.getPageNo());
        pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
        pageInfo.setPageCount((pageInfo.getCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize());
        pageInfo.setResult(funAccountResponses);

        return pageInfo;
    }

    /***
     * 账单明细查询
     * @param param 账单ID
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    @Override
    public PageInfo<FunAccountDetailResponse> queryFunAccountDetail(FunAccountDetailQueryRequest param) throws BusinessException, SystemException {

        List<FunAccountDetailResponse> funAccountDetaiResponses = new ArrayList<FunAccountDetailResponse>();
        FunAccountDetailCriteria funAccountDetailCriteria = new FunAccountDetailCriteria();
        FunAccountDetailCriteria.Criteria critreia = funAccountDetailCriteria.createCriteria();
        String orderByClause = "ORDER_TIME desc";
        funAccountDetailCriteria.setOrderByClause(orderByClause);
        critreia.andBillIdEqualTo(param.getBillID());
//        List<FunAccountDetail> funAccountDetails = funAccountDetailAtomSV.queryFunAccountDetail(param);
        PageInfo<FunAccountDetailResponse> pageInfo = new PageInfo<FunAccountDetailResponse>();
        FunAccountDetailMapper mapper = MapperFactory.getFunAccountDetailMapper();
        pageInfo.setCount(mapper.countByExample(funAccountDetailCriteria));
        List<FunAccountDetail> funAccountDetails = mapper.selectByExample(funAccountDetailCriteria);
        if (param.getPageInfo() == null) {
            pageInfo.setPageNo(1);
            pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
        }else {
            pageInfo.setPageNo(param.getPageInfo().getPageNo());
            pageInfo.setPageSize(param.getPageInfo().getPageSize() == null ? 10
                    : param.getPageInfo().getPageSize());
            funAccountDetailCriteria.setLimitStart(param.getPageInfo()
                    .getStartRowIndex());
            funAccountDetailCriteria.setLimitEnd(param.getPageInfo().getPageSize());
        }
        if (!CollectionUtil.isEmpty(funAccountDetails)){
            funAccountDetaiResponses = new ArrayList<FunAccountDetailResponse>();
            for (int i=0;i<funAccountDetails.size();i++){
                FunAccountDetailResponse funAccountDetailResponse = new FunAccountDetailResponse();
                BeanUtils.copyProperties(funAccountDetailResponse,funAccountDetails.get(i));
                funAccountDetaiResponses.add(funAccountDetailResponse);
            }
        }
        pageInfo.setPageNo(pageInfo.getPageNo() == null?1:pageInfo.getPageNo());
        pageInfo.setPageSize(pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
        pageInfo.setPageCount((pageInfo.getCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize());
        pageInfo.setResult(funAccountDetaiResponses);
        return pageInfo;
    }

    @Override
    public String settleBill(SettleParam param) throws BusinessException, SystemException {

        FunAccountMapper mapper = MapperFactory.getFunAccountMapper();
        FunAccount funAccount = mapper.selectByPrimaryKey(param.getBillID());
        funAccount.setBillId(param.getBillID());
        funAccount.setState(2);
        log.info("=========+param.state="+param.getState());
        log.info("====================+State="+funAccount.getState());

        log.info("funAccount已创建，OK："+ JSON.toJSONString(funAccount));
        funAccount.setAccountAmout(param.getAccountAmount());
        funAccount.setSettleAccount(param.getSettleAccount());
        funAccount.setAccountType(param.getAccountType());
        funAccount.setActAccountTime(DateUtil.getSysDate());
        funAccountAtomSV.settleBill(funAccount);
        return funAccount.getBillId();
    }

    @Override
    public String insertParam(AccountParam accountParam) throws BusinessException, SystemException {
        TAccountParam tAccountParam = new TAccountParam();
        tAccountParam.setAccountDay(accountParam.getAccountDay());
        tAccountParam.setTargetId(accountParam.getTargetID());
        tAccountParam.setTargetName(accountParam.getTargetName());
        tAccountParam.setAccountPeriod(accountParam.getAccountPeriod());
        tAccountParam.setCreateTime(DateUtil.getSysDate());
        tAccountParam.setAccountType(accountParam.getAccountType());
        String paramID = SeqUtil.getNewId(SeqConstants.T_ACCOUNT_PARAM$ID).toString();
        tAccountParam.setId(paramID);
        tAccountParam.setDiscount(accountParam.getDiscount());
        tAccountParam.setTargetType(accountParam.getTargetType());
        funAccountAtomSV.insertParam(tAccountParam);
        return paramID;
    }

    @Override
    public TAccountParam queryTaccount(String paramId) throws BusinessException, SystemException {

        TAccountParamCriteria tAccountParamCriteria = new TAccountParamCriteria();
        TAccountParamCriteria.Criteria critreia = tAccountParamCriteria.createCriteria();
        critreia.andTargetIdEqualTo(paramId);
        TAccountParamMapper mapper = MapperFactory.getTAccountParamMapper();
        List<TAccountParam> tAccountParams = mapper.selectByExample(tAccountParamCriteria);
        if (tAccountParams.size()>0){
            return tAccountParams.get(0);
        }else {
            return null;
        }
    }
}
