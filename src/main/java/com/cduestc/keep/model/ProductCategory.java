package com.cduestc.keep.model;

public class ProductCategory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.parent_id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.create_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.modify_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.state
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Integer state;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.id
     *
     * @return the value of product_category.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.id
     *
     * @param id the value for product_category.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.parent_id
     *
     * @return the value of product_category.parent_id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.parent_id
     *
     * @param parentId the value for product_category.parent_id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.name
     *
     * @return the value of product_category.name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.name
     *
     * @param name the value for product_category.name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.create_date
     *
     * @return the value of product_category.create_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.create_date
     *
     * @param createDate the value for product_category.create_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.modify_date
     *
     * @return the value of product_category.modify_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.modify_date
     *
     * @param modifyDate the value for product_category.modify_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_category.state
     *
     * @return the value of product_category.state
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_category.state
     *
     * @param state the value for product_category.state
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setState(Integer state) {
        this.state = state;
    }
}