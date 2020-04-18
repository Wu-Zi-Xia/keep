package com.cduestc.keep.mapper;

import com.cduestc.keep.model.FriendCircle;
import com.cduestc.keep.model.FriendCircleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendCircleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend_circle
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    long countByExample(FriendCircleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend_circle
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int deleteByExample(FriendCircleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend_circle
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend_circle
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int insert(FriendCircle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend_circle
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int insertSelective(FriendCircle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend_circle
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    List<FriendCircle> selectByExample(FriendCircleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend_circle
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    FriendCircle selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend_circle
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByExampleSelective(@Param("record") FriendCircle record, @Param("example") FriendCircleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend_circle
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByExample(@Param("record") FriendCircle record, @Param("example") FriendCircleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend_circle
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByPrimaryKeySelective(FriendCircle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend_circle
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByPrimaryKey(FriendCircle record);
}