package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XslMatchRewardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslMatchRewardExample() {
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

        public Criteria andMatchidIsNull() {
            addCriterion("matchId is null");
            return (Criteria) this;
        }

        public Criteria andMatchidIsNotNull() {
            addCriterion("matchId is not null");
            return (Criteria) this;
        }

        public Criteria andMatchidEqualTo(String value) {
            addCriterion("matchId =", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotEqualTo(String value) {
            addCriterion("matchId <>", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThan(String value) {
            addCriterion("matchId >", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThanOrEqualTo(String value) {
            addCriterion("matchId >=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThan(String value) {
            addCriterion("matchId <", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThanOrEqualTo(String value) {
            addCriterion("matchId <=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLike(String value) {
            addCriterion("matchId like", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotLike(String value) {
            addCriterion("matchId not like", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidIn(List<String> values) {
            addCriterion("matchId in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotIn(List<String> values) {
            addCriterion("matchId not in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidBetween(String value1, String value2) {
            addCriterion("matchId between", value1, value2, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotBetween(String value1, String value2) {
            addCriterion("matchId not between", value1, value2, "matchid");
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

        public Criteria andRewardaddtimeIsNull() {
            addCriterion("rewardAddTime is null");
            return (Criteria) this;
        }

        public Criteria andRewardaddtimeIsNotNull() {
            addCriterion("rewardAddTime is not null");
            return (Criteria) this;
        }

        public Criteria andRewardaddtimeEqualTo(Date value) {
            addCriterion("rewardAddTime =", value, "rewardaddtime");
            return (Criteria) this;
        }

        public Criteria andRewardaddtimeNotEqualTo(Date value) {
            addCriterion("rewardAddTime <>", value, "rewardaddtime");
            return (Criteria) this;
        }

        public Criteria andRewardaddtimeGreaterThan(Date value) {
            addCriterion("rewardAddTime >", value, "rewardaddtime");
            return (Criteria) this;
        }

        public Criteria andRewardaddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rewardAddTime >=", value, "rewardaddtime");
            return (Criteria) this;
        }

        public Criteria andRewardaddtimeLessThan(Date value) {
            addCriterion("rewardAddTime <", value, "rewardaddtime");
            return (Criteria) this;
        }

        public Criteria andRewardaddtimeLessThanOrEqualTo(Date value) {
            addCriterion("rewardAddTime <=", value, "rewardaddtime");
            return (Criteria) this;
        }

        public Criteria andRewardaddtimeIn(List<Date> values) {
            addCriterion("rewardAddTime in", values, "rewardaddtime");
            return (Criteria) this;
        }

        public Criteria andRewardaddtimeNotIn(List<Date> values) {
            addCriterion("rewardAddTime not in", values, "rewardaddtime");
            return (Criteria) this;
        }

        public Criteria andRewardaddtimeBetween(Date value1, Date value2) {
            addCriterion("rewardAddTime between", value1, value2, "rewardaddtime");
            return (Criteria) this;
        }

        public Criteria andRewardaddtimeNotBetween(Date value1, Date value2) {
            addCriterion("rewardAddTime not between", value1, value2, "rewardaddtime");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateIsNull() {
            addCriterion("matchRewardState is null");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateIsNotNull() {
            addCriterion("matchRewardState is not null");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateEqualTo(Integer value) {
            addCriterion("matchRewardState =", value, "matchrewardstate");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateNotEqualTo(Integer value) {
            addCriterion("matchRewardState <>", value, "matchrewardstate");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateGreaterThan(Integer value) {
            addCriterion("matchRewardState >", value, "matchrewardstate");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("matchRewardState >=", value, "matchrewardstate");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateLessThan(Integer value) {
            addCriterion("matchRewardState <", value, "matchrewardstate");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateLessThanOrEqualTo(Integer value) {
            addCriterion("matchRewardState <=", value, "matchrewardstate");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateIn(List<Integer> values) {
            addCriterion("matchRewardState in", values, "matchrewardstate");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateNotIn(List<Integer> values) {
            addCriterion("matchRewardState not in", values, "matchrewardstate");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateBetween(Integer value1, Integer value2) {
            addCriterion("matchRewardState between", value1, value2, "matchrewardstate");
            return (Criteria) this;
        }

        public Criteria andMatchrewardstateNotBetween(Integer value1, Integer value2) {
            addCriterion("matchRewardState not between", value1, value2, "matchrewardstate");
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