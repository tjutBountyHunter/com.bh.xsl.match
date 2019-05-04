package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.List;

public class XslMatchRankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslMatchRankExample() {
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

        public Criteria andMatchrankidIsNull() {
            addCriterion("matchRankId is null");
            return (Criteria) this;
        }

        public Criteria andMatchrankidIsNotNull() {
            addCriterion("matchRankId is not null");
            return (Criteria) this;
        }

        public Criteria andMatchrankidEqualTo(String value) {
            addCriterion("matchRankId =", value, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andMatchrankidNotEqualTo(String value) {
            addCriterion("matchRankId <>", value, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andMatchrankidGreaterThan(String value) {
            addCriterion("matchRankId >", value, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andMatchrankidGreaterThanOrEqualTo(String value) {
            addCriterion("matchRankId >=", value, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andMatchrankidLessThan(String value) {
            addCriterion("matchRankId <", value, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andMatchrankidLessThanOrEqualTo(String value) {
            addCriterion("matchRankId <=", value, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andMatchrankidLike(String value) {
            addCriterion("matchRankId like", value, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andMatchrankidNotLike(String value) {
            addCriterion("matchRankId not like", value, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andMatchrankidIn(List<String> values) {
            addCriterion("matchRankId in", values, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andMatchrankidNotIn(List<String> values) {
            addCriterion("matchRankId not in", values, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andMatchrankidBetween(String value1, String value2) {
            addCriterion("matchRankId between", value1, value2, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andMatchrankidNotBetween(String value1, String value2) {
            addCriterion("matchRankId not between", value1, value2, "matchrankid");
            return (Criteria) this;
        }

        public Criteria andRanknameIsNull() {
            addCriterion("rankName is null");
            return (Criteria) this;
        }

        public Criteria andRanknameIsNotNull() {
            addCriterion("rankName is not null");
            return (Criteria) this;
        }

        public Criteria andRanknameEqualTo(String value) {
            addCriterion("rankName =", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameNotEqualTo(String value) {
            addCriterion("rankName <>", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameGreaterThan(String value) {
            addCriterion("rankName >", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameGreaterThanOrEqualTo(String value) {
            addCriterion("rankName >=", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameLessThan(String value) {
            addCriterion("rankName <", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameLessThanOrEqualTo(String value) {
            addCriterion("rankName <=", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameLike(String value) {
            addCriterion("rankName like", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameNotLike(String value) {
            addCriterion("rankName not like", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameIn(List<String> values) {
            addCriterion("rankName in", values, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameNotIn(List<String> values) {
            addCriterion("rankName not in", values, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameBetween(String value1, String value2) {
            addCriterion("rankName between", value1, value2, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameNotBetween(String value1, String value2) {
            addCriterion("rankName not between", value1, value2, "rankname");
            return (Criteria) this;
        }

        public Criteria andRankinfoIsNull() {
            addCriterion("rankInfo is null");
            return (Criteria) this;
        }

        public Criteria andRankinfoIsNotNull() {
            addCriterion("rankInfo is not null");
            return (Criteria) this;
        }

        public Criteria andRankinfoEqualTo(String value) {
            addCriterion("rankInfo =", value, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankinfoNotEqualTo(String value) {
            addCriterion("rankInfo <>", value, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankinfoGreaterThan(String value) {
            addCriterion("rankInfo >", value, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankinfoGreaterThanOrEqualTo(String value) {
            addCriterion("rankInfo >=", value, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankinfoLessThan(String value) {
            addCriterion("rankInfo <", value, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankinfoLessThanOrEqualTo(String value) {
            addCriterion("rankInfo <=", value, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankinfoLike(String value) {
            addCriterion("rankInfo like", value, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankinfoNotLike(String value) {
            addCriterion("rankInfo not like", value, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankinfoIn(List<String> values) {
            addCriterion("rankInfo in", values, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankinfoNotIn(List<String> values) {
            addCriterion("rankInfo not in", values, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankinfoBetween(String value1, String value2) {
            addCriterion("rankInfo between", value1, value2, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankinfoNotBetween(String value1, String value2) {
            addCriterion("rankInfo not between", value1, value2, "rankinfo");
            return (Criteria) this;
        }

        public Criteria andRankstateIsNull() {
            addCriterion("rankState is null");
            return (Criteria) this;
        }

        public Criteria andRankstateIsNotNull() {
            addCriterion("rankState is not null");
            return (Criteria) this;
        }

        public Criteria andRankstateEqualTo(Integer value) {
            addCriterion("rankState =", value, "rankstate");
            return (Criteria) this;
        }

        public Criteria andRankstateNotEqualTo(Integer value) {
            addCriterion("rankState <>", value, "rankstate");
            return (Criteria) this;
        }

        public Criteria andRankstateGreaterThan(Integer value) {
            addCriterion("rankState >", value, "rankstate");
            return (Criteria) this;
        }

        public Criteria andRankstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("rankState >=", value, "rankstate");
            return (Criteria) this;
        }

        public Criteria andRankstateLessThan(Integer value) {
            addCriterion("rankState <", value, "rankstate");
            return (Criteria) this;
        }

        public Criteria andRankstateLessThanOrEqualTo(Integer value) {
            addCriterion("rankState <=", value, "rankstate");
            return (Criteria) this;
        }

        public Criteria andRankstateIn(List<Integer> values) {
            addCriterion("rankState in", values, "rankstate");
            return (Criteria) this;
        }

        public Criteria andRankstateNotIn(List<Integer> values) {
            addCriterion("rankState not in", values, "rankstate");
            return (Criteria) this;
        }

        public Criteria andRankstateBetween(Integer value1, Integer value2) {
            addCriterion("rankState between", value1, value2, "rankstate");
            return (Criteria) this;
        }

        public Criteria andRankstateNotBetween(Integer value1, Integer value2) {
            addCriterion("rankState not between", value1, value2, "rankstate");
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