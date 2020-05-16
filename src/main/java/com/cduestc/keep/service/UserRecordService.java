package com.cduestc.keep.service;

import com.cduestc.keep.mapper.ProductCategoryExMapper;
import com.cduestc.keep.mapper.ProductExMapper;
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
    @Autowired
    ProductExMapper productExMapper;
    public void insertUserRecord(UserRecord userRecord){
        //这里其实先去product表去查出CategoryId，
        // 然后再去ProductCategory表里面去查ParentId,
        long l = productExMapper.selectParentIdByid(userRecord.getProductId());
        userRecord.setProductId(l);
        userRecordMapper.insert(userRecord);
    }
    public void insertUserRecord(UserRecordInsertParam userRecord){
        List<Long> longs = productCategoryExMapper.selectParentIdsByIds(userRecord.getProductIds());
        userRecord.setProductIds(longs);
        userRecordExMapper.insert(userRecord);
    }
}
