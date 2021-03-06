package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ThighSports;
import com.cduestc.keep.model.ThighSportsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThighSportsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thigh_sports
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    long countByExample(ThighSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thigh_sports
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByExample(ThighSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thigh_sports
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByPrimaryKey(Long sportsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thigh_sports
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insert(ThighSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thigh_sports
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insertSelective(ThighSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thigh_sports
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    List<ThighSports> selectByExample(ThighSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thigh_sports
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    ThighSports selectByPrimaryKey(Long sportsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thigh_sports
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") ThighSports record, @Param("example") ThighSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thigh_sports
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExample(@Param("record") ThighSports record, @Param("example") ThighSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thigh_sports
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKeySelective(ThighSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thigh_sports
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKey(ThighSports record);
}