package com.eboji.data.pojo;

import java.util.ArrayList;
import java.util.List;

public class GameHistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameHistExample() {
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

        public Criteria andDEuidIsNull() {
            addCriterion("d_euid is null");
            return (Criteria) this;
        }

        public Criteria andDEuidIsNotNull() {
            addCriterion("d_euid is not null");
            return (Criteria) this;
        }

        public Criteria andDEuidEqualTo(String value) {
            addCriterion("d_euid =", value, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDEuidNotEqualTo(String value) {
            addCriterion("d_euid <>", value, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDEuidGreaterThan(String value) {
            addCriterion("d_euid >", value, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDEuidGreaterThanOrEqualTo(String value) {
            addCriterion("d_euid >=", value, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDEuidLessThan(String value) {
            addCriterion("d_euid <", value, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDEuidLessThanOrEqualTo(String value) {
            addCriterion("d_euid <=", value, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDEuidLike(String value) {
            addCriterion("d_euid like", value, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDEuidNotLike(String value) {
            addCriterion("d_euid not like", value, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDEuidIn(List<String> values) {
            addCriterion("d_euid in", values, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDEuidNotIn(List<String> values) {
            addCriterion("d_euid not in", values, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDEuidBetween(String value1, String value2) {
            addCriterion("d_euid between", value1, value2, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDEuidNotBetween(String value1, String value2) {
            addCriterion("d_euid not between", value1, value2, "dEuid");
            return (Criteria) this;
        }

        public Criteria andDSuidIsNull() {
            addCriterion("d_suid is null");
            return (Criteria) this;
        }

        public Criteria andDSuidIsNotNull() {
            addCriterion("d_suid is not null");
            return (Criteria) this;
        }

        public Criteria andDSuidEqualTo(String value) {
            addCriterion("d_suid =", value, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDSuidNotEqualTo(String value) {
            addCriterion("d_suid <>", value, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDSuidGreaterThan(String value) {
            addCriterion("d_suid >", value, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDSuidGreaterThanOrEqualTo(String value) {
            addCriterion("d_suid >=", value, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDSuidLessThan(String value) {
            addCriterion("d_suid <", value, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDSuidLessThanOrEqualTo(String value) {
            addCriterion("d_suid <=", value, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDSuidLike(String value) {
            addCriterion("d_suid like", value, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDSuidNotLike(String value) {
            addCriterion("d_suid not like", value, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDSuidIn(List<String> values) {
            addCriterion("d_suid in", values, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDSuidNotIn(List<String> values) {
            addCriterion("d_suid not in", values, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDSuidBetween(String value1, String value2) {
            addCriterion("d_suid between", value1, value2, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDSuidNotBetween(String value1, String value2) {
            addCriterion("d_suid not between", value1, value2, "dSuid");
            return (Criteria) this;
        }

        public Criteria andDWuidIsNull() {
            addCriterion("d_wuid is null");
            return (Criteria) this;
        }

        public Criteria andDWuidIsNotNull() {
            addCriterion("d_wuid is not null");
            return (Criteria) this;
        }

        public Criteria andDWuidEqualTo(String value) {
            addCriterion("d_wuid =", value, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDWuidNotEqualTo(String value) {
            addCriterion("d_wuid <>", value, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDWuidGreaterThan(String value) {
            addCriterion("d_wuid >", value, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDWuidGreaterThanOrEqualTo(String value) {
            addCriterion("d_wuid >=", value, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDWuidLessThan(String value) {
            addCriterion("d_wuid <", value, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDWuidLessThanOrEqualTo(String value) {
            addCriterion("d_wuid <=", value, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDWuidLike(String value) {
            addCriterion("d_wuid like", value, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDWuidNotLike(String value) {
            addCriterion("d_wuid not like", value, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDWuidIn(List<String> values) {
            addCriterion("d_wuid in", values, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDWuidNotIn(List<String> values) {
            addCriterion("d_wuid not in", values, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDWuidBetween(String value1, String value2) {
            addCriterion("d_wuid between", value1, value2, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDWuidNotBetween(String value1, String value2) {
            addCriterion("d_wuid not between", value1, value2, "dWuid");
            return (Criteria) this;
        }

        public Criteria andDNuidIsNull() {
            addCriterion("d_nuid is null");
            return (Criteria) this;
        }

        public Criteria andDNuidIsNotNull() {
            addCriterion("d_nuid is not null");
            return (Criteria) this;
        }

        public Criteria andDNuidEqualTo(String value) {
            addCriterion("d_nuid =", value, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDNuidNotEqualTo(String value) {
            addCriterion("d_nuid <>", value, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDNuidGreaterThan(String value) {
            addCriterion("d_nuid >", value, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDNuidGreaterThanOrEqualTo(String value) {
            addCriterion("d_nuid >=", value, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDNuidLessThan(String value) {
            addCriterion("d_nuid <", value, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDNuidLessThanOrEqualTo(String value) {
            addCriterion("d_nuid <=", value, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDNuidLike(String value) {
            addCriterion("d_nuid like", value, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDNuidNotLike(String value) {
            addCriterion("d_nuid not like", value, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDNuidIn(List<String> values) {
            addCriterion("d_nuid in", values, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDNuidNotIn(List<String> values) {
            addCriterion("d_nuid not in", values, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDNuidBetween(String value1, String value2) {
            addCriterion("d_nuid between", value1, value2, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDNuidNotBetween(String value1, String value2) {
            addCriterion("d_nuid not between", value1, value2, "dNuid");
            return (Criteria) this;
        }

        public Criteria andDInIsNull() {
            addCriterion("d_in is null");
            return (Criteria) this;
        }

        public Criteria andDInIsNotNull() {
            addCriterion("d_in is not null");
            return (Criteria) this;
        }

        public Criteria andDInEqualTo(String value) {
            addCriterion("d_in =", value, "dIn");
            return (Criteria) this;
        }

        public Criteria andDInNotEqualTo(String value) {
            addCriterion("d_in <>", value, "dIn");
            return (Criteria) this;
        }

        public Criteria andDInGreaterThan(String value) {
            addCriterion("d_in >", value, "dIn");
            return (Criteria) this;
        }

        public Criteria andDInGreaterThanOrEqualTo(String value) {
            addCriterion("d_in >=", value, "dIn");
            return (Criteria) this;
        }

        public Criteria andDInLessThan(String value) {
            addCriterion("d_in <", value, "dIn");
            return (Criteria) this;
        }

        public Criteria andDInLessThanOrEqualTo(String value) {
            addCriterion("d_in <=", value, "dIn");
            return (Criteria) this;
        }

        public Criteria andDInLike(String value) {
            addCriterion("d_in like", value, "dIn");
            return (Criteria) this;
        }

        public Criteria andDInNotLike(String value) {
            addCriterion("d_in not like", value, "dIn");
            return (Criteria) this;
        }

        public Criteria andDInIn(List<String> values) {
            addCriterion("d_in in", values, "dIn");
            return (Criteria) this;
        }

        public Criteria andDInNotIn(List<String> values) {
            addCriterion("d_in not in", values, "dIn");
            return (Criteria) this;
        }

        public Criteria andDInBetween(String value1, String value2) {
            addCriterion("d_in between", value1, value2, "dIn");
            return (Criteria) this;
        }

        public Criteria andDInNotBetween(String value1, String value2) {
            addCriterion("d_in not between", value1, value2, "dIn");
            return (Criteria) this;
        }

        public Criteria andDOutIsNull() {
            addCriterion("d_out is null");
            return (Criteria) this;
        }

        public Criteria andDOutIsNotNull() {
            addCriterion("d_out is not null");
            return (Criteria) this;
        }

        public Criteria andDOutEqualTo(String value) {
            addCriterion("d_out =", value, "dOut");
            return (Criteria) this;
        }

        public Criteria andDOutNotEqualTo(String value) {
            addCriterion("d_out <>", value, "dOut");
            return (Criteria) this;
        }

        public Criteria andDOutGreaterThan(String value) {
            addCriterion("d_out >", value, "dOut");
            return (Criteria) this;
        }

        public Criteria andDOutGreaterThanOrEqualTo(String value) {
            addCriterion("d_out >=", value, "dOut");
            return (Criteria) this;
        }

        public Criteria andDOutLessThan(String value) {
            addCriterion("d_out <", value, "dOut");
            return (Criteria) this;
        }

        public Criteria andDOutLessThanOrEqualTo(String value) {
            addCriterion("d_out <=", value, "dOut");
            return (Criteria) this;
        }

        public Criteria andDOutLike(String value) {
            addCriterion("d_out like", value, "dOut");
            return (Criteria) this;
        }

        public Criteria andDOutNotLike(String value) {
            addCriterion("d_out not like", value, "dOut");
            return (Criteria) this;
        }

        public Criteria andDOutIn(List<String> values) {
            addCriterion("d_out in", values, "dOut");
            return (Criteria) this;
        }

        public Criteria andDOutNotIn(List<String> values) {
            addCriterion("d_out not in", values, "dOut");
            return (Criteria) this;
        }

        public Criteria andDOutBetween(String value1, String value2) {
            addCriterion("d_out between", value1, value2, "dOut");
            return (Criteria) this;
        }

        public Criteria andDOutNotBetween(String value1, String value2) {
            addCriterion("d_out not between", value1, value2, "dOut");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Integer value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Integer value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Integer value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Integer value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Integer value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Integer> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Integer> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Integer value1, Integer value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Integer value1, Integer value2) {
            addCriterion("step not between", value1, value2, "step");
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