package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XslMatchGroupHonorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslMatchGroupHonorExample() {
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

        public Criteria andGrouphonoridIsNull() {
            addCriterion("groupHonorId is null");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridIsNotNull() {
            addCriterion("groupHonorId is not null");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridEqualTo(String value) {
            addCriterion("groupHonorId =", value, "grouphonorid");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridNotEqualTo(String value) {
            addCriterion("groupHonorId <>", value, "grouphonorid");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridGreaterThan(String value) {
            addCriterion("groupHonorId >", value, "grouphonorid");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridGreaterThanOrEqualTo(String value) {
            addCriterion("groupHonorId >=", value, "grouphonorid");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridLessThan(String value) {
            addCriterion("groupHonorId <", value, "grouphonorid");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridLessThanOrEqualTo(String value) {
            addCriterion("groupHonorId <=", value, "grouphonorid");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridLike(String value) {
            addCriterion("groupHonorId like", value, "grouphonorid");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridNotLike(String value) {
            addCriterion("groupHonorId not like", value, "grouphonorid");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridIn(List<String> values) {
            addCriterion("groupHonorId in", values, "grouphonorid");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridNotIn(List<String> values) {
            addCriterion("groupHonorId not in", values, "grouphonorid");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridBetween(String value1, String value2) {
            addCriterion("groupHonorId between", value1, value2, "grouphonorid");
            return (Criteria) this;
        }

        public Criteria andGrouphonoridNotBetween(String value1, String value2) {
            addCriterion("groupHonorId not between", value1, value2, "grouphonorid");
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

        public Criteria andGrouphonornameIsNull() {
            addCriterion("groupHonorName is null");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameIsNotNull() {
            addCriterion("groupHonorName is not null");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameEqualTo(String value) {
            addCriterion("groupHonorName =", value, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameNotEqualTo(String value) {
            addCriterion("groupHonorName <>", value, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameGreaterThan(String value) {
            addCriterion("groupHonorName >", value, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameGreaterThanOrEqualTo(String value) {
            addCriterion("groupHonorName >=", value, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameLessThan(String value) {
            addCriterion("groupHonorName <", value, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameLessThanOrEqualTo(String value) {
            addCriterion("groupHonorName <=", value, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameLike(String value) {
            addCriterion("groupHonorName like", value, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameNotLike(String value) {
            addCriterion("groupHonorName not like", value, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameIn(List<String> values) {
            addCriterion("groupHonorName in", values, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameNotIn(List<String> values) {
            addCriterion("groupHonorName not in", values, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameBetween(String value1, String value2) {
            addCriterion("groupHonorName between", value1, value2, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonornameNotBetween(String value1, String value2) {
            addCriterion("groupHonorName not between", value1, value2, "grouphonorname");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoIsNull() {
            addCriterion("groupHonorInfo is null");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoIsNotNull() {
            addCriterion("groupHonorInfo is not null");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoEqualTo(String value) {
            addCriterion("groupHonorInfo =", value, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoNotEqualTo(String value) {
            addCriterion("groupHonorInfo <>", value, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoGreaterThan(String value) {
            addCriterion("groupHonorInfo >", value, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoGreaterThanOrEqualTo(String value) {
            addCriterion("groupHonorInfo >=", value, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoLessThan(String value) {
            addCriterion("groupHonorInfo <", value, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoLessThanOrEqualTo(String value) {
            addCriterion("groupHonorInfo <=", value, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoLike(String value) {
            addCriterion("groupHonorInfo like", value, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoNotLike(String value) {
            addCriterion("groupHonorInfo not like", value, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoIn(List<String> values) {
            addCriterion("groupHonorInfo in", values, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoNotIn(List<String> values) {
            addCriterion("groupHonorInfo not in", values, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoBetween(String value1, String value2) {
            addCriterion("groupHonorInfo between", value1, value2, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorinfoNotBetween(String value1, String value2) {
            addCriterion("groupHonorInfo not between", value1, value2, "grouphonorinfo");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherIsNull() {
            addCriterion("groupHonorVoucher is null");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherIsNotNull() {
            addCriterion("groupHonorVoucher is not null");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherEqualTo(String value) {
            addCriterion("groupHonorVoucher =", value, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherNotEqualTo(String value) {
            addCriterion("groupHonorVoucher <>", value, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherGreaterThan(String value) {
            addCriterion("groupHonorVoucher >", value, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherGreaterThanOrEqualTo(String value) {
            addCriterion("groupHonorVoucher >=", value, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherLessThan(String value) {
            addCriterion("groupHonorVoucher <", value, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherLessThanOrEqualTo(String value) {
            addCriterion("groupHonorVoucher <=", value, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherLike(String value) {
            addCriterion("groupHonorVoucher like", value, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherNotLike(String value) {
            addCriterion("groupHonorVoucher not like", value, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherIn(List<String> values) {
            addCriterion("groupHonorVoucher in", values, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherNotIn(List<String> values) {
            addCriterion("groupHonorVoucher not in", values, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherBetween(String value1, String value2) {
            addCriterion("groupHonorVoucher between", value1, value2, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorvoucherNotBetween(String value1, String value2) {
            addCriterion("groupHonorVoucher not between", value1, value2, "grouphonorvoucher");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateIsNull() {
            addCriterion("groupHonorState is null");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateIsNotNull() {
            addCriterion("groupHonorState is not null");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateEqualTo(Integer value) {
            addCriterion("groupHonorState =", value, "grouphonorstate");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateNotEqualTo(Integer value) {
            addCriterion("groupHonorState <>", value, "grouphonorstate");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateGreaterThan(Integer value) {
            addCriterion("groupHonorState >", value, "grouphonorstate");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("groupHonorState >=", value, "grouphonorstate");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateLessThan(Integer value) {
            addCriterion("groupHonorState <", value, "grouphonorstate");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateLessThanOrEqualTo(Integer value) {
            addCriterion("groupHonorState <=", value, "grouphonorstate");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateIn(List<Integer> values) {
            addCriterion("groupHonorState in", values, "grouphonorstate");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateNotIn(List<Integer> values) {
            addCriterion("groupHonorState not in", values, "grouphonorstate");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateBetween(Integer value1, Integer value2) {
            addCriterion("groupHonorState between", value1, value2, "grouphonorstate");
            return (Criteria) this;
        }

        public Criteria andGrouphonorstateNotBetween(Integer value1, Integer value2) {
            addCriterion("groupHonorState not between", value1, value2, "grouphonorstate");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeIsNull() {
            addCriterion("groupHonorTime is null");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeIsNotNull() {
            addCriterion("groupHonorTime is not null");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeEqualTo(Date value) {
            addCriterion("groupHonorTime =", value, "grouphonortime");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeNotEqualTo(Date value) {
            addCriterion("groupHonorTime <>", value, "grouphonortime");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeGreaterThan(Date value) {
            addCriterion("groupHonorTime >", value, "grouphonortime");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeGreaterThanOrEqualTo(Date value) {
            addCriterion("groupHonorTime >=", value, "grouphonortime");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeLessThan(Date value) {
            addCriterion("groupHonorTime <", value, "grouphonortime");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeLessThanOrEqualTo(Date value) {
            addCriterion("groupHonorTime <=", value, "grouphonortime");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeIn(List<Date> values) {
            addCriterion("groupHonorTime in", values, "grouphonortime");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeNotIn(List<Date> values) {
            addCriterion("groupHonorTime not in", values, "grouphonortime");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeBetween(Date value1, Date value2) {
            addCriterion("groupHonorTime between", value1, value2, "grouphonortime");
            return (Criteria) this;
        }

        public Criteria andGrouphonortimeNotBetween(Date value1, Date value2) {
            addCriterion("groupHonorTime not between", value1, value2, "grouphonortime");
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