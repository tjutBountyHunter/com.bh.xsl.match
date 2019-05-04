package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.List;

public class XslOrientedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslOrientedExample() {
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

        public Criteria andOrientedidIsNull() {
            addCriterion("orientedId is null");
            return (Criteria) this;
        }

        public Criteria andOrientedidIsNotNull() {
            addCriterion("orientedId is not null");
            return (Criteria) this;
        }

        public Criteria andOrientedidEqualTo(String value) {
            addCriterion("orientedId =", value, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientedidNotEqualTo(String value) {
            addCriterion("orientedId <>", value, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientedidGreaterThan(String value) {
            addCriterion("orientedId >", value, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientedidGreaterThanOrEqualTo(String value) {
            addCriterion("orientedId >=", value, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientedidLessThan(String value) {
            addCriterion("orientedId <", value, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientedidLessThanOrEqualTo(String value) {
            addCriterion("orientedId <=", value, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientedidLike(String value) {
            addCriterion("orientedId like", value, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientedidNotLike(String value) {
            addCriterion("orientedId not like", value, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientedidIn(List<String> values) {
            addCriterion("orientedId in", values, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientedidNotIn(List<String> values) {
            addCriterion("orientedId not in", values, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientedidBetween(String value1, String value2) {
            addCriterion("orientedId between", value1, value2, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientedidNotBetween(String value1, String value2) {
            addCriterion("orientedId not between", value1, value2, "orientedid");
            return (Criteria) this;
        }

        public Criteria andOrientednameIsNull() {
            addCriterion("orientedName is null");
            return (Criteria) this;
        }

        public Criteria andOrientednameIsNotNull() {
            addCriterion("orientedName is not null");
            return (Criteria) this;
        }

        public Criteria andOrientednameEqualTo(String value) {
            addCriterion("orientedName =", value, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientednameNotEqualTo(String value) {
            addCriterion("orientedName <>", value, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientednameGreaterThan(String value) {
            addCriterion("orientedName >", value, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientednameGreaterThanOrEqualTo(String value) {
            addCriterion("orientedName >=", value, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientednameLessThan(String value) {
            addCriterion("orientedName <", value, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientednameLessThanOrEqualTo(String value) {
            addCriterion("orientedName <=", value, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientednameLike(String value) {
            addCriterion("orientedName like", value, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientednameNotLike(String value) {
            addCriterion("orientedName not like", value, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientednameIn(List<String> values) {
            addCriterion("orientedName in", values, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientednameNotIn(List<String> values) {
            addCriterion("orientedName not in", values, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientednameBetween(String value1, String value2) {
            addCriterion("orientedName between", value1, value2, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientednameNotBetween(String value1, String value2) {
            addCriterion("orientedName not between", value1, value2, "orientedname");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoIsNull() {
            addCriterion("orientedInfo is null");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoIsNotNull() {
            addCriterion("orientedInfo is not null");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoEqualTo(String value) {
            addCriterion("orientedInfo =", value, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoNotEqualTo(String value) {
            addCriterion("orientedInfo <>", value, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoGreaterThan(String value) {
            addCriterion("orientedInfo >", value, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoGreaterThanOrEqualTo(String value) {
            addCriterion("orientedInfo >=", value, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoLessThan(String value) {
            addCriterion("orientedInfo <", value, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoLessThanOrEqualTo(String value) {
            addCriterion("orientedInfo <=", value, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoLike(String value) {
            addCriterion("orientedInfo like", value, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoNotLike(String value) {
            addCriterion("orientedInfo not like", value, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoIn(List<String> values) {
            addCriterion("orientedInfo in", values, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoNotIn(List<String> values) {
            addCriterion("orientedInfo not in", values, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoBetween(String value1, String value2) {
            addCriterion("orientedInfo between", value1, value2, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedinfoNotBetween(String value1, String value2) {
            addCriterion("orientedInfo not between", value1, value2, "orientedinfo");
            return (Criteria) this;
        }

        public Criteria andOrientedstateIsNull() {
            addCriterion("orientedState is null");
            return (Criteria) this;
        }

        public Criteria andOrientedstateIsNotNull() {
            addCriterion("orientedState is not null");
            return (Criteria) this;
        }

        public Criteria andOrientedstateEqualTo(Integer value) {
            addCriterion("orientedState =", value, "orientedstate");
            return (Criteria) this;
        }

        public Criteria andOrientedstateNotEqualTo(Integer value) {
            addCriterion("orientedState <>", value, "orientedstate");
            return (Criteria) this;
        }

        public Criteria andOrientedstateGreaterThan(Integer value) {
            addCriterion("orientedState >", value, "orientedstate");
            return (Criteria) this;
        }

        public Criteria andOrientedstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("orientedState >=", value, "orientedstate");
            return (Criteria) this;
        }

        public Criteria andOrientedstateLessThan(Integer value) {
            addCriterion("orientedState <", value, "orientedstate");
            return (Criteria) this;
        }

        public Criteria andOrientedstateLessThanOrEqualTo(Integer value) {
            addCriterion("orientedState <=", value, "orientedstate");
            return (Criteria) this;
        }

        public Criteria andOrientedstateIn(List<Integer> values) {
            addCriterion("orientedState in", values, "orientedstate");
            return (Criteria) this;
        }

        public Criteria andOrientedstateNotIn(List<Integer> values) {
            addCriterion("orientedState not in", values, "orientedstate");
            return (Criteria) this;
        }

        public Criteria andOrientedstateBetween(Integer value1, Integer value2) {
            addCriterion("orientedState between", value1, value2, "orientedstate");
            return (Criteria) this;
        }

        public Criteria andOrientedstateNotBetween(Integer value1, Integer value2) {
            addCriterion("orientedState not between", value1, value2, "orientedstate");
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