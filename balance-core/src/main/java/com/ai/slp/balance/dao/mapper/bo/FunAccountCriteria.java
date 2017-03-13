package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FunAccountCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public FunAccountCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBillIdIsNull() {
            addCriterion("BILL_ID is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("BILL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(String value) {
            addCriterion("BILL_ID =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(String value) {
            addCriterion("BILL_ID <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(String value) {
            addCriterion("BILL_ID >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_ID >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(String value) {
            addCriterion("BILL_ID <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(String value) {
            addCriterion("BILL_ID <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLike(String value) {
            addCriterion("BILL_ID like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotLike(String value) {
            addCriterion("BILL_ID not like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<String> values) {
            addCriterion("BILL_ID in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<String> values) {
            addCriterion("BILL_ID not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(String value1, String value2) {
            addCriterion("BILL_ID between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(String value1, String value2) {
            addCriterion("BILL_ID not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNull() {
            addCriterion("TARGET_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNotNull() {
            addCriterion("TARGET_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeEqualTo(String value) {
            addCriterion("TARGET_TYPE =", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotEqualTo(String value) {
            addCriterion("TARGET_TYPE <>", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThan(String value) {
            addCriterion("TARGET_TYPE >", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_TYPE >=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThan(String value) {
            addCriterion("TARGET_TYPE <", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThanOrEqualTo(String value) {
            addCriterion("TARGET_TYPE <=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLike(String value) {
            addCriterion("TARGET_TYPE like", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotLike(String value) {
            addCriterion("TARGET_TYPE not like", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIn(List<String> values) {
            addCriterion("TARGET_TYPE in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotIn(List<String> values) {
            addCriterion("TARGET_TYPE not in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeBetween(String value1, String value2) {
            addCriterion("TARGET_TYPE between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotBetween(String value1, String value2) {
            addCriterion("TARGET_TYPE not between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNull() {
            addCriterion("TARGET_ID is null");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("TARGET_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIdEqualTo(String value) {
            addCriterion("TARGET_ID =", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotEqualTo(String value) {
            addCriterion("TARGET_ID <>", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThan(String value) {
            addCriterion("TARGET_ID >", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_ID >=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThan(String value) {
            addCriterion("TARGET_ID <", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThanOrEqualTo(String value) {
            addCriterion("TARGET_ID <=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLike(String value) {
            addCriterion("TARGET_ID like", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotLike(String value) {
            addCriterion("TARGET_ID not like", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIn(List<String> values) {
            addCriterion("TARGET_ID in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotIn(List<String> values) {
            addCriterion("TARGET_ID not in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdBetween(String value1, String value2) {
            addCriterion("TARGET_ID between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotBetween(String value1, String value2) {
            addCriterion("TARGET_ID not between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetNameIsNull() {
            addCriterion("TARGET_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTargetNameIsNotNull() {
            addCriterion("TARGET_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTargetNameEqualTo(String value) {
            addCriterion("TARGET_NAME =", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameNotEqualTo(String value) {
            addCriterion("TARGET_NAME <>", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameGreaterThan(String value) {
            addCriterion("TARGET_NAME >", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_NAME >=", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameLessThan(String value) {
            addCriterion("TARGET_NAME <", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameLessThanOrEqualTo(String value) {
            addCriterion("TARGET_NAME <=", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameLike(String value) {
            addCriterion("TARGET_NAME like", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameNotLike(String value) {
            addCriterion("TARGET_NAME not like", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameIn(List<String> values) {
            addCriterion("TARGET_NAME in", values, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameNotIn(List<String> values) {
            addCriterion("TARGET_NAME not in", values, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameBetween(String value1, String value2) {
            addCriterion("TARGET_NAME between", value1, value2, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameNotBetween(String value1, String value2) {
            addCriterion("TARGET_NAME not between", value1, value2, "targetName");
            return (Criteria) this;
        }

        public Criteria andAccountClsIsNull() {
            addCriterion("ACCOUNT_CLS is null");
            return (Criteria) this;
        }

        public Criteria andAccountClsIsNotNull() {
            addCriterion("ACCOUNT_CLS is not null");
            return (Criteria) this;
        }

        public Criteria andAccountClsEqualTo(String value) {
            addCriterion("ACCOUNT_CLS =", value, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountClsNotEqualTo(String value) {
            addCriterion("ACCOUNT_CLS <>", value, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountClsGreaterThan(String value) {
            addCriterion("ACCOUNT_CLS >", value, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountClsGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_CLS >=", value, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountClsLessThan(String value) {
            addCriterion("ACCOUNT_CLS <", value, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountClsLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_CLS <=", value, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountClsLike(String value) {
            addCriterion("ACCOUNT_CLS like", value, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountClsNotLike(String value) {
            addCriterion("ACCOUNT_CLS not like", value, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountClsIn(List<String> values) {
            addCriterion("ACCOUNT_CLS in", values, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountClsNotIn(List<String> values) {
            addCriterion("ACCOUNT_CLS not in", values, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountClsBetween(String value1, String value2) {
            addCriterion("ACCOUNT_CLS between", value1, value2, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountClsNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_CLS not between", value1, value2, "accountCls");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodIsNull() {
            addCriterion("ACCOUNT_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodIsNotNull() {
            addCriterion("ACCOUNT_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEqualTo(String value) {
            addCriterion("ACCOUNT_PERIOD =", value, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodNotEqualTo(String value) {
            addCriterion("ACCOUNT_PERIOD <>", value, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodGreaterThan(String value) {
            addCriterion("ACCOUNT_PERIOD >", value, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_PERIOD >=", value, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodLessThan(String value) {
            addCriterion("ACCOUNT_PERIOD <", value, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_PERIOD <=", value, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodLike(String value) {
            addCriterion("ACCOUNT_PERIOD like", value, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodNotLike(String value) {
            addCriterion("ACCOUNT_PERIOD not like", value, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodIn(List<String> values) {
            addCriterion("ACCOUNT_PERIOD in", values, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodNotIn(List<String> values) {
            addCriterion("ACCOUNT_PERIOD not in", values, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBetween(String value1, String value2) {
            addCriterion("ACCOUNT_PERIOD between", value1, value2, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_PERIOD not between", value1, value2, "accountPeriod");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayIsNull() {
            addCriterion("ACCOUNT_PERIOD_DAY is null");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayIsNotNull() {
            addCriterion("ACCOUNT_PERIOD_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayEqualTo(String value) {
            addCriterion("ACCOUNT_PERIOD_DAY =", value, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayNotEqualTo(String value) {
            addCriterion("ACCOUNT_PERIOD_DAY <>", value, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayGreaterThan(String value) {
            addCriterion("ACCOUNT_PERIOD_DAY >", value, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_PERIOD_DAY >=", value, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayLessThan(String value) {
            addCriterion("ACCOUNT_PERIOD_DAY <", value, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_PERIOD_DAY <=", value, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayLike(String value) {
            addCriterion("ACCOUNT_PERIOD_DAY like", value, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayNotLike(String value) {
            addCriterion("ACCOUNT_PERIOD_DAY not like", value, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayIn(List<String> values) {
            addCriterion("ACCOUNT_PERIOD_DAY in", values, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayNotIn(List<String> values) {
            addCriterion("ACCOUNT_PERIOD_DAY not in", values, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayBetween(String value1, String value2) {
            addCriterion("ACCOUNT_PERIOD_DAY between", value1, value2, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodDayNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_PERIOD_DAY not between", value1, value2, "accountPeriodDay");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeIsNull() {
            addCriterion("PLAN_ACCOUNT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeIsNotNull() {
            addCriterion("PLAN_ACCOUNT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeEqualTo(Timestamp value) {
            addCriterion("PLAN_ACCOUNT_TIME =", value, "planAccountTime");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeNotEqualTo(Timestamp value) {
            addCriterion("PLAN_ACCOUNT_TIME <>", value, "planAccountTime");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeGreaterThan(Timestamp value) {
            addCriterion("PLAN_ACCOUNT_TIME >", value, "planAccountTime");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("PLAN_ACCOUNT_TIME >=", value, "planAccountTime");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeLessThan(Timestamp value) {
            addCriterion("PLAN_ACCOUNT_TIME <", value, "planAccountTime");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("PLAN_ACCOUNT_TIME <=", value, "planAccountTime");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeIn(List<Timestamp> values) {
            addCriterion("PLAN_ACCOUNT_TIME in", values, "planAccountTime");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeNotIn(List<Timestamp> values) {
            addCriterion("PLAN_ACCOUNT_TIME not in", values, "planAccountTime");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("PLAN_ACCOUNT_TIME between", value1, value2, "planAccountTime");
            return (Criteria) this;
        }

        public Criteria andPlanAccountTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("PLAN_ACCOUNT_TIME not between", value1, value2, "planAccountTime");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeIsNull() {
            addCriterion("ACT_ACCOUNT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeIsNotNull() {
            addCriterion("ACT_ACCOUNT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeEqualTo(Timestamp value) {
            addCriterion("ACT_ACCOUNT_TIME =", value, "actAccountTime");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeNotEqualTo(Timestamp value) {
            addCriterion("ACT_ACCOUNT_TIME <>", value, "actAccountTime");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeGreaterThan(Timestamp value) {
            addCriterion("ACT_ACCOUNT_TIME >", value, "actAccountTime");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("ACT_ACCOUNT_TIME >=", value, "actAccountTime");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeLessThan(Timestamp value) {
            addCriterion("ACT_ACCOUNT_TIME <", value, "actAccountTime");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("ACT_ACCOUNT_TIME <=", value, "actAccountTime");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeIn(List<Timestamp> values) {
            addCriterion("ACT_ACCOUNT_TIME in", values, "actAccountTime");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeNotIn(List<Timestamp> values) {
            addCriterion("ACT_ACCOUNT_TIME not in", values, "actAccountTime");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ACT_ACCOUNT_TIME between", value1, value2, "actAccountTime");
            return (Criteria) this;
        }

        public Criteria andActAccountTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ACT_ACCOUNT_TIME not between", value1, value2, "actAccountTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("PAY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("PAY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Timestamp value) {
            addCriterion("PAY_TIME =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Timestamp value) {
            addCriterion("PAY_TIME <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Timestamp value) {
            addCriterion("PAY_TIME >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("PAY_TIME >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Timestamp value) {
            addCriterion("PAY_TIME <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("PAY_TIME <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Timestamp> values) {
            addCriterion("PAY_TIME in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Timestamp> values) {
            addCriterion("PAY_TIME not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("PAY_TIME between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("PAY_TIME not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andLspAdminIsNull() {
            addCriterion("lsp_admin is null");
            return (Criteria) this;
        }

        public Criteria andLspAdminIsNotNull() {
            addCriterion("lsp_admin is not null");
            return (Criteria) this;
        }

        public Criteria andLspAdminEqualTo(String value) {
            addCriterion("lsp_admin =", value, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andLspAdminNotEqualTo(String value) {
            addCriterion("lsp_admin <>", value, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andLspAdminGreaterThan(String value) {
            addCriterion("lsp_admin >", value, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andLspAdminGreaterThanOrEqualTo(String value) {
            addCriterion("lsp_admin >=", value, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andLspAdminLessThan(String value) {
            addCriterion("lsp_admin <", value, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andLspAdminLessThanOrEqualTo(String value) {
            addCriterion("lsp_admin <=", value, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andLspAdminLike(String value) {
            addCriterion("lsp_admin like", value, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andLspAdminNotLike(String value) {
            addCriterion("lsp_admin not like", value, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andLspAdminIn(List<String> values) {
            addCriterion("lsp_admin in", values, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andLspAdminNotIn(List<String> values) {
            addCriterion("lsp_admin not in", values, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andLspAdminBetween(String value1, String value2) {
            addCriterion("lsp_admin between", value1, value2, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andLspAdminNotBetween(String value1, String value2) {
            addCriterion("lsp_admin not between", value1, value2, "lspAdmin");
            return (Criteria) this;
        }

        public Criteria andBillFeeIsNull() {
            addCriterion("BILL_FEE is null");
            return (Criteria) this;
        }

        public Criteria andBillFeeIsNotNull() {
            addCriterion("BILL_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andBillFeeEqualTo(Long value) {
            addCriterion("BILL_FEE =", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeNotEqualTo(Long value) {
            addCriterion("BILL_FEE <>", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeGreaterThan(Long value) {
            addCriterion("BILL_FEE >", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("BILL_FEE >=", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeLessThan(Long value) {
            addCriterion("BILL_FEE <", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeLessThanOrEqualTo(Long value) {
            addCriterion("BILL_FEE <=", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeIn(List<Long> values) {
            addCriterion("BILL_FEE in", values, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeNotIn(List<Long> values) {
            addCriterion("BILL_FEE not in", values, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeBetween(Long value1, Long value2) {
            addCriterion("BILL_FEE between", value1, value2, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeNotBetween(Long value1, Long value2) {
            addCriterion("BILL_FEE not between", value1, value2, "billFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeIsNull() {
            addCriterion("PLAT_FEE is null");
            return (Criteria) this;
        }

        public Criteria andPlatFeeIsNotNull() {
            addCriterion("PLAT_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andPlatFeeEqualTo(Long value) {
            addCriterion("PLAT_FEE =", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeNotEqualTo(Long value) {
            addCriterion("PLAT_FEE <>", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeGreaterThan(Long value) {
            addCriterion("PLAT_FEE >", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("PLAT_FEE >=", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeLessThan(Long value) {
            addCriterion("PLAT_FEE <", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeLessThanOrEqualTo(Long value) {
            addCriterion("PLAT_FEE <=", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeIn(List<Long> values) {
            addCriterion("PLAT_FEE in", values, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeNotIn(List<Long> values) {
            addCriterion("PLAT_FEE not in", values, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeBetween(Long value1, Long value2) {
            addCriterion("PLAT_FEE between", value1, value2, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeNotBetween(Long value1, Long value2) {
            addCriterion("PLAT_FEE not between", value1, value2, "platFee");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutIsNull() {
            addCriterion("ACCOUNT_AMOUT is null");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutIsNotNull() {
            addCriterion("ACCOUNT_AMOUT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutEqualTo(Long value) {
            addCriterion("ACCOUNT_AMOUT =", value, "accountAmout");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutNotEqualTo(Long value) {
            addCriterion("ACCOUNT_AMOUT <>", value, "accountAmout");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutGreaterThan(Long value) {
            addCriterion("ACCOUNT_AMOUT >", value, "accountAmout");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutGreaterThanOrEqualTo(Long value) {
            addCriterion("ACCOUNT_AMOUT >=", value, "accountAmout");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutLessThan(Long value) {
            addCriterion("ACCOUNT_AMOUT <", value, "accountAmout");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutLessThanOrEqualTo(Long value) {
            addCriterion("ACCOUNT_AMOUT <=", value, "accountAmout");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutIn(List<Long> values) {
            addCriterion("ACCOUNT_AMOUT in", values, "accountAmout");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutNotIn(List<Long> values) {
            addCriterion("ACCOUNT_AMOUT not in", values, "accountAmout");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutBetween(Long value1, Long value2) {
            addCriterion("ACCOUNT_AMOUT between", value1, value2, "accountAmout");
            return (Criteria) this;
        }

        public Criteria andAccountAmoutNotBetween(Long value1, Long value2) {
            addCriterion("ACCOUNT_AMOUT not between", value1, value2, "accountAmout");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Timestamp value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Timestamp value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeIsNull() {
            addCriterion("START_ACCOUNT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeIsNotNull() {
            addCriterion("START_ACCOUNT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeEqualTo(Timestamp value) {
            addCriterion("START_ACCOUNT_TIME =", value, "startAccountTime");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeNotEqualTo(Timestamp value) {
            addCriterion("START_ACCOUNT_TIME <>", value, "startAccountTime");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeGreaterThan(Timestamp value) {
            addCriterion("START_ACCOUNT_TIME >", value, "startAccountTime");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("START_ACCOUNT_TIME >=", value, "startAccountTime");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeLessThan(Timestamp value) {
            addCriterion("START_ACCOUNT_TIME <", value, "startAccountTime");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("START_ACCOUNT_TIME <=", value, "startAccountTime");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeIn(List<Timestamp> values) {
            addCriterion("START_ACCOUNT_TIME in", values, "startAccountTime");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeNotIn(List<Timestamp> values) {
            addCriterion("START_ACCOUNT_TIME not in", values, "startAccountTime");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("START_ACCOUNT_TIME between", value1, value2, "startAccountTime");
            return (Criteria) this;
        }

        public Criteria andStartAccountTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("START_ACCOUNT_TIME not between", value1, value2, "startAccountTime");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeIsNull() {
            addCriterion("END_ACCOUNT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeIsNotNull() {
            addCriterion("END_ACCOUNT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeEqualTo(Timestamp value) {
            addCriterion("END_ACCOUNT_TIME =", value, "endAccountTime");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeNotEqualTo(Timestamp value) {
            addCriterion("END_ACCOUNT_TIME <>", value, "endAccountTime");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeGreaterThan(Timestamp value) {
            addCriterion("END_ACCOUNT_TIME >", value, "endAccountTime");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("END_ACCOUNT_TIME >=", value, "endAccountTime");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeLessThan(Timestamp value) {
            addCriterion("END_ACCOUNT_TIME <", value, "endAccountTime");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("END_ACCOUNT_TIME <=", value, "endAccountTime");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeIn(List<Timestamp> values) {
            addCriterion("END_ACCOUNT_TIME in", values, "endAccountTime");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeNotIn(List<Timestamp> values) {
            addCriterion("END_ACCOUNT_TIME not in", values, "endAccountTime");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("END_ACCOUNT_TIME between", value1, value2, "endAccountTime");
            return (Criteria) this;
        }

        public Criteria andEndAccountTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("END_ACCOUNT_TIME not between", value1, value2, "endAccountTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("ACCOUNT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("ACCOUNT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(String value) {
            addCriterion("ACCOUNT_TYPE >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(String value) {
            addCriterion("ACCOUNT_TYPE <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLike(String value) {
            addCriterion("ACCOUNT_TYPE like", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotLike(String value) {
            addCriterion("ACCOUNT_TYPE not like", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<String> values) {
            addCriterion("ACCOUNT_TYPE in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<String> values) {
            addCriterion("ACCOUNT_TYPE not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(String value1, String value2) {
            addCriterion("ACCOUNT_TYPE between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_TYPE not between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andSettleAccountIsNull() {
            addCriterion("SETTLE_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSettleAccountIsNotNull() {
            addCriterion("SETTLE_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSettleAccountEqualTo(String value) {
            addCriterion("SETTLE_ACCOUNT =", value, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andSettleAccountNotEqualTo(String value) {
            addCriterion("SETTLE_ACCOUNT <>", value, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andSettleAccountGreaterThan(String value) {
            addCriterion("SETTLE_ACCOUNT >", value, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andSettleAccountGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_ACCOUNT >=", value, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andSettleAccountLessThan(String value) {
            addCriterion("SETTLE_ACCOUNT <", value, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andSettleAccountLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_ACCOUNT <=", value, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andSettleAccountLike(String value) {
            addCriterion("SETTLE_ACCOUNT like", value, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andSettleAccountNotLike(String value) {
            addCriterion("SETTLE_ACCOUNT not like", value, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andSettleAccountIn(List<String> values) {
            addCriterion("SETTLE_ACCOUNT in", values, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andSettleAccountNotIn(List<String> values) {
            addCriterion("SETTLE_ACCOUNT not in", values, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andSettleAccountBetween(String value1, String value2) {
            addCriterion("SETTLE_ACCOUNT between", value1, value2, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andSettleAccountNotBetween(String value1, String value2) {
            addCriterion("SETTLE_ACCOUNT not between", value1, value2, "settleAccount");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("FLAG like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("FLAG not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeIsNull() {
            addCriterion("TRANSLATOR_FEE is null");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeIsNotNull() {
            addCriterion("TRANSLATOR_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeEqualTo(Long value) {
            addCriterion("TRANSLATOR_FEE =", value, "translatorFee");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeNotEqualTo(Long value) {
            addCriterion("TRANSLATOR_FEE <>", value, "translatorFee");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeGreaterThan(Long value) {
            addCriterion("TRANSLATOR_FEE >", value, "translatorFee");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("TRANSLATOR_FEE >=", value, "translatorFee");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeLessThan(Long value) {
            addCriterion("TRANSLATOR_FEE <", value, "translatorFee");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeLessThanOrEqualTo(Long value) {
            addCriterion("TRANSLATOR_FEE <=", value, "translatorFee");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeIn(List<Long> values) {
            addCriterion("TRANSLATOR_FEE in", values, "translatorFee");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeNotIn(List<Long> values) {
            addCriterion("TRANSLATOR_FEE not in", values, "translatorFee");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeBetween(Long value1, Long value2) {
            addCriterion("TRANSLATOR_FEE between", value1, value2, "translatorFee");
            return (Criteria) this;
        }

        public Criteria andTranslatorFeeNotBetween(Long value1, Long value2) {
            addCriterion("TRANSLATOR_FEE not between", value1, value2, "translatorFee");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}