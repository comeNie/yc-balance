package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FunAccountDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public FunAccountDetailCriteria() {
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

        public Criteria andDetailIdIsNull() {
            addCriterion("DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(String value) {
            addCriterion("DETAIL_ID =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(String value) {
            addCriterion("DETAIL_ID <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(String value) {
            addCriterion("DETAIL_ID >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_ID >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(String value) {
            addCriterion("DETAIL_ID <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_ID <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLike(String value) {
            addCriterion("DETAIL_ID like", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotLike(String value) {
            addCriterion("DETAIL_ID not like", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<String> values) {
            addCriterion("DETAIL_ID in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<String> values) {
            addCriterion("DETAIL_ID not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(String value1, String value2) {
            addCriterion("DETAIL_ID between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(String value1, String value2) {
            addCriterion("DETAIL_ID not between", value1, value2, "detailId");
            return (Criteria) this;
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

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("ORDER_ID like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("ORDER_ID not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("ORDER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("ORDER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Timestamp value) {
            addCriterion("ORDER_TIME =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Timestamp value) {
            addCriterion("ORDER_TIME <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Timestamp value) {
            addCriterion("ORDER_TIME >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("ORDER_TIME >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Timestamp value) {
            addCriterion("ORDER_TIME <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("ORDER_TIME <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Timestamp> values) {
            addCriterion("ORDER_TIME in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Timestamp> values) {
            addCriterion("ORDER_TIME not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ORDER_TIME between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ORDER_TIME not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameIsNull() {
            addCriterion("LANGUNGE_PAIR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameIsNotNull() {
            addCriterion("LANGUNGE_PAIR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR_NAME =", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameNotEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR_NAME <>", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameGreaterThan(String value) {
            addCriterion("LANGUNGE_PAIR_NAME >", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameGreaterThanOrEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR_NAME >=", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameLessThan(String value) {
            addCriterion("LANGUNGE_PAIR_NAME <", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameLessThanOrEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR_NAME <=", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameLike(String value) {
            addCriterion("LANGUNGE_PAIR_NAME like", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameNotLike(String value) {
            addCriterion("LANGUNGE_PAIR_NAME not like", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameIn(List<String> values) {
            addCriterion("LANGUNGE_PAIR_NAME in", values, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameNotIn(List<String> values) {
            addCriterion("LANGUNGE_PAIR_NAME not in", values, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameBetween(String value1, String value2) {
            addCriterion("LANGUNGE_PAIR_NAME between", value1, value2, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameNotBetween(String value1, String value2) {
            addCriterion("LANGUNGE_PAIR_NAME not between", value1, value2, "langungePairName");
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

        public Criteria andTotalFeeIsNull() {
            addCriterion("TOTAL_FEE is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("TOTAL_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(Long value) {
            addCriterion("TOTAL_FEE =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Long value) {
            addCriterion("TOTAL_FEE <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Long value) {
            addCriterion("TOTAL_FEE >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_FEE >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Long value) {
            addCriterion("TOTAL_FEE <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_FEE <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Long> values) {
            addCriterion("TOTAL_FEE in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Long> values) {
            addCriterion("TOTAL_FEE not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Long value1, Long value2) {
            addCriterion("TOTAL_FEE between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_FEE not between", value1, value2, "totalFee");
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

        public Criteria andInterperFeeIsNull() {
            addCriterion("INTERPER_FEE is null");
            return (Criteria) this;
        }

        public Criteria andInterperFeeIsNotNull() {
            addCriterion("INTERPER_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andInterperFeeEqualTo(Long value) {
            addCriterion("INTERPER_FEE =", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeNotEqualTo(Long value) {
            addCriterion("INTERPER_FEE <>", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeGreaterThan(Long value) {
            addCriterion("INTERPER_FEE >", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("INTERPER_FEE >=", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeLessThan(Long value) {
            addCriterion("INTERPER_FEE <", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeLessThanOrEqualTo(Long value) {
            addCriterion("INTERPER_FEE <=", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeIn(List<Long> values) {
            addCriterion("INTERPER_FEE in", values, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeNotIn(List<Long> values) {
            addCriterion("INTERPER_FEE not in", values, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeBetween(Long value1, Long value2) {
            addCriterion("INTERPER_FEE between", value1, value2, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeNotBetween(Long value1, Long value2) {
            addCriterion("INTERPER_FEE not between", value1, value2, "interperFee");
            return (Criteria) this;
        }

        public Criteria andNickname2IsNull() {
            addCriterion("nickname2 is null");
            return (Criteria) this;
        }

        public Criteria andNickname2IsNotNull() {
            addCriterion("nickname2 is not null");
            return (Criteria) this;
        }

        public Criteria andNickname2EqualTo(String value) {
            addCriterion("nickname2 =", value, "nickname2");
            return (Criteria) this;
        }

        public Criteria andNickname2NotEqualTo(String value) {
            addCriterion("nickname2 <>", value, "nickname2");
            return (Criteria) this;
        }

        public Criteria andNickname2GreaterThan(String value) {
            addCriterion("nickname2 >", value, "nickname2");
            return (Criteria) this;
        }

        public Criteria andNickname2GreaterThanOrEqualTo(String value) {
            addCriterion("nickname2 >=", value, "nickname2");
            return (Criteria) this;
        }

        public Criteria andNickname2LessThan(String value) {
            addCriterion("nickname2 <", value, "nickname2");
            return (Criteria) this;
        }

        public Criteria andNickname2LessThanOrEqualTo(String value) {
            addCriterion("nickname2 <=", value, "nickname2");
            return (Criteria) this;
        }

        public Criteria andNickname2Like(String value) {
            addCriterion("nickname2 like", value, "nickname2");
            return (Criteria) this;
        }

        public Criteria andNickname2NotLike(String value) {
            addCriterion("nickname2 not like", value, "nickname2");
            return (Criteria) this;
        }

        public Criteria andNickname2In(List<String> values) {
            addCriterion("nickname2 in", values, "nickname2");
            return (Criteria) this;
        }

        public Criteria andNickname2NotIn(List<String> values) {
            addCriterion("nickname2 not in", values, "nickname2");
            return (Criteria) this;
        }

        public Criteria andNickname2Between(String value1, String value2) {
            addCriterion("nickname2 between", value1, value2, "nickname2");
            return (Criteria) this;
        }

        public Criteria andNickname2NotBetween(String value1, String value2) {
            addCriterion("nickname2 not between", value1, value2, "nickname2");
            return (Criteria) this;
        }

        public Criteria andLspIdIsNull() {
            addCriterion("LSP_ID is null");
            return (Criteria) this;
        }

        public Criteria andLspIdIsNotNull() {
            addCriterion("LSP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLspIdEqualTo(String value) {
            addCriterion("LSP_ID =", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdNotEqualTo(String value) {
            addCriterion("LSP_ID <>", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdGreaterThan(String value) {
            addCriterion("LSP_ID >", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdGreaterThanOrEqualTo(String value) {
            addCriterion("LSP_ID >=", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdLessThan(String value) {
            addCriterion("LSP_ID <", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdLessThanOrEqualTo(String value) {
            addCriterion("LSP_ID <=", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdLike(String value) {
            addCriterion("LSP_ID like", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdNotLike(String value) {
            addCriterion("LSP_ID not like", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdIn(List<String> values) {
            addCriterion("LSP_ID in", values, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdNotIn(List<String> values) {
            addCriterion("LSP_ID not in", values, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdBetween(String value1, String value2) {
            addCriterion("LSP_ID between", value1, value2, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdNotBetween(String value1, String value2) {
            addCriterion("LSP_ID not between", value1, value2, "lspId");
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

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
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

        public Criteria andLspFeeIsNull() {
            addCriterion("LSP_FEE is null");
            return (Criteria) this;
        }

        public Criteria andLspFeeIsNotNull() {
            addCriterion("LSP_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andLspFeeEqualTo(Long value) {
            addCriterion("LSP_FEE =", value, "lspFee");
            return (Criteria) this;
        }

        public Criteria andLspFeeNotEqualTo(Long value) {
            addCriterion("LSP_FEE <>", value, "lspFee");
            return (Criteria) this;
        }

        public Criteria andLspFeeGreaterThan(Long value) {
            addCriterion("LSP_FEE >", value, "lspFee");
            return (Criteria) this;
        }

        public Criteria andLspFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("LSP_FEE >=", value, "lspFee");
            return (Criteria) this;
        }

        public Criteria andLspFeeLessThan(Long value) {
            addCriterion("LSP_FEE <", value, "lspFee");
            return (Criteria) this;
        }

        public Criteria andLspFeeLessThanOrEqualTo(Long value) {
            addCriterion("LSP_FEE <=", value, "lspFee");
            return (Criteria) this;
        }

        public Criteria andLspFeeIn(List<Long> values) {
            addCriterion("LSP_FEE in", values, "lspFee");
            return (Criteria) this;
        }

        public Criteria andLspFeeNotIn(List<Long> values) {
            addCriterion("LSP_FEE not in", values, "lspFee");
            return (Criteria) this;
        }

        public Criteria andLspFeeBetween(Long value1, Long value2) {
            addCriterion("LSP_FEE between", value1, value2, "lspFee");
            return (Criteria) this;
        }

        public Criteria andLspFeeNotBetween(Long value1, Long value2) {
            addCriterion("LSP_FEE not between", value1, value2, "lspFee");
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