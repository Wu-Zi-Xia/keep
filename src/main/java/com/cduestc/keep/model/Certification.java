package com.cduestc.keep.model;

public class Certification {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column certification.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column certification.qualification_type
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    private String qualificationType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column certification.id
     *
     * @return the value of certification.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column certification.id
     *
     * @param id the value for certification.id
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column certification.qualification_type
     *
     * @return the value of certification.qualification_type
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public String getQualificationType() {
        return qualificationType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column certification.qualification_type
     *
     * @param qualificationType the value for certification.qualification_type
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType == null ? null : qualificationType.trim();
    }
}