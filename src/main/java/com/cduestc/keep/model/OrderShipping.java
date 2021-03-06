package com.cduestc.keep.model;

public class OrderShipping {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.order_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.receiver_name
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String receiverName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.receiver_phone
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String receiverPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.receiver_mobile
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String receiverMobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.receiver_state
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String receiverState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.receiver_city
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String receiverCity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.receiver_district
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String receiverDistrict;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.receiver_address
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String receiverAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.receiver_zip
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String receiverZip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_shipping.modify_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long modifyDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.id
     *
     * @return the value of order_shipping.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.id
     *
     * @param id the value for order_shipping.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.order_id
     *
     * @return the value of order_shipping.order_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.order_id
     *
     * @param orderId the value for order_shipping.order_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.receiver_name
     *
     * @return the value of order_shipping.receiver_name
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.receiver_name
     *
     * @param receiverName the value for order_shipping.receiver_name
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.receiver_phone
     *
     * @return the value of order_shipping.receiver_phone
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.receiver_phone
     *
     * @param receiverPhone the value for order_shipping.receiver_phone
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.receiver_mobile
     *
     * @return the value of order_shipping.receiver_mobile
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.receiver_mobile
     *
     * @param receiverMobile the value for order_shipping.receiver_mobile
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.receiver_state
     *
     * @return the value of order_shipping.receiver_state
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getReceiverState() {
        return receiverState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.receiver_state
     *
     * @param receiverState the value for order_shipping.receiver_state
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState == null ? null : receiverState.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.receiver_city
     *
     * @return the value of order_shipping.receiver_city
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getReceiverCity() {
        return receiverCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.receiver_city
     *
     * @param receiverCity the value for order_shipping.receiver_city
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity == null ? null : receiverCity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.receiver_district
     *
     * @return the value of order_shipping.receiver_district
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.receiver_district
     *
     * @param receiverDistrict the value for order_shipping.receiver_district
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict == null ? null : receiverDistrict.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.receiver_address
     *
     * @return the value of order_shipping.receiver_address
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.receiver_address
     *
     * @param receiverAddress the value for order_shipping.receiver_address
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.receiver_zip
     *
     * @return the value of order_shipping.receiver_zip
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getReceiverZip() {
        return receiverZip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.receiver_zip
     *
     * @param receiverZip the value for order_shipping.receiver_zip
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip == null ? null : receiverZip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.create_date
     *
     * @return the value of order_shipping.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.create_date
     *
     * @param createDate the value for order_shipping.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_shipping.modify_date
     *
     * @return the value of order_shipping.modify_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_shipping.modify_date
     *
     * @param modifyDate the value for order_shipping.modify_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }
}