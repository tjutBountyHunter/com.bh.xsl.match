package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XslRewardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslRewardExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRewardidIsNull() {
            addCriterion("rewardId is null");
            return (Criteria) this;
        }

        public Criteria andRewardidIsNotNull() {
            addCriterion("rewardId is not null");
            return (Criteria) this;
        }

        public Criteria andRewardidEqualTo(String value) {
            addCriterion("rewardId =", value, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardidNotEqualTo(String value) {
            addCriterion("rewardId <>", value, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardidGreaterThan(String value) {
            addCriterion("rewardId >", value, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardidGreaterThanOrEqualTo(String value) {
            addCriterion("rewardId >=", value, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardidLessThan(String value) {
            addCriterion("rewardId <", value, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardidLessThanOrEqualTo(String value) {
            addCriterion("rewardId <=", value, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardidLike(String value) {
            addCriterion("rewardId like", value, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardidNotLike(String value) {
            addCriterion("rewardId not like", value, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardidIn(List<String> values) {
            addCriterion("rewardId in", values, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardidNotIn(List<String> values) {
            addCriterion("rewardId not in", values, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardidBetween(String value1, String value2) {
            addCriterion("rewardId between", value1, value2, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardidNotBetween(String value1, String value2) {
            addCriterion("rewardId not between", value1, value2, "rewardid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidIsNull() {
            addCriterion("rewardRankId is null");
            return (Criteria) this;
        }

        public Criteria andRewardrankidIsNotNull() {
            addCriterion("rewardRankId is not null");
            return (Criteria) this;
        }

        public Criteria andRewardrankidEqualTo(String value) {
            addCriterion("rewardRankId =", value, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidNotEqualTo(String value) {
            addCriterion("rewardRankId <>", value, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidGreaterThan(String value) {
            addCriterion("rewardRankId >", value, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidGreaterThanOrEqualTo(String value) {
            addCriterion("rewardRankId >=", value, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidLessThan(String value) {
            addCriterion("rewardRankId <", value, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidLessThanOrEqualTo(String value) {
            addCriterion("rewardRankId <=", value, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidLike(String value) {
            addCriterion("rewardRankId like", value, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidNotLike(String value) {
            addCriterion("rewardRankId not like", value, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidIn(List<String> values) {
            addCriterion("rewardRankId in", values, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidNotIn(List<String> values) {
            addCriterion("rewardRankId not in", values, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidBetween(String value1, String value2) {
            addCriterion("rewardRankId between", value1, value2, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardrankidNotBetween(String value1, String value2) {
            addCriterion("rewardRankId not between", value1, value2, "rewardrankid");
            return (Criteria) this;
        }

        public Criteria andRewardcontentIsNull() {
            addCriterion("rewardContent is null");
            return (Criteria) this;
        }

        public Criteria andRewardcontentIsNotNull() {
            addCriterion("rewardContent is not null");
            return (Criteria) this;
        }

        public Criteria andRewardcontentEqualTo(String value) {
            addCriterion("rewardContent =", value, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andRewardcontentNotEqualTo(String value) {
            addCriterion("rewardContent <>", value, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andRewardcontentGreaterThan(String value) {
            addCriterion("rewardContent >", value, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andRewardcontentGreaterThanOrEqualTo(String value) {
            addCriterion("rewardContent >=", value, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andRewardcontentLessThan(String value) {
            addCriterion("rewardContent <", value, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andRewardcontentLessThanOrEqualTo(String value) {
            addCriterion("rewardContent <=", value, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andRewardcontentLike(String value) {
            addCriterion("rewardContent like", value, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andRewardcontentNotLike(String value) {
            addCriterion("rewardContent not like", value, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andRewardcontentIn(List<String> values) {
            addCriterion("rewardContent in", values, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andRewardcontentNotIn(List<String> values) {
            addCriterion("rewardContent not in", values, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andRewardcontentBetween(String value1, String value2) {
            addCriterion("rewardContent between", value1, value2, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andRewardcontentNotBetween(String value1, String value2) {
            addCriterion("rewardContent not between", value1, value2, "rewardcontent");
            return (Criteria) this;
        }

        public Criteria andContentquotaIsNull() {
            addCriterion("contentQuota is null");
            return (Criteria) this;
        }

        public Criteria andContentquotaIsNotNull() {
            addCriterion("contentQuota is not null");
            return (Criteria) this;
        }

        public Criteria andContentquotaEqualTo(Integer value) {
            addCriterion("contentQuota =", value, "contentquota");
            return (Criteria) this;
        }

        public Criteria andContentquotaNotEqualTo(Integer value) {
            addCriterion("contentQuota <>", value, "contentquota");
            return (Criteria) this;
        }

        public Criteria andContentquotaGreaterThan(Integer value) {
            addCriterion("contentQuota >", value, "contentquota");
            return (Criteria) this;
        }

        public Criteria andContentquotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("contentQuota >=", value, "contentquota");
            return (Criteria) this;
        }

        public Criteria andContentquotaLessThan(Integer value) {
            addCriterion("contentQuota <", value, "contentquota");
            return (Criteria) this;
        }

        public Criteria andContentquotaLessThanOrEqualTo(Integer value) {
            addCriterion("contentQuota <=", value, "contentquota");
            return (Criteria) this;
        }

        public Criteria andContentquotaIn(List<Integer> values) {
            addCriterion("contentQuota in", values, "contentquota");
            return (Criteria) this;
        }

        public Criteria andContentquotaNotIn(List<Integer> values) {
            addCriterion("contentQuota not in", values, "contentquota");
            return (Criteria) this;
        }

        public Criteria andContentquotaBetween(Integer value1, Integer value2) {
            addCriterion("contentQuota between", value1, value2, "contentquota");
            return (Criteria) this;
        }

        public Criteria andContentquotaNotBetween(Integer value1, Integer value2) {
            addCriterion("contentQuota not between", value1, value2, "contentquota");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeIsNull() {
            addCriterion("rewardCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeIsNotNull() {
            addCriterion("rewardCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeEqualTo(Date value) {
            addCriterion("rewardCreateTime =", value, "rewardcreatetime");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeNotEqualTo(Date value) {
            addCriterion("rewardCreateTime <>", value, "rewardcreatetime");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeGreaterThan(Date value) {
            addCriterion("rewardCreateTime >", value, "rewardcreatetime");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rewardCreateTime >=", value, "rewardcreatetime");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeLessThan(Date value) {
            addCriterion("rewardCreateTime <", value, "rewardcreatetime");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("rewardCreateTime <=", value, "rewardcreatetime");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeIn(List<Date> values) {
            addCriterion("rewardCreateTime in", values, "rewardcreatetime");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeNotIn(List<Date> values) {
            addCriterion("rewardCreateTime not in", values, "rewardcreatetime");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeBetween(Date value1, Date value2) {
            addCriterion("rewardCreateTime between", value1, value2, "rewardcreatetime");
            return (Criteria) this;
        }

        public Criteria andRewardcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("rewardCreateTime not between", value1, value2, "rewardcreatetime");
            return (Criteria) this;
        }

        public Criteria andRewardstateIsNull() {
            addCriterion("rewardState is null");
            return (Criteria) this;
        }

        public Criteria andRewardstateIsNotNull() {
            addCriterion("rewardState is not null");
            return (Criteria) this;
        }

        public Criteria andRewardstateEqualTo(Integer value) {
            addCriterion("rewardState =", value, "rewardstate");
            return (Criteria) this;
        }

        public Criteria andRewardstateNotEqualTo(Integer value) {
            addCriterion("rewardState <>", value, "rewardstate");
            return (Criteria) this;
        }

        public Criteria andRewardstateGreaterThan(Integer value) {
            addCriterion("rewardState >", value, "rewardstate");
            return (Criteria) this;
        }

        public Criteria andRewardstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("rewardState >=", value, "rewardstate");
            return (Criteria) this;
        }

        public Criteria andRewardstateLessThan(Integer value) {
            addCriterion("rewardState <", value, "rewardstate");
            return (Criteria) this;
        }

        public Criteria andRewardstateLessThanOrEqualTo(Integer value) {
            addCriterion("rewardState <=", value, "rewardstate");
            return (Criteria) this;
        }

        public Criteria andRewardstateIn(List<Integer> values) {
            addCriterion("rewardState in", values, "rewardstate");
            return (Criteria) this;
        }

        public Criteria andRewardstateNotIn(List<Integer> values) {
            addCriterion("rewardState not in", values, "rewardstate");
            return (Criteria) this;
        }

        public Criteria andRewardstateBetween(Integer value1, Integer value2) {
            addCriterion("rewardState between", value1, value2, "rewardstate");
            return (Criteria) this;
        }

        public Criteria andRewardstateNotBetween(Integer value1, Integer value2) {
            addCriterion("rewardState not between", value1, value2, "rewardstate");
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