package com.cduestc.keep.mapper;

import com.cduestc.keep.model.User;
import com.cduestc.keep.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_user
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_user
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_user
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_user
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_user
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_user
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_user
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    User selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_user
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_user
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_user
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_user
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByPrimaryKey(User record);
}