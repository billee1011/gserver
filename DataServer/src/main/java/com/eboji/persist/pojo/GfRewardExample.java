package com.eboji.persist.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GfRewardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GfRewardExample() {
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

        public Criteria andRewardmoneyIsNull() {
            addCriterion("rewardmoney is null");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyIsNotNull() {
            addCriterion("rewardmoney is not null");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyEqualTo(BigDecimal value) {
            addCriterion("rewardmoney =", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyNotEqualTo(BigDecimal value) {
            addCriterion("rewardmoney <>", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyGreaterThan(BigDecimal value) {
            addCriterion("rewardmoney >", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rewardmoney >=", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyLessThan(BigDecimal value) {
            addCriterion("rewardmoney <", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rewardmoney <=", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyIn(List<BigDecimal> values) {
            addCriterion("rewardmoney in", values, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyNotIn(List<BigDecimal> values) {
            addCriterion("rewardmoney not in", values, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rewardmoney between", value1, value2, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rewardmoney not between", value1, value2, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxIsNull() {
            addCriterion("rewardmoneytax is null");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxIsNotNull() {
            addCriterion("rewardmoneytax is not null");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxEqualTo(BigDecimal value) {
            addCriterion("rewardmoneytax =", value, "rewardmoneytax");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxNotEqualTo(BigDecimal value) {
            addCriterion("rewardmoneytax <>", value, "rewardmoneytax");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxGreaterThan(BigDecimal value) {
            addCriterion("rewardmoneytax >", value, "rewardmoneytax");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rewardmoneytax >=", value, "rewardmoneytax");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxLessThan(BigDecimal value) {
            addCriterion("rewardmoneytax <", value, "rewardmoneytax");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rewardmoneytax <=", value, "rewardmoneytax");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxIn(List<BigDecimal> values) {
            addCriterion("rewardmoneytax in", values, "rewardmoneytax");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxNotIn(List<BigDecimal> values) {
            addCriterion("rewardmoneytax not in", values, "rewardmoneytax");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rewardmoneytax between", value1, value2, "rewardmoneytax");
            return (Criteria) this;
        }

        public Criteria andRewardmoneytaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rewardmoneytax not between", value1, value2, "rewardmoneytax");
            return (Criteria) this;
        }

        public Criteria andRewardcoinIsNull() {
            addCriterion("rewardcoin is null");
            return (Criteria) this;
        }

        public Criteria andRewardcoinIsNotNull() {
            addCriterion("rewardcoin is not null");
            return (Criteria) this;
        }

        public Criteria andRewardcoinEqualTo(Integer value) {
            addCriterion("rewardcoin =", value, "rewardcoin");
            return (Criteria) this;
        }

        public Criteria andRewardcoinNotEqualTo(Integer value) {
            addCriterion("rewardcoin <>", value, "rewardcoin");
            return (Criteria) this;
        }

        public Criteria andRewardcoinGreaterThan(Integer value) {
            addCriterion("rewardcoin >", value, "rewardcoin");
            return (Criteria) this;
        }

        public Criteria andRewardcoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("rewardcoin >=", value, "rewardcoin");
            return (Criteria) this;
        }

        public Criteria andRewardcoinLessThan(Integer value) {
            addCriterion("rewardcoin <", value, "rewardcoin");
            return (Criteria) this;
        }

        public Criteria andRewardcoinLessThanOrEqualTo(Integer value) {
            addCriterion("rewardcoin <=", value, "rewardcoin");
            return (Criteria) this;
        }

        public Criteria andRewardcoinIn(List<Integer> values) {
            addCriterion("rewardcoin in", values, "rewardcoin");
            return (Criteria) this;
        }

        public Criteria andRewardcoinNotIn(List<Integer> values) {
            addCriterion("rewardcoin not in", values, "rewardcoin");
            return (Criteria) this;
        }

        public Criteria andRewardcoinBetween(Integer value1, Integer value2) {
            addCriterion("rewardcoin between", value1, value2, "rewardcoin");
            return (Criteria) this;
        }

        public Criteria andRewardcoinNotBetween(Integer value1, Integer value2) {
            addCriterion("rewardcoin not between", value1, value2, "rewardcoin");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxIsNull() {
            addCriterion("rewardcointax is null");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxIsNotNull() {
            addCriterion("rewardcointax is not null");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxEqualTo(Integer value) {
            addCriterion("rewardcointax =", value, "rewardcointax");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxNotEqualTo(Integer value) {
            addCriterion("rewardcointax <>", value, "rewardcointax");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxGreaterThan(Integer value) {
            addCriterion("rewardcointax >", value, "rewardcointax");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("rewardcointax >=", value, "rewardcointax");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxLessThan(Integer value) {
            addCriterion("rewardcointax <", value, "rewardcointax");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxLessThanOrEqualTo(Integer value) {
            addCriterion("rewardcointax <=", value, "rewardcointax");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxIn(List<Integer> values) {
            addCriterion("rewardcointax in", values, "rewardcointax");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxNotIn(List<Integer> values) {
            addCriterion("rewardcointax not in", values, "rewardcointax");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxBetween(Integer value1, Integer value2) {
            addCriterion("rewardcointax between", value1, value2, "rewardcointax");
            return (Criteria) this;
        }

        public Criteria andRewardcointaxNotBetween(Integer value1, Integer value2) {
            addCriterion("rewardcointax not between", value1, value2, "rewardcointax");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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