package cn.h4795.OnlineStudy.Pojo;

import java.util.ArrayList;
import java.util.List;

public class PersonalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonalExample() {
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

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
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

        public Criteria andPsexIsNull() {
            addCriterion("psex is null");
            return (Criteria) this;
        }

        public Criteria andPsexIsNotNull() {
            addCriterion("psex is not null");
            return (Criteria) this;
        }

        public Criteria andPsexEqualTo(String value) {
            addCriterion("psex =", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexNotEqualTo(String value) {
            addCriterion("psex <>", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexGreaterThan(String value) {
            addCriterion("psex >", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexGreaterThanOrEqualTo(String value) {
            addCriterion("psex >=", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexLessThan(String value) {
            addCriterion("psex <", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexLessThanOrEqualTo(String value) {
            addCriterion("psex <=", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexLike(String value) {
            addCriterion("psex like", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexNotLike(String value) {
            addCriterion("psex not like", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexIn(List<String> values) {
            addCriterion("psex in", values, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexNotIn(List<String> values) {
            addCriterion("psex not in", values, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexBetween(String value1, String value2) {
            addCriterion("psex between", value1, value2, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexNotBetween(String value1, String value2) {
            addCriterion("psex not between", value1, value2, "psex");
            return (Criteria) this;
        }

        public Criteria andPaddressIsNull() {
            addCriterion("paddress is null");
            return (Criteria) this;
        }

        public Criteria andPaddressIsNotNull() {
            addCriterion("paddress is not null");
            return (Criteria) this;
        }

        public Criteria andPaddressEqualTo(String value) {
            addCriterion("paddress =", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressNotEqualTo(String value) {
            addCriterion("paddress <>", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressGreaterThan(String value) {
            addCriterion("paddress >", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressGreaterThanOrEqualTo(String value) {
            addCriterion("paddress >=", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressLessThan(String value) {
            addCriterion("paddress <", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressLessThanOrEqualTo(String value) {
            addCriterion("paddress <=", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressLike(String value) {
            addCriterion("paddress like", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressNotLike(String value) {
            addCriterion("paddress not like", value, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressIn(List<String> values) {
            addCriterion("paddress in", values, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressNotIn(List<String> values) {
            addCriterion("paddress not in", values, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressBetween(String value1, String value2) {
            addCriterion("paddress between", value1, value2, "paddress");
            return (Criteria) this;
        }

        public Criteria andPaddressNotBetween(String value1, String value2) {
            addCriterion("paddress not between", value1, value2, "paddress");
            return (Criteria) this;
        }

        public Criteria andPschoolIsNull() {
            addCriterion("pschool is null");
            return (Criteria) this;
        }

        public Criteria andPschoolIsNotNull() {
            addCriterion("pschool is not null");
            return (Criteria) this;
        }

        public Criteria andPschoolEqualTo(String value) {
            addCriterion("pschool =", value, "pschool");
            return (Criteria) this;
        }

        public Criteria andPschoolNotEqualTo(String value) {
            addCriterion("pschool <>", value, "pschool");
            return (Criteria) this;
        }

        public Criteria andPschoolGreaterThan(String value) {
            addCriterion("pschool >", value, "pschool");
            return (Criteria) this;
        }

        public Criteria andPschoolGreaterThanOrEqualTo(String value) {
            addCriterion("pschool >=", value, "pschool");
            return (Criteria) this;
        }

        public Criteria andPschoolLessThan(String value) {
            addCriterion("pschool <", value, "pschool");
            return (Criteria) this;
        }

        public Criteria andPschoolLessThanOrEqualTo(String value) {
            addCriterion("pschool <=", value, "pschool");
            return (Criteria) this;
        }

        public Criteria andPschoolLike(String value) {
            addCriterion("pschool like", value, "pschool");
            return (Criteria) this;
        }

        public Criteria andPschoolNotLike(String value) {
            addCriterion("pschool not like", value, "pschool");
            return (Criteria) this;
        }

        public Criteria andPschoolIn(List<String> values) {
            addCriterion("pschool in", values, "pschool");
            return (Criteria) this;
        }

        public Criteria andPschoolNotIn(List<String> values) {
            addCriterion("pschool not in", values, "pschool");
            return (Criteria) this;
        }

        public Criteria andPschoolBetween(String value1, String value2) {
            addCriterion("pschool between", value1, value2, "pschool");
            return (Criteria) this;
        }

        public Criteria andPschoolNotBetween(String value1, String value2) {
            addCriterion("pschool not between", value1, value2, "pschool");
            return (Criteria) this;
        }

        public Criteria andPcompanyIsNull() {
            addCriterion("pcompany is null");
            return (Criteria) this;
        }

        public Criteria andPcompanyIsNotNull() {
            addCriterion("pcompany is not null");
            return (Criteria) this;
        }

        public Criteria andPcompanyEqualTo(String value) {
            addCriterion("pcompany =", value, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPcompanyNotEqualTo(String value) {
            addCriterion("pcompany <>", value, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPcompanyGreaterThan(String value) {
            addCriterion("pcompany >", value, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPcompanyGreaterThanOrEqualTo(String value) {
            addCriterion("pcompany >=", value, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPcompanyLessThan(String value) {
            addCriterion("pcompany <", value, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPcompanyLessThanOrEqualTo(String value) {
            addCriterion("pcompany <=", value, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPcompanyLike(String value) {
            addCriterion("pcompany like", value, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPcompanyNotLike(String value) {
            addCriterion("pcompany not like", value, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPcompanyIn(List<String> values) {
            addCriterion("pcompany in", values, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPcompanyNotIn(List<String> values) {
            addCriterion("pcompany not in", values, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPcompanyBetween(String value1, String value2) {
            addCriterion("pcompany between", value1, value2, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPcompanyNotBetween(String value1, String value2) {
            addCriterion("pcompany not between", value1, value2, "pcompany");
            return (Criteria) this;
        }

        public Criteria andPpathIsNull() {
            addCriterion("ppath is null");
            return (Criteria) this;
        }

        public Criteria andPpathIsNotNull() {
            addCriterion("ppath is not null");
            return (Criteria) this;
        }

        public Criteria andPpathEqualTo(String value) {
            addCriterion("ppath =", value, "ppath");
            return (Criteria) this;
        }

        public Criteria andPpathNotEqualTo(String value) {
            addCriterion("ppath <>", value, "ppath");
            return (Criteria) this;
        }

        public Criteria andPpathGreaterThan(String value) {
            addCriterion("ppath >", value, "ppath");
            return (Criteria) this;
        }

        public Criteria andPpathGreaterThanOrEqualTo(String value) {
            addCriterion("ppath >=", value, "ppath");
            return (Criteria) this;
        }

        public Criteria andPpathLessThan(String value) {
            addCriterion("ppath <", value, "ppath");
            return (Criteria) this;
        }

        public Criteria andPpathLessThanOrEqualTo(String value) {
            addCriterion("ppath <=", value, "ppath");
            return (Criteria) this;
        }

        public Criteria andPpathLike(String value) {
            addCriterion("ppath like", value, "ppath");
            return (Criteria) this;
        }

        public Criteria andPpathNotLike(String value) {
            addCriterion("ppath not like", value, "ppath");
            return (Criteria) this;
        }

        public Criteria andPpathIn(List<String> values) {
            addCriterion("ppath in", values, "ppath");
            return (Criteria) this;
        }

        public Criteria andPpathNotIn(List<String> values) {
            addCriterion("ppath not in", values, "ppath");
            return (Criteria) this;
        }

        public Criteria andPpathBetween(String value1, String value2) {
            addCriterion("ppath between", value1, value2, "ppath");
            return (Criteria) this;
        }

        public Criteria andPpathNotBetween(String value1, String value2) {
            addCriterion("ppath not between", value1, value2, "ppath");
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