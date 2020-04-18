package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ForearmSports;
import com.cduestc.keep.model.ForearmSportsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForearmSportsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table forearm_sports
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    long countByExample(ForearmSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table forearm_sports
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int deleteByExample(ForearmSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table forearm_sports
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int deleteByPrimaryKey(Long sportsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table forearm_sports
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int insert(ForearmSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table forearm_sports
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int insertSelective(ForearmSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table forearm_sports
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    List<ForearmSports> selectByExample(ForearmSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table forearm_sports
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    ForearmSports selectByPrimaryKey(Long sportsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table forearm_sports
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByExampleSelective(@Param("record") ForearmSports record, @Param("example") ForearmSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table forearm_sports
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByExample(@Param("record") ForearmSports record, @Param("example") ForearmSportsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table forearm_sports
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByPrimaryKeySelective(ForearmSports record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table forearm_sports
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByPrimaryKey(ForearmSports record);
}