package com.cduestc.keep.model;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_comment.comment_ID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private Long commentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_comment.owner_ID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private Long ownerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_comment.content
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_comment.type
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_comment.create_date
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private Long createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_comment.review_id
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private Long reviewId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_comment.comment_ID
     *
     * @return the value of keep_comment.comment_ID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_comment.comment_ID
     *
     * @param commentId the value for keep_comment.comment_ID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_comment.owner_ID
     *
     * @return the value of keep_comment.owner_ID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_comment.owner_ID
     *
     * @param ownerId the value for keep_comment.owner_ID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_comment.content
     *
     * @return the value of keep_comment.content
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_comment.content
     *
     * @param content the value for keep_comment.content
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_comment.type
     *
     * @return the value of keep_comment.type
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_comment.type
     *
     * @param type the value for keep_comment.type
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_comment.create_date
     *
     * @return the value of keep_comment.create_date
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_comment.create_date
     *
     * @param createDate the value for keep_comment.create_date
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_comment.review_id
     *
     * @return the value of keep_comment.review_id
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public Long getReviewId() {
        return reviewId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_comment.review_id
     *
     * @param reviewId the value for keep_comment.review_id
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
}