package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Plan;
import com.cduestc.keep.model.PlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_plan
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    long countByExample(PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_plan
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int deleteByExample(PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_plan
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int deleteByPrimaryKey(Long planId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_plan
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int insert(Plan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_plan
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int insertSelective(Plan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_plan
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    List<Plan> selectByExample(PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_plan
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    Plan selectByPrimaryKey(Long planId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_plan
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByExampleSelective(@Param("record") Plan record, @Param("example") PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_plan
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByExample(@Param("record") Plan record, @Param("example") PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_plan
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByPrimaryKeySelective(Plan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_plan
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByPrimaryKey(Plan record);
}