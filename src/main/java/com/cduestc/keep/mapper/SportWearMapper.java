package com.cduestc.keep.mapper;

import com.cduestc.keep.model.SportWear;
import com.cduestc.keep.model.SportWearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SportWearMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_wear
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    long countByExample(SportWearExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_wear
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int deleteByExample(SportWearExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_wear
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int deleteByPrimaryKey(Long wearId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_wear
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int insert(SportWear record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_wear
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int insertSelective(SportWear record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_wear
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    List<SportWear> selectByExample(SportWearExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_wear
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    SportWear selectByPrimaryKey(Long wearId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_wear
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int updateByExampleSelective(@Param("record") SportWear record, @Param("example") SportWearExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_wear
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int updateByExample(@Param("record") SportWear record, @Param("example") SportWearExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_wear
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int updateByPrimaryKeySelective(SportWear record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_wear
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int updateByPrimaryKey(SportWear record);
}