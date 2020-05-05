package com.cduestc.keep.provider;

import lombok.Data;

@Data
public class Sports {
    private Long sportsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column arm_sports.sports_name
     *
     * @mbg.generated Thu Mar 26 17:15:33 CST 2020
     */
    private String sportsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column arm_sports.weight
     *
     * @mbg.generated Thu Mar 26 17:15:33 CST 2020
     */
    private Integer weight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column arm_sports.resource_URL
     *
     * @mbg.generated Thu Mar 26 17:15:33 CST 2020
     */
    private String resourceUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column arm_sports.calorie
     *
     * @mbg.generated Thu Mar 26 17:15:33 CST 2020
     */
    private Integer calorie;
}