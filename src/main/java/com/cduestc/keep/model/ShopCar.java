package com.cduestc.keep.model;

import java.util.Date;

public class ShopCar {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop_car.shop_carID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    private Long shopCarid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop_car.owner_ID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    private Long ownerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop_car.product_ID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    private Long productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop_car.create_date
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop_car.number
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    private Integer number;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop_car.shop_carID
     *
     * @return the value of shop_car.shop_carID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public Long getShopCarid() {
        return shopCarid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop_car.shop_carID
     *
     * @param shopCarid the value for shop_car.shop_carID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public void setShopCarid(Long shopCarid) {
        this.shopCarid = shopCarid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop_car.owner_ID
     *
     * @return the value of shop_car.owner_ID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop_car.owner_ID
     *
     * @param ownerId the value for shop_car.owner_ID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop_car.product_ID
     *
     * @return the value of shop_car.product_ID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop_car.product_ID
     *
     * @param productId the value for shop_car.product_ID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop_car.create_date
     *
     * @return the value of shop_car.create_date
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop_car.create_date
     *
     * @param createDate the value for shop_car.create_date
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop_car.number
     *
     * @return the value of shop_car.number
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop_car.number
     *
     * @param number the value for shop_car.number
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
}