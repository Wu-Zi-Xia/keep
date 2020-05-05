package com.cduestc.keep.model;

public class Product {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.category_id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.public_attribute
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String publicAttribute;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.attribute_list
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String attributeList;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.create_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.modify_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.description
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.urls
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String urls;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.price
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String price;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.id
     *
     * @return the value of product.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.id
     *
     * @param id the value for product.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.category_id
     *
     * @return the value of product.category_id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.category_id
     *
     * @param categoryId the value for product.category_id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.public_attribute
     *
     * @return the value of product.public_attribute
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getPublicAttribute() {
        return publicAttribute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.public_attribute
     *
     * @param publicAttribute the value for product.public_attribute
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setPublicAttribute(String publicAttribute) {
        this.publicAttribute = publicAttribute == null ? null : publicAttribute.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.attribute_list
     *
     * @return the value of product.attribute_list
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getAttributeList() {
        return attributeList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.attribute_list
     *
     * @param attributeList the value for product.attribute_list
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setAttributeList(String attributeList) {
        this.attributeList = attributeList == null ? null : attributeList.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.create_date
     *
     * @return the value of product.create_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.create_date
     *
     * @param createDate the value for product.create_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.modify_date
     *
     * @return the value of product.modify_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.modify_date
     *
     * @param modifyDate the value for product.modify_date
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.name
     *
     * @return the value of product.name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.name
     *
     * @param name the value for product.name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.description
     *
     * @return the value of product.description
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.description
     *
     * @param description the value for product.description
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.urls
     *
     * @return the value of product.urls
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getUrls() {
        return urls;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.urls
     *
     * @param urls the value for product.urls
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setUrls(String urls) {
        this.urls = urls == null ? null : urls.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.price
     *
     * @return the value of product.price
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.price
     *
     * @param price the value for product.price
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }
}