package com.cduestc.keep.model;

public class BellySports {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column belly_sports.sports_id
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private Long sportsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column belly_sports.sports_name
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private String sportsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column belly_sports.weight
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private Integer weight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column belly_sports.resource_URL
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private String resourceUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column belly_sports.calorie
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private Integer calorie;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column belly_sports.sports_id
     *
     * @return the value of belly_sports.sports_id
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public Long getSportsId() {
        return sportsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column belly_sports.sports_id
     *
     * @param sportsId the value for belly_sports.sports_id
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setSportsId(Long sportsId) {
        this.sportsId = sportsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column belly_sports.sports_name
     *
     * @return the value of belly_sports.sports_name
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public String getSportsName() {
        return sportsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column belly_sports.sports_name
     *
     * @param sportsName the value for belly_sports.sports_name
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setSportsName(String sportsName) {
        this.sportsName = sportsName == null ? null : sportsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column belly_sports.weight
     *
     * @return the value of belly_sports.weight
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column belly_sports.weight
     *
     * @param weight the value for belly_sports.weight
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column belly_sports.resource_URL
     *
     * @return the value of belly_sports.resource_URL
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column belly_sports.resource_URL
     *
     * @param resourceUrl the value for belly_sports.resource_URL
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column belly_sports.calorie
     *
     * @return the value of belly_sports.calorie
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public Integer getCalorie() {
        return calorie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column belly_sports.calorie
     *
     * @param calorie the value for belly_sports.calorie
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }
}