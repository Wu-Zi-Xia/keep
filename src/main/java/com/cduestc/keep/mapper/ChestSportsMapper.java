package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ChestSports;
import com.cduestc.keep.model.ChestSportsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChestSportsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chest_sports
     *
     * @mbg.generated Sat Feb 15 21:07:37 CST 2020
     */
    long countByExample(ChestSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chest_sports
     *
     * @mbg.generated Sat Feb 15 21:07:37 CST 2020
     */
    int deleteByExample(ChestSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chest_sports
     *
     * @mbg.generated Sat Feb 15 21:07:37 CST 2020
     */
    int deleteByPrimaryKey(Long sportsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chest_sports
     *
     * @mbg.generated Sat Feb 15 21:07:37 CST 2020
     */
    int insert(ChestSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chest_sports
     *
     * @mbg.generated Sat Feb 15 21:07:37 CST 2020
     */
    int insertSelective(ChestSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chest_sports
     *
     * @mbg.generated Sat Feb 15 21:07:37 CST 2020
     */
    List<ChestSports> selectByExample(ChestSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chest_sports
     *
     * @mbg.generated Sat Feb 15 21:07:37 CST 2020
     */
    ChestSports selectByPrimaryKey(Long sportsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chest_sports
     *
     * @mbg.generated Sat Feb 15 21:07:37 CST 2020
     */
    int updateByExampleSelective(@Param("record") ChestSports record, @Param("example") ChestSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chest_sports
     *
     * @mbg.generated Sat Feb 15 21:07:37 CST 2020
     */
    int updateByExample(@Param("record") ChestSports record, @Param("example") ChestSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chest_sports
     *
     * @mbg.generated Sat Feb 15 21:07:37 CST 2020
     */
    int updateByPrimaryKeySelective(ChestSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chest_sports
     *
     * @mbg.generated Sat Feb 15 21:07:37 CST 2020
     */
    int updateByPrimaryKey(ChestSports record);
}