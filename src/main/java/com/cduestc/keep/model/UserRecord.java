package com.cduestc.keep.model;

public class UserRecord {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_record.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_record.owner_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long ownerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_record.product_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long productId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_record.id
     *
     * @return the value of user_record.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_record.id
     *
     * @param id the value for user_record.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_record.owner_id
     *
     * @return the value of user_record.owner_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_record.owner_id
     *
     * @param ownerId the value for user_record.owner_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_record.product_id
     *
     * @return the value of user_record.product_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_record.product_id
     *
     * @param productId the value for user_record.product_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }
}