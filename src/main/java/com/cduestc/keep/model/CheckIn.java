package com.cduestc.keep.model;

public class CheckIn {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.check_inID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    private Long checkInid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.owner_ID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    private Long ownerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.month
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    private String month;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.results
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    private String results;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_in.continue_sign
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    private Integer continueSign;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.check_inID
     *
     * @return the value of check_in.check_inID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public Long getCheckInid() {
        return checkInid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.check_inID
     *
     * @param checkInid the value for check_in.check_inID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public void setCheckInid(Long checkInid) {
        this.checkInid = checkInid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.owner_ID
     *
     * @return the value of check_in.owner_ID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.owner_ID
     *
     * @param ownerId the value for check_in.owner_ID
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.month
     *
     * @return the value of check_in.month
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public String getMonth() {
        return month;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.month
     *
     * @param month the value for check_in.month
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.results
     *
     * @return the value of check_in.results
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public String getResults() {
        return results;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.results
     *
     * @param results the value for check_in.results
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public void setResults(String results) {
        this.results = results == null ? null : results.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_in.continue_sign
     *
     * @return the value of check_in.continue_sign
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public Integer getContinueSign() {
        return continueSign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_in.continue_sign
     *
     * @param continueSign the value for check_in.continue_sign
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    public void setContinueSign(Integer continueSign) {
        this.continueSign = continueSign;
    }
}