package cn.h4795.OnlineStudy.Pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreatedataIsNull() {
            addCriterion("createdata is null");
            return (Criteria) this;
        }

        public Criteria andCreatedataIsNotNull() {
            addCriterion("createdata is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedataEqualTo(Date value) {
            addCriterion("createdata =", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataNotEqualTo(Date value) {
            addCriterion("createdata <>", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataGreaterThan(Date value) {
            addCriterion("createdata >", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataGreaterThanOrEqualTo(Date value) {
            addCriterion("createdata >=", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataLessThan(Date value) {
            addCriterion("createdata <", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataLessThanOrEqualTo(Date value) {
            addCriterion("createdata <=", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataIn(List<Date> values) {
            addCriterion("createdata in", values, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataNotIn(List<Date> values) {
            addCriterion("createdata not in", values, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataBetween(Date value1, Date value2) {
            addCriterion("createdata between", value1, value2, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataNotBetween(Date value1, Date value2) {
            addCriterion("createdata not between", value1, value2, "createdata");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andPurlIsNull() {
            addCriterion("purl is null");
            return (Criteria) this;
        }

        public Criteria andPurlIsNotNull() {
            addCriterion("purl is not null");
            return (Criteria) this;
        }

        public Criteria andPurlEqualTo(String value) {
            addCriterion("purl =", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlNotEqualTo(String value) {
            addCriterion("purl <>", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlGreaterThan(String value) {
            addCriterion("purl >", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlGreaterThanOrEqualTo(String value) {
            addCriterion("purl >=", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlLessThan(String value) {
            addCriterion("purl <", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlLessThanOrEqualTo(String value) {
            addCriterion("purl <=", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlLike(String value) {
            addCriterion("purl like", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlNotLike(String value) {
            addCriterion("purl not like", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlIn(List<String> values) {
            addCriterion("purl in", values, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlNotIn(List<String> values) {
            addCriterion("purl not in", values, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlBetween(String value1, String value2) {
            addCriterion("purl between", value1, value2, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlNotBetween(String value1, String value2) {
            addCriterion("purl not between", value1, value2, "purl");
            return (Criteria) this;
        }

        public Criteria andAswerIsNull() {
            addCriterion("aswer is null");
            return (Criteria) this;
        }

        public Criteria andAswerIsNotNull() {
            addCriterion("aswer is not null");
            return (Criteria) this;
        }

        public Criteria andAswerEqualTo(String value) {
            addCriterion("aswer =", value, "aswer");
            return (Criteria) this;
        }

        public Criteria andAswerNotEqualTo(String value) {
            addCriterion("aswer <>", value, "aswer");
            return (Criteria) this;
        }

        public Criteria andAswerGreaterThan(String value) {
            addCriterion("aswer >", value, "aswer");
            return (Criteria) this;
        }

        public Criteria andAswerGreaterThanOrEqualTo(String value) {
            addCriterion("aswer >=", value, "aswer");
            return (Criteria) this;
        }

        public Criteria andAswerLessThan(String value) {
            addCriterion("aswer <", value, "aswer");
            return (Criteria) this;
        }

        public Criteria andAswerLessThanOrEqualTo(String value) {
            addCriterion("aswer <=", value, "aswer");
            return (Criteria) this;
        }

        public Criteria andAswerLike(String value) {
            addCriterion("aswer like", value, "aswer");
            return (Criteria) this;
        }

        public Criteria andAswerNotLike(String value) {
            addCriterion("aswer not like", value, "aswer");
            return (Criteria) this;
        }

        public Criteria andAswerIn(List<String> values) {
            addCriterion("aswer in", values, "aswer");
            return (Criteria) this;
        }

        public Criteria andAswerNotIn(List<String> values) {
            addCriterion("aswer not in", values, "aswer");
            return (Criteria) this;
        }

        public Criteria andAswerBetween(String value1, String value2) {
            addCriterion("aswer between", value1, value2, "aswer");
            return (Criteria) this;
        }

        public Criteria andAswerNotBetween(String value1, String value2) {
            addCriterion("aswer not between", value1, value2, "aswer");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andKidIsNull() {
            addCriterion("kid is null");
            return (Criteria) this;
        }

        public Criteria andKidIsNotNull() {
            addCriterion("kid is not null");
            return (Criteria) this;
        }

        public Criteria andKidEqualTo(Integer value) {
            addCriterion("kid =", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotEqualTo(Integer value) {
            addCriterion("kid <>", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThan(Integer value) {
            addCriterion("kid >", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThanOrEqualTo(Integer value) {
            addCriterion("kid >=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThan(Integer value) {
            addCriterion("kid <", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThanOrEqualTo(Integer value) {
            addCriterion("kid <=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidIn(List<Integer> values) {
            addCriterion("kid in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotIn(List<Integer> values) {
            addCriterion("kid not in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidBetween(Integer value1, Integer value2) {
            addCriterion("kid between", value1, value2, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotBetween(Integer value1, Integer value2) {
            addCriterion("kid not between", value1, value2, "kid");
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