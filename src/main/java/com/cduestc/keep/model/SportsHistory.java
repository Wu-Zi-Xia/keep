package com.cduestc.keep.model;

public class SportsHistory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_history.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_history.owner_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long ownerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_history.sports_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long sportsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_history.finish_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long finishDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_history.type
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_history.calorie
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Integer calorie;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sports_history.sports_time
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Integer sportsTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_history.id
     *
     * @return the value of sports_history.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_history.id
     *
     * @param id the value for sports_history.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_history.owner_id
     *
     * @return the value of sports_history.owner_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_history.owner_id
     *
     * @param ownerId the value for sports_history.owner_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_history.sports_id
     *
     * @return the value of sports_history.sports_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getSportsId() {
        return sportsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_history.sports_id
     *
     * @param sportsId the value for sports_history.sports_id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setSportsId(Long sportsId) {
        this.sportsId = sportsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_history.finish_date
     *
     * @return the value of sports_history.finish_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getFinishDate() {
        return finishDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_history.finish_date
     *
     * @param finishDate the value for sports_history.finish_date
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setFinishDate(Long finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_history.type
     *
     * @return the value of sports_history.type
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_history.type
     *
     * @param type the value for sports_history.type
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_history.calorie
     *
     * @return the value of sports_history.calorie
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Integer getCalorie() {
        return calorie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_history.calorie
     *
     * @param calorie the value for sports_history.calorie
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sports_history.sports_time
     *
     * @return the value of sports_history.sports_time
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Integer getSportsTime() {
        return sportsTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sports_history.sports_time
     *
     * @param sportsTime the value for sports_history.sports_time
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setSportsTime(Integer sportsTime) {
        this.sportsTime = sportsTime;
    }
}