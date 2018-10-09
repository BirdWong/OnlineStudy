package cn.h4795.OnlineStudy.Pojo;

import java.util.ArrayList;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMtextIsNull() {
            addCriterion("mtext is null");
            return (Criteria) this;
        }

        public Criteria andMtextIsNotNull() {
            addCriterion("mtext is not null");
            return (Criteria) this;
        }

        public Criteria andMtextEqualTo(String value) {
            addCriterion("mtext =", value, "mtext");
            return (Criteria) this;
        }

        public Criteria andMtextNotEqualTo(String value) {
            addCriterion("mtext <>", value, "mtext");
            return (Criteria) this;
        }

        public Criteria andMtextGreaterThan(String value) {
            addCriterion("mtext >", value, "mtext");
            return (Criteria) this;
        }

        public Criteria andMtextGreaterThanOrEqualTo(String value) {
            addCriterion("mtext >=", value, "mtext");
            return (Criteria) this;
        }

        public Criteria andMtextLessThan(String value) {
            addCriterion("mtext <", value, "mtext");
            return (Criteria) this;
        }

        public Criteria andMtextLessThanOrEqualTo(String value) {
            addCriterion("mtext <=", value, "mtext");
            return (Criteria) this;
        }

        public Criteria andMtextLike(String value) {
            addCriterion("mtext like", value, "mtext");
            return (Criteria) this;
        }

        public Criteria andMtextNotLike(String value) {
            addCriterion("mtext not like", value, "mtext");
            return (Criteria) this;
        }

        public Criteria andMtextIn(List<String> values) {
            addCriterion("mtext in", values, "mtext");
            return (Criteria) this;
        }

        public Criteria andMtextNotIn(List<String> values) {
            addCriterion("mtext not in", values, "mtext");
            return (Criteria) this;
        }

        public Criteria andMtextBetween(String value1, String value2) {
            addCriterion("mtext between", value1, value2, "mtext");
            return (Criteria) this;
        }

        public Criteria andMtextNotBetween(String value1, String value2) {
            addCriterion("mtext not between", value1, value2, "mtext");
            return (Criteria) this;
        }

        public Criteria andGetidIsNull() {
            addCriterion("getid is null");
            return (Criteria) this;
        }

        public Criteria andGetidIsNotNull() {
            addCriterion("getid is not null");
            return (Criteria) this;
        }

        public Criteria andGetidEqualTo(Integer value) {
            addCriterion("getid =", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidNotEqualTo(Integer value) {
            addCriterion("getid <>", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidGreaterThan(Integer value) {
            addCriterion("getid >", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("getid >=", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidLessThan(Integer value) {
            addCriterion("getid <", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidLessThanOrEqualTo(Integer value) {
            addCriterion("getid <=", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidIn(List<Integer> values) {
            addCriterion("getid in", values, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidNotIn(List<Integer> values) {
            addCriterion("getid not in", values, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidBetween(Integer value1, Integer value2) {
            addCriterion("getid between", value1, value2, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidNotBetween(Integer value1, Integer value2) {
            addCriterion("getid not between", value1, value2, "getid");
            return (Criteria) this;
        }

        public Criteria andSendidIsNull() {
            addCriterion("sendid is null");
            return (Criteria) this;
        }

        public Criteria andSendidIsNotNull() {
            addCriterion("sendid is not null");
            return (Criteria) this;
        }

        public Criteria andSendidEqualTo(Integer value) {
            addCriterion("sendid =", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidNotEqualTo(Integer value) {
            addCriterion("sendid <>", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidGreaterThan(Integer value) {
            addCriterion("sendid >", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sendid >=", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidLessThan(Integer value) {
            addCriterion("sendid <", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidLessThanOrEqualTo(Integer value) {
            addCriterion("sendid <=", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidIn(List<Integer> values) {
            addCriterion("sendid in", values, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidNotIn(List<Integer> values) {
            addCriterion("sendid not in", values, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidBetween(Integer value1, Integer value2) {
            addCriterion("sendid between", value1, value2, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidNotBetween(Integer value1, Integer value2) {
            addCriterion("sendid not between", value1, value2, "sendid");
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