package com.cduestc.keep.service;

import com.cduestc.keep.mapper.ProductCategoryExMapper;
import com.cduestc.keep.mapper.UserRecordExMapper;
import com.cduestc.keep.mapper.UserRecordMapper;
import com.cduestc.keep.model.UserRecord;
import com.cduestc.keep.provider.UserRecordInsertParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRecordService {
    @Autowired
    UserRecordMapper userRecordMapper;
    @Autowired
    UserRecordExMapper userRecordExMapper;
    @Autowired
    ProductCategoryExMapper productCategoryExMapper;
    public void insertUserRecord(UserRecord userRecord){
        long l = productCategoryExMapper.selectParentIdByid(userRecord.getProductId());
        userRecord.setProductId(l);
        userRecordMapper.insert(userRecord);
    }
    public void insertUserRecord(UserRecordInsertParam userRecord){
        List<Long> longs = productCategoryExMapper.selectParentIdsByIds(userRecord.getProductIds());
        userRecord.setProductIds(longs);
        userRecordExMapper.insert(userRecord);
    }
}
