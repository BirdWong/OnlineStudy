package cn.h4795.OnlineStudy.Pojo;

import java.util.ArrayList;
import java.util.List;

public class VidioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VidioExample() {
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

        public Criteria andVnameIsNull() {
            addCriterion("vname is null");
            return (Criteria) this;
        }

        public Criteria andVnameIsNotNull() {
            addCriterion("vname is not null");
            return (Criteria) this;
        }

        public Criteria andVnameEqualTo(String value) {
            addCriterion("vname =", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameNotEqualTo(String value) {
            addCriterion("vname <>", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameGreaterThan(String value) {
            addCriterion("vname >", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameGreaterThanOrEqualTo(String value) {
            addCriterion("vname >=", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameLessThan(String value) {
            addCriterion("vname <", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameLessThanOrEqualTo(String value) {
            addCriterion("vname <=", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameLike(String value) {
            addCriterion("vname like", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameNotLike(String value) {
            addCriterion("vname not like", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameIn(List<String> values) {
            addCriterion("vname in", values, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameNotIn(List<String> values) {
            addCriterion("vname not in", values, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameBetween(String value1, String value2) {
            addCriterion("vname between", value1, value2, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameNotBetween(String value1, String value2) {
            addCriterion("vname not between", value1, value2, "vname");
            return (Criteria) this;
        }

        public Criteria andVtextIsNull() {
            addCriterion("vtext is null");
            return (Criteria) this;
        }

        public Criteria andVtextIsNotNull() {
            addCriterion("vtext is not null");
            return (Criteria) this;
        }

        public Criteria andVtextEqualTo(String value) {
            addCriterion("vtext =", value, "vtext");
            return (Criteria) this;
        }

        public Criteria andVtextNotEqualTo(String value) {
            addCriterion("vtext <>", value, "vtext");
            return (Criteria) this;
        }

        public Criteria andVtextGreaterThan(String value) {
            addCriterion("vtext >", value, "vtext");
            return (Criteria) this;
        }

        public Criteria andVtextGreaterThanOrEqualTo(String value) {
            addCriterion("vtext >=", value, "vtext");
            return (Criteria) this;
        }

        public Criteria andVtextLessThan(String value) {
            addCriterion("vtext <", value, "vtext");
            return (Criteria) this;
        }

        public Criteria andVtextLessThanOrEqualTo(String value) {
            addCriterion("vtext <=", value, "vtext");
            return (Criteria) this;
        }

        public Criteria andVtextLike(String value) {
            addCriterion("vtext like", value, "vtext");
            return (Criteria) this;
        }

        public Criteria andVtextNotLike(String value) {
            addCriterion("vtext not like", value, "vtext");
            return (Criteria) this;
        }

        public Criteria andVtextIn(List<String> values) {
            addCriterion("vtext in", values, "vtext");
            return (Criteria) this;
        }

        public Criteria andVtextNotIn(List<String> values) {
            addCriterion("vtext not in", values, "vtext");
            return (Criteria) this;
        }

        public Criteria andVtextBetween(String value1, String value2) {
            addCriterion("vtext between", value1, value2, "vtext");
            return (Criteria) this;
        }

        public Criteria andVtextNotBetween(String value1, String value2) {
            addCriterion("vtext not between", value1, value2, "vtext");
            return (Criteria) this;
        }

        public Criteria andVurlIsNull() {
            addCriterion("vurl is null");
            return (Criteria) this;
        }

        public Criteria andVurlIsNotNull() {
            addCriterion("vurl is not null");
            return (Criteria) this;
        }

        public Criteria andVurlEqualTo(String value) {
            addCriterion("vurl =", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlNotEqualTo(String value) {
            addCriterion("vurl <>", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlGreaterThan(String value) {
            addCriterion("vurl >", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlGreaterThanOrEqualTo(String value) {
            addCriterion("vurl >=", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlLessThan(String value) {
            addCriterion("vurl <", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlLessThanOrEqualTo(String value) {
            addCriterion("vurl <=", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlLike(String value) {
            addCriterion("vurl like", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlNotLike(String value) {
            addCriterion("vurl not like", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlIn(List<String> values) {
            addCriterion("vurl in", values, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlNotIn(List<String> values) {
            addCriterion("vurl not in", values, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlBetween(String value1, String value2) {
            addCriterion("vurl between", value1, value2, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlNotBetween(String value1, String value2) {
            addCriterion("vurl not between", value1, value2, "vurl");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
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