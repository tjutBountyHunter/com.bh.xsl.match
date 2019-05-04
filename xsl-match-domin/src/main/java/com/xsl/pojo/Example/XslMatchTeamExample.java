package com.xsl.pojo.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XslMatchTeamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XslMatchTeamExample() {
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

        public Criteria andTeamnameIsNull() {
            addCriterion("teamName is null");
            return (Criteria) this;
        }

        public Criteria andTeamnameIsNotNull() {
            addCriterion("teamName is not null");
            return (Criteria) this;
        }

        public Criteria andTeamnameEqualTo(String value) {
            addCriterion("teamName =", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameNotEqualTo(String value) {
            addCriterion("teamName <>", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameGreaterThan(String value) {
            addCriterion("teamName >", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameGreaterThanOrEqualTo(String value) {
            addCriterion("teamName >=", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameLessThan(String value) {
            addCriterion("teamName <", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameLessThanOrEqualTo(String value) {
            addCriterion("teamName <=", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameLike(String value) {
            addCriterion("teamName like", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameNotLike(String value) {
            addCriterion("teamName not like", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameIn(List<String> values) {
            addCriterion("teamName in", values, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameNotIn(List<String> values) {
            addCriterion("teamName not in", values, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameBetween(String value1, String value2) {
            addCriterion("teamName between", value1, value2, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameNotBetween(String value1, String value2) {
            addCriterion("teamName not between", value1, value2, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisIsNull() {
            addCriterion("teamSynopsis is null");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisIsNotNull() {
            addCriterion("teamSynopsis is not null");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisEqualTo(String value) {
            addCriterion("teamSynopsis =", value, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisNotEqualTo(String value) {
            addCriterion("teamSynopsis <>", value, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisGreaterThan(String value) {
            addCriterion("teamSynopsis >", value, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisGreaterThanOrEqualTo(String value) {
            addCriterion("teamSynopsis >=", value, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisLessThan(String value) {
            addCriterion("teamSynopsis <", value, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisLessThanOrEqualTo(String value) {
            addCriterion("teamSynopsis <=", value, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisLike(String value) {
            addCriterion("teamSynopsis like", value, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisNotLike(String value) {
            addCriterion("teamSynopsis not like", value, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisIn(List<String> values) {
            addCriterion("teamSynopsis in", values, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisNotIn(List<String> values) {
            addCriterion("teamSynopsis not in", values, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisBetween(String value1, String value2) {
            addCriterion("teamSynopsis between", value1, value2, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamsynopsisNotBetween(String value1, String value2) {
            addCriterion("teamSynopsis not between", value1, value2, "teamsynopsis");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridIsNull() {
            addCriterion("teamCreatorId is null");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridIsNotNull() {
            addCriterion("teamCreatorId is not null");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridEqualTo(String value) {
            addCriterion("teamCreatorId =", value, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridNotEqualTo(String value) {
            addCriterion("teamCreatorId <>", value, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridGreaterThan(String value) {
            addCriterion("teamCreatorId >", value, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridGreaterThanOrEqualTo(String value) {
            addCriterion("teamCreatorId >=", value, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridLessThan(String value) {
            addCriterion("teamCreatorId <", value, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridLessThanOrEqualTo(String value) {
            addCriterion("teamCreatorId <=", value, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridLike(String value) {
            addCriterion("teamCreatorId like", value, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridNotLike(String value) {
            addCriterion("teamCreatorId not like", value, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridIn(List<String> values) {
            addCriterion("teamCreatorId in", values, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridNotIn(List<String> values) {
            addCriterion("teamCreatorId not in", values, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridBetween(String value1, String value2) {
            addCriterion("teamCreatorId between", value1, value2, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatoridNotBetween(String value1, String value2) {
            addCriterion("teamCreatorId not between", value1, value2, "teamcreatorid");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeIsNull() {
            addCriterion("teamCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeIsNotNull() {
            addCriterion("teamCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeEqualTo(Date value) {
            addCriterion("teamCreateTime =", value, "teamcreatetime");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeNotEqualTo(Date value) {
            addCriterion("teamCreateTime <>", value, "teamcreatetime");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeGreaterThan(Date value) {
            addCriterion("teamCreateTime >", value, "teamcreatetime");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("teamCreateTime >=", value, "teamcreatetime");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeLessThan(Date value) {
            addCriterion("teamCreateTime <", value, "teamcreatetime");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("teamCreateTime <=", value, "teamcreatetime");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeIn(List<Date> values) {
            addCriterion("teamCreateTime in", values, "teamcreatetime");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeNotIn(List<Date> values) {
            addCriterion("teamCreateTime not in", values, "teamcreatetime");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeBetween(Date value1, Date value2) {
            addCriterion("teamCreateTime between", value1, value2, "teamcreatetime");
            return (Criteria) this;
        }

        public Criteria andTeamcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("teamCreateTime not between", value1, value2, "teamcreatetime");
            return (Criteria) this;
        }

        public Criteria andTeamstateIsNull() {
            addCriterion("teamState is null");
            return (Criteria) this;
        }

        public Criteria andTeamstateIsNotNull() {
            addCriterion("teamState is not null");
            return (Criteria) this;
        }

        public Criteria andTeamstateEqualTo(Integer value) {
            addCriterion("teamState =", value, "teamstate");
            return (Criteria) this;
        }

        public Criteria andTeamstateNotEqualTo(Integer value) {
            addCriterion("teamState <>", value, "teamstate");
            return (Criteria) this;
        }

        public Criteria andTeamstateGreaterThan(Integer value) {
            addCriterion("teamState >", value, "teamstate");
            return (Criteria) this;
        }

        public Criteria andTeamstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("teamState >=", value, "teamstate");
            return (Criteria) this;
        }

        public Criteria andTeamstateLessThan(Integer value) {
            addCriterion("teamState <", value, "teamstate");
            return (Criteria) this;
        }

        public Criteria andTeamstateLessThanOrEqualTo(Integer value) {
            addCriterion("teamState <=", value, "teamstate");
            return (Criteria) this;
        }

        public Criteria andTeamstateIn(List<Integer> values) {
            addCriterion("teamState in", values, "teamstate");
            return (Criteria) this;
        }

        public Criteria andTeamstateNotIn(List<Integer> values) {
            addCriterion("teamState not in", values, "teamstate");
            return (Criteria) this;
        }

        public Criteria andTeamstateBetween(Integer value1, Integer value2) {
            addCriterion("teamState between", value1, value2, "teamstate");
            return (Criteria) this;
        }

        public Criteria andTeamstateNotBetween(Integer value1, Integer value2) {
            addCriterion("teamState not between", value1, value2, "teamstate");
            return (Criteria) this;
        }

        public Criteria andTeamsloganIsNull() {
            addCriterion("teamSlogan is null");
            return (Criteria) this;
        }

        public Criteria andTeamsloganIsNotNull() {
            addCriterion("teamSlogan is not null");
            return (Criteria) this;
        }

        public Criteria andTeamsloganEqualTo(String value) {
            addCriterion("teamSlogan =", value, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamsloganNotEqualTo(String value) {
            addCriterion("teamSlogan <>", value, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamsloganGreaterThan(String value) {
            addCriterion("teamSlogan >", value, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamsloganGreaterThanOrEqualTo(String value) {
            addCriterion("teamSlogan >=", value, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamsloganLessThan(String value) {
            addCriterion("teamSlogan <", value, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamsloganLessThanOrEqualTo(String value) {
            addCriterion("teamSlogan <=", value, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamsloganLike(String value) {
            addCriterion("teamSlogan like", value, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamsloganNotLike(String value) {
            addCriterion("teamSlogan not like", value, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamsloganIn(List<String> values) {
            addCriterion("teamSlogan in", values, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamsloganNotIn(List<String> values) {
            addCriterion("teamSlogan not in", values, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamsloganBetween(String value1, String value2) {
            addCriterion("teamSlogan between", value1, value2, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamsloganNotBetween(String value1, String value2) {
            addCriterion("teamSlogan not between", value1, value2, "teamslogan");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlIsNull() {
            addCriterion("teamLogoUrl is null");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlIsNotNull() {
            addCriterion("teamLogoUrl is not null");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlEqualTo(String value) {
            addCriterion("teamLogoUrl =", value, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlNotEqualTo(String value) {
            addCriterion("teamLogoUrl <>", value, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlGreaterThan(String value) {
            addCriterion("teamLogoUrl >", value, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlGreaterThanOrEqualTo(String value) {
            addCriterion("teamLogoUrl >=", value, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlLessThan(String value) {
            addCriterion("teamLogoUrl <", value, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlLessThanOrEqualTo(String value) {
            addCriterion("teamLogoUrl <=", value, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlLike(String value) {
            addCriterion("teamLogoUrl like", value, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlNotLike(String value) {
            addCriterion("teamLogoUrl not like", value, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlIn(List<String> values) {
            addCriterion("teamLogoUrl in", values, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlNotIn(List<String> values) {
            addCriterion("teamLogoUrl not in", values, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlBetween(String value1, String value2) {
            addCriterion("teamLogoUrl between", value1, value2, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andTeamlogourlNotBetween(String value1, String value2) {
            addCriterion("teamLogoUrl not between", value1, value2, "teamlogourl");
            return (Criteria) this;
        }

        public Criteria andIseditIsNull() {
            addCriterion("isEdit is null");
            return (Criteria) this;
        }

        public Criteria andIseditIsNotNull() {
            addCriterion("isEdit is not null");
            return (Criteria) this;
        }

        public Criteria andIseditEqualTo(Boolean value) {
            addCriterion("isEdit =", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditNotEqualTo(Boolean value) {
            addCriterion("isEdit <>", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditGreaterThan(Boolean value) {
            addCriterion("isEdit >", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isEdit >=", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditLessThan(Boolean value) {
            addCriterion("isEdit <", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditLessThanOrEqualTo(Boolean value) {
            addCriterion("isEdit <=", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditIn(List<Boolean> values) {
            addCriterion("isEdit in", values, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditNotIn(List<Boolean> values) {
            addCriterion("isEdit not in", values, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditBetween(Boolean value1, Boolean value2) {
            addCriterion("isEdit between", value1, value2, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isEdit not between", value1, value2, "isedit");
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