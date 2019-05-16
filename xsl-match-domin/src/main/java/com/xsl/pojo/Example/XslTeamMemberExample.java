package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XslTeamMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslTeamMemberExample() {
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

        public Criteria andMemberidIsNull() {
            addCriterion("memberId is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberId is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(String value) {
            addCriterion("memberId =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(String value) {
            addCriterion("memberId <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(String value) {
            addCriterion("memberId >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(String value) {
            addCriterion("memberId >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(String value) {
            addCriterion("memberId <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(String value) {
            addCriterion("memberId <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLike(String value) {
            addCriterion("memberId like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotLike(String value) {
            addCriterion("memberId not like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<String> values) {
            addCriterion("memberId in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<String> values) {
            addCriterion("memberId not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(String value1, String value2) {
            addCriterion("memberId between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(String value1, String value2) {
            addCriterion("memberId not between", value1, value2, "memberid");
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
            addCriterion("teamid is null");
            return (Criteria) this;
        }

        public Criteria andTeamidIsNotNull() {
            addCriterion("teamid is not null");
            return (Criteria) this;
        }

        public Criteria andTeamidEqualTo(String value) {
            addCriterion("teamid =", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotEqualTo(String value) {
            addCriterion("teamid <>", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidGreaterThan(String value) {
            addCriterion("teamid >", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidGreaterThanOrEqualTo(String value) {
            addCriterion("teamid >=", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidLessThan(String value) {
            addCriterion("teamid <", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidLessThanOrEqualTo(String value) {
            addCriterion("teamid <=", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidLike(String value) {
            addCriterion("teamid like", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotLike(String value) {
            addCriterion("teamid not like", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidIn(List<String> values) {
            addCriterion("teamid in", values, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotIn(List<String> values) {
            addCriterion("teamid not in", values, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidBetween(String value1, String value2) {
            addCriterion("teamid between", value1, value2, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotBetween(String value1, String value2) {
            addCriterion("teamid not between", value1, value2, "teamid");
            return (Criteria) this;
        }

        public Criteria andMemberstateIsNull() {
            addCriterion("memberState is null");
            return (Criteria) this;
        }

        public Criteria andMemberstateIsNotNull() {
            addCriterion("memberState is not null");
            return (Criteria) this;
        }

        public Criteria andMemberstateEqualTo(Integer value) {
            addCriterion("memberState =", value, "memberstate");
            return (Criteria) this;
        }

        public Criteria andMemberstateNotEqualTo(Integer value) {
            addCriterion("memberState <>", value, "memberstate");
            return (Criteria) this;
        }

        public Criteria andMemberstateGreaterThan(Integer value) {
            addCriterion("memberState >", value, "memberstate");
            return (Criteria) this;
        }

        public Criteria andMemberstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("memberState >=", value, "memberstate");
            return (Criteria) this;
        }

        public Criteria andMemberstateLessThan(Integer value) {
            addCriterion("memberState <", value, "memberstate");
            return (Criteria) this;
        }

        public Criteria andMemberstateLessThanOrEqualTo(Integer value) {
            addCriterion("memberState <=", value, "memberstate");
            return (Criteria) this;
        }

        public Criteria andMemberstateIn(List<Integer> values) {
            addCriterion("memberState in", values, "memberstate");
            return (Criteria) this;
        }

        public Criteria andMemberstateNotIn(List<Integer> values) {
            addCriterion("memberState not in", values, "memberstate");
            return (Criteria) this;
        }

        public Criteria andMemberstateBetween(Integer value1, Integer value2) {
            addCriterion("memberState between", value1, value2, "memberstate");
            return (Criteria) this;
        }

        public Criteria andMemberstateNotBetween(Integer value1, Integer value2) {
            addCriterion("memberState not between", value1, value2, "memberstate");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeIsNull() {
            addCriterion("memberJoinTime is null");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeIsNotNull() {
            addCriterion("memberJoinTime is not null");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeEqualTo(Date value) {
            addCriterion("memberJoinTime =", value, "memberjointime");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeNotEqualTo(Date value) {
            addCriterion("memberJoinTime <>", value, "memberjointime");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeGreaterThan(Date value) {
            addCriterion("memberJoinTime >", value, "memberjointime");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeGreaterThanOrEqualTo(Date value) {
            addCriterion("memberJoinTime >=", value, "memberjointime");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeLessThan(Date value) {
            addCriterion("memberJoinTime <", value, "memberjointime");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeLessThanOrEqualTo(Date value) {
            addCriterion("memberJoinTime <=", value, "memberjointime");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeIn(List<Date> values) {
            addCriterion("memberJoinTime in", values, "memberjointime");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeNotIn(List<Date> values) {
            addCriterion("memberJoinTime not in", values, "memberjointime");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeBetween(Date value1, Date value2) {
            addCriterion("memberJoinTime between", value1, value2, "memberjointime");
            return (Criteria) this;
        }

        public Criteria andMemberjointimeNotBetween(Date value1, Date value2) {
            addCriterion("memberJoinTime not between", value1, value2, "memberjointime");
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