package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Product;
import com.cduestc.keep.provider.PostSelectParameter;
import com.cduestc.keep.provider.ProductSelectParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductExMapper {
     List<Product> selectByLimit(Map<String,Object> map);
}
