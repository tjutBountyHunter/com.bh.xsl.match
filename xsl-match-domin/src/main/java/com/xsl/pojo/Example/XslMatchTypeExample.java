package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XslMatchTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslMatchTypeExample() {
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

        public Criteria andMatchtypeidIsNull() {
            addCriterion("matchTypeId is null");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidIsNotNull() {
            addCriterion("matchTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidEqualTo(String value) {
            addCriterion("matchTypeId =", value, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidNotEqualTo(String value) {
            addCriterion("matchTypeId <>", value, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidGreaterThan(String value) {
            addCriterion("matchTypeId >", value, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidGreaterThanOrEqualTo(String value) {
            addCriterion("matchTypeId >=", value, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidLessThan(String value) {
            addCriterion("matchTypeId <", value, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidLessThanOrEqualTo(String value) {
            addCriterion("matchTypeId <=", value, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidLike(String value) {
            addCriterion("matchTypeId like", value, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidNotLike(String value) {
            addCriterion("matchTypeId not like", value, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidIn(List<String> values) {
            addCriterion("matchTypeId in", values, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidNotIn(List<String> values) {
            addCriterion("matchTypeId not in", values, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidBetween(String value1, String value2) {
            addCriterion("matchTypeId between", value1, value2, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypeidNotBetween(String value1, String value2) {
            addCriterion("matchTypeId not between", value1, value2, "matchtypeid");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameIsNull() {
            addCriterion("matchTypeName is null");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameIsNotNull() {
            addCriterion("matchTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameEqualTo(String value) {
            addCriterion("matchTypeName =", value, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameNotEqualTo(String value) {
            addCriterion("matchTypeName <>", value, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameGreaterThan(String value) {
            addCriterion("matchTypeName >", value, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameGreaterThanOrEqualTo(String value) {
            addCriterion("matchTypeName >=", value, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameLessThan(String value) {
            addCriterion("matchTypeName <", value, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameLessThanOrEqualTo(String value) {
            addCriterion("matchTypeName <=", value, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameLike(String value) {
            addCriterion("matchTypeName like", value, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameNotLike(String value) {
            addCriterion("matchTypeName not like", value, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameIn(List<String> values) {
            addCriterion("matchTypeName in", values, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameNotIn(List<String> values) {
            addCriterion("matchTypeName not in", values, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameBetween(String value1, String value2) {
            addCriterion("matchTypeName between", value1, value2, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypenameNotBetween(String value1, String value2) {
            addCriterion("matchTypeName not between", value1, value2, "matchtypename");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateIsNull() {
            addCriterion("matchTypeState is null");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateIsNotNull() {
            addCriterion("matchTypeState is not null");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateEqualTo(Integer value) {
            addCriterion("matchTypeState =", value, "matchtypestate");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateNotEqualTo(Integer value) {
            addCriterion("matchTypeState <>", value, "matchtypestate");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateGreaterThan(Integer value) {
            addCriterion("matchTypeState >", value, "matchtypestate");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("matchTypeState >=", value, "matchtypestate");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateLessThan(Integer value) {
            addCriterion("matchTypeState <", value, "matchtypestate");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateLessThanOrEqualTo(Integer value) {
            addCriterion("matchTypeState <=", value, "matchtypestate");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateIn(List<Integer> values) {
            addCriterion("matchTypeState in", values, "matchtypestate");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateNotIn(List<Integer> values) {
            addCriterion("matchTypeState not in", values, "matchtypestate");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateBetween(Integer value1, Integer value2) {
            addCriterion("matchTypeState between", value1, value2, "matchtypestate");
            return (Criteria) this;
        }

        public Criteria andMatchtypestateNotBetween(Integer value1, Integer value2) {
            addCriterion("matchTypeState not between", value1, value2, "matchtypestate");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoIsNull() {
            addCriterion("matchTypeInfo is null");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoIsNotNull() {
            addCriterion("matchTypeInfo is not null");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoEqualTo(String value) {
            addCriterion("matchTypeInfo =", value, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoNotEqualTo(String value) {
            addCriterion("matchTypeInfo <>", value, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoGreaterThan(String value) {
            addCriterion("matchTypeInfo >", value, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoGreaterThanOrEqualTo(String value) {
            addCriterion("matchTypeInfo >=", value, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoLessThan(String value) {
            addCriterion("matchTypeInfo <", value, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoLessThanOrEqualTo(String value) {
            addCriterion("matchTypeInfo <=", value, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoLike(String value) {
            addCriterion("matchTypeInfo like", value, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoNotLike(String value) {
            addCriterion("matchTypeInfo not like", value, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoIn(List<String> values) {
            addCriterion("matchTypeInfo in", values, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoNotIn(List<String> values) {
            addCriterion("matchTypeInfo not in", values, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoBetween(String value1, String value2) {
            addCriterion("matchTypeInfo between", value1, value2, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypeinfoNotBetween(String value1, String value2) {
            addCriterion("matchTypeInfo not between", value1, value2, "matchtypeinfo");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeIsNull() {
            addCriterion("matchTypeCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeIsNotNull() {
            addCriterion("matchTypeCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeEqualTo(Date value) {
            addCriterion("matchTypeCreateTime =", value, "matchtypecreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeNotEqualTo(Date value) {
            addCriterion("matchTypeCreateTime <>", value, "matchtypecreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeGreaterThan(Date value) {
            addCriterion("matchTypeCreateTime >", value, "matchtypecreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("matchTypeCreateTime >=", value, "matchtypecreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeLessThan(Date value) {
            addCriterion("matchTypeCreateTime <", value, "matchtypecreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("matchTypeCreateTime <=", value, "matchtypecreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeIn(List<Date> values) {
            addCriterion("matchTypeCreateTime in", values, "matchtypecreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeNotIn(List<Date> values) {
            addCriterion("matchTypeCreateTime not in", values, "matchtypecreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeBetween(Date value1, Date value2) {
            addCriterion("matchTypeCreateTime between", value1, value2, "matchtypecreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchtypecreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("matchTypeCreateTime not between", value1, value2, "matchtypecreatetime");
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