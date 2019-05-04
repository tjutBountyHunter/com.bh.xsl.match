package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XslMatchUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslMatchUserExample() {
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

        public Criteria andHunteridIsNull() {
            addCriterion("hunterId is null");
            return (Criteria) this;
        }

        public Criteria andHunteridIsNotNull() {
            addCriterion("hunterId is not null");
            return (Criteria) this;
        }

        public Criteria andHunteridEqualTo(String value) {
            addCriterion("hunterId =", value, "hunterid");
            return (Criteria) this;
        }

        public Criteria andHunteridNotEqualTo(String value) {
            addCriterion("hunterId <>", value, "hunterid");
            return (Criteria) this;
        }

        public Criteria andHunteridGreaterThan(String value) {
            addCriterion("hunterId >", value, "hunterid");
            return (Criteria) this;
        }

        public Criteria andHunteridGreaterThanOrEqualTo(String value) {
            addCriterion("hunterId >=", value, "hunterid");
            return (Criteria) this;
        }

        public Criteria andHunteridLessThan(String value) {
            addCriterion("hunterId <", value, "hunterid");
            return (Criteria) this;
        }

        public Criteria andHunteridLessThanOrEqualTo(String value) {
            addCriterion("hunterId <=", value, "hunterid");
            return (Criteria) this;
        }

        public Criteria andHunteridLike(String value) {
            addCriterion("hunterId like", value, "hunterid");
            return (Criteria) this;
        }

        public Criteria andHunteridNotLike(String value) {
            addCriterion("hunterId not like", value, "hunterid");
            return (Criteria) this;
        }

        public Criteria andHunteridIn(List<String> values) {
            addCriterion("hunterId in", values, "hunterid");
            return (Criteria) this;
        }

        public Criteria andHunteridNotIn(List<String> values) {
            addCriterion("hunterId not in", values, "hunterid");
            return (Criteria) this;
        }

        public Criteria andHunteridBetween(String value1, String value2) {
            addCriterion("hunterId between", value1, value2, "hunterid");
            return (Criteria) this;
        }

        public Criteria andHunteridNotBetween(String value1, String value2) {
            addCriterion("hunterId not between", value1, value2, "hunterid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
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

        public Criteria andIsrecommendIsNull() {
            addCriterion("isRecommend is null");
            return (Criteria) this;
        }

        public Criteria andIsrecommendIsNotNull() {
            addCriterion("isRecommend is not null");
            return (Criteria) this;
        }

        public Criteria andIsrecommendEqualTo(Boolean value) {
            addCriterion("isRecommend =", value, "isrecommend");
            return (Criteria) this;
        }

        public Criteria andIsrecommendNotEqualTo(Boolean value) {
            addCriterion("isRecommend <>", value, "isrecommend");
            return (Criteria) this;
        }

        public Criteria andIsrecommendGreaterThan(Boolean value) {
            addCriterion("isRecommend >", value, "isrecommend");
            return (Criteria) this;
        }

        public Criteria andIsrecommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isRecommend >=", value, "isrecommend");
            return (Criteria) this;
        }

        public Criteria andIsrecommendLessThan(Boolean value) {
            addCriterion("isRecommend <", value, "isrecommend");
            return (Criteria) this;
        }

        public Criteria andIsrecommendLessThanOrEqualTo(Boolean value) {
            addCriterion("isRecommend <=", value, "isrecommend");
            return (Criteria) this;
        }

        public Criteria andIsrecommendIn(List<Boolean> values) {
            addCriterion("isRecommend in", values, "isrecommend");
            return (Criteria) this;
        }

        public Criteria andIsrecommendNotIn(List<Boolean> values) {
            addCriterion("isRecommend not in", values, "isrecommend");
            return (Criteria) this;
        }

        public Criteria andIsrecommendBetween(Boolean value1, Boolean value2) {
            addCriterion("isRecommend between", value1, value2, "isrecommend");
            return (Criteria) this;
        }

        public Criteria andIsrecommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isRecommend not between", value1, value2, "isrecommend");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Short value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Short value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Short value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Short value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Short value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Short> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Short> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Short value1, Short value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Short value1, Short value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumIsNull() {
            addCriterion("taskAccNum is null");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumIsNotNull() {
            addCriterion("taskAccNum is not null");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumEqualTo(Integer value) {
            addCriterion("taskAccNum =", value, "taskaccnum");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumNotEqualTo(Integer value) {
            addCriterion("taskAccNum <>", value, "taskaccnum");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumGreaterThan(Integer value) {
            addCriterion("taskAccNum >", value, "taskaccnum");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskAccNum >=", value, "taskaccnum");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumLessThan(Integer value) {
            addCriterion("taskAccNum <", value, "taskaccnum");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumLessThanOrEqualTo(Integer value) {
            addCriterion("taskAccNum <=", value, "taskaccnum");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumIn(List<Integer> values) {
            addCriterion("taskAccNum in", values, "taskaccnum");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumNotIn(List<Integer> values) {
            addCriterion("taskAccNum not in", values, "taskaccnum");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumBetween(Integer value1, Integer value2) {
            addCriterion("taskAccNum between", value1, value2, "taskaccnum");
            return (Criteria) this;
        }

        public Criteria andTaskaccnumNotBetween(Integer value1, Integer value2) {
            addCriterion("taskAccNum not between", value1, value2, "taskaccnum");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNull() {
            addCriterion("lastTime is null");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNotNull() {
            addCriterion("lastTime is not null");
            return (Criteria) this;
        }

        public Criteria andLasttimeEqualTo(Date value) {
            addCriterion("lastTime =", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotEqualTo(Date value) {
            addCriterion("lastTime <>", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThan(Date value) {
            addCriterion("lastTime >", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastTime >=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThan(Date value) {
            addCriterion("lastTime <", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThanOrEqualTo(Date value) {
            addCriterion("lastTime <=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeIn(List<Date> values) {
            addCriterion("lastTime in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotIn(List<Date> values) {
            addCriterion("lastTime not in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeBetween(Date value1, Date value2) {
            addCriterion("lastTime between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotBetween(Date value1, Date value2) {
            addCriterion("lastTime not between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentIsNull() {
            addCriterion("selfAssessment is null");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentIsNotNull() {
            addCriterion("selfAssessment is not null");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentEqualTo(String value) {
            addCriterion("selfAssessment =", value, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentNotEqualTo(String value) {
            addCriterion("selfAssessment <>", value, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentGreaterThan(String value) {
            addCriterion("selfAssessment >", value, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentGreaterThanOrEqualTo(String value) {
            addCriterion("selfAssessment >=", value, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentLessThan(String value) {
            addCriterion("selfAssessment <", value, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentLessThanOrEqualTo(String value) {
            addCriterion("selfAssessment <=", value, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentLike(String value) {
            addCriterion("selfAssessment like", value, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentNotLike(String value) {
            addCriterion("selfAssessment not like", value, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentIn(List<String> values) {
            addCriterion("selfAssessment in", values, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentNotIn(List<String> values) {
            addCriterion("selfAssessment not in", values, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentBetween(String value1, String value2) {
            addCriterion("selfAssessment between", value1, value2, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andSelfassessmentNotBetween(String value1, String value2) {
            addCriterion("selfAssessment not between", value1, value2, "selfassessment");
            return (Criteria) this;
        }

        public Criteria andCreditIsNull() {
            addCriterion("credit is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("credit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(Short value) {
            addCriterion("credit =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(Short value) {
            addCriterion("credit <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(Short value) {
            addCriterion("credit >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(Short value) {
            addCriterion("credit >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(Short value) {
            addCriterion("credit <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(Short value) {
            addCriterion("credit <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<Short> values) {
            addCriterion("credit in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<Short> values) {
            addCriterion("credit not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(Short value1, Short value2) {
            addCriterion("credit between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(Short value1, Short value2) {
            addCriterion("credit not between", value1, value2, "credit");
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