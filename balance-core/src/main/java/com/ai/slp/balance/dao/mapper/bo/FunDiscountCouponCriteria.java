package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FunDiscountCouponCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public FunDiscountCouponCriteria() {
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

        public Criteria andCouponIdIsNull() {
            addCriterion("COUPON_ID is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("COUPON_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(String value) {
            addCriterion("COUPON_ID =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(String value) {
            addCriterion("COUPON_ID <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(String value) {
            addCriterion("COUPON_ID >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(String value) {
            addCriterion("COUPON_ID >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(String value) {
            addCriterion("COUPON_ID <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(String value) {
            addCriterion("COUPON_ID <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLike(String value) {
            addCriterion("COUPON_ID like", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotLike(String value) {
            addCriterion("COUPON_ID not like", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<String> values) {
            addCriterion("COUPON_ID in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<String> values) {
            addCriterion("COUPON_ID not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(String value1, String value2) {
            addCriterion("COUPON_ID between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(String value1, String value2) {
            addCriterion("COUPON_ID not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponNameIsNull() {
            addCriterion("COUPON_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCouponNameIsNotNull() {
            addCriterion("COUPON_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCouponNameEqualTo(String value) {
            addCriterion("COUPON_NAME =", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotEqualTo(String value) {
            addCriterion("COUPON_NAME <>", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThan(String value) {
            addCriterion("COUPON_NAME >", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThanOrEqualTo(String value) {
            addCriterion("COUPON_NAME >=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThan(String value) {
            addCriterion("COUPON_NAME <", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThanOrEqualTo(String value) {
            addCriterion("COUPON_NAME <=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLike(String value) {
            addCriterion("COUPON_NAME like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotLike(String value) {
            addCriterion("COUPON_NAME not like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameIn(List<String> values) {
            addCriterion("COUPON_NAME in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotIn(List<String> values) {
            addCriterion("COUPON_NAME not in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameBetween(String value1, String value2) {
            addCriterion("COUPON_NAME between", value1, value2, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotBetween(String value1, String value2) {
            addCriterion("COUPON_NAME not between", value1, value2, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponDescIsNull() {
            addCriterion("COUPON_DESC is null");
            return (Criteria) this;
        }

        public Criteria andCouponDescIsNotNull() {
            addCriterion("COUPON_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andCouponDescEqualTo(String value) {
            addCriterion("COUPON_DESC =", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotEqualTo(String value) {
            addCriterion("COUPON_DESC <>", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescGreaterThan(String value) {
            addCriterion("COUPON_DESC >", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescGreaterThanOrEqualTo(String value) {
            addCriterion("COUPON_DESC >=", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescLessThan(String value) {
            addCriterion("COUPON_DESC <", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescLessThanOrEqualTo(String value) {
            addCriterion("COUPON_DESC <=", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescLike(String value) {
            addCriterion("COUPON_DESC like", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotLike(String value) {
            addCriterion("COUPON_DESC not like", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescIn(List<String> values) {
            addCriterion("COUPON_DESC in", values, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotIn(List<String> values) {
            addCriterion("COUPON_DESC not in", values, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescBetween(String value1, String value2) {
            addCriterion("COUPON_DESC between", value1, value2, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotBetween(String value1, String value2) {
            addCriterion("COUPON_DESC not between", value1, value2, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("ACTIVITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("ACTIVITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("ACTIVITY_ID =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("ACTIVITY_ID <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("ACTIVITY_ID >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACTIVITY_ID >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("ACTIVITY_ID <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("ACTIVITY_ID <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("ACTIVITY_ID in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("ACTIVITY_ID not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("ACTIVITY_ID between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ACTIVITY_ID not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(Integer value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(Integer value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(Integer value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(Integer value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(Integer value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<Integer> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<Integer> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(Integer value1, Integer value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
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

        public Criteria andUsedSceneIsNull() {
            addCriterion("used_scene is null");
            return (Criteria) this;
        }

        public Criteria andUsedSceneIsNotNull() {
            addCriterion("used_scene is not null");
            return (Criteria) this;
        }

        public Criteria andUsedSceneEqualTo(String value) {
            addCriterion("used_scene =", value, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUsedSceneNotEqualTo(String value) {
            addCriterion("used_scene <>", value, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUsedSceneGreaterThan(String value) {
            addCriterion("used_scene >", value, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUsedSceneGreaterThanOrEqualTo(String value) {
            addCriterion("used_scene >=", value, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUsedSceneLessThan(String value) {
            addCriterion("used_scene <", value, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUsedSceneLessThanOrEqualTo(String value) {
            addCriterion("used_scene <=", value, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUsedSceneLike(String value) {
            addCriterion("used_scene like", value, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUsedSceneNotLike(String value) {
            addCriterion("used_scene not like", value, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUsedSceneIn(List<String> values) {
            addCriterion("used_scene in", values, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUsedSceneNotIn(List<String> values) {
            addCriterion("used_scene not in", values, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUsedSceneBetween(String value1, String value2) {
            addCriterion("used_scene between", value1, value2, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUsedSceneNotBetween(String value1, String value2) {
            addCriterion("used_scene not between", value1, value2, "usedScene");
            return (Criteria) this;
        }

        public Criteria andUseLimitsIsNull() {
            addCriterion("USE_LIMITS is null");
            return (Criteria) this;
        }

        public Criteria andUseLimitsIsNotNull() {
            addCriterion("USE_LIMITS is not null");
            return (Criteria) this;
        }

        public Criteria andUseLimitsEqualTo(String value) {
            addCriterion("USE_LIMITS =", value, "useLimits");
            return (Criteria) this;
        }

        public Criteria andUseLimitsNotEqualTo(String value) {
            addCriterion("USE_LIMITS <>", value, "useLimits");
            return (Criteria) this;
        }

        public Criteria andUseLimitsGreaterThan(String value) {
            addCriterion("USE_LIMITS >", value, "useLimits");
            return (Criteria) this;
        }

        public Criteria andUseLimitsGreaterThanOrEqualTo(String value) {
            addCriterion("USE_LIMITS >=", value, "useLimits");
            return (Criteria) this;
        }

        public Criteria andUseLimitsLessThan(String value) {
            addCriterion("USE_LIMITS <", value, "useLimits");
            return (Criteria) this;
        }

        public Criteria andUseLimitsLessThanOrEqualTo(String value) {
            addCriterion("USE_LIMITS <=", value, "useLimits");
            return (Criteria) this;
        }

        public Criteria andUseLimitsLike(String value) {
            addCriterion("USE_LIMITS like", value, "useLimits");
            return (Criteria) this;
        }

        public Criteria andUseLimitsNotLike(String value) {
            addCriterion("USE_LIMITS not like", value, "useLimits");
            return (Criteria) this;
        }

        public Criteria andUseLimitsIn(List<String> values) {
            addCriterion("USE_LIMITS in", values, "useLimits");
            return (Criteria) this;
        }

        public Criteria andUseLimitsNotIn(List<String> values) {
            addCriterion("USE_LIMITS not in", values, "useLimits");
            return (Criteria) this;
        }

        public Criteria andUseLimitsBetween(String value1, String value2) {
            addCriterion("USE_LIMITS between", value1, value2, "useLimits");
            return (Criteria) this;
        }

        public Criteria andUseLimitsNotBetween(String value1, String value2) {
            addCriterion("USE_LIMITS not between", value1, value2, "useLimits");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIsNull() {
            addCriterion("EFFECTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIsNotNull() {
            addCriterion("EFFECTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEqualTo(Integer value) {
            addCriterion("EFFECTIVE_TIME =", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotEqualTo(Integer value) {
            addCriterion("EFFECTIVE_TIME <>", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThan(Integer value) {
            addCriterion("EFFECTIVE_TIME >", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("EFFECTIVE_TIME >=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThan(Integer value) {
            addCriterion("EFFECTIVE_TIME <", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThanOrEqualTo(Integer value) {
            addCriterion("EFFECTIVE_TIME <=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIn(List<Integer> values) {
            addCriterion("EFFECTIVE_TIME in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotIn(List<Integer> values) {
            addCriterion("EFFECTIVE_TIME not in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBetween(Integer value1, Integer value2) {
            addCriterion("EFFECTIVE_TIME between", value1, value2, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("EFFECTIVE_TIME not between", value1, value2, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeIsNull() {
            addCriterion("EFFECTIVE_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeIsNotNull() {
            addCriterion("EFFECTIVE_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeEqualTo(Timestamp value) {
            addCriterion("EFFECTIVE_START_TIME =", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeNotEqualTo(Timestamp value) {
            addCriterion("EFFECTIVE_START_TIME <>", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeGreaterThan(Timestamp value) {
            addCriterion("EFFECTIVE_START_TIME >", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("EFFECTIVE_START_TIME >=", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeLessThan(Timestamp value) {
            addCriterion("EFFECTIVE_START_TIME <", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("EFFECTIVE_START_TIME <=", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeIn(List<Timestamp> values) {
            addCriterion("EFFECTIVE_START_TIME in", values, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeNotIn(List<Timestamp> values) {
            addCriterion("EFFECTIVE_START_TIME not in", values, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("EFFECTIVE_START_TIME between", value1, value2, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("EFFECTIVE_START_TIME not between", value1, value2, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeIsNull() {
            addCriterion("EFFECTIVE_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeIsNotNull() {
            addCriterion("EFFECTIVE_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeEqualTo(Timestamp value) {
            addCriterion("EFFECTIVE_END_TIME =", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeNotEqualTo(Timestamp value) {
            addCriterion("EFFECTIVE_END_TIME <>", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeGreaterThan(Timestamp value) {
            addCriterion("EFFECTIVE_END_TIME >", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("EFFECTIVE_END_TIME >=", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeLessThan(Timestamp value) {
            addCriterion("EFFECTIVE_END_TIME <", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("EFFECTIVE_END_TIME <=", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeIn(List<Timestamp> values) {
            addCriterion("EFFECTIVE_END_TIME in", values, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeNotIn(List<Timestamp> values) {
            addCriterion("EFFECTIVE_END_TIME not in", values, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("EFFECTIVE_END_TIME between", value1, value2, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("EFFECTIVE_END_TIME not between", value1, value2, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("ACCOUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("ACCOUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("ACCOUNT_ID >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("ACCOUNT_ID <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("ACCOUNT_ID in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("ACCOUNT_ID not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("ACCOUNT_ID between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ACCOUNT_ID not between", value1, value2, "accountId");
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

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNull() {
            addCriterion("USE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNotNull() {
            addCriterion("USE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeEqualTo(Timestamp value) {
            addCriterion("USE_TIME =", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotEqualTo(Timestamp value) {
            addCriterion("USE_TIME <>", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThan(Timestamp value) {
            addCriterion("USE_TIME >", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("USE_TIME >=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThan(Timestamp value) {
            addCriterion("USE_TIME <", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("USE_TIME <=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeIn(List<Timestamp> values) {
            addCriterion("USE_TIME in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotIn(List<Timestamp> values) {
            addCriterion("USE_TIME not in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USE_TIME between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USE_TIME not between", value1, value2, "useTime");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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