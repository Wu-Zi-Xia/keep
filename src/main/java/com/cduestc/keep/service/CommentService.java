package com.cduestc.keep.service;

import com.cduestc.keep.dto.AchieveCommentDTO;
import com.cduestc.keep.enums.CommentTypeEnum;
import com.cduestc.keep.mapper.CommentMapper;
import com.cduestc.keep.model.Comment;
import com.cduestc.keep.model.CommentExample;
import com.cduestc.keep.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    public List<Comment> getCommentsByOwnerId(long id, CommentTypeEnum typeEnum){
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria().andOwnerIdEqualTo(id);
        criteria.andTypeEqualTo(typeEnum.getType());
        commentExample.setOrderByClause("create_date desc");
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        return comments;
    }

    public int insertComment(HttpServletRequest request, AchieveCommentDTO achieveCommentDTO) {
        User user = (User)request.getSession().getAttribute("user");
        achieveCommentDTO.setReviewerID(user.getUserId());
        Comment comment=new Comment();
        BeanUtils.copyProperties(achieveCommentDTO,comment);
        Date date = new Date(System.currentTimeMillis());
        String str = "yyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        String formatDate = sdf.format(date);
        comment.setCreateDate(formatDate);
        int insert = commentMapper.insert(comment);
        return insert;
    }
}
