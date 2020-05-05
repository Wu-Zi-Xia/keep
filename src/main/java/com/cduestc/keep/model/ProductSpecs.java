package com.cduestc.keep.model;

public class ProductSpecs {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_specs.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_specs.product_id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_specs.product_specs
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String productSpecs;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_specs.product_stock
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Integer productStock;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_specs.product_price
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Double productPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_specs.status
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_specs.URL
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String url;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_specs.id
     *
     * @return the value of product_specs.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_specs.id
     *
     * @param id the value for product_specs.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_specs.product_id
     *
     * @return the value of product_specs.product_id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_specs.product_id
     *
     * @param productId the value for product_specs.product_id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_specs.product_specs
     *
     * @return the value of product_specs.product_specs
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getProductSpecs() {
        return productSpecs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_specs.product_specs
     *
     * @param productSpecs the value for product_specs.product_specs
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setProductSpecs(String productSpecs) {
        this.productSpecs = productSpecs == null ? null : productSpecs.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_specs.product_stock
     *
     * @return the value of product_specs.product_stock
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Integer getProductStock() {
        return productStock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_specs.product_stock
     *
     * @param productStock the value for product_specs.product_stock
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_specs.product_price
     *
     * @return the value of product_specs.product_price
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Double getProductPrice() {
        return productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_specs.product_price
     *
     * @param productPrice the value for product_specs.product_price
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_specs.status
     *
     * @return the value of product_specs.status
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_specs.status
     *
     * @param status the value for product_specs.status
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_specs.URL
     *
     * @return the value of product_specs.URL
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_specs.URL
     *
     * @param url the value for product_specs.URL
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}