package com.eboji.data.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GGScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GGScoreExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andGnoIsNull() {
            addCriterion("gno is null");
            return (Criteria) this;
        }

        public Criteria andGnoIsNotNull() {
            addCriterion("gno is not null");
            return (Criteria) this;
        }

        public Criteria andGnoEqualTo(Integer value) {
            addCriterion("gno =", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoNotEqualTo(Integer value) {
            addCriterion("gno <>", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoGreaterThan(Integer value) {
            addCriterion("gno >", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("gno >=", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoLessThan(Integer value) {
            addCriterion("gno <", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoLessThanOrEqualTo(Integer value) {
            addCriterion("gno <=", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoIn(List<Integer> values) {
            addCriterion("gno in", values, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoNotIn(List<Integer> values) {
            addCriterion("gno not in", values, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoBetween(Integer value1, Integer value2) {
            addCriterion("gno between", value1, value2, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoNotBetween(Integer value1, Integer value2) {
            addCriterion("gno not between", value1, value2, "gno");
            return (Criteria) this;
        }

        public Criteria andScEuidIsNull() {
            addCriterion("sc_euid is null");
            return (Criteria) this;
        }

        public Criteria andScEuidIsNotNull() {
            addCriterion("sc_euid is not null");
            return (Criteria) this;
        }

        public Criteria andScEuidEqualTo(Integer value) {
            addCriterion("sc_euid =", value, "scEuid");
            return (Criteria) this;
        }

        public Criteria andScEuidNotEqualTo(Integer value) {
            addCriterion("sc_euid <>", value, "scEuid");
            return (Criteria) this;
        }

        public Criteria andScEuidGreaterThan(Integer value) {
            addCriterion("sc_euid >", value, "scEuid");
            return (Criteria) this;
        }

        public Criteria andScEuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sc_euid >=", value, "scEuid");
            return (Criteria) this;
        }

        public Criteria andScEuidLessThan(Integer value) {
            addCriterion("sc_euid <", value, "scEuid");
            return (Criteria) this;
        }

        public Criteria andScEuidLessThanOrEqualTo(Integer value) {
            addCriterion("sc_euid <=", value, "scEuid");
            return (Criteria) this;
        }

        public Criteria andScEuidIn(List<Integer> values) {
            addCriterion("sc_euid in", values, "scEuid");
            return (Criteria) this;
        }

        public Criteria andScEuidNotIn(List<Integer> values) {
            addCriterion("sc_euid not in", values, "scEuid");
            return (Criteria) this;
        }

        public Criteria andScEuidBetween(Integer value1, Integer value2) {
            addCriterion("sc_euid between", value1, value2, "scEuid");
            return (Criteria) this;
        }

        public Criteria andScEuidNotBetween(Integer value1, Integer value2) {
            addCriterion("sc_euid not between", value1, value2, "scEuid");
            return (Criteria) this;
        }

        public Criteria andScSuidIsNull() {
            addCriterion("sc_suid is null");
            return (Criteria) this;
        }

        public Criteria andScSuidIsNotNull() {
            addCriterion("sc_suid is not null");
            return (Criteria) this;
        }

        public Criteria andScSuidEqualTo(Integer value) {
            addCriterion("sc_suid =", value, "scSuid");
            return (Criteria) this;
        }

        public Criteria andScSuidNotEqualTo(Integer value) {
            addCriterion("sc_suid <>", value, "scSuid");
            return (Criteria) this;
        }

        public Criteria andScSuidGreaterThan(Integer value) {
            addCriterion("sc_suid >", value, "scSuid");
            return (Criteria) this;
        }

        public Criteria andScSuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sc_suid >=", value, "scSuid");
            return (Criteria) this;
        }

        public Criteria andScSuidLessThan(Integer value) {
            addCriterion("sc_suid <", value, "scSuid");
            return (Criteria) this;
        }

        public Criteria andScSuidLessThanOrEqualTo(Integer value) {
            addCriterion("sc_suid <=", value, "scSuid");
            return (Criteria) this;
        }

        public Criteria andScSuidIn(List<Integer> values) {
            addCriterion("sc_suid in", values, "scSuid");
            return (Criteria) this;
        }

        public Criteria andScSuidNotIn(List<Integer> values) {
            addCriterion("sc_suid not in", values, "scSuid");
            return (Criteria) this;
        }

        public Criteria andScSuidBetween(Integer value1, Integer value2) {
            addCriterion("sc_suid between", value1, value2, "scSuid");
            return (Criteria) this;
        }

        public Criteria andScSuidNotBetween(Integer value1, Integer value2) {
            addCriterion("sc_suid not between", value1, value2, "scSuid");
            return (Criteria) this;
        }

        public Criteria andScWuidIsNull() {
            addCriterion("sc_wuid is null");
            return (Criteria) this;
        }

        public Criteria andScWuidIsNotNull() {
            addCriterion("sc_wuid is not null");
            return (Criteria) this;
        }

        public Criteria andScWuidEqualTo(Integer value) {
            addCriterion("sc_wuid =", value, "scWuid");
            return (Criteria) this;
        }

        public Criteria andScWuidNotEqualTo(Integer value) {
            addCriterion("sc_wuid <>", value, "scWuid");
            return (Criteria) this;
        }

        public Criteria andScWuidGreaterThan(Integer value) {
            addCriterion("sc_wuid >", value, "scWuid");
            return (Criteria) this;
        }

        public Criteria andScWuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sc_wuid >=", value, "scWuid");
            return (Criteria) this;
        }

        public Criteria andScWuidLessThan(Integer value) {
            addCriterion("sc_wuid <", value, "scWuid");
            return (Criteria) this;
        }

        public Criteria andScWuidLessThanOrEqualTo(Integer value) {
            addCriterion("sc_wuid <=", value, "scWuid");
            return (Criteria) this;
        }

        public Criteria andScWuidIn(List<Integer> values) {
            addCriterion("sc_wuid in", values, "scWuid");
            return (Criteria) this;
        }

        public Criteria andScWuidNotIn(List<Integer> values) {
            addCriterion("sc_wuid not in", values, "scWuid");
            return (Criteria) this;
        }

        public Criteria andScWuidBetween(Integer value1, Integer value2) {
            addCriterion("sc_wuid between", value1, value2, "scWuid");
            return (Criteria) this;
        }

        public Criteria andScWuidNotBetween(Integer value1, Integer value2) {
            addCriterion("sc_wuid not between", value1, value2, "scWuid");
            return (Criteria) this;
        }

        public Criteria andScNuidIsNull() {
            addCriterion("sc_nuid is null");
            return (Criteria) this;
        }

        public Criteria andScNuidIsNotNull() {
            addCriterion("sc_nuid is not null");
            return (Criteria) this;
        }

        public Criteria andScNuidEqualTo(Integer value) {
            addCriterion("sc_nuid =", value, "scNuid");
            return (Criteria) this;
        }

        public Criteria andScNuidNotEqualTo(Integer value) {
            addCriterion("sc_nuid <>", value, "scNuid");
            return (Criteria) this;
        }

        public Criteria andScNuidGreaterThan(Integer value) {
            addCriterion("sc_nuid >", value, "scNuid");
            return (Criteria) this;
        }

        public Criteria andScNuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sc_nuid >=", value, "scNuid");
            return (Criteria) this;
        }

        public Criteria andScNuidLessThan(Integer value) {
            addCriterion("sc_nuid <", value, "scNuid");
            return (Criteria) this;
        }

        public Criteria andScNuidLessThanOrEqualTo(Integer value) {
            addCriterion("sc_nuid <=", value, "scNuid");
            return (Criteria) this;
        }

        public Criteria andScNuidIn(List<Integer> values) {
            addCriterion("sc_nuid in", values, "scNuid");
            return (Criteria) this;
        }

        public Criteria andScNuidNotIn(List<Integer> values) {
            addCriterion("sc_nuid not in", values, "scNuid");
            return (Criteria) this;
        }

        public Criteria andScNuidBetween(Integer value1, Integer value2) {
            addCriterion("sc_nuid between", value1, value2, "scNuid");
            return (Criteria) this;
        }

        public Criteria andScNuidNotBetween(Integer value1, Integer value2) {
            addCriterion("sc_nuid not between", value1, value2, "scNuid");
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