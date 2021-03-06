package com.cduestc.keep.model;

public class Post {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_post.post_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long postId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_post.owner_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long ownerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_post.image_url
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String imageUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_post.video_url
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String videoUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_post.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_post.description
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_post.like_count
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_post.comment_count
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Integer commentCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_post.post_ID
     *
     * @return the value of keep_post.post_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_post.post_ID
     *
     * @param postId the value for keep_post.post_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_post.owner_ID
     *
     * @return the value of keep_post.owner_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_post.owner_ID
     *
     * @param ownerId the value for keep_post.owner_ID
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_post.image_url
     *
     * @return the value of keep_post.image_url
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_post.image_url
     *
     * @param imageUrl the value for keep_post.image_url
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_post.video_url
     *
     * @return the value of keep_post.video_url
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_post.video_url
     *
     * @param videoUrl the value for keep_post.video_url
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_post.create_date
     *
     * @return the value of keep_post.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_post.create_date
     *
     * @param createDate the value for keep_post.create_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_post.description
     *
     * @return the value of keep_post.description
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_post.description
     *
     * @param description the value for keep_post.description
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_post.like_count
     *
     * @return the value of keep_post.like_count
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_post.like_count
     *
     * @param likeCount the value for keep_post.like_count
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_post.comment_count
     *
     * @return the value of keep_post.comment_count
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_post.comment_count
     *
     * @param commentCount the value for keep_post.comment_count
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}