package com.cduestc.keep.model;

public class ProductOrder {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.payment
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Double payment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.payment_type
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Integer paymentType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.post_fee
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Double postFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.status
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.modify_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.payment_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long paymentDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.consign_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long consignDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.end_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long endDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.close_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long closeDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.shipping_name
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String shippingName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.shipping_code
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String shippingCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.user_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.buyer_message
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String buyerMessage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.buyer_nick
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String buyerNick;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.buyer_rate
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Integer buyerRate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.id
     *
     * @return the value of product_order.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.id
     *
     * @param id the value for product_order.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.payment
     *
     * @return the value of product_order.payment
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Double getPayment() {
        return payment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.payment
     *
     * @param payment the value for product_order.payment
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setPayment(Double payment) {
        this.payment = payment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.payment_type
     *
     * @return the value of product_order.payment_type
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.payment_type
     *
     * @param paymentType the value for product_order.payment_type
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.post_fee
     *
     * @return the value of product_order.post_fee
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Double getPostFee() {
        return postFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.post_fee
     *
     * @param postFee the value for product_order.post_fee
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setPostFee(Double postFee) {
        this.postFee = postFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.status
     *
     * @return the value of product_order.status
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.status
     *
     * @param status the value for product_order.status
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.create_date
     *
     * @return the value of product_order.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.create_date
     *
     * @param createDate the value for product_order.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.modify_date
     *
     * @return the value of product_order.modify_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.modify_date
     *
     * @param modifyDate the value for product_order.modify_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.payment_date
     *
     * @return the value of product_order.payment_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getPaymentDate() {
        return paymentDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.payment_date
     *
     * @param paymentDate the value for product_order.payment_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setPaymentDate(Long paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.consign_date
     *
     * @return the value of product_order.consign_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getConsignDate() {
        return consignDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.consign_date
     *
     * @param consignDate the value for product_order.consign_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setConsignDate(Long consignDate) {
        this.consignDate = consignDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.end_date
     *
     * @return the value of product_order.end_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.end_date
     *
     * @param endDate the value for product_order.end_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.close_date
     *
     * @return the value of product_order.close_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getCloseDate() {
        return closeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.close_date
     *
     * @param closeDate the value for product_order.close_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setCloseDate(Long closeDate) {
        this.closeDate = closeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.shipping_name
     *
     * @return the value of product_order.shipping_name
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getShippingName() {
        return shippingName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.shipping_name
     *
     * @param shippingName the value for product_order.shipping_name
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.shipping_code
     *
     * @return the value of product_order.shipping_code
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getShippingCode() {
        return shippingCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.shipping_code
     *
     * @param shippingCode the value for product_order.shipping_code
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.user_id
     *
     * @return the value of product_order.user_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.user_id
     *
     * @param userId the value for product_order.user_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.buyer_message
     *
     * @return the value of product_order.buyer_message
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getBuyerMessage() {
        return buyerMessage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.buyer_message
     *
     * @param buyerMessage the value for product_order.buyer_message
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage == null ? null : buyerMessage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.buyer_nick
     *
     * @return the value of product_order.buyer_nick
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getBuyerNick() {
        return buyerNick;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.buyer_nick
     *
     * @param buyerNick the value for product_order.buyer_nick
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick == null ? null : buyerNick.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.buyer_rate
     *
     * @return the value of product_order.buyer_rate
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Integer getBuyerRate() {
        return buyerRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.buyer_rate
     *
     * @param buyerRate the value for product_order.buyer_rate
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setBuyerRate(Integer buyerRate) {
        this.buyerRate = buyerRate;
    }
}