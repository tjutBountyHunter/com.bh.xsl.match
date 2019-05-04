package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XslMatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslMatchExample() {
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

        public Criteria andMatchnameIsNull() {
            addCriterion("matchName is null");
            return (Criteria) this;
        }

        public Criteria andMatchnameIsNotNull() {
            addCriterion("matchName is not null");
            return (Criteria) this;
        }

        public Criteria andMatchnameEqualTo(String value) {
            addCriterion("matchName =", value, "matchname");
            return (Criteria) this;
        }

        public Criteria andMatchnameNotEqualTo(String value) {
            addCriterion("matchName <>", value, "matchname");
            return (Criteria) this;
        }

        public Criteria andMatchnameGreaterThan(String value) {
            addCriterion("matchName >", value, "matchname");
            return (Criteria) this;
        }

        public Criteria andMatchnameGreaterThanOrEqualTo(String value) {
            addCriterion("matchName >=", value, "matchname");
            return (Criteria) this;
        }

        public Criteria andMatchnameLessThan(String value) {
            addCriterion("matchName <", value, "matchname");
            return (Criteria) this;
        }

        public Criteria andMatchnameLessThanOrEqualTo(String value) {
            addCriterion("matchName <=", value, "matchname");
            return (Criteria) this;
        }

        public Criteria andMatchnameLike(String value) {
            addCriterion("matchName like", value, "matchname");
            return (Criteria) this;
        }

        public Criteria andMatchnameNotLike(String value) {
            addCriterion("matchName not like", value, "matchname");
            return (Criteria) this;
        }

        public Criteria andMatchnameIn(List<String> values) {
            addCriterion("matchName in", values, "matchname");
            return (Criteria) this;
        }

        public Criteria andMatchnameNotIn(List<String> values) {
            addCriterion("matchName not in", values, "matchname");
            return (Criteria) this;
        }

        public Criteria andMatchnameBetween(String value1, String value2) {
            addCriterion("matchName between", value1, value2, "matchname");
            return (Criteria) this;
        }

        public Criteria andMatchnameNotBetween(String value1, String value2) {
            addCriterion("matchName not between", value1, value2, "matchname");
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

        public Criteria andMatchwebsiteIsNull() {
            addCriterion("matchWebsite is null");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteIsNotNull() {
            addCriterion("matchWebsite is not null");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteEqualTo(String value) {
            addCriterion("matchWebsite =", value, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteNotEqualTo(String value) {
            addCriterion("matchWebsite <>", value, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteGreaterThan(String value) {
            addCriterion("matchWebsite >", value, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("matchWebsite >=", value, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteLessThan(String value) {
            addCriterion("matchWebsite <", value, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteLessThanOrEqualTo(String value) {
            addCriterion("matchWebsite <=", value, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteLike(String value) {
            addCriterion("matchWebsite like", value, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteNotLike(String value) {
            addCriterion("matchWebsite not like", value, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteIn(List<String> values) {
            addCriterion("matchWebsite in", values, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteNotIn(List<String> values) {
            addCriterion("matchWebsite not in", values, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteBetween(String value1, String value2) {
            addCriterion("matchWebsite between", value1, value2, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchwebsiteNotBetween(String value1, String value2) {
            addCriterion("matchWebsite not between", value1, value2, "matchwebsite");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidIsNull() {
            addCriterion("matchOrientedId is null");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidIsNotNull() {
            addCriterion("matchOrientedId is not null");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidEqualTo(String value) {
            addCriterion("matchOrientedId =", value, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidNotEqualTo(String value) {
            addCriterion("matchOrientedId <>", value, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidGreaterThan(String value) {
            addCriterion("matchOrientedId >", value, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidGreaterThanOrEqualTo(String value) {
            addCriterion("matchOrientedId >=", value, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidLessThan(String value) {
            addCriterion("matchOrientedId <", value, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidLessThanOrEqualTo(String value) {
            addCriterion("matchOrientedId <=", value, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidLike(String value) {
            addCriterion("matchOrientedId like", value, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidNotLike(String value) {
            addCriterion("matchOrientedId not like", value, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidIn(List<String> values) {
            addCriterion("matchOrientedId in", values, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidNotIn(List<String> values) {
            addCriterion("matchOrientedId not in", values, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidBetween(String value1, String value2) {
            addCriterion("matchOrientedId between", value1, value2, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchorientedidNotBetween(String value1, String value2) {
            addCriterion("matchOrientedId not between", value1, value2, "matchorientedid");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeIsNull() {
            addCriterion("matchStartTime is null");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeIsNotNull() {
            addCriterion("matchStartTime is not null");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeEqualTo(Date value) {
            addCriterion("matchStartTime =", value, "matchstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeNotEqualTo(Date value) {
            addCriterion("matchStartTime <>", value, "matchstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeGreaterThan(Date value) {
            addCriterion("matchStartTime >", value, "matchstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("matchStartTime >=", value, "matchstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeLessThan(Date value) {
            addCriterion("matchStartTime <", value, "matchstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeLessThanOrEqualTo(Date value) {
            addCriterion("matchStartTime <=", value, "matchstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeIn(List<Date> values) {
            addCriterion("matchStartTime in", values, "matchstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeNotIn(List<Date> values) {
            addCriterion("matchStartTime not in", values, "matchstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeBetween(Date value1, Date value2) {
            addCriterion("matchStartTime between", value1, value2, "matchstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchstarttimeNotBetween(Date value1, Date value2) {
            addCriterion("matchStartTime not between", value1, value2, "matchstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeIsNull() {
            addCriterion("matchEndTime is null");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeIsNotNull() {
            addCriterion("matchEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeEqualTo(Date value) {
            addCriterion("matchEndTime =", value, "matchendtime");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeNotEqualTo(Date value) {
            addCriterion("matchEndTime <>", value, "matchendtime");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeGreaterThan(Date value) {
            addCriterion("matchEndTime >", value, "matchendtime");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("matchEndTime >=", value, "matchendtime");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeLessThan(Date value) {
            addCriterion("matchEndTime <", value, "matchendtime");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeLessThanOrEqualTo(Date value) {
            addCriterion("matchEndTime <=", value, "matchendtime");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeIn(List<Date> values) {
            addCriterion("matchEndTime in", values, "matchendtime");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeNotIn(List<Date> values) {
            addCriterion("matchEndTime not in", values, "matchendtime");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeBetween(Date value1, Date value2) {
            addCriterion("matchEndTime between", value1, value2, "matchendtime");
            return (Criteria) this;
        }

        public Criteria andMatchendtimeNotBetween(Date value1, Date value2) {
            addCriterion("matchEndTime not between", value1, value2, "matchendtime");
            return (Criteria) this;
        }

        public Criteria andMatchstateIsNull() {
            addCriterion("matchState is null");
            return (Criteria) this;
        }

        public Criteria andMatchstateIsNotNull() {
            addCriterion("matchState is not null");
            return (Criteria) this;
        }

        public Criteria andMatchstateEqualTo(Integer value) {
            addCriterion("matchState =", value, "matchstate");
            return (Criteria) this;
        }

        public Criteria andMatchstateNotEqualTo(Integer value) {
            addCriterion("matchState <>", value, "matchstate");
            return (Criteria) this;
        }

        public Criteria andMatchstateGreaterThan(Integer value) {
            addCriterion("matchState >", value, "matchstate");
            return (Criteria) this;
        }

        public Criteria andMatchstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("matchState >=", value, "matchstate");
            return (Criteria) this;
        }

        public Criteria andMatchstateLessThan(Integer value) {
            addCriterion("matchState <", value, "matchstate");
            return (Criteria) this;
        }

        public Criteria andMatchstateLessThanOrEqualTo(Integer value) {
            addCriterion("matchState <=", value, "matchstate");
            return (Criteria) this;
        }

        public Criteria andMatchstateIn(List<Integer> values) {
            addCriterion("matchState in", values, "matchstate");
            return (Criteria) this;
        }

        public Criteria andMatchstateNotIn(List<Integer> values) {
            addCriterion("matchState not in", values, "matchstate");
            return (Criteria) this;
        }

        public Criteria andMatchstateBetween(Integer value1, Integer value2) {
            addCriterion("matchState between", value1, value2, "matchstate");
            return (Criteria) this;
        }

        public Criteria andMatchstateNotBetween(Integer value1, Integer value2) {
            addCriterion("matchState not between", value1, value2, "matchstate");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeIsNull() {
            addCriterion("matchSignUpEndTime is null");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeIsNotNull() {
            addCriterion("matchSignUpEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeEqualTo(Date value) {
            addCriterion("matchSignUpEndTime =", value, "matchsignupendtime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeNotEqualTo(Date value) {
            addCriterion("matchSignUpEndTime <>", value, "matchsignupendtime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeGreaterThan(Date value) {
            addCriterion("matchSignUpEndTime >", value, "matchsignupendtime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("matchSignUpEndTime >=", value, "matchsignupendtime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeLessThan(Date value) {
            addCriterion("matchSignUpEndTime <", value, "matchsignupendtime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeLessThanOrEqualTo(Date value) {
            addCriterion("matchSignUpEndTime <=", value, "matchsignupendtime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeIn(List<Date> values) {
            addCriterion("matchSignUpEndTime in", values, "matchsignupendtime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeNotIn(List<Date> values) {
            addCriterion("matchSignUpEndTime not in", values, "matchsignupendtime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeBetween(Date value1, Date value2) {
            addCriterion("matchSignUpEndTime between", value1, value2, "matchsignupendtime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupendtimeNotBetween(Date value1, Date value2) {
            addCriterion("matchSignUpEndTime not between", value1, value2, "matchsignupendtime");
            return (Criteria) this;
        }

        public Criteria andMatchaddressIsNull() {
            addCriterion("matchAddress is null");
            return (Criteria) this;
        }

        public Criteria andMatchaddressIsNotNull() {
            addCriterion("matchAddress is not null");
            return (Criteria) this;
        }

        public Criteria andMatchaddressEqualTo(String value) {
            addCriterion("matchAddress =", value, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchaddressNotEqualTo(String value) {
            addCriterion("matchAddress <>", value, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchaddressGreaterThan(String value) {
            addCriterion("matchAddress >", value, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchaddressGreaterThanOrEqualTo(String value) {
            addCriterion("matchAddress >=", value, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchaddressLessThan(String value) {
            addCriterion("matchAddress <", value, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchaddressLessThanOrEqualTo(String value) {
            addCriterion("matchAddress <=", value, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchaddressLike(String value) {
            addCriterion("matchAddress like", value, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchaddressNotLike(String value) {
            addCriterion("matchAddress not like", value, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchaddressIn(List<String> values) {
            addCriterion("matchAddress in", values, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchaddressNotIn(List<String> values) {
            addCriterion("matchAddress not in", values, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchaddressBetween(String value1, String value2) {
            addCriterion("matchAddress between", value1, value2, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchaddressNotBetween(String value1, String value2) {
            addCriterion("matchAddress not between", value1, value2, "matchaddress");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumIsNull() {
            addCriterion("matchSignUpMaxNum is null");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumIsNotNull() {
            addCriterion("matchSignUpMaxNum is not null");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumEqualTo(Integer value) {
            addCriterion("matchSignUpMaxNum =", value, "matchsignupmaxnum");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumNotEqualTo(Integer value) {
            addCriterion("matchSignUpMaxNum <>", value, "matchsignupmaxnum");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumGreaterThan(Integer value) {
            addCriterion("matchSignUpMaxNum >", value, "matchsignupmaxnum");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("matchSignUpMaxNum >=", value, "matchsignupmaxnum");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumLessThan(Integer value) {
            addCriterion("matchSignUpMaxNum <", value, "matchsignupmaxnum");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumLessThanOrEqualTo(Integer value) {
            addCriterion("matchSignUpMaxNum <=", value, "matchsignupmaxnum");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumIn(List<Integer> values) {
            addCriterion("matchSignUpMaxNum in", values, "matchsignupmaxnum");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumNotIn(List<Integer> values) {
            addCriterion("matchSignUpMaxNum not in", values, "matchsignupmaxnum");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumBetween(Integer value1, Integer value2) {
            addCriterion("matchSignUpMaxNum between", value1, value2, "matchsignupmaxnum");
            return (Criteria) this;
        }

        public Criteria andMatchsignupmaxnumNotBetween(Integer value1, Integer value2) {
            addCriterion("matchSignUpMaxNum not between", value1, value2, "matchsignupmaxnum");
            return (Criteria) this;
        }

        public Criteria andMatchformIsNull() {
            addCriterion("matchForm is null");
            return (Criteria) this;
        }

        public Criteria andMatchformIsNotNull() {
            addCriterion("matchForm is not null");
            return (Criteria) this;
        }

        public Criteria andMatchformEqualTo(Integer value) {
            addCriterion("matchForm =", value, "matchform");
            return (Criteria) this;
        }

        public Criteria andMatchformNotEqualTo(Integer value) {
            addCriterion("matchForm <>", value, "matchform");
            return (Criteria) this;
        }

        public Criteria andMatchformGreaterThan(Integer value) {
            addCriterion("matchForm >", value, "matchform");
            return (Criteria) this;
        }

        public Criteria andMatchformGreaterThanOrEqualTo(Integer value) {
            addCriterion("matchForm >=", value, "matchform");
            return (Criteria) this;
        }

        public Criteria andMatchformLessThan(Integer value) {
            addCriterion("matchForm <", value, "matchform");
            return (Criteria) this;
        }

        public Criteria andMatchformLessThanOrEqualTo(Integer value) {
            addCriterion("matchForm <=", value, "matchform");
            return (Criteria) this;
        }

        public Criteria andMatchformIn(List<Integer> values) {
            addCriterion("matchForm in", values, "matchform");
            return (Criteria) this;
        }

        public Criteria andMatchformNotIn(List<Integer> values) {
            addCriterion("matchForm not in", values, "matchform");
            return (Criteria) this;
        }

        public Criteria andMatchformBetween(Integer value1, Integer value2) {
            addCriterion("matchForm between", value1, value2, "matchform");
            return (Criteria) this;
        }

        public Criteria andMatchformNotBetween(Integer value1, Integer value2) {
            addCriterion("matchForm not between", value1, value2, "matchform");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumIsNull() {
            addCriterion("matchTeamNum is null");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumIsNotNull() {
            addCriterion("matchTeamNum is not null");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumEqualTo(Integer value) {
            addCriterion("matchTeamNum =", value, "matchteamnum");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumNotEqualTo(Integer value) {
            addCriterion("matchTeamNum <>", value, "matchteamnum");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumGreaterThan(Integer value) {
            addCriterion("matchTeamNum >", value, "matchteamnum");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("matchTeamNum >=", value, "matchteamnum");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumLessThan(Integer value) {
            addCriterion("matchTeamNum <", value, "matchteamnum");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumLessThanOrEqualTo(Integer value) {
            addCriterion("matchTeamNum <=", value, "matchteamnum");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumIn(List<Integer> values) {
            addCriterion("matchTeamNum in", values, "matchteamnum");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumNotIn(List<Integer> values) {
            addCriterion("matchTeamNum not in", values, "matchteamnum");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumBetween(Integer value1, Integer value2) {
            addCriterion("matchTeamNum between", value1, value2, "matchteamnum");
            return (Criteria) this;
        }

        public Criteria andMatchteamnumNotBetween(Integer value1, Integer value2) {
            addCriterion("matchTeamNum not between", value1, value2, "matchteamnum");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeIsNull() {
            addCriterion("matchSignUpStartTime is null");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeIsNotNull() {
            addCriterion("matchSignUpStartTime is not null");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeEqualTo(Date value) {
            addCriterion("matchSignUpStartTime =", value, "matchsignupstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeNotEqualTo(Date value) {
            addCriterion("matchSignUpStartTime <>", value, "matchsignupstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeGreaterThan(Date value) {
            addCriterion("matchSignUpStartTime >", value, "matchsignupstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("matchSignUpStartTime >=", value, "matchsignupstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeLessThan(Date value) {
            addCriterion("matchSignUpStartTime <", value, "matchsignupstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeLessThanOrEqualTo(Date value) {
            addCriterion("matchSignUpStartTime <=", value, "matchsignupstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeIn(List<Date> values) {
            addCriterion("matchSignUpStartTime in", values, "matchsignupstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeNotIn(List<Date> values) {
            addCriterion("matchSignUpStartTime not in", values, "matchsignupstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeBetween(Date value1, Date value2) {
            addCriterion("matchSignUpStartTime between", value1, value2, "matchsignupstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchsignupstarttimeNotBetween(Date value1, Date value2) {
            addCriterion("matchSignUpStartTime not between", value1, value2, "matchsignupstarttime");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeIsNull() {
            addCriterion("matchCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeIsNotNull() {
            addCriterion("matchCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeEqualTo(Date value) {
            addCriterion("matchCreateTime =", value, "matchcreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeNotEqualTo(Date value) {
            addCriterion("matchCreateTime <>", value, "matchcreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeGreaterThan(Date value) {
            addCriterion("matchCreateTime >", value, "matchcreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("matchCreateTime >=", value, "matchcreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeLessThan(Date value) {
            addCriterion("matchCreateTime <", value, "matchcreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("matchCreateTime <=", value, "matchcreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeIn(List<Date> values) {
            addCriterion("matchCreateTime in", values, "matchcreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeNotIn(List<Date> values) {
            addCriterion("matchCreateTime not in", values, "matchcreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeBetween(Date value1, Date value2) {
            addCriterion("matchCreateTime between", value1, value2, "matchcreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("matchCreateTime not between", value1, value2, "matchcreatetime");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlIsNull() {
            addCriterion("matchPosterUrl is null");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlIsNotNull() {
            addCriterion("matchPosterUrl is not null");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlEqualTo(String value) {
            addCriterion("matchPosterUrl =", value, "matchposterurl");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlNotEqualTo(String value) {
            addCriterion("matchPosterUrl <>", value, "matchposterurl");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlGreaterThan(String value) {
            addCriterion("matchPosterUrl >", value, "matchposterurl");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlGreaterThanOrEqualTo(String value) {
            addCriterion("matchPosterUrl >=", value, "matchposterurl");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlLessThan(String value) {
            addCriterion("matchPosterUrl <", value, "matchposterurl");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlLessThanOrEqualTo(String value) {
            addCriterion("matchPosterUrl <=", value, "matchposterurl");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlLike(String value) {
            addCriterion("matchPosterUrl like", value, "matchposterurl");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlNotLike(String value) {
            addCriterion("matchPosterUrl not like", value, "matchposterurl");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlIn(List<String> values) {
            addCriterion("matchPosterUrl in", values, "matchposterurl");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlNotIn(List<String> values) {
            addCriterion("matchPosterUrl not in", values, "matchposterurl");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlBetween(String value1, String value2) {
            addCriterion("matchPosterUrl between", value1, value2, "matchposterurl");
            return (Criteria) this;
        }

        public Criteria andMatchposterurlNotBetween(String value1, String value2) {
            addCriterion("matchPosterUrl not between", value1, value2, "matchposterurl");
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

        public Criteria andMatchinfoIsNull() {
            addCriterion("matchInfo is null");
            return (Criteria) this;
        }

        public Criteria andMatchinfoIsNotNull() {
            addCriterion("matchInfo is not null");
            return (Criteria) this;
        }

        public Criteria andMatchinfoEqualTo(String value) {
            addCriterion("matchInfo =", value, "matchinfo");
            return (Criteria) this;
        }

        public Criteria andMatchinfoNotEqualTo(String value) {
            addCriterion("matchInfo <>", value, "matchinfo");
            return (Criteria) this;
        }

        public Criteria andMatchinfoGreaterThan(String value) {
            addCriterion("matchInfo >", value, "matchinfo");
            return (Criteria) this;
        }

        public Criteria andMatchinfoGreaterThanOrEqualTo(String value) {
            addCriterion("matchInfo >=", value, "matchinfo");
            return (Criteria) this;
        }

        public Criteria andMatchinfoLessThan(String value) {
            addCriterion("matchInfo <", value, "matchinfo");
            return (Criteria) this;
        }

        public Criteria andMatchinfoLessThanOrEqualTo(String value) {
            addCriterion("matchInfo <=", value, "matchinfo");
            return (Criteria) this;
        }

        public Criteria andMatchinfoLike(String value) {
            addCriterion("matchInfo like", value, "matchinfo");
            return (Criteria) this;
        }

        public Criteria andMatchinfoNotLike(String value) {
            addCriterion("matchInfo not like", value, "matchinfo");
            return (Criteria) this;
        }

        public Criteria andMatchinfoIn(List<String> values) {
            addCriterion("matchInfo in", values, "matchinfo");
            return (Criteria) this;
        }

        public Criteria andMatchinfoNotIn(List<String> values) {
            addCriterion("matchInfo not in", values, "matchinfo");
            return (Criteria) this;
        }

        public Criteria andMatchinfoBetween(String value1, String value2) {
            addCriterion("matchInfo between", value1, value2, "matchinfo");
            return (Criteria) this;
        }

        public Criteria andMatchinfoNotBetween(String value1, String value2) {
            addCriterion("matchInfo not between", value1, value2, "matchinfo");
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