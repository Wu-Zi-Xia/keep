package com.cduestc.keep.mapper;

import com.cduestc.keep.model.CoachQualification;
import com.cduestc.keep.model.CoachQualificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoachQualificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coach_qualification
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    long countByExample(CoachQualificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coach_qualification
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int deleteByExample(CoachQualificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coach_qualification
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coach_qualification
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int insert(CoachQualification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coach_qualification
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int insertSelective(CoachQualification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coach_qualification
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    List<CoachQualification> selectByExample(CoachQualificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coach_qualification
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    CoachQualification selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coach_qualification
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int updateByExampleSelective(@Param("record") CoachQualification record, @Param("example") CoachQualificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coach_qualification
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int updateByExample(@Param("record") CoachQualification record, @Param("example") CoachQualificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coach_qualification
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int updateByPrimaryKeySelective(CoachQualification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coach_qualification
     *
     * @mbg.generated Sat May 02 15:10:06 CST 2020
     */
    int updateByPrimaryKey(CoachQualification record);
}