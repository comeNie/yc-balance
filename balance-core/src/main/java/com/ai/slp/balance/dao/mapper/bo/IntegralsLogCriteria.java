package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class IntegralsLogCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public IntegralsLogCriteria() {
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

        public Criteria andIntegralLogIdIsNull() {
            addCriterion("integral_log_id is null");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdIsNotNull() {
            addCriterion("integral_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdEqualTo(String value) {
            addCriterion("integral_log_id =", value, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdNotEqualTo(String value) {
            addCriterion("integral_log_id <>", value, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdGreaterThan(String value) {
            addCriterion("integral_log_id >", value, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("integral_log_id >=", value, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdLessThan(String value) {
            addCriterion("integral_log_id <", value, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdLessThanOrEqualTo(String value) {
            addCriterion("integral_log_id <=", value, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdLike(String value) {
            addCriterion("integral_log_id like", value, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdNotLike(String value) {
            addCriterion("integral_log_id not like", value, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdIn(List<String> values) {
            addCriterion("integral_log_id in", values, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdNotIn(List<String> values) {
            addCriterion("integral_log_id not in", values, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdBetween(String value1, String value2) {
            addCriterion("integral_log_id between", value1, value2, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIntegralLogIdNotBetween(String value1, String value2) {
            addCriterion("integral_log_id not between", value1, value2, "integralLogId");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceIsNull() {
            addCriterion("integral_source is null");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceIsNotNull() {
            addCriterion("integral_source is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceEqualTo(String value) {
            addCriterion("integral_source =", value, "integralSource");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceNotEqualTo(String value) {
            addCriterion("integral_source <>", value, "integralSource");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceGreaterThan(String value) {
            addCriterion("integral_source >", value, "integralSource");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceGreaterThanOrEqualTo(String value) {
            addCriterion("integral_source >=", value, "integralSource");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceLessThan(String value) {
            addCriterion("integral_source <", value, "integralSource");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceLessThanOrEqualTo(String value) {
            addCriterion("integral_source <=", value, "integralSource");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceLike(String value) {
            addCriterion("integral_source like", value, "integralSource");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceNotLike(String value) {
            addCriterion("integral_source not like", value, "integralSource");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceIn(List<String> values) {
            addCriterion("integral_source in", values, "integralSource");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceNotIn(List<String> values) {
            addCriterion("integral_source not in", values, "integralSource");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceBetween(String value1, String value2) {
            addCriterion("integral_source between", value1, value2, "integralSource");
            return (Criteria) this;
        }

        public Criteria andIntegralSourceNotBetween(String value1, String value2) {
            addCriterion("integral_source not between", value1, value2, "integralSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceIsNull() {
            addCriterion("system_source is null");
            return (Criteria) this;
        }

        public Criteria andSystemSourceIsNotNull() {
            addCriterion("system_source is not null");
            return (Criteria) this;
        }

        public Criteria andSystemSourceEqualTo(String value) {
            addCriterion("system_source =", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceNotEqualTo(String value) {
            addCriterion("system_source <>", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceGreaterThan(String value) {
            addCriterion("system_source >", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceGreaterThanOrEqualTo(String value) {
            addCriterion("system_source >=", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceLessThan(String value) {
            addCriterion("system_source <", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceLessThanOrEqualTo(String value) {
            addCriterion("system_source <=", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceLike(String value) {
            addCriterion("system_source like", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceNotLike(String value) {
            addCriterion("system_source not like", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceIn(List<String> values) {
            addCriterion("system_source in", values, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceNotIn(List<String> values) {
            addCriterion("system_source not in", values, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceBetween(String value1, String value2) {
            addCriterion("system_source between", value1, value2, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceNotBetween(String value1, String value2) {
            addCriterion("system_source not between", value1, value2, "systemSource");
            return (Criteria) this;
        }

        public Criteria andIntegralValueIsNull() {
            addCriterion("integral_value is null");
            return (Criteria) this;
        }

        public Criteria andIntegralValueIsNotNull() {
            addCriterion("integral_value is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralValueEqualTo(Integer value) {
            addCriterion("integral_value =", value, "integralValue");
            return (Criteria) this;
        }

        public Criteria andIntegralValueNotEqualTo(Integer value) {
            addCriterion("integral_value <>", value, "integralValue");
            return (Criteria) this;
        }

        public Criteria andIntegralValueGreaterThan(Integer value) {
            addCriterion("integral_value >", value, "integralValue");
            return (Criteria) this;
        }

        public Criteria andIntegralValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral_value >=", value, "integralValue");
            return (Criteria) this;
        }

        public Criteria andIntegralValueLessThan(Integer value) {
            addCriterion("integral_value <", value, "integralValue");
            return (Criteria) this;
        }

        public Criteria andIntegralValueLessThanOrEqualTo(Integer value) {
            addCriterion("integral_value <=", value, "integralValue");
            return (Criteria) this;
        }

        public Criteria andIntegralValueIn(List<Integer> values) {
            addCriterion("integral_value in", values, "integralValue");
            return (Criteria) this;
        }

        public Criteria andIntegralValueNotIn(List<Integer> values) {
            addCriterion("integral_value not in", values, "integralValue");
            return (Criteria) this;
        }

        public Criteria andIntegralValueBetween(Integer value1, Integer value2) {
            addCriterion("integral_value between", value1, value2, "integralValue");
            return (Criteria) this;
        }

        public Criteria andIntegralValueNotBetween(Integer value1, Integer value2) {
            addCriterion("integral_value not between", value1, value2, "integralValue");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(Timestamp value) {
            addCriterion("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Timestamp value) {
            addCriterion("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Timestamp value) {
            addCriterion("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Timestamp value) {
            addCriterion("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Timestamp> values) {
            addCriterion("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Timestamp> values) {
            addCriterion("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("log_time not between", value1, value2, "logTime");
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