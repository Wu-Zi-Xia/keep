package com.cduestc.keep.service;

import com.cduestc.keep.mapper.ProductCategoryExMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    ProductCategoryExMapper productCategoryExMapper;
    public List<Long> selectProductIdByCategoryId(Long id){
        List<Long> longs = productCategoryExMapper.selectProductIdByCategoryId(id);
        return longs;
    }
}
