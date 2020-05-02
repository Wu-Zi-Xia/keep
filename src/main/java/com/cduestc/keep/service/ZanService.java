package com.cduestc.keep.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.mapper.FriendExMapper;
import com.cduestc.keep.mapper.PostExMapper;
import com.cduestc.keep.mapper.ZanMapper;
import com.cduestc.keep.model.Zan;
import com.cduestc.keep.model.ZanExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
            String s = StringUtils.join(ids.toArray(),",");
            Zan zan1=new Zan();
            zan1.setOwnerId(postId);
            zan1.setZanId(s);
            zanMapper.insert(zan1);
        }
        else{
            String idString=zans.get(0).getZanId();
        switch (type){
            case "A":
                String s = idString+","+userId.toString();
                Zan zan1=new Zan();
                zan1.setZanId(s);
                ZanExample zanExample1=new ZanExample();
                zanExample1.createCriteria().andOwnerIdEqualTo(postId);
                zanMapper.updateByExampleSelective(zan1,zanExample1);
                break;
            case "D":
                String[] split1= idString.split(",");
                //List<String> mlist1= Arrays.asList(split1);
                List<String> mlist1= new ArrayList<>(Arrays.asList(split1));
                mlist1.remove(userId.toString());
                String s1 = StringUtils.join(mlist1.toArray(),",");
                Zan zan2=new Zan();
                zan2.setZanId(s1);
                ZanExample zanExample2=new ZanExample();
                zanExample2.createCriteria().andOwnerIdEqualTo(postId);
                zanMapper.updateByExampleSelective(zan2,zanExample2);
                break;
        }
    }
    }

    public boolean isZan(long postId, Long userId) {
        ZanExample zanExample=new ZanExample();
        zanExample.createCriteria().andOwnerIdEqualTo(postId);
        List<Zan> zans = zanMapper.selectByExample(zanExample);
        Zan zan = zans.get(0);
        String zanId = zan.getZanId();
        String[] split1= zanId.split(",");
//        for(int i=(days-2);i>=0;i--) {
//            Byte signs = parseArray.getByte(i);
//            //如果是前一天没有签到就返回签到一天
//            if(signs == 0 && i == (days-2)) {
//                //map.put("conSigns", conSigns);
//                break;
        return Arrays.asList(split1).contains(userId.toString());
    }
}
