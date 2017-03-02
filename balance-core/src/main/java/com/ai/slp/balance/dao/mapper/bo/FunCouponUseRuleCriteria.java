package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FunCouponUseRuleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public FunCouponUseRuleCriteria() {
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

        public Criteria andCouponUserIdIsNull() {
            addCriterion("COUPON_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdIsNotNull() {
            addCriterion("COUPON_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdEqualTo(String value) {
            addCriterion("COUPON_USER_ID =", value, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdNotEqualTo(String value) {
            addCriterion("COUPON_USER_ID <>", value, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdGreaterThan(String value) {
            addCriterion("COUPON_USER_ID >", value, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("COUPON_USER_ID >=", value, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdLessThan(String value) {
            addCriterion("COUPON_USER_ID <", value, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdLessThanOrEqualTo(String value) {
            addCriterion("COUPON_USER_ID <=", value, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdLike(String value) {
            addCriterion("COUPON_USER_ID like", value, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdNotLike(String value) {
            addCriterion("COUPON_USER_ID not like", value, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdIn(List<String> values) {
            addCriterion("COUPON_USER_ID in", values, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdNotIn(List<String> values) {
            addCriterion("COUPON_USER_ID not in", values, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdBetween(String value1, String value2) {
            addCriterion("COUPON_USER_ID between", value1, value2, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andCouponUserIdNotBetween(String value1, String value2) {
            addCriterion("COUPON_USER_ID not between", value1, value2, "couponUserId");
            return (Criteria) this;
        }

        public Criteria andFaceValueIsNull() {
            addCriterion("FACE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andFaceValueIsNotNull() {
            addCriterion("FACE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andFaceValueEqualTo(Integer value) {
            addCriterion("FACE_VALUE =", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueNotEqualTo(Integer value) {
            addCriterion("FACE_VALUE <>", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueGreaterThan(Integer value) {
            addCriterion("FACE_VALUE >", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("FACE_VALUE >=", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueLessThan(Integer value) {
            addCriterion("FACE_VALUE <", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueLessThanOrEqualTo(Integer value) {
            addCriterion("FACE_VALUE <=", value, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueIn(List<Integer> values) {
            addCriterion("FACE_VALUE in", values, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueNotIn(List<Integer> values) {
            addCriterion("FACE_VALUE not in", values, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueBetween(Integer value1, Integer value2) {
            addCriterion("FACE_VALUE between", value1, value2, "faceValue");
            return (Criteria) this;
        }

        public Criteria andFaceValueNotBetween(Integer value1, Integer value2) {
            addCriterion("FACE_VALUE not between", value1, value2, "faceValue");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountIsNull() {
            addCriterion("REQUIRED_MONEY_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountIsNotNull() {
            addCriterion("REQUIRED_MONEY_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountEqualTo(Integer value) {
            addCriterion("REQUIRED_MONEY_AMOUNT =", value, "requiredMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountNotEqualTo(Integer value) {
            addCriterion("REQUIRED_MONEY_AMOUNT <>", value, "requiredMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountGreaterThan(Integer value) {
            addCriterion("REQUIRED_MONEY_AMOUNT >", value, "requiredMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("REQUIRED_MONEY_AMOUNT >=", value, "requiredMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountLessThan(Integer value) {
            addCriterion("REQUIRED_MONEY_AMOUNT <", value, "requiredMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountLessThanOrEqualTo(Integer value) {
            addCriterion("REQUIRED_MONEY_AMOUNT <=", value, "requiredMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountIn(List<Integer> values) {
            addCriterion("REQUIRED_MONEY_AMOUNT in", values, "requiredMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountNotIn(List<Integer> values) {
            addCriterion("REQUIRED_MONEY_AMOUNT not in", values, "requiredMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountBetween(Integer value1, Integer value2) {
            addCriterion("REQUIRED_MONEY_AMOUNT between", value1, value2, "requiredMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andRequiredMoneyAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("REQUIRED_MONEY_AMOUNT not between", value1, value2, "requiredMoneyAmount");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIsNull() {
            addCriterion("CURRENCY_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIsNotNull() {
            addCriterion("CURRENCY_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitEqualTo(String value) {
            addCriterion("CURRENCY_UNIT =", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotEqualTo(String value) {
            addCriterion("CURRENCY_UNIT <>", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitGreaterThan(String value) {
            addCriterion("CURRENCY_UNIT >", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENCY_UNIT >=", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLessThan(String value) {
            addCriterion("CURRENCY_UNIT <", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLessThanOrEqualTo(String value) {
            addCriterion("CURRENCY_UNIT <=", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLike(String value) {
            addCriterion("CURRENCY_UNIT like", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotLike(String value) {
            addCriterion("CURRENCY_UNIT not like", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIn(List<String> values) {
            addCriterion("CURRENCY_UNIT in", values, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotIn(List<String> values) {
            addCriterion("CURRENCY_UNIT not in", values, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitBetween(String value1, String value2) {
            addCriterion("CURRENCY_UNIT between", value1, value2, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotBetween(String value1, String value2) {
            addCriterion("CURRENCY_UNIT not between", value1, value2, "currencyUnit");
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