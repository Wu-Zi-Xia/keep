package com.cduestc.keep.model;

import java.util.ArrayList;
import java.util.List;

public class SportsHistoryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public SportsHistoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
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

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(Long value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(Long value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(Long value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(Long value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(Long value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<Long> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<Long> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(Long value1, Long value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(Long value1, Long value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andSportsIdIsNull() {
            addCriterion("sports_id is null");
            return (Criteria) this;
        }

        public Criteria andSportsIdIsNotNull() {
            addCriterion("sports_id is not null");
            return (Criteria) this;
        }

        public Criteria andSportsIdEqualTo(Long value) {
            addCriterion("sports_id =", value, "sportsId");
            return (Criteria) this;
        }

        public Criteria andSportsIdNotEqualTo(Long value) {
            addCriterion("sports_id <>", value, "sportsId");
            return (Criteria) this;
        }

        public Criteria andSportsIdGreaterThan(Long value) {
            addCriterion("sports_id >", value, "sportsId");
            return (Criteria) this;
        }

        public Criteria andSportsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sports_id >=", value, "sportsId");
            return (Criteria) this;
        }

        public Criteria andSportsIdLessThan(Long value) {
            addCriterion("sports_id <", value, "sportsId");
            return (Criteria) this;
        }

        public Criteria andSportsIdLessThanOrEqualTo(Long value) {
            addCriterion("sports_id <=", value, "sportsId");
            return (Criteria) this;
        }

        public Criteria andSportsIdIn(List<Long> values) {
            addCriterion("sports_id in", values, "sportsId");
            return (Criteria) this;
        }

        public Criteria andSportsIdNotIn(List<Long> values) {
            addCriterion("sports_id not in", values, "sportsId");
            return (Criteria) this;
        }

        public Criteria andSportsIdBetween(Long value1, Long value2) {
            addCriterion("sports_id between", value1, value2, "sportsId");
            return (Criteria) this;
        }

        public Criteria andSportsIdNotBetween(Long value1, Long value2) {
            addCriterion("sports_id not between", value1, value2, "sportsId");
            return (Criteria) this;
        }

        public Criteria andFinishDateIsNull() {
            addCriterion("finish_date is null");
            return (Criteria) this;
        }

        public Criteria andFinishDateIsNotNull() {
            addCriterion("finish_date is not null");
            return (Criteria) this;
        }

        public Criteria andFinishDateEqualTo(Long value) {
            addCriterion("finish_date =", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotEqualTo(Long value) {
            addCriterion("finish_date <>", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateGreaterThan(Long value) {
            addCriterion("finish_date >", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateGreaterThanOrEqualTo(Long value) {
            addCriterion("finish_date >=", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateLessThan(Long value) {
            addCriterion("finish_date <", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateLessThanOrEqualTo(Long value) {
            addCriterion("finish_date <=", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateIn(List<Long> values) {
            addCriterion("finish_date in", values, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotIn(List<Long> values) {
            addCriterion("finish_date not in", values, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateBetween(Long value1, Long value2) {
            addCriterion("finish_date between", value1, value2, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotBetween(Long value1, Long value2) {
            addCriterion("finish_date not between", value1, value2, "finishDate");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCalorieIsNull() {
            addCriterion("calorie is null");
            return (Criteria) this;
        }

        public Criteria andCalorieIsNotNull() {
            addCriterion("calorie is not null");
            return (Criteria) this;
        }

        public Criteria andCalorieEqualTo(Integer value) {
            addCriterion("calorie =", value, "calorie");
            return (Criteria) this;
        }

        public Criteria andCalorieNotEqualTo(Integer value) {
            addCriterion("calorie <>", value, "calorie");
            return (Criteria) this;
        }

        public Criteria andCalorieGreaterThan(Integer value) {
            addCriterion("calorie >", value, "calorie");
            return (Criteria) this;
        }

        public Criteria andCalorieGreaterThanOrEqualTo(Integer value) {
            addCriterion("calorie >=", value, "calorie");
            return (Criteria) this;
        }

        public Criteria andCalorieLessThan(Integer value) {
            addCriterion("calorie <", value, "calorie");
            return (Criteria) this;
        }

        public Criteria andCalorieLessThanOrEqualTo(Integer value) {
            addCriterion("calorie <=", value, "calorie");
            return (Criteria) this;
        }

        public Criteria andCalorieIn(List<Integer> values) {
            addCriterion("calorie in", values, "calorie");
            return (Criteria) this;
        }

        public Criteria andCalorieNotIn(List<Integer> values) {
            addCriterion("calorie not in", values, "calorie");
            return (Criteria) this;
        }

        public Criteria andCalorieBetween(Integer value1, Integer value2) {
            addCriterion("calorie between", value1, value2, "calorie");
            return (Criteria) this;
        }

        public Criteria andCalorieNotBetween(Integer value1, Integer value2) {
            addCriterion("calorie not between", value1, value2, "calorie");
            return (Criteria) this;
        }

        public Criteria andSportsTimeIsNull() {
            addCriterion("sports_time is null");
            return (Criteria) this;
        }

        public Criteria andSportsTimeIsNotNull() {
            addCriterion("sports_time is not null");
            return (Criteria) this;
        }

        public Criteria andSportsTimeEqualTo(Integer value) {
            addCriterion("sports_time =", value, "sportsTime");
            return (Criteria) this;
        }

        public Criteria andSportsTimeNotEqualTo(Integer value) {
            addCriterion("sports_time <>", value, "sportsTime");
            return (Criteria) this;
        }

        public Criteria andSportsTimeGreaterThan(Integer value) {
            addCriterion("sports_time >", value, "sportsTime");
            return (Criteria) this;
        }

        public Criteria andSportsTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sports_time >=", value, "sportsTime");
            return (Criteria) this;
        }

        public Criteria andSportsTimeLessThan(Integer value) {
            addCriterion("sports_time <", value, "sportsTime");
            return (Criteria) this;
        }

        public Criteria andSportsTimeLessThanOrEqualTo(Integer value) {
            addCriterion("sports_time <=", value, "sportsTime");
            return (Criteria) this;
        }

        public Criteria andSportsTimeIn(List<Integer> values) {
            addCriterion("sports_time in", values, "sportsTime");
            return (Criteria) this;
        }

        public Criteria andSportsTimeNotIn(List<Integer> values) {
            addCriterion("sports_time not in", values, "sportsTime");
            return (Criteria) this;
        }

        public Criteria andSportsTimeBetween(Integer value1, Integer value2) {
            addCriterion("sports_time between", value1, value2, "sportsTime");
            return (Criteria) this;
        }

        public Criteria andSportsTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("sports_time not between", value1, value2, "sportsTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sports_history
     *
     * @mbg.generated do_not_delete_during_merge Tue May 05 02:20:27 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sports_history
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
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