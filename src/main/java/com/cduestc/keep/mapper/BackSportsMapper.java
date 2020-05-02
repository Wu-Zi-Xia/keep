package com.cduestc.keep.mapper;

import com.cduestc.keep.model.BackSports;
import com.cduestc.keep.model.BackSportsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BackSportsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table back_sports
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    long countByExample(BackSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table back_sports
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int deleteByExample(BackSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table back_sports
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int deleteByPrimaryKey(Long sportsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table back_sports
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int insert(BackSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table back_sports
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int insertSelective(BackSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table back_sports
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    List<BackSports> selectByExample(BackSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table back_sports
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    BackSports selectByPrimaryKey(Long sportsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table back_sports
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int updateByExampleSelective(@Param("record") BackSports record, @Param("example") BackSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table back_sports
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int updateByExample(@Param("record") BackSports record, @Param("example") BackSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table back_sports
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int updateByPrimaryKeySelective(BackSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table back_sports
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int updateByPrimaryKey(BackSports record);
}