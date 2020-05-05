package com.cduestc.keep.model;

public class SportLife {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_life.product_ID
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_life.product_name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String productName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_life.image_url
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String imageUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_life.brand
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String brand;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_life.price
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_life.description
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_life.storage
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Integer storage;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_life.product_ID
     *
     * @return the value of sports_life.product_ID
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_life.product_ID
     *
     * @param productId the value for sports_life.product_ID
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_life.product_name
     *
     * @return the value of sports_life.product_name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_life.product_name
     *
     * @param productName the value for sports_life.product_name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_life.image_url
     *
     * @return the value of sports_life.image_url
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_life.image_url
     *
     * @param imageUrl the value for sports_life.image_url
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_life.brand
     *
     * @return the value of sports_life.brand
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getBrand() {
        return brand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_life.brand
     *
     * @param brand the value for sports_life.brand
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_life.price
     *
     * @return the value of sports_life.price
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_life.price
     *
     * @param price the value for sports_life.price
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_life.description
     *
     * @return the value of sports_life.description
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_life.description
     *
     * @param description the value for sports_life.description
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_life.storage
     *
     * @return the value of sports_life.storage
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Integer getStorage() {
        return storage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_life.storage
     *
     * @param storage the value for sports_life.storage
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setStorage(Integer storage) {
        this.storage = storage;
    }
}