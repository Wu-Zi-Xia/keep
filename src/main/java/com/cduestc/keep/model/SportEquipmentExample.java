package com.cduestc.keep.model;

import java.util.ArrayList;
import java.util.List;

public class SportEquipmentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    public SportEquipmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
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
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
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

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_ID is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(Long value) {
            addCriterion("equipment_ID =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(Long value) {
            addCriterion("equipment_ID <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(Long value) {
            addCriterion("equipment_ID >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("equipment_ID >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(Long value) {
            addCriterion("equipment_ID <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(Long value) {
            addCriterion("equipment_ID <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<Long> values) {
            addCriterion("equipment_ID in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<Long> values) {
            addCriterion("equipment_ID not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(Long value1, Long value2) {
            addCriterion("equipment_ID between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(Long value1, Long value2) {
            addCriterion("equipment_ID not between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNull() {
            addCriterion("equipment_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNotNull() {
            addCriterion("equipment_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameEqualTo(String value) {
            addCriterion("equipment_name =", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotEqualTo(String value) {
            addCriterion("equipment_name <>", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThan(String value) {
            addCriterion("equipment_name >", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_name >=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThan(String value) {
            addCriterion("equipment_name <", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThanOrEqualTo(String value) {
            addCriterion("equipment_name <=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLike(String value) {
            addCriterion("equipment_name like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotLike(String value) {
            addCriterion("equipment_name not like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIn(List<String> values) {
            addCriterion("equipment_name in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotIn(List<String> values) {
            addCriterion("equipment_name not in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameBetween(String value1, String value2) {
            addCriterion("equipment_name between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotBetween(String value1, String value2) {
            addCriterion("equipment_name not between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagIsNull() {
            addCriterion("equipment_tag is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagIsNotNull() {
            addCriterion("equipment_tag is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagEqualTo(String value) {
            addCriterion("equipment_tag =", value, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagNotEqualTo(String value) {
            addCriterion("equipment_tag <>", value, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagGreaterThan(String value) {
            addCriterion("equipment_tag >", value, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_tag >=", value, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagLessThan(String value) {
            addCriterion("equipment_tag <", value, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagLessThanOrEqualTo(String value) {
            addCriterion("equipment_tag <=", value, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagLike(String value) {
            addCriterion("equipment_tag like", value, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagNotLike(String value) {
            addCriterion("equipment_tag not like", value, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagIn(List<String> values) {
            addCriterion("equipment_tag in", values, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagNotIn(List<String> values) {
            addCriterion("equipment_tag not in", values, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagBetween(String value1, String value2) {
            addCriterion("equipment_tag between", value1, value2, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andEquipmentTagNotBetween(String value1, String value2) {
            addCriterion("equipment_tag not between", value1, value2, "equipmentTag");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andStorageIsNull() {
            addCriterion("`storage` is null");
            return (Criteria) this;
        }

        public Criteria andStorageIsNotNull() {
            addCriterion("`storage` is not null");
            return (Criteria) this;
        }

        public Criteria andStorageEqualTo(Integer value) {
            addCriterion("`storage` =", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageNotEqualTo(Integer value) {
            addCriterion("`storage` <>", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageGreaterThan(Integer value) {
            addCriterion("`storage` >", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageGreaterThanOrEqualTo(Integer value) {
            addCriterion("`storage` >=", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageLessThan(Integer value) {
            addCriterion("`storage` <", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageLessThanOrEqualTo(Integer value) {
            addCriterion("`storage` <=", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageIn(List<Integer> values) {
            addCriterion("`storage` in", values, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageNotIn(List<Integer> values) {
            addCriterion("`storage` not in", values, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageBetween(Integer value1, Integer value2) {
            addCriterion("`storage` between", value1, value2, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageNotBetween(Integer value1, Integer value2) {
            addCriterion("`storage` not between", value1, value2, "storage");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sports_equipment
     *
     * @mbg.generated do_not_delete_during_merge Sun Apr 19 02:58:57 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sports_equipment
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
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