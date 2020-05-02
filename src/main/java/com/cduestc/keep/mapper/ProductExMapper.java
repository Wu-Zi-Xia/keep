package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Product;
import com.cduestc.keep.pojo.ProductSimpleINFO;
import com.cduestc.keep.provider.PostSelectParameter;
import com.cduestc.keep.provider.ProductSelectParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

public interface ProductExMapper {
     List<Product> selectByLimit(Map<String,Object> map);

    long countBySearch(@Value("search") String search);
    List<ProductSimpleINFO> selectBySearch(ProductSelectParam productSelectParam);
}

