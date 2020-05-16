package com.cduestc.keep.mapper;

import com.cduestc.keep.model.UserRecord;
import com.cduestc.keep.model.UserRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    long countByExample(UserRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByExample(UserRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insert(UserRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insertSelective(UserRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    List<UserRecord> selectByExample(UserRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    UserRecord selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserRecord record, @Param("example") UserRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExample(@Param("record") UserRecord record, @Param("example") UserRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKeySelective(UserRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKey(UserRecord record);
}