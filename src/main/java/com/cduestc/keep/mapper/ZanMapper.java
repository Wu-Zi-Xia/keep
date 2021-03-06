package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Zan;
import com.cduestc.keep.model.ZanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zan
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    long countByExample(ZanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zan
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByExample(ZanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zan
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zan
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insert(Zan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zan
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insertSelective(Zan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zan
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    List<Zan> selectByExample(ZanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zan
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    Zan selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zan
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") Zan record, @Param("example") ZanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zan
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExample(@Param("record") Zan record, @Param("example") ZanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zan
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKeySelective(Zan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zan
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKey(Zan record);
}