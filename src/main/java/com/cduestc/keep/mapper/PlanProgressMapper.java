package com.cduestc.keep.mapper;

import com.cduestc.keep.model.PlanProgress;
import com.cduestc.keep.model.PlanProgressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanProgressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plan_progress
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    long countByExample(PlanProgressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plan_progress
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int deleteByExample(PlanProgressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plan_progress
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int deleteByPrimaryKey(Long planProgressid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plan_progress
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int insert(PlanProgress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plan_progress
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int insertSelective(PlanProgress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plan_progress
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    List<PlanProgress> selectByExample(PlanProgressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plan_progress
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    PlanProgress selectByPrimaryKey(Long planProgressid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plan_progress
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int updateByExampleSelective(@Param("record") PlanProgress record, @Param("example") PlanProgressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plan_progress
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int updateByExample(@Param("record") PlanProgress record, @Param("example") PlanProgressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plan_progress
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int updateByPrimaryKeySelective(PlanProgress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plan_progress
     *
     * @mbg.generated Sat Apr 04 19:47:10 CST 2020
     */
    int updateByPrimaryKey(PlanProgress record);
}