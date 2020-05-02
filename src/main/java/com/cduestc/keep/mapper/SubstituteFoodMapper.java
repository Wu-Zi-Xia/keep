package com.cduestc.keep.mapper;

import com.cduestc.keep.model.SubstituteFood;
import com.cduestc.keep.model.SubstituteFoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubstituteFoodMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table substitute_food
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    long countByExample(SubstituteFoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table substitute_food
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int deleteByExample(SubstituteFoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table substitute_food
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int deleteByPrimaryKey(Long foodId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table substitute_food
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int insert(SubstituteFood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table substitute_food
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int insertSelective(SubstituteFood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table substitute_food
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    List<SubstituteFood> selectByExample(SubstituteFoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table substitute_food
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    SubstituteFood selectByPrimaryKey(Long foodId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table substitute_food
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int updateByExampleSelective(@Param("record") SubstituteFood record, @Param("example") SubstituteFoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table substitute_food
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int updateByExample(@Param("record") SubstituteFood record, @Param("example") SubstituteFoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table substitute_food
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int updateByPrimaryKeySelective(SubstituteFood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table substitute_food
     *
     * @mbg.generated Sat May 02 15:10:05 CST 2020
     */
    int updateByPrimaryKey(SubstituteFood record);
}