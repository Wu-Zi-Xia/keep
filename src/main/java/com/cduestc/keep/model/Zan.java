package com.cduestc.keep.model;

public class Zan {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zan.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zan.owner_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long ownerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zan.zan_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String zanId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zan.id
     *
     * @return the value of zan.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zan.id
     *
     * @param id the value for zan.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zan.owner_ID
     *
     * @return the value of zan.owner_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zan.owner_ID
     *
     * @param ownerId the value for zan.owner_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zan.zan_id
     *
     * @return the value of zan.zan_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getZanId() {
        return zanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zan.zan_id
     *
     * @param zanId the value for zan.zan_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setZanId(String zanId) {
        this.zanId = zanId == null ? null : zanId.trim();
    }
}