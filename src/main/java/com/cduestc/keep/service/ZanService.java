package com.cduestc.keep.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.mapper.FriendExMapper;
import com.cduestc.keep.mapper.PostExMapper;
import com.cduestc.keep.mapper.ZanMapper;
import com.cduestc.keep.model.Zan;
import com.cduestc.keep.model.ZanExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZanService {
    @Autowired
   private ZanMapper zanMapper;
    @Autowired
    FriendExMapper friendExMapper;
    @Autowired
    PostExMapper postExMapper;
    public void updateId(Long userId,Long postId,String type){
        ZanExample zanExample=new ZanExample();
        zanExample.createCriteria().andOwnerIdEqualTo(postId);
        List<Zan> zans = zanMapper.selectByExample(zanExample);
        if(zans.size()==0){//如果返回是空，证明还没有人赞这个动态，需要新建一个赞的数据
           //找到当前动态的拥有者的总朋友数
//            Long ownerId = postExMapper.selectOwnerIdByKey(postId);
//            int friendCount = friendExMapper.countByOwner(ownerId);
            List<Long> ids=new ArrayList<>();
            //将新进来的数据插入到数组的末尾
            ids.add(userId);
            String s = JSONObject.toJSONString(ids);
            Zan zan1=new Zan();
            zan1.setOwnerId(postId);
            zan1.setZanId(s);
            zanMapper.insert(zan1);
        }
        else{
            String idString=zans.get(0).getZanId();
        switch (type){
            case "A":
                JSONArray parseArray1 = JSONObject.parseArray(idString);
                parseArray1.add(userId);
                String s1=JSONObject.toJSONString(parseArray1);
                Zan zan1=new Zan();
                zan1.setZanId(s1);
                ZanExample zanExample1=new ZanExample();
                zanExample1.createCriteria().andOwnerIdEqualTo(postId);
                zanMapper.updateByExampleSelective(zan1,zanExample1);
                break;
            case "D":
                JSONArray parseArray2 = JSONObject.parseArray(idString);
                List<Long> list2 = JSONObject.parseArray(parseArray2.toJSONString(), Long.class);
                list2.remove(userId);
                String s2=JSONObject.toJSONString(list2);
                Zan zan2=new Zan();
                zan2.setZanId(s2);
                ZanExample zanExample2=new ZanExample();
                zanExample2.createCriteria().andOwnerIdEqualTo(postId);
                zanMapper.updateByExampleSelective(zan2,zanExample2);
                break;
        }
    }
    }
}
