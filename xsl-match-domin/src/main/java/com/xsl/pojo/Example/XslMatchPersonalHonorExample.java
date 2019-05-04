package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XslMatchPersonalHonorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslMatchPersonalHonorExample() {
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

        public Criteria andPersonalhonoridIsNull() {
            addCriterion("personalHonorId is null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridIsNotNull() {
            addCriterion("personalHonorId is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridEqualTo(String value) {
            addCriterion("personalHonorId =", value, "personalhonorid");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridNotEqualTo(String value) {
            addCriterion("personalHonorId <>", value, "personalhonorid");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridGreaterThan(String value) {
            addCriterion("personalHonorId >", value, "personalhonorid");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridGreaterThanOrEqualTo(String value) {
            addCriterion("personalHonorId >=", value, "personalhonorid");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridLessThan(String value) {
            addCriterion("personalHonorId <", value, "personalhonorid");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridLessThanOrEqualTo(String value) {
            addCriterion("personalHonorId <=", value, "personalhonorid");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridLike(String value) {
            addCriterion("personalHonorId like", value, "personalhonorid");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridNotLike(String value) {
            addCriterion("personalHonorId not like", value, "personalhonorid");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridIn(List<String> values) {
            addCriterion("personalHonorId in", values, "personalhonorid");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridNotIn(List<String> values) {
            addCriterion("personalHonorId not in", values, "personalhonorid");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridBetween(String value1, String value2) {
            addCriterion("personalHonorId between", value1, value2, "personalhonorid");
            return (Criteria) this;
        }

        public Criteria andPersonalhonoridNotBetween(String value1, String value2) {
            addCriterion("personalHonorId not between", value1, value2, "personalhonorid");
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

        public Criteria andPersonalhonornameIsNull() {
            addCriterion("personalHonorName is null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameIsNotNull() {
            addCriterion("personalHonorName is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameEqualTo(String value) {
            addCriterion("personalHonorName =", value, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameNotEqualTo(String value) {
            addCriterion("personalHonorName <>", value, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameGreaterThan(String value) {
            addCriterion("personalHonorName >", value, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameGreaterThanOrEqualTo(String value) {
            addCriterion("personalHonorName >=", value, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameLessThan(String value) {
            addCriterion("personalHonorName <", value, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameLessThanOrEqualTo(String value) {
            addCriterion("personalHonorName <=", value, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameLike(String value) {
            addCriterion("personalHonorName like", value, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameNotLike(String value) {
            addCriterion("personalHonorName not like", value, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameIn(List<String> values) {
            addCriterion("personalHonorName in", values, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameNotIn(List<String> values) {
            addCriterion("personalHonorName not in", values, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameBetween(String value1, String value2) {
            addCriterion("personalHonorName between", value1, value2, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonornameNotBetween(String value1, String value2) {
            addCriterion("personalHonorName not between", value1, value2, "personalhonorname");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoIsNull() {
            addCriterion("personalHonorInfo is null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoIsNotNull() {
            addCriterion("personalHonorInfo is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoEqualTo(String value) {
            addCriterion("personalHonorInfo =", value, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoNotEqualTo(String value) {
            addCriterion("personalHonorInfo <>", value, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoGreaterThan(String value) {
            addCriterion("personalHonorInfo >", value, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoGreaterThanOrEqualTo(String value) {
            addCriterion("personalHonorInfo >=", value, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoLessThan(String value) {
            addCriterion("personalHonorInfo <", value, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoLessThanOrEqualTo(String value) {
            addCriterion("personalHonorInfo <=", value, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoLike(String value) {
            addCriterion("personalHonorInfo like", value, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoNotLike(String value) {
            addCriterion("personalHonorInfo not like", value, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoIn(List<String> values) {
            addCriterion("personalHonorInfo in", values, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoNotIn(List<String> values) {
            addCriterion("personalHonorInfo not in", values, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoBetween(String value1, String value2) {
            addCriterion("personalHonorInfo between", value1, value2, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorinfoNotBetween(String value1, String value2) {
            addCriterion("personalHonorInfo not between", value1, value2, "personalhonorinfo");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherIsNull() {
            addCriterion("personalHonorVoucher is null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherIsNotNull() {
            addCriterion("personalHonorVoucher is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherEqualTo(String value) {
            addCriterion("personalHonorVoucher =", value, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherNotEqualTo(String value) {
            addCriterion("personalHonorVoucher <>", value, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherGreaterThan(String value) {
            addCriterion("personalHonorVoucher >", value, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherGreaterThanOrEqualTo(String value) {
            addCriterion("personalHonorVoucher >=", value, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherLessThan(String value) {
            addCriterion("personalHonorVoucher <", value, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherLessThanOrEqualTo(String value) {
            addCriterion("personalHonorVoucher <=", value, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherLike(String value) {
            addCriterion("personalHonorVoucher like", value, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherNotLike(String value) {
            addCriterion("personalHonorVoucher not like", value, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherIn(List<String> values) {
            addCriterion("personalHonorVoucher in", values, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherNotIn(List<String> values) {
            addCriterion("personalHonorVoucher not in", values, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherBetween(String value1, String value2) {
            addCriterion("personalHonorVoucher between", value1, value2, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorvoucherNotBetween(String value1, String value2) {
            addCriterion("personalHonorVoucher not between", value1, value2, "personalhonorvoucher");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeIsNull() {
            addCriterion("personalHonorTime is null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeIsNotNull() {
            addCriterion("personalHonorTime is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeEqualTo(Date value) {
            addCriterion("personalHonorTime =", value, "personalhonortime");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeNotEqualTo(Date value) {
            addCriterion("personalHonorTime <>", value, "personalhonortime");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeGreaterThan(Date value) {
            addCriterion("personalHonorTime >", value, "personalhonortime");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeGreaterThanOrEqualTo(Date value) {
            addCriterion("personalHonorTime >=", value, "personalhonortime");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeLessThan(Date value) {
            addCriterion("personalHonorTime <", value, "personalhonortime");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeLessThanOrEqualTo(Date value) {
            addCriterion("personalHonorTime <=", value, "personalhonortime");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeIn(List<Date> values) {
            addCriterion("personalHonorTime in", values, "personalhonortime");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeNotIn(List<Date> values) {
            addCriterion("personalHonorTime not in", values, "personalhonortime");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeBetween(Date value1, Date value2) {
            addCriterion("personalHonorTime between", value1, value2, "personalhonortime");
            return (Criteria) this;
        }

        public Criteria andPersonalhonortimeNotBetween(Date value1, Date value2) {
            addCriterion("personalHonorTime not between", value1, value2, "personalhonortime");
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

        public Criteria andPersonalhonorstateIsNull() {
            addCriterion("personalHonorState is null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorstateIsNotNull() {
            addCriterion("personalHonorState is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorstateEqualTo(Integer value) {
            addCriterion("personalHonorState =", value, "personalhonorstate");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorstateNotEqualTo(Integer value) {
            addCriterion("personalHonorState <>", value, "personalhonorstate");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorstateGreaterThan(Integer value) {
            addCriterion("personalHonorState >", value, "personalhonorstate");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("personalHonorState >=", value, "personalhonorstate");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorstateLessThan(Integer value) {
            addCriterion("personalHonorState <", value, "personalhonorstate");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorstateLessThanOrEqualTo(Integer value) {
            addCriterion("personalHonorState <=", value, "personalhonorstate");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorstateIn(List<Integer> values) {
            addCriterion("personalHonorState in", values, "personalhonorstate");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorstateNotIn(List<Integer> values) {
            addCriterion("personalHonorState not in", values, "personalhonorstate");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorstateBetween(Integer value1, Integer value2) {
            addCriterion("personalHonorState between", value1, value2, "personalhonorstate");
            return (Criteria) this;
        }

        public Criteria andPersonalhonorstateNotBetween(Integer value1, Integer value2) {
            addCriterion("personalHonorState not between", value1, value2, "personalhonorstate");
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