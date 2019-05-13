package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XslMatchHonorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslMatchHonorExample() {
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

        public Criteria andHonoridIsNull() {
            addCriterion("honorId is null");
            return (Criteria) this;
        }

        public Criteria andHonoridIsNotNull() {
            addCriterion("honorId is not null");
            return (Criteria) this;
        }

        public Criteria andHonoridEqualTo(String value) {
            addCriterion("honorId =", value, "honorid");
            return (Criteria) this;
        }

        public Criteria andHonoridNotEqualTo(String value) {
            addCriterion("honorId <>", value, "honorid");
            return (Criteria) this;
        }

        public Criteria andHonoridGreaterThan(String value) {
            addCriterion("honorId >", value, "honorid");
            return (Criteria) this;
        }

        public Criteria andHonoridGreaterThanOrEqualTo(String value) {
            addCriterion("honorId >=", value, "honorid");
            return (Criteria) this;
        }

        public Criteria andHonoridLessThan(String value) {
            addCriterion("honorId <", value, "honorid");
            return (Criteria) this;
        }

        public Criteria andHonoridLessThanOrEqualTo(String value) {
            addCriterion("honorId <=", value, "honorid");
            return (Criteria) this;
        }

        public Criteria andHonoridLike(String value) {
            addCriterion("honorId like", value, "honorid");
            return (Criteria) this;
        }

        public Criteria andHonoridNotLike(String value) {
            addCriterion("honorId not like", value, "honorid");
            return (Criteria) this;
        }

        public Criteria andHonoridIn(List<String> values) {
            addCriterion("honorId in", values, "honorid");
            return (Criteria) this;
        }

        public Criteria andHonoridNotIn(List<String> values) {
            addCriterion("honorId not in", values, "honorid");
            return (Criteria) this;
        }

        public Criteria andHonoridBetween(String value1, String value2) {
            addCriterion("honorId between", value1, value2, "honorid");
            return (Criteria) this;
        }

        public Criteria andHonoridNotBetween(String value1, String value2) {
            addCriterion("honorId not between", value1, value2, "honorid");
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

        public Criteria andHonornameIsNull() {
            addCriterion("honorName is null");
            return (Criteria) this;
        }

        public Criteria andHonornameIsNotNull() {
            addCriterion("honorName is not null");
            return (Criteria) this;
        }

        public Criteria andHonornameEqualTo(String value) {
            addCriterion("honorName =", value, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonornameNotEqualTo(String value) {
            addCriterion("honorName <>", value, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonornameGreaterThan(String value) {
            addCriterion("honorName >", value, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonornameGreaterThanOrEqualTo(String value) {
            addCriterion("honorName >=", value, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonornameLessThan(String value) {
            addCriterion("honorName <", value, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonornameLessThanOrEqualTo(String value) {
            addCriterion("honorName <=", value, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonornameLike(String value) {
            addCriterion("honorName like", value, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonornameNotLike(String value) {
            addCriterion("honorName not like", value, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonornameIn(List<String> values) {
            addCriterion("honorName in", values, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonornameNotIn(List<String> values) {
            addCriterion("honorName not in", values, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonornameBetween(String value1, String value2) {
            addCriterion("honorName between", value1, value2, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonornameNotBetween(String value1, String value2) {
            addCriterion("honorName not between", value1, value2, "honorname");
            return (Criteria) this;
        }

        public Criteria andHonorinfoIsNull() {
            addCriterion("honorInfo is null");
            return (Criteria) this;
        }

        public Criteria andHonorinfoIsNotNull() {
            addCriterion("honorInfo is not null");
            return (Criteria) this;
        }

        public Criteria andHonorinfoEqualTo(String value) {
            addCriterion("honorInfo =", value, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorinfoNotEqualTo(String value) {
            addCriterion("honorInfo <>", value, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorinfoGreaterThan(String value) {
            addCriterion("honorInfo >", value, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorinfoGreaterThanOrEqualTo(String value) {
            addCriterion("honorInfo >=", value, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorinfoLessThan(String value) {
            addCriterion("honorInfo <", value, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorinfoLessThanOrEqualTo(String value) {
            addCriterion("honorInfo <=", value, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorinfoLike(String value) {
            addCriterion("honorInfo like", value, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorinfoNotLike(String value) {
            addCriterion("honorInfo not like", value, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorinfoIn(List<String> values) {
            addCriterion("honorInfo in", values, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorinfoNotIn(List<String> values) {
            addCriterion("honorInfo not in", values, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorinfoBetween(String value1, String value2) {
            addCriterion("honorInfo between", value1, value2, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorinfoNotBetween(String value1, String value2) {
            addCriterion("honorInfo not between", value1, value2, "honorinfo");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherIsNull() {
            addCriterion("honorVoucher is null");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherIsNotNull() {
            addCriterion("honorVoucher is not null");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherEqualTo(String value) {
            addCriterion("honorVoucher =", value, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherNotEqualTo(String value) {
            addCriterion("honorVoucher <>", value, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherGreaterThan(String value) {
            addCriterion("honorVoucher >", value, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherGreaterThanOrEqualTo(String value) {
            addCriterion("honorVoucher >=", value, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherLessThan(String value) {
            addCriterion("honorVoucher <", value, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherLessThanOrEqualTo(String value) {
            addCriterion("honorVoucher <=", value, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherLike(String value) {
            addCriterion("honorVoucher like", value, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherNotLike(String value) {
            addCriterion("honorVoucher not like", value, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherIn(List<String> values) {
            addCriterion("honorVoucher in", values, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherNotIn(List<String> values) {
            addCriterion("honorVoucher not in", values, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherBetween(String value1, String value2) {
            addCriterion("honorVoucher between", value1, value2, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonorvoucherNotBetween(String value1, String value2) {
            addCriterion("honorVoucher not between", value1, value2, "honorvoucher");
            return (Criteria) this;
        }

        public Criteria andHonortimeIsNull() {
            addCriterion("honorTime is null");
            return (Criteria) this;
        }

        public Criteria andHonortimeIsNotNull() {
            addCriterion("honorTime is not null");
            return (Criteria) this;
        }

        public Criteria andHonortimeEqualTo(Date value) {
            addCriterion("honorTime =", value, "honortime");
            return (Criteria) this;
        }

        public Criteria andHonortimeNotEqualTo(Date value) {
            addCriterion("honorTime <>", value, "honortime");
            return (Criteria) this;
        }

        public Criteria andHonortimeGreaterThan(Date value) {
            addCriterion("honorTime >", value, "honortime");
            return (Criteria) this;
        }

        public Criteria andHonortimeGreaterThanOrEqualTo(Date value) {
            addCriterion("honorTime >=", value, "honortime");
            return (Criteria) this;
        }

        public Criteria andHonortimeLessThan(Date value) {
            addCriterion("honorTime <", value, "honortime");
            return (Criteria) this;
        }

        public Criteria andHonortimeLessThanOrEqualTo(Date value) {
            addCriterion("honorTime <=", value, "honortime");
            return (Criteria) this;
        }

        public Criteria andHonortimeIn(List<Date> values) {
            addCriterion("honorTime in", values, "honortime");
            return (Criteria) this;
        }

        public Criteria andHonortimeNotIn(List<Date> values) {
            addCriterion("honorTime not in", values, "honortime");
            return (Criteria) this;
        }

        public Criteria andHonortimeBetween(Date value1, Date value2) {
            addCriterion("honorTime between", value1, value2, "honortime");
            return (Criteria) this;
        }

        public Criteria andHonortimeNotBetween(Date value1, Date value2) {
            addCriterion("honorTime not between", value1, value2, "honortime");
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

        public Criteria andHonorstateIsNull() {
            addCriterion("honorState is null");
            return (Criteria) this;
        }

        public Criteria andHonorstateIsNotNull() {
            addCriterion("honorState is not null");
            return (Criteria) this;
        }

        public Criteria andHonorstateEqualTo(Integer value) {
            addCriterion("honorState =", value, "honorstate");
            return (Criteria) this;
        }

        public Criteria andHonorstateNotEqualTo(Integer value) {
            addCriterion("honorState <>", value, "honorstate");
            return (Criteria) this;
        }

        public Criteria andHonorstateGreaterThan(Integer value) {
            addCriterion("honorState >", value, "honorstate");
            return (Criteria) this;
        }

        public Criteria andHonorstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("honorState >=", value, "honorstate");
            return (Criteria) this;
        }

        public Criteria andHonorstateLessThan(Integer value) {
            addCriterion("honorState <", value, "honorstate");
            return (Criteria) this;
        }

        public Criteria andHonorstateLessThanOrEqualTo(Integer value) {
            addCriterion("honorState <=", value, "honorstate");
            return (Criteria) this;
        }

        public Criteria andHonorstateIn(List<Integer> values) {
            addCriterion("honorState in", values, "honorstate");
            return (Criteria) this;
        }

        public Criteria andHonorstateNotIn(List<Integer> values) {
            addCriterion("honorState not in", values, "honorstate");
            return (Criteria) this;
        }

        public Criteria andHonorstateBetween(Integer value1, Integer value2) {
            addCriterion("honorState between", value1, value2, "honorstate");
            return (Criteria) this;
        }

        public Criteria andHonorstateNotBetween(Integer value1, Integer value2) {
            addCriterion("honorState not between", value1, value2, "honorstate");
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