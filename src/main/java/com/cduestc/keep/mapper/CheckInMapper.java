package com.cduestc.keep.mapper;

import com.cduestc.keep.model.CheckIn;
import com.cduestc.keep.model.CheckInExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckInMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_in
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    long countByExample(CheckInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_in
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int deleteByExample(CheckInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_in
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int deleteByPrimaryKey(Long checkInid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_in
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int insert(CheckIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_in
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int insertSelective(CheckIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_in
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    List<CheckIn> selectByExample(CheckInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_in
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    CheckIn selectByPrimaryKey(Long checkInid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_in
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int updateByExampleSelective(@Param("record") CheckIn record, @Param("example") CheckInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_in
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int updateByExample(@Param("record") CheckIn record, @Param("example") CheckInExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_in
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int updateByPrimaryKeySelective(CheckIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_in
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int updateByPrimaryKey(CheckIn record);
}