package com.cduestc.keep.model;

public class FriendCircle {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_circle.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_circle.owner_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long ownerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_circle.post_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long postId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_circle.is_own
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Integer isOwn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_circle.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_circle.post_OwnerId
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long postOwnerid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_circle.id
     *
     * @return the value of friend_circle.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_circle.id
     *
     * @param id the value for friend_circle.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_circle.owner_ID
     *
     * @return the value of friend_circle.owner_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_circle.owner_ID
     *
     * @param ownerId the value for friend_circle.owner_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_circle.post_ID
     *
     * @return the value of friend_circle.post_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_circle.post_ID
     *
     * @param postId the value for friend_circle.post_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_circle.is_own
     *
     * @return the value of friend_circle.is_own
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Integer getIsOwn() {
        return isOwn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_circle.is_own
     *
     * @param isOwn the value for friend_circle.is_own
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setIsOwn(Integer isOwn) {
        this.isOwn = isOwn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_circle.create_date
     *
     * @return the value of friend_circle.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_circle.create_date
     *
     * @param createDate the value for friend_circle.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_circle.post_OwnerId
     *
     * @return the value of friend_circle.post_OwnerId
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getPostOwnerid() {
        return postOwnerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_circle.post_OwnerId
     *
     * @param postOwnerid the value for friend_circle.post_OwnerId
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setPostOwnerid(Long postOwnerid) {
        this.postOwnerid = postOwnerid;
    }
}