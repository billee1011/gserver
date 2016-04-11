package com.eboji.persist.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GgHistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GgHistExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNull() {
            addCriterion("roomid is null");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNotNull() {
            addCriterion("roomid is not null");
            return (Criteria) this;
        }

        public Criteria andRoomidEqualTo(Long value) {
            addCriterion("roomid =", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotEqualTo(Long value) {
            addCriterion("roomid <>", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThan(Long value) {
            addCriterion("roomid >", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThanOrEqualTo(Long value) {
            addCriterion("roomid >=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThan(Long value) {
            addCriterion("roomid <", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThanOrEqualTo(Long value) {
            addCriterion("roomid <=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidIn(List<Long> values) {
            addCriterion("roomid in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotIn(List<Long> values) {
            addCriterion("roomid not in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidBetween(Long value1, Long value2) {
            addCriterion("roomid between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotBetween(Long value1, Long value2) {
            addCriterion("roomid not between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andPlayeridIsNull() {
            addCriterion("playerid is null");
            return (Criteria) this;
        }

        public Criteria andPlayeridIsNotNull() {
            addCriterion("playerid is not null");
            return (Criteria) this;
        }

        public Criteria andPlayeridEqualTo(Integer value) {
            addCriterion("playerid =", value, "playerid");
            return (Criteria) this;
        }

        public Criteria andPlayeridNotEqualTo(Integer value) {
            addCriterion("playerid <>", value, "playerid");
            return (Criteria) this;
        }

        public Criteria andPlayeridGreaterThan(Integer value) {
            addCriterion("playerid >", value, "playerid");
            return (Criteria) this;
        }

        public Criteria andPlayeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("playerid >=", value, "playerid");
            return (Criteria) this;
        }

        public Criteria andPlayeridLessThan(Integer value) {
            addCriterion("playerid <", value, "playerid");
            return (Criteria) this;
        }

        public Criteria andPlayeridLessThanOrEqualTo(Integer value) {
            addCriterion("playerid <=", value, "playerid");
            return (Criteria) this;
        }

        public Criteria andPlayeridIn(List<Integer> values) {
            addCriterion("playerid in", values, "playerid");
            return (Criteria) this;
        }

        public Criteria andPlayeridNotIn(List<Integer> values) {
            addCriterion("playerid not in", values, "playerid");
            return (Criteria) this;
        }

        public Criteria andPlayeridBetween(Integer value1, Integer value2) {
            addCriterion("playerid between", value1, value2, "playerid");
            return (Criteria) this;
        }

        public Criteria andPlayeridNotBetween(Integer value1, Integer value2) {
            addCriterion("playerid not between", value1, value2, "playerid");
            return (Criteria) this;
        }

        public Criteria andOptypeIsNull() {
            addCriterion("optype is null");
            return (Criteria) this;
        }

        public Criteria andOptypeIsNotNull() {
            addCriterion("optype is not null");
            return (Criteria) this;
        }

        public Criteria andOptypeEqualTo(Integer value) {
            addCriterion("optype =", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeNotEqualTo(Integer value) {
            addCriterion("optype <>", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeGreaterThan(Integer value) {
            addCriterion("optype >", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("optype >=", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeLessThan(Integer value) {
            addCriterion("optype <", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeLessThanOrEqualTo(Integer value) {
            addCriterion("optype <=", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeIn(List<Integer> values) {
            addCriterion("optype in", values, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeNotIn(List<Integer> values) {
            addCriterion("optype not in", values, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeBetween(Integer value1, Integer value2) {
            addCriterion("optype between", value1, value2, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeNotBetween(Integer value1, Integer value2) {
            addCriterion("optype not between", value1, value2, "optype");
            return (Criteria) this;
        }

        public Criteria andOpcardIsNull() {
            addCriterion("opcard is null");
            return (Criteria) this;
        }

        public Criteria andOpcardIsNotNull() {
            addCriterion("opcard is not null");
            return (Criteria) this;
        }

        public Criteria andOpcardEqualTo(String value) {
            addCriterion("opcard =", value, "opcard");
            return (Criteria) this;
        }

        public Criteria andOpcardNotEqualTo(String value) {
            addCriterion("opcard <>", value, "opcard");
            return (Criteria) this;
        }

        public Criteria andOpcardGreaterThan(String value) {
            addCriterion("opcard >", value, "opcard");
            return (Criteria) this;
        }

        public Criteria andOpcardGreaterThanOrEqualTo(String value) {
            addCriterion("opcard >=", value, "opcard");
            return (Criteria) this;
        }

        public Criteria andOpcardLessThan(String value) {
            addCriterion("opcard <", value, "opcard");
            return (Criteria) this;
        }

        public Criteria andOpcardLessThanOrEqualTo(String value) {
            addCriterion("opcard <=", value, "opcard");
            return (Criteria) this;
        }

        public Criteria andOpcardLike(String value) {
            addCriterion("opcard like", value, "opcard");
            return (Criteria) this;
        }

        public Criteria andOpcardNotLike(String value) {
            addCriterion("opcard not like", value, "opcard");
            return (Criteria) this;
        }

        public Criteria andOpcardIn(List<String> values) {
            addCriterion("opcard in", values, "opcard");
            return (Criteria) this;
        }

        public Criteria andOpcardNotIn(List<String> values) {
            addCriterion("opcard not in", values, "opcard");
            return (Criteria) this;
        }

        public Criteria andOpcardBetween(String value1, String value2) {
            addCriterion("opcard between", value1, value2, "opcard");
            return (Criteria) this;
        }

        public Criteria andOpcardNotBetween(String value1, String value2) {
            addCriterion("opcard not between", value1, value2, "opcard");
            return (Criteria) this;
        }

        public Criteria andIncardIsNull() {
            addCriterion("incard is null");
            return (Criteria) this;
        }

        public Criteria andIncardIsNotNull() {
            addCriterion("incard is not null");
            return (Criteria) this;
        }

        public Criteria andIncardEqualTo(String value) {
            addCriterion("incard =", value, "incard");
            return (Criteria) this;
        }

        public Criteria andIncardNotEqualTo(String value) {
            addCriterion("incard <>", value, "incard");
            return (Criteria) this;
        }

        public Criteria andIncardGreaterThan(String value) {
            addCriterion("incard >", value, "incard");
            return (Criteria) this;
        }

        public Criteria andIncardGreaterThanOrEqualTo(String value) {
            addCriterion("incard >=", value, "incard");
            return (Criteria) this;
        }

        public Criteria andIncardLessThan(String value) {
            addCriterion("incard <", value, "incard");
            return (Criteria) this;
        }

        public Criteria andIncardLessThanOrEqualTo(String value) {
            addCriterion("incard <=", value, "incard");
            return (Criteria) this;
        }

        public Criteria andIncardLike(String value) {
            addCriterion("incard like", value, "incard");
            return (Criteria) this;
        }

        public Criteria andIncardNotLike(String value) {
            addCriterion("incard not like", value, "incard");
            return (Criteria) this;
        }

        public Criteria andIncardIn(List<String> values) {
            addCriterion("incard in", values, "incard");
            return (Criteria) this;
        }

        public Criteria andIncardNotIn(List<String> values) {
            addCriterion("incard not in", values, "incard");
            return (Criteria) this;
        }

        public Criteria andIncardBetween(String value1, String value2) {
            addCriterion("incard between", value1, value2, "incard");
            return (Criteria) this;
        }

        public Criteria andIncardNotBetween(String value1, String value2) {
            addCriterion("incard not between", value1, value2, "incard");
            return (Criteria) this;
        }

        public Criteria andOutcardIsNull() {
            addCriterion("outcard is null");
            return (Criteria) this;
        }

        public Criteria andOutcardIsNotNull() {
            addCriterion("outcard is not null");
            return (Criteria) this;
        }

        public Criteria andOutcardEqualTo(String value) {
            addCriterion("outcard =", value, "outcard");
            return (Criteria) this;
        }

        public Criteria andOutcardNotEqualTo(String value) {
            addCriterion("outcard <>", value, "outcard");
            return (Criteria) this;
        }

        public Criteria andOutcardGreaterThan(String value) {
            addCriterion("outcard >", value, "outcard");
            return (Criteria) this;
        }

        public Criteria andOutcardGreaterThanOrEqualTo(String value) {
            addCriterion("outcard >=", value, "outcard");
            return (Criteria) this;
        }

        public Criteria andOutcardLessThan(String value) {
            addCriterion("outcard <", value, "outcard");
            return (Criteria) this;
        }

        public Criteria andOutcardLessThanOrEqualTo(String value) {
            addCriterion("outcard <=", value, "outcard");
            return (Criteria) this;
        }

        public Criteria andOutcardLike(String value) {
            addCriterion("outcard like", value, "outcard");
            return (Criteria) this;
        }

        public Criteria andOutcardNotLike(String value) {
            addCriterion("outcard not like", value, "outcard");
            return (Criteria) this;
        }

        public Criteria andOutcardIn(List<String> values) {
            addCriterion("outcard in", values, "outcard");
            return (Criteria) this;
        }

        public Criteria andOutcardNotIn(List<String> values) {
            addCriterion("outcard not in", values, "outcard");
            return (Criteria) this;
        }

        public Criteria andOutcardBetween(String value1, String value2) {
            addCriterion("outcard between", value1, value2, "outcard");
            return (Criteria) this;
        }

        public Criteria andOutcardNotBetween(String value1, String value2) {
            addCriterion("outcard not between", value1, value2, "outcard");
            return (Criteria) this;
        }

        public Criteria andRoundIsNull() {
            addCriterion("round is null");
            return (Criteria) this;
        }

        public Criteria andRoundIsNotNull() {
            addCriterion("round is not null");
            return (Criteria) this;
        }

        public Criteria andRoundEqualTo(Integer value) {
            addCriterion("round =", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotEqualTo(Integer value) {
            addCriterion("round <>", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThan(Integer value) {
            addCriterion("round >", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThanOrEqualTo(Integer value) {
            addCriterion("round >=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThan(Integer value) {
            addCriterion("round <", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThanOrEqualTo(Integer value) {
            addCriterion("round <=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundIn(List<Integer> values) {
            addCriterion("round in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotIn(List<Integer> values) {
            addCriterion("round not in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundBetween(Integer value1, Integer value2) {
            addCriterion("round between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotBetween(Integer value1, Integer value2) {
            addCriterion("round not between", value1, value2, "round");
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