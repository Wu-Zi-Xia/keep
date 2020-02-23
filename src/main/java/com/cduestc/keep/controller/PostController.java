package com.cduestc.keep.controller;

import com.cduestc.keep.dto.PostDto;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PostController {
    @Autowired
    PostService postService;
    @RequestMapping("createPost")
    public Object createPost(HttpServletRequest request, @RequestBody PostDto newPost) throws IOException {

        MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest) request;
        MultipartFile imageFile=multipartHttpServletRequest.getFile("image-file");
        MultipartFile videoFile=multipartHttpServletRequest.getFile("video-file");
        Map<String,MultipartFile> files=new HashMap<>();
        if(imageFile!=null){
            files.put("imageFile",imageFile);
        }
        if(videoFile!=null){
            files.put("videoFile",videoFile);
        }

        int i = postService.insertNewPost(request.getSession(), newPost, files);
        if(i>0){
            return  ResultDto.oxOf();
        }
        return ResultDto.errorOf(300,"发表动态失败！！");
    }
}
