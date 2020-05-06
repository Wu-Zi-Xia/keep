package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Certification;
import com.cduestc.keep.model.CertificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CertificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    long countByExample(CertificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByExample(CertificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insert(Certification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insertSelective(Certification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    List<Certification> selectByExample(CertificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    Certification selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") Certification record, @Param("example") CertificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExample(@Param("record") Certification record, @Param("example") CertificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKeySelective(Certification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKey(Certification record);
}