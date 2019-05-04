package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XslTeamPositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslTeamPositionExample() {
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

        public Criteria andPositionidIsNull() {
            addCriterion("positionId is null");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNotNull() {
            addCriterion("positionId is not null");
            return (Criteria) this;
        }

        public Criteria andPositionidEqualTo(String value) {
            addCriterion("positionId =", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotEqualTo(String value) {
            addCriterion("positionId <>", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThan(String value) {
            addCriterion("positionId >", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThanOrEqualTo(String value) {
            addCriterion("positionId >=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThan(String value) {
            addCriterion("positionId <", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThanOrEqualTo(String value) {
            addCriterion("positionId <=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLike(String value) {
            addCriterion("positionId like", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotLike(String value) {
            addCriterion("positionId not like", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidIn(List<String> values) {
            addCriterion("positionId in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotIn(List<String> values) {
            addCriterion("positionId not in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidBetween(String value1, String value2) {
            addCriterion("positionId between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotBetween(String value1, String value2) {
            addCriterion("positionId not between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andTeamidIsNull() {
            addCriterion("teamId is null");
            return (Criteria) this;
        }

        public Criteria andTeamidIsNotNull() {
            addCriterion("teamId is not null");
            return (Criteria) this;
        }

        public Criteria andTeamidEqualTo(String value) {
            addCriterion("teamId =", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotEqualTo(String value) {
            addCriterion("teamId <>", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidGreaterThan(String value) {
            addCriterion("teamId >", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidGreaterThanOrEqualTo(String value) {
            addCriterion("teamId >=", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidLessThan(String value) {
            addCriterion("teamId <", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidLessThanOrEqualTo(String value) {
            addCriterion("teamId <=", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidLike(String value) {
            addCriterion("teamId like", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotLike(String value) {
            addCriterion("teamId not like", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidIn(List<String> values) {
            addCriterion("teamId in", values, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotIn(List<String> values) {
            addCriterion("teamId not in", values, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidBetween(String value1, String value2) {
            addCriterion("teamId between", value1, value2, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotBetween(String value1, String value2) {
            addCriterion("teamId not between", value1, value2, "teamid");
            return (Criteria) this;
        }

        public Criteria andPositionnameIsNull() {
            addCriterion("positionName is null");
            return (Criteria) this;
        }

        public Criteria andPositionnameIsNotNull() {
            addCriterion("positionName is not null");
            return (Criteria) this;
        }

        public Criteria andPositionnameEqualTo(String value) {
            addCriterion("positionName =", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotEqualTo(String value) {
            addCriterion("positionName <>", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameGreaterThan(String value) {
            addCriterion("positionName >", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameGreaterThanOrEqualTo(String value) {
            addCriterion("positionName >=", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameLessThan(String value) {
            addCriterion("positionName <", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameLessThanOrEqualTo(String value) {
            addCriterion("positionName <=", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameLike(String value) {
            addCriterion("positionName like", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotLike(String value) {
            addCriterion("positionName not like", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameIn(List<String> values) {
            addCriterion("positionName in", values, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotIn(List<String> values) {
            addCriterion("positionName not in", values, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameBetween(String value1, String value2) {
            addCriterion("positionName between", value1, value2, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotBetween(String value1, String value2) {
            addCriterion("positionName not between", value1, value2, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositioninfoIsNull() {
            addCriterion("positionInfo is null");
            return (Criteria) this;
        }

        public Criteria andPositioninfoIsNotNull() {
            addCriterion("positionInfo is not null");
            return (Criteria) this;
        }

        public Criteria andPositioninfoEqualTo(String value) {
            addCriterion("positionInfo =", value, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositioninfoNotEqualTo(String value) {
            addCriterion("positionInfo <>", value, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositioninfoGreaterThan(String value) {
            addCriterion("positionInfo >", value, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositioninfoGreaterThanOrEqualTo(String value) {
            addCriterion("positionInfo >=", value, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositioninfoLessThan(String value) {
            addCriterion("positionInfo <", value, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositioninfoLessThanOrEqualTo(String value) {
            addCriterion("positionInfo <=", value, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositioninfoLike(String value) {
            addCriterion("positionInfo like", value, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositioninfoNotLike(String value) {
            addCriterion("positionInfo not like", value, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositioninfoIn(List<String> values) {
            addCriterion("positionInfo in", values, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositioninfoNotIn(List<String> values) {
            addCriterion("positionInfo not in", values, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositioninfoBetween(String value1, String value2) {
            addCriterion("positionInfo between", value1, value2, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositioninfoNotBetween(String value1, String value2) {
            addCriterion("positionInfo not between", value1, value2, "positioninfo");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsIsNull() {
            addCriterion("positionRequirements is null");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsIsNotNull() {
            addCriterion("positionRequirements is not null");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsEqualTo(String value) {
            addCriterion("positionRequirements =", value, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsNotEqualTo(String value) {
            addCriterion("positionRequirements <>", value, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsGreaterThan(String value) {
            addCriterion("positionRequirements >", value, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsGreaterThanOrEqualTo(String value) {
            addCriterion("positionRequirements >=", value, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsLessThan(String value) {
            addCriterion("positionRequirements <", value, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsLessThanOrEqualTo(String value) {
            addCriterion("positionRequirements <=", value, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsLike(String value) {
            addCriterion("positionRequirements like", value, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsNotLike(String value) {
            addCriterion("positionRequirements not like", value, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsIn(List<String> values) {
            addCriterion("positionRequirements in", values, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsNotIn(List<String> values) {
            addCriterion("positionRequirements not in", values, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsBetween(String value1, String value2) {
            addCriterion("positionRequirements between", value1, value2, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionrequirementsNotBetween(String value1, String value2) {
            addCriterion("positionRequirements not between", value1, value2, "positionrequirements");
            return (Criteria) this;
        }

        public Criteria andPositionstateIsNull() {
            addCriterion("positionState is null");
            return (Criteria) this;
        }

        public Criteria andPositionstateIsNotNull() {
            addCriterion("positionState is not null");
            return (Criteria) this;
        }

        public Criteria andPositionstateEqualTo(Integer value) {
            addCriterion("positionState =", value, "positionstate");
            return (Criteria) this;
        }

        public Criteria andPositionstateNotEqualTo(Integer value) {
            addCriterion("positionState <>", value, "positionstate");
            return (Criteria) this;
        }

        public Criteria andPositionstateGreaterThan(Integer value) {
            addCriterion("positionState >", value, "positionstate");
            return (Criteria) this;
        }

        public Criteria andPositionstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("positionState >=", value, "positionstate");
            return (Criteria) this;
        }

        public Criteria andPositionstateLessThan(Integer value) {
            addCriterion("positionState <", value, "positionstate");
            return (Criteria) this;
        }

        public Criteria andPositionstateLessThanOrEqualTo(Integer value) {
            addCriterion("positionState <=", value, "positionstate");
            return (Criteria) this;
        }

        public Criteria andPositionstateIn(List<Integer> values) {
            addCriterion("positionState in", values, "positionstate");
            return (Criteria) this;
        }

        public Criteria andPositionstateNotIn(List<Integer> values) {
            addCriterion("positionState not in", values, "positionstate");
            return (Criteria) this;
        }

        public Criteria andPositionstateBetween(Integer value1, Integer value2) {
            addCriterion("positionState between", value1, value2, "positionstate");
            return (Criteria) this;
        }

        public Criteria andPositionstateNotBetween(Integer value1, Integer value2) {
            addCriterion("positionState not between", value1, value2, "positionstate");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeIsNull() {
            addCriterion("positionCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeIsNotNull() {
            addCriterion("positionCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeEqualTo(Date value) {
            addCriterion("positionCreateTime =", value, "positioncreatetime");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeNotEqualTo(Date value) {
            addCriterion("positionCreateTime <>", value, "positioncreatetime");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeGreaterThan(Date value) {
            addCriterion("positionCreateTime >", value, "positioncreatetime");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("positionCreateTime >=", value, "positioncreatetime");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeLessThan(Date value) {
            addCriterion("positionCreateTime <", value, "positioncreatetime");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("positionCreateTime <=", value, "positioncreatetime");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeIn(List<Date> values) {
            addCriterion("positionCreateTime in", values, "positioncreatetime");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeNotIn(List<Date> values) {
            addCriterion("positionCreateTime not in", values, "positioncreatetime");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeBetween(Date value1, Date value2) {
            addCriterion("positionCreateTime between", value1, value2, "positioncreatetime");
            return (Criteria) this;
        }

        public Criteria andPositioncreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("positionCreateTime not between", value1, value2, "positioncreatetime");
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