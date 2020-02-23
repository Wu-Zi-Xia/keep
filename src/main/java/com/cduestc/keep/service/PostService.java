package com.cduestc.keep.service;

import com.cduestc.keep.dto.PostDto;
import com.cduestc.keep.mapper.PostMapper;
import com.cduestc.keep.model.Post;
import com.cduestc.keep.model.User;
import com.qcloud.cos.COSClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;
    @Autowired
    FileService fileService;
    public int insertNewPost(HttpSession session, PostDto newPost, Map<String,MultipartFile>files) throws IOException {
        User user = (User) session.getAttribute("user");
        newPost.setOwnerID(user.getUserId());//设置动态的拥有者
        java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String formatTime = sdf.format(new Date(System.currentTimeMillis()));
        newPost.setCreateDate(formatTime);//设置新建时间

        COSClient cosClient=fileService.getCosClient();//获取腾讯云存储客户端
        FileInputStream fileInputStream=null;
        int insert=0;
        //文件上传
     if(files.get("imageFile")!=null) {
        String url = fileService.upload(files.get("imageFile"), fileInputStream, cosClient);
         newPost.setImageUrl(url);//设置url
    }
        if(files.get("videoFile")!=null) {
            String url = fileService.upload(files.get("videoFile"), fileInputStream, cosClient);
            newPost.setImageUrl(url);//设置url
        }
        Post post=new Post();
        BeanUtils.copyProperties(newPost,post);
        insert= postMapper.insert(post);
        return insert;

    }


}
