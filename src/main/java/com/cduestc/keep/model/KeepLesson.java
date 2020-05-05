package com.cduestc.keep.model;

public class KeepLesson {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_lesson.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_lesson.lesson_name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String lessonName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_lesson.image_url
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String imageUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_lesson.sports
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String sports;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_lesson.hot
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Integer hot;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_lesson.type
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_lesson.time
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Integer time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_lesson.calorie
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private Integer calorie;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_lesson.resource_url
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    private String resourceUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_lesson.id
     *
     * @return the value of keep_lesson.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_lesson.id
     *
     * @param id the value for keep_lesson.id
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_lesson.lesson_name
     *
     * @return the value of keep_lesson.lesson_name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getLessonName() {
        return lessonName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_lesson.lesson_name
     *
     * @param lessonName the value for keep_lesson.lesson_name
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setLessonName(String lessonName) {
        this.lessonName = lessonName == null ? null : lessonName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_lesson.image_url
     *
     * @return the value of keep_lesson.image_url
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_lesson.image_url
     *
     * @param imageUrl the value for keep_lesson.image_url
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_lesson.sports
     *
     * @return the value of keep_lesson.sports
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getSports() {
        return sports;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_lesson.sports
     *
     * @param sports the value for keep_lesson.sports
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setSports(String sports) {
        this.sports = sports == null ? null : sports.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_lesson.hot
     *
     * @return the value of keep_lesson.hot
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Integer getHot() {
        return hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_lesson.hot
     *
     * @param hot the value for keep_lesson.hot
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setHot(Integer hot) {
        this.hot = hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_lesson.type
     *
     * @return the value of keep_lesson.type
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_lesson.type
     *
     * @param type the value for keep_lesson.type
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_lesson.time
     *
     * @return the value of keep_lesson.time
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Integer getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_lesson.time
     *
     * @param time the value for keep_lesson.time
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_lesson.calorie
     *
     * @return the value of keep_lesson.calorie
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public Integer getCalorie() {
        return calorie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_lesson.calorie
     *
     * @param calorie the value for keep_lesson.calorie
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_lesson.resource_url
     *
     * @return the value of keep_lesson.resource_url
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_lesson.resource_url
     *
     * @param resourceUrl the value for keep_lesson.resource_url
     *
     * @mbg.generated Tue May 05 02:20:27 CST 2020
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }
}