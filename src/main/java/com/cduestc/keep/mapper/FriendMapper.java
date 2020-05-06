package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Friend;
import com.cduestc.keep.model.FriendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_friend
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    long countByExample(FriendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_friend
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByExample(FriendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_friend
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByPrimaryKey(Long friendId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_friend
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insert(Friend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_friend
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insertSelective(Friend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_friend
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    List<Friend> selectByExample(FriendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_friend
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    Friend selectByPrimaryKey(Long friendId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_friend
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") Friend record, @Param("example") FriendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_friend
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExample(@Param("record") Friend record, @Param("example") FriendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_friend
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKeySelective(Friend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_friend
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKey(Friend record);
}