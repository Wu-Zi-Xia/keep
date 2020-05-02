package com.cduestc.keep.mapper;

import com.cduestc.keep.model.SportsHistory;
import com.cduestc.keep.model.SportsHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SportsHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    long countByExample(SportsHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int deleteByExample(SportsHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int insert(SportsHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int insertSelective(SportsHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    List<SportsHistory> selectByExample(SportsHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    SportsHistory selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int updateByExampleSelective(@Param("record") SportsHistory record, @Param("example") SportsHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int updateByExample(@Param("record") SportsHistory record, @Param("example") SportsHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int updateByPrimaryKeySelective(SportsHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_history
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int updateByPrimaryKey(SportsHistory record);
}