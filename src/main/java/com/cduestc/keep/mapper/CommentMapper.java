package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Comment;
import com.cduestc.keep.model.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_comment
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    long countByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_comment
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int deleteByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_comment
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int deleteByPrimaryKey(Long commentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_comment
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int insert(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_comment
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int insertSelective(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_comment
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    List<Comment> selectByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_comment
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    Comment selectByPrimaryKey(Long commentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_comment
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_comment
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_comment
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByPrimaryKeySelective(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table keep_comment
     *
     * @mbg.generated Sat Apr 18 17:54:02 CST 2020
     */
    int updateByPrimaryKey(Comment record);
}