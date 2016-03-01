package com.eboji.data.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GGTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GGTableExample() {
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

        public Criteria andEuidIsNull() {
            addCriterion("euid is null");
            return (Criteria) this;
        }

        public Criteria andEuidIsNotNull() {
            addCriterion("euid is not null");
            return (Criteria) this;
        }

        public Criteria andEuidEqualTo(Integer value) {
            addCriterion("euid =", value, "euid");
            return (Criteria) this;
        }

        public Criteria andEuidNotEqualTo(Integer value) {
            addCriterion("euid <>", value, "euid");
            return (Criteria) this;
        }

        public Criteria andEuidGreaterThan(Integer value) {
            addCriterion("euid >", value, "euid");
            return (Criteria) this;
        }

        public Criteria andEuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("euid >=", value, "euid");
            return (Criteria) this;
        }

        public Criteria andEuidLessThan(Integer value) {
            addCriterion("euid <", value, "euid");
            return (Criteria) this;
        }

        public Criteria andEuidLessThanOrEqualTo(Integer value) {
            addCriterion("euid <=", value, "euid");
            return (Criteria) this;
        }

        public Criteria andEuidIn(List<Integer> values) {
            addCriterion("euid in", values, "euid");
            return (Criteria) this;
        }

        public Criteria andEuidNotIn(List<Integer> values) {
            addCriterion("euid not in", values, "euid");
            return (Criteria) this;
        }

        public Criteria andEuidBetween(Integer value1, Integer value2) {
            addCriterion("euid between", value1, value2, "euid");
            return (Criteria) this;
        }

        public Criteria andEuidNotBetween(Integer value1, Integer value2) {
            addCriterion("euid not between", value1, value2, "euid");
            return (Criteria) this;
        }

        public Criteria andSuidIsNull() {
            addCriterion("suid is null");
            return (Criteria) this;
        }

        public Criteria andSuidIsNotNull() {
            addCriterion("suid is not null");
            return (Criteria) this;
        }

        public Criteria andSuidEqualTo(Integer value) {
            addCriterion("suid =", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidNotEqualTo(Integer value) {
            addCriterion("suid <>", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidGreaterThan(Integer value) {
            addCriterion("suid >", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("suid >=", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidLessThan(Integer value) {
            addCriterion("suid <", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidLessThanOrEqualTo(Integer value) {
            addCriterion("suid <=", value, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidIn(List<Integer> values) {
            addCriterion("suid in", values, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidNotIn(List<Integer> values) {
            addCriterion("suid not in", values, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidBetween(Integer value1, Integer value2) {
            addCriterion("suid between", value1, value2, "suid");
            return (Criteria) this;
        }

        public Criteria andSuidNotBetween(Integer value1, Integer value2) {
            addCriterion("suid not between", value1, value2, "suid");
            return (Criteria) this;
        }

        public Criteria andWuidIsNull() {
            addCriterion("wuid is null");
            return (Criteria) this;
        }

        public Criteria andWuidIsNotNull() {
            addCriterion("wuid is not null");
            return (Criteria) this;
        }

        public Criteria andWuidEqualTo(Integer value) {
            addCriterion("wuid =", value, "wuid");
            return (Criteria) this;
        }

        public Criteria andWuidNotEqualTo(Integer value) {
            addCriterion("wuid <>", value, "wuid");
            return (Criteria) this;
        }

        public Criteria andWuidGreaterThan(Integer value) {
            addCriterion("wuid >", value, "wuid");
            return (Criteria) this;
        }

        public Criteria andWuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("wuid >=", value, "wuid");
            return (Criteria) this;
        }

        public Criteria andWuidLessThan(Integer value) {
            addCriterion("wuid <", value, "wuid");
            return (Criteria) this;
        }

        public Criteria andWuidLessThanOrEqualTo(Integer value) {
            addCriterion("wuid <=", value, "wuid");
            return (Criteria) this;
        }

        public Criteria andWuidIn(List<Integer> values) {
            addCriterion("wuid in", values, "wuid");
            return (Criteria) this;
        }

        public Criteria andWuidNotIn(List<Integer> values) {
            addCriterion("wuid not in", values, "wuid");
            return (Criteria) this;
        }

        public Criteria andWuidBetween(Integer value1, Integer value2) {
            addCriterion("wuid between", value1, value2, "wuid");
            return (Criteria) this;
        }

        public Criteria andWuidNotBetween(Integer value1, Integer value2) {
            addCriterion("wuid not between", value1, value2, "wuid");
            return (Criteria) this;
        }

        public Criteria andNuidIsNull() {
            addCriterion("nuid is null");
            return (Criteria) this;
        }

        public Criteria andNuidIsNotNull() {
            addCriterion("nuid is not null");
            return (Criteria) this;
        }

        public Criteria andNuidEqualTo(Integer value) {
            addCriterion("nuid =", value, "nuid");
            return (Criteria) this;
        }

        public Criteria andNuidNotEqualTo(Integer value) {
            addCriterion("nuid <>", value, "nuid");
            return (Criteria) this;
        }

        public Criteria andNuidGreaterThan(Integer value) {
            addCriterion("nuid >", value, "nuid");
            return (Criteria) this;
        }

        public Criteria andNuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("nuid >=", value, "nuid");
            return (Criteria) this;
        }

        public Criteria andNuidLessThan(Integer value) {
            addCriterion("nuid <", value, "nuid");
            return (Criteria) this;
        }

        public Criteria andNuidLessThanOrEqualTo(Integer value) {
            addCriterion("nuid <=", value, "nuid");
            return (Criteria) this;
        }

        public Criteria andNuidIn(List<Integer> values) {
            addCriterion("nuid in", values, "nuid");
            return (Criteria) this;
        }

        public Criteria andNuidNotIn(List<Integer> values) {
            addCriterion("nuid not in", values, "nuid");
            return (Criteria) this;
        }

        public Criteria andNuidBetween(Integer value1, Integer value2) {
            addCriterion("nuid between", value1, value2, "nuid");
            return (Criteria) this;
        }

        public Criteria andNuidNotBetween(Integer value1, Integer value2) {
            addCriterion("nuid not between", value1, value2, "nuid");
            return (Criteria) this;
        }

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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