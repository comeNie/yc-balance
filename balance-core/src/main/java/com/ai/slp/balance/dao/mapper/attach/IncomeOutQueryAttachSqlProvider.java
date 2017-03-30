package com.ai.slp.balance.dao.mapper.attach;

import com.ai.opt.sdk.util.StringUtil;

import java.util.Map;

public class IncomeOutQueryAttachSqlProvider {
	public String incomeOutQueryAttachSqlProvider(Map<String, Object> param) {
        StringBuffer seqBuffer = new StringBuffer();
        seqBuffer.append("select serial.pay_serial_code,serial.pay_time," +
                "serial.opt_type,serial.INCOME_FLAG,serial.acct_name1," +
                "detail.total_amount,detail.balance_pre,serial.channel," +
                "serial.pay_status,serial.remark,detail.CURRENCY_UNIT " +
                "FROM fun_fund_detail detail, fun_fund_serial serial WHERE detail.pay_serial_code=serial.pay_serial_code");
        if (param.get("serialCode") != null)
        	seqBuffer.append(" and serial.pay_serial_code = '" + param.get("serialCode")+"'");
        String nickName = param.containsKey("nickName") ? (String) param.get("nickName") : null;
        if (!StringUtil.isBlank(nickName))
        	seqBuffer.append(" and serial.acct_name1 like '%" + nickName+"%'");
        String beginDate = param.containsKey("beginDate") ? (String) param.get("beginDate") : null;
        String endDate = param.containsKey("endDate") ? (String) param.get("endDate") : null;
        if (!(StringUtil.isBlank(beginDate)&&StringUtil.isBlank(beginDate)))
            seqBuffer.append(" and serial.pay_time BETWEEN '"+ beginDate + "' AND '" + endDate +"'");
        String channel = param.containsKey("channel") ? (String) param.get("channel") : null;
        if (!StringUtil.isBlank(channel))
            seqBuffer.append(" and serial.channel = '" + channel+"'");
        String state = param.containsKey("state") ? (String) param.get("state") : null;
        if (!StringUtil.isBlank(state))
            seqBuffer.append(" and serial.pay_status = '" + state+"'");
        String currencyUnit = param.containsKey("currencyUnit") ? (String) param.get("currencyUnit") : null;
        if (!StringUtil.isBlank(currencyUnit))
            seqBuffer.append(" and detail.CURRENCY_UNIT = '" + currencyUnit+"'");
        Long beginAmount = param.containsKey("beginAmount") ? (Long) param.get("beginAmount") : null;
        Long endAmount = param.containsKey("endAmount") ? (Long) param.get("endAmount") : null;
        if (beginAmount!=null&&endAmount!=null)
            seqBuffer.append(" and detail.total_amount BETWEEN "+ beginAmount + " AND " + endAmount+"");
        String incomeFlag = param.containsKey("incomeFlag") ? (String) param.get("incomeFlag") : null;
        if (!StringUtil.isBlank(incomeFlag))
            seqBuffer.append(" and serial.INCOME_FLAG = '" + incomeFlag+"'");
        String optType = param.containsKey("optType") ? (String) param.get("optType") : null;
        if (!StringUtil.isBlank(optType))
            seqBuffer.append(" and serial.opt_type = '" + optType+"'");
        Integer pageNo = param.containsKey("pageNo") ? (Integer) param.get("pageNo") : null;
        Integer pageSize = param.containsKey("pageSize") ? (Integer) param.get("pageSize") : null;
        seqBuffer.append(" order by serial.pay_time desc");
        if (pageNo!=null&&pageSize!=null)
            seqBuffer.append(" LIMIT "+((pageNo-1)*pageSize)+","+pageSize+"");
        return seqBuffer.toString();
    }
}
