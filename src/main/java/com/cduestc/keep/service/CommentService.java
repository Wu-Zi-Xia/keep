package com.cduestc.keep.service;

import com.cduestc.keep.dto.AchieveCommentDTO;
import com.cduestc.keep.enums.CommentTypeEnum;
import com.cduestc.keep.mapper.CommentExMapper;
import com.cduestc.keep.mapper.CommentMapper;
import com.cduestc.keep.mapper.PostExMapper;
import com.cduestc.keep.model.Comment;
import com.cduestc.keep.model.CommentExample;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.UpdatePostParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    PostExMapper postExMapper;
    @Value("${redis.keep.FriCirMyself}")
    String redisFriTableNameM;
    @Value("${redis.keep.FriCirMyselfSort}")
    String redisFriCriSortSetM;
    @Value("${redis.keep.FriCirMyFriend}")
    String redisFriTableNameF;
    @Value("${redis.keep.FriCirMyFriendSort}")
    String redisFriCriSortSetF;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    CommentExMapper commentExMapper;
    public List<Comment> getCommentsByOwnerId(long id, CommentTypeEnum typeEnum){
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria().andOwnerIdEqualTo(id);
        criteria.andTypeEqualTo(typeEnum.getType());
        commentExample.setOrderByClause("create_date desc");
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        return comments;
    }

    public int insertComment(User user, AchieveCommentDTO achieveCommentDTO) {
        Comment comment=new Comment();
        comment.setOwnerId(achieveCommentDTO.getOwnerID());
        if(achieveCommentDTO.getType().equals("P")){
            comment.setType(CommentTypeEnum.POST.getType());
        }
        if(achieveCommentDTO.getType().equals("C")){
            comment.setType(CommentTypeEnum.COMMENT.getType());
        }
        comment.setContent(achieveCommentDTO.getContent());
        Long createDate=System.currentTimeMillis();
        comment.setCreateDate(createDate);
        comment.setReviewId(user.getUserId());
        int insert = commentMapper.insert(comment);
        //异步修改动态的评论数
        UpdatePostParam updatePostParam=new UpdatePostParam();
        updatePostParam.setPostId(achieveCommentDTO.getOwnerID());
        updatePostParam.setNum(1);
        postExMapper.updatePostCommentCount(updatePostParam);
        //异步的去删除redis中的朋友圈表或者删除自己的相册表
        //获取到这个动态的拥有者
        Long userId=null;
        if(achieveCommentDTO.getType().equals("P")){
            userId = postExMapper.selectOwnerIdByKey(achieveCommentDTO.getOwnerID());
        }
        if(achieveCommentDTO.getType().equals("C")){
            Long commentId=commentExMapper.selectOwnerIdByKey(achieveCommentDTO.getOwnerID());
            Long postId=commentExMapper.selectOwnerIdByKey(commentId);
            userId=postExMapper.selectOwnerIdByKey(postId);
        }
        if(userId.equals(user.getUserId())){//判断这个动态的拥有者和评论这条的动态的人是否是同一个人
            if(redisTemplate.hasKey(redisFriCriSortSetM+user.getUserId())){//存在就删除自己的相册表
                Set range = redisTemplate.opsForZSet().range(redisFriCriSortSetM + user.getUserId(), 0, -1);
                Iterator iterator = range.iterator();
                while(iterator.hasNext()){
                    String next =(String) iterator.next();
                    redisTemplate.delete(next);
                }
            }
            redisTemplate.delete(redisFriCriSortSetM+user.getUserId());
            //删除被评论的动态或者评论的拥有者的朋友圈表
            if(redisTemplate.hasKey(redisFriCriSortSetF+achieveCommentDTO.getToUserID())){
                Set range = redisTemplate.opsForZSet().range(redisFriCriSortSetF + achieveCommentDTO.getToUserID(), 0, -1);
                Iterator iterator = range.iterator();
                while(iterator.hasNext()){
                    String next =(String) iterator.next();
                    redisTemplate.delete(next);
                }
            }
            redisTemplate.delete(redisFriCriSortSetF+achieveCommentDTO.getToUserID());
        }
        else{//删除朋友圈表
            if(redisTemplate.hasKey(redisFriCriSortSetF+user.getUserId())){//存在就删除自己的朋友圈表
                Set range = redisTemplate.opsForZSet().range(redisFriCriSortSetF + user.getUserId(), 0, -1);
                Iterator iterator = range.iterator();
                while(iterator.hasNext()){
                    String next =(String) iterator.next();
                    redisTemplate.delete(next);
                }

            }
            redisTemplate.delete(redisFriCriSortSetF+user.getUserId());

            if(redisTemplate.hasKey(redisFriCriSortSetM+achieveCommentDTO.getToUserID())){
                Set range = redisTemplate.opsForZSet().range(redisFriCriSortSetM + achieveCommentDTO.getToUserID(), 0, -1);
                Iterator iterator = range.iterator();
                while(iterator.hasNext()){
                    String next =(String) iterator.next();
                    redisTemplate.delete(next);
                }
            }
            redisTemplate.delete(redisFriCriSortSetM+achieveCommentDTO.getToUserID());
        }
        return insert;
    }
}
