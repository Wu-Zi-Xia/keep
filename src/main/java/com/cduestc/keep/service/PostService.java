package com.cduestc.keep.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.*;
import com.cduestc.keep.enums.CommentTypeEnum;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.mapper.*;
import com.cduestc.keep.model.*;
import com.cduestc.keep.provider.PostSelectParameter;
import com.cduestc.keep.provider.ProductSelectParam;
import com.cduestc.keep.provider.UpdatePostParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;
    @Autowired
    PostExMapper postExMapper;
    @Autowired
    FileService fileService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    FriendService friendService;
    @Autowired
    FriendCircleService friendCircleService;
    @Autowired
    FriendCircleExMapper friendCircleExMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ZanService zanService;
    @Autowired
    RedisPostService redisPostService;
    @Autowired
    ZanMapper zanMapper;
    @Value("${redis.keep.FriCirMyself}")
    String redisFriTableNameM;
    @Value("${redis.keep.FriCirMyselfSort}")
    String redisFriCriSortSetM;
    @Value("${redis.keep.FriCirMyFriend}")
    String redisFriTableNameF;
    @Value("${redis.keep.FriCirMyFriendSort}")
    String redisFriCriSortSetF;
    @Autowired
    CoachQualificationService coachQualificationService;
    @Autowired
    CertificationMapper certificationMapper;
    @Autowired
    UserService keepUserService;
    @Autowired
    PostService postService;
    //插入一条动态
    public int insertNewPost(User user, PostDto newPost){
        newPost.setOwnerId(user.getUserId());//设置动态的拥有者
        long createDate = System.currentTimeMillis();
        int insert=0;
        Post post=new Post();
        post.setLikeCount(0);
        post.setCommentCount(0);
        post.setCreateDate(createDate);
        post.setDescription(newPost.getDescription());
        post.setOwnerId(user.getUserId());
        post.setImageUrl(newPost.getImageUrl());
        post.setVideoUrl(newPost.getVideoUrl());
        //新插入的post的id会直接返回到当前插入动态这个参数（post）的id
        insert= postExMapper.insert(post);
        //插入数据库之后，当前的这个post已经是完备的post了，将post转成map再进行存入redis
        //插入自己的朋友圈表(可以异步去做)
        FriendCircle friendCircle=new FriendCircle();
        friendCircle.setPostOwnerid(user.getUserId());
        friendCircle.setOwnerId(user.getUserId());
        friendCircle.setIsOwn(1);
        friendCircle.setPostId(post.getPostId());
        friendCircle.setCreateDate(createDate);
        friendCircleExMapper.insert(friendCircle);
        //删除朋友圈redis
      if(redisPostService.isEnpty(redisFriCriSortSetM+user.getUserId())){
          //有当前的这个key就删它
          Set postIds = redisTemplate.opsForZSet().range(redisFriCriSortSetM + user.getUserId().toString(), 0, -1);
          Iterator iterator = postIds.iterator();
          while (iterator.hasNext()){
              Object next = iterator.next();
              redisTemplate.delete(next.toString());
          }
          redisTemplate.delete(redisFriCriSortSetM+user.getUserId());
      }
        //redisTemplate.opsForList().leftPush("FriCir:"+friendCircle.getOwnerId().toString(),friendCircle.getPostId().toString());

        //插入当前关注了这个用户的所有的人的friendCircle数据（可以异步去做）
        List<Friend> friendsByUserId = friendService.getFriendByFriendId(user.getUserId());
        //List<Long> IDS=new ArrayList<>();
        Iterator<Friend> friendIte = friendsByUserId.iterator();
        while(friendIte.hasNext()){
            Friend next = friendIte.next();
            FriendCircle friendCircle1=new FriendCircle();
            friendCircle1.setPostId(post.getPostId());
            friendCircle1.setPostOwnerid(user.getUserId());
            friendCircle1.setOwnerId(next.getFriendUserid());
            friendCircle1.setIsOwn(0);
            friendCircle1.setCreateDate(createDate);
            //插入数据库
            friendCircleExMapper.insert(friendCircle1);
            //删除朋友的redis中的朋友圈
            if(redisTemplate.hasKey(redisFriTableNameM+next.getFriendFriendid())){
                Set range = redisTemplate.opsForZSet().
                        range(redisFriTableNameM + next.getFriendFriendid(), 0, -1);
                Iterator iterator = range.iterator();
                while (iterator.hasNext()){
                    Object next1 = iterator.next();
                    redisTemplate.delete(next1.toString());
                }
                redisTemplate.delete(redisFriCriSortSetM+user.getUserId());
            }
        }
        return insert;
    }

    //获取自己的动态
    public List<DeliverPostDTO> getPostByOwnerID(User user,int offset,int size) {
        long ID=user.getUserId();
        //动态详情的list
        List<DeliverPostDTO> deliverPostDTOList=new ArrayList<>();
        //获取发布者的简单信息
        DeliverSimpleUserINFODTO simpleUserINFOById = userService.getSimpleUserINFOById(ID);
       // BeanUtils.copyProperties(user,simpleUserINFOById);

        //从朋友圈表获取当前用户所有的动态的总数
        int postCount = friendCircleExMapper.countByOwnerId(ID,1);
        if(postCount==0){
            throw new CustomizeException(CustomizeErrorCode.NOT_HAVE_POSTS);
        }
        PostSelectParameter postExample=new PostSelectParameter();
        postExample.setOwnerId(ID);
        postExample.setIsOwn(1);
        postExample.setOrder("asc");
        int page=postCount-offset;

        if(page<=0){//证明请求的数据已经超过了数据库的总数
            throw new CustomizeException(CustomizeErrorCode.PRODUCT_IS_ENPTY);
        }
        if(page>size){
            postExample.setSize(size);
            postExample.setOffset(offset);
        }
        if(page<=size){
            postExample.setOffset(offset);
            postExample.setSize(page);
        }
        List<Post> posts =new ArrayList<>();
        //从朋友圈获取需要查的动态的ID
        List<Long> postIdList = friendCircleExMapper.selectByLimit(postExample);//自己发的动态
        Iterator<Long> iterator2 = postIdList.iterator();
        //根据id查询出所有的动态信息
        while (iterator2.hasNext()){
            Long next = iterator2.next();
            Post post = postMapper.selectByPrimaryKey(next);
            posts.add(post);
        }
        Iterator<Post> iterator1 = posts.iterator();
        int j=0;
        while(iterator1.hasNext()){
            DeliverPostDTO deliverPostDTO1=new DeliverPostDTO();
            //设置发布者的简单信息
            deliverPostDTO1.setDeliverSimpleUserINFODTO(simpleUserINFOById);
            //设置动态
            Post next = iterator1.next();
            DeliverAnathorPostDto deliverAnathorPostDto=new DeliverAnathorPostDto();
            BeanUtils.copyProperties(next,deliverAnathorPostDto);
            if(next.getImageUrl()!=null){//如果当前动态的图片不为空，就设置图片数组
                deliverAnathorPostDto.setImageUrl(next.getImageUrl().split(","));
            }
            if(next.getVideoUrl()!=null){
                deliverAnathorPostDto.setVideoUrl(next.getVideoUrl().split(","));
            }
            deliverPostDTO1.setPost(deliverAnathorPostDto);
            List<Comment> comments;
            //获取每一条动态的一级评论：
            comments= commentService.getCommentsByOwnerId(next.getPostId(), CommentTypeEnum.POST);
            List<DeliverCommentDto> deliverCommentDtoList=new ArrayList<>();
            Iterator<Comment> iterator = comments.iterator();
            while (iterator.hasNext()){
                DeliverCommentDto deliverCommentDto=new DeliverCommentDto();
                //设置一级评论
                Comment next1 = iterator.next();
                deliverCommentDto.setComment(next1);
                //设置评论的的二级评论
                deliverCommentDto.setCommentList(commentService.getCommentsByOwnerId(next1.getCommentId(),CommentTypeEnum.COMMENT));//设置二级评论的list
                deliverCommentDtoList.add(deliverCommentDto);
            }
            //设置动态的一级评论
            deliverPostDTO1.setComments(deliverCommentDtoList);
            deliverPostDTOList.add(deliverPostDTO1);
        }

        for(int i=0;i<deliverPostDTOList.size();i++) {//将查询出来的所有数据进行redis同步
            redisPostService.insertSort(deliverPostDTOList.get(i), user.getUserId());
        }
        //判断数据长度小于5就直接返回到前台
        if(deliverPostDTOList.size()<=5){
            return deliverPostDTOList;
        }
        //判断数据长度大于5但是小于10，将
        if(deliverPostDTOList.size()>5&&deliverPostDTOList.size()<=10){
            List<DeliverPostDTO> deliverPostDTOList1=new ArrayList<>();
            for(int i=0;i<5;i++){
                deliverPostDTOList1.add(deliverPostDTOList.get(i));
            }
            return deliverPostDTOList1;
        }
        return deliverPostDTOList;
    }



    //获取朋友的动态
    public List<DeliverPostDTO> getFriendPostByOwnerId(User user,int offset,int size) {

        long ID=user.getUserId();
        //动态详情的list
        List<DeliverPostDTO> deliverPostDTOList=new ArrayList<>();
        //从朋友圈表获取当前用户的朋友的所有的动态的总数
        int postCount = friendCircleExMapper.countByOwnerId(ID,0);
        PostSelectParameter postExample=new PostSelectParameter();
        postExample.setOwnerId(ID);
        postExample.setIsOwn(0);
        postExample.setOrder("asc");
        if(postCount==0){//证明没有动态
            throw new CustomizeException(CustomizeErrorCode.NOT_HAVE_POSTS);
        }
        int page=postCount-offset;

        if(page<=0){//证明请求的数据已经超过了数据库的总数
            throw new CustomizeException(CustomizeErrorCode.PRODUCT_IS_ENPTY);
        }
        if(page>size){
            postExample.setSize(size);
            postExample.setOffset(offset);
        }
        if(page<=size){
            postExample.setOffset(offset);
            postExample.setSize(page);
        }
        List<Post> posts =new ArrayList<>();
        //从朋友圈获取需要查的动态的ID
        List<Long> postIdList = friendCircleExMapper.selectByLimit(postExample);//朋友发的动态的id
        Iterator<Long> iterator2 = postIdList.iterator();
        //根据id查询出所有的动态信息
        while (iterator2.hasNext()){
            Long next = iterator2.next();
            Post post = postMapper.selectByPrimaryKey(next);
            posts.add(post);
        }
        Iterator<Post> iterator1 = posts.iterator();
        while(iterator1.hasNext()){
            DeliverPostDTO deliverPostDTO1=new DeliverPostDTO();
            //设置动态
            Post next = iterator1.next();
            //设置发布者的简单信息
            DeliverSimpleUserINFODTO simpleUserINFOById = userService.getSimpleUserINFOById(next.getOwnerId());
            deliverPostDTO1.setDeliverSimpleUserINFODTO(simpleUserINFOById);
            DeliverAnathorPostDto deliverAnathorPostDto=new DeliverAnathorPostDto();
            BeanUtils.copyProperties(next,deliverAnathorPostDto);
            if(next.getImageUrl()!=null){
                deliverAnathorPostDto.setImageUrl(next.getImageUrl().split(","));
            }
            if(next.getVideoUrl()!=null){
                deliverAnathorPostDto.setVideoUrl(next.getVideoUrl().split(","));
            }
            deliverPostDTO1.setPost(deliverAnathorPostDto);
            List<Comment> comments;
            //获取每一条动态的一级评论：
            comments= commentService.getCommentsByOwnerId(next.getPostId(), CommentTypeEnum.POST);

            Iterator<Comment> iterator = comments.iterator();
            List<DeliverCommentDto> deliverCommentDtoList=new ArrayList<>();
            while (iterator.hasNext()){
                DeliverCommentDto deliverCommentDto=new DeliverCommentDto();
                //设置一级评论
                Comment next1 = iterator.next();
                deliverCommentDto.setComment(next1);
                //设置评论的的二级评论
                deliverCommentDto.setCommentList(commentService.getCommentsByOwnerId(next1.getCommentId(),CommentTypeEnum.COMMENT));//设置二级评论的list
                deliverCommentDtoList.add(deliverCommentDto);
            }
            //设置动态的所有一级评论
            deliverPostDTO1.setComments(deliverCommentDtoList);
            deliverPostDTOList.add(deliverPostDTO1);
        }

        for(int i=0;i<deliverPostDTOList.size();i++) {//将查询出来的所有数据进行redis同步
            redisPostService.insertFriendSort(deliverPostDTOList.get(i), user.getUserId());
        }
        //判断数据长度小于5就直接返回到前台
        if(deliverPostDTOList.size()<=5){
            return deliverPostDTOList;
        }
        //判断数据长度大于5但是小于10，将
        if(deliverPostDTOList.size()>5&&deliverPostDTOList.size()<=10){
            List<DeliverPostDTO> deliverPostDTOList1=new ArrayList<>();
            for(int i=0;i<5;i++){
                deliverPostDTOList1.add(deliverPostDTOList.get(i));
            }
            return deliverPostDTOList1;
        }
        return deliverPostDTOList;
    }

    public void updateLikeCount(UpdatePostParam updatePostParam) {
        postExMapper.updateLikeCount(updatePostParam);

    }

    public boolean updateZan(String keyName, Long userId,Long postId) {
        UpdatePostParam updatePostParam=new UpdatePostParam();
        if(redisTemplate.opsForSet().isMember(keyName,userId.toString())){//看当前用户是否已经点赞
            //删除redis中的点赞信息
            redisTemplate.opsForSet().remove(keyName,userId.toString());
            //发送异步请求将点赞信息持久化到数据库
            zanService.updateId(userId,postId,"D");
            //发送异步请求修改redis中的动态的字段
            if(redisPostService.isEnpty(redisFriTableNameM+postId)){
                //判断那个动态是否还存在于redis中，如果存在，那就可以修改那个字段,不存在的话，就什么都不做
                //因为总是会修改数据库中过字段，这样再刷新的时候，就会去数据库中查询，那必然是最新的数据
                redisPostService.updateLikeCount(redisFriTableNameM+postId,-1);
            }
            updatePostParam.setNum(-1);
            updatePostParam.setPostId(postId);
            //发异步请求到mysql修改字段
            updateLikeCount(updatePostParam);
            return true;
        }
        else{
            //将点赞用户加入集合，
            redisTemplate.opsForSet().add(keyName,userId.toString());
            //异步的将点赞信息持久化到数据库
             zanService.updateId(userId,postId,"A");
            //发送异步请求修改redis中的动态的字段
            if(redisPostService.isEnpty(redisFriTableNameM+postId)){
                //判断那个动态是否还存在于redis中，如果存在，那就可以修改那个字段,不存在的话，就什么都不做
                //因为总是会修改数据库中过字段，这样再刷新的时候，就会去数据库中查询，那必然是最新的数据
                redisPostService.updateLikeCount(redisFriTableNameM+postId,1);
            }
            //发异步请求到mysql中的redis的修改字段
            updatePostParam.setNum(1);
            updatePostParam.setPostId(postId);
            updateLikeCount(updatePostParam);
            return false;
        }
    }

    public void getZan(String keyName,long postId) {
        ZanExample zanExample=new ZanExample();
        zanExample.createCriteria().andOwnerIdEqualTo(postId);
        //获取具体的赞的信息的数据
        List<Zan> zans = zanMapper.selectByExample(zanExample);

        //判断数据是否为空，空的话就生成一个空字符串，放入到redis中
        if(zans.size()==0){
            redisTemplate.opsForSet().add(keyName,"");
        }else{//点赞id不为空
            String[] split1= zans.get(0).getZanId().split(",");
            String suids = JSONObject.toJSONString(split1);
            redisTemplate.opsForSet().add(keyName,suids);
        }
    }


    public List<Post> selectPostsByOwnerId(long userId) {
        PostExample postExample=new PostExample();
        postExample.createCriteria().andOwnerIdEqualTo(userId);
        List<Post> posts = postMapper.selectByExample(postExample);
        return posts;
    }

    public DeliverPostDTO getPostByOwnerID(User user, String postId) {
        DeliverPostDTO deliverPostDTO=new DeliverPostDTO();
        //获取发布者的简单信息
        DeliverSimpleUserINFODTO simpleUserINFOById = userService.getSimpleUserINFOById(user.getUserId());
        deliverPostDTO.setDeliverSimpleUserINFODTO(simpleUserINFOById);
        long postId1 = Long.parseLong(postId);
        Post post = postMapper.selectByPrimaryKey(postId1);
        DeliverAnathorPostDto deliverAnathorPostDto=new DeliverAnathorPostDto();
        BeanUtils.copyProperties(post,deliverAnathorPostDto);
        deliverAnathorPostDto.setImageUrl(post.getImageUrl().split(","));
        deliverPostDTO.setPost(deliverAnathorPostDto);
        List<Comment> commentsByOwnerId = commentService.getCommentsByOwnerId(postId1, CommentTypeEnum.POST);
        List<DeliverCommentDto> deliverCommentDtos=new ArrayList<>();
        if(commentsByOwnerId!=null){
            Iterator<Comment> iterator = commentsByOwnerId.iterator();
            while(iterator.hasNext()){
                DeliverCommentDto deliverCommentDto=new DeliverCommentDto();
                Comment next = iterator.next();
                deliverCommentDto.setComment(next);
                List<Comment> commentsByOwnerId1 = commentService.getCommentsByOwnerId(next.getCommentId(), CommentTypeEnum.COMMENT);
                deliverCommentDto.setCommentList(commentsByOwnerId1);
                deliverCommentDtos.add(deliverCommentDto);
            }
            deliverPostDTO.setComments(deliverCommentDtos);
        }
        redisPostService.insertSort(deliverPostDTO, user.getUserId());
        return deliverPostDTO;
    }
     //获取推荐的动态
    public  List<DeliverRecomendDto> getRecommend(int mysqlOffset, int mysqlSize,long userId) {
        //参数校验
        if(mysqlOffset<0){
            throw new CustomizeException(CustomizeErrorCode.PRODUCT_IS_ENPTY);
        }
        if(mysqlSize<0){
            throw new CustomizeException(CustomizeErrorCode.PRODUCT_IS_ENPTY);
        }
        List<DeliverRecomendDto> deliverRecomendDtos=new ArrayList<>();
           //获取到教练和
         List<CoachQualification> coach = coachQualificationService.getCoach(mysqlOffset, mysqlSize, userId);
         Iterator<CoachQualification> iterator = coach.iterator();
         while(iterator.hasNext()){
            CoachQualification next = iterator.next();
            DeliverRecomendDto deliverRecomendDto=new DeliverRecomendDto();
            //查询用户的简单信息
            DeliverSimpleUserINFODTO simpleUserINFOById = userService.getSimpleUserINFOById(next.getUserId());
            deliverRecomendDto.setDeliverSimpleUserINFODTO(simpleUserINFOById);
            //查询该教练的第一条动态
            PostSelectParameter postSelectParameter=new PostSelectParameter();
            postSelectParameter.setOffset(0);
            postSelectParameter.setSize(1);
            postSelectParameter.setOwnerId(next.getUserId());
            postSelectParameter.setIsOwn(1);
            List<Post> posts = postExMapper.selectByLimit(postSelectParameter);
            deliverRecomendDto.setPost(posts.get(0));
            //查询教练的勋章
            Certification certification = certificationMapper.selectByPrimaryKey(next.getCertificationId());
            deliverRecomendDto.setCerString(certification.getQualificationType());
            deliverRecomendDtos.add(deliverRecomendDto);
        }
        return deliverRecomendDtos;
    }
    //获取热门的动态
    public List<DeliverPostDTO> getHot(int page,int size) {
        if(page<=0){
            throw new CustomizeException(CustomizeErrorCode.PARAM_IS_WRONG);
        }
        int likeCount=100;
        int totalCount=postService.countByLikeCount(likeCount);
        int l = totalCount % size;
        int totalPage=0;
        if(l>0){
            totalPage=totalCount/size+1;
        }
        if(l==0){
            totalPage=totalCount/size;
        }
        if(page>totalPage){
            throw new CustomizeException(CustomizeErrorCode.PRODUCT_IS_ENPTY);
        }
        int offset=size*(page-1);
        PostSelectParameter postSelectParameter=new PostSelectParameter();
        postSelectParameter.setSize(size);
        postSelectParameter.setOffset(offset);
        postSelectParameter.setLikeCount(likeCount);
        List<Post> posts = postService.selectPostsByLikeCount(postSelectParameter);
        List<DeliverPostDTO> deliverPostDTOList = setDeliverPostDTO(posts);
        for(int i=0;i<deliverPostDTOList.size();i++) {//将查询出来的所有数据进行redis同步
            redisPostService.insertSort(deliverPostDTOList.get(i));
        }
        return deliverPostDTOList;
    }

    private List<Post> selectPostsByLikeCount(PostSelectParameter postSelectParameter) {
        List<Post> posts = postExMapper.selectByLikeCount(postSelectParameter);
        return posts;
    }

    private int countByLikeCount(int likeCount) {
       int totalCount= postExMapper.countByLikeCount(likeCount);
       return totalCount;
    }


    //辅助方法，根据post去设置出一个完整的前台需要的post传到前台的动态
    public List<DeliverPostDTO> setDeliverPostDTO(List<Post> posts) {
        //动态详情的list
        List<DeliverPostDTO> deliverPostDTOList=new ArrayList<>();
        Iterator<Post> iterator1 = posts.iterator();
        while(iterator1.hasNext()){
            DeliverPostDTO deliverPostDTO1=new DeliverPostDTO();
            //设置动态
            Post next = iterator1.next();
            //设置发布者的简单信息
            DeliverSimpleUserINFODTO simpleUserINFOById = userService.getSimpleUserINFOById(next.getOwnerId());
            deliverPostDTO1.setDeliverSimpleUserINFODTO(simpleUserINFOById);
            DeliverAnathorPostDto deliverAnathorPostDto=new DeliverAnathorPostDto();
            BeanUtils.copyProperties(next,deliverAnathorPostDto);
            deliverAnathorPostDto.setImageUrl(next.getImageUrl().split(","));
            deliverPostDTO1.setPost(deliverAnathorPostDto);

            List<Comment> comments;
            //获取每一条动态的一级评论：
            comments= commentService.getCommentsByOwnerId(next.getPostId(), CommentTypeEnum.POST);

            Iterator<Comment> iterator = comments.iterator();
            List<DeliverCommentDto> deliverCommentDtoList=new ArrayList<>();
            while (iterator.hasNext()){
                DeliverCommentDto deliverCommentDto=new DeliverCommentDto();
                //设置一级评论
                Comment next1 = iterator.next();
                deliverCommentDto.setComment(next1);
                //设置评论的的二级评论
                deliverCommentDto.setCommentList(commentService.getCommentsByOwnerId(next1.getCommentId(),CommentTypeEnum.COMMENT));//设置二级评论的list
                deliverCommentDtoList.add(deliverCommentDto);
            }
            //设置动态的所有一级评论
            deliverPostDTO1.setComments(deliverCommentDtoList);
            deliverPostDTOList.add(deliverPostDTO1);
        }
    return deliverPostDTOList;
    }

}
