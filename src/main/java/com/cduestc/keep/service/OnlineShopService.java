package com.cduestc.keep.service;

//import javafx.css.CssParser;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.mapper.ProductExMapper;
import com.cduestc.keep.model.Product;
import com.cduestc.keep.pojo.ProductSimpleINFO;
import com.cduestc.keep.provider.ProductSelectParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OnlineShopService {
    @Autowired
    ProductExMapper productExMapper;
    public List<ProductSimpleINFO> search(String search, long limit, long size){
        long productCount=0l;
        if(StringUtils.isNotBlank(search))//如果搜索字段不为空，那么就去匹配
        {
            String[] tags= StringUtils.split(search," ");
            search= Arrays.stream(tags).collect(Collectors.joining("|"));
            productCount=productExMapper.countBySearch(search);
            if(productCount==0l){//证明搜索的商品不存在
                //抛出商品不存在异常
                throw new CustomizeException(CustomizeErrorCode.PRODUCT_NOT_FOUND);
            }
            else{//搜索的商品存在，那么就要去设置limit和size
                long pageSize = productCount - limit;
                if(pageSize<size&&pageSize>0){
                    size=pageSize;
                }
                if(pageSize<0){//证明已经超过了想要的
                    //抛出商品已经到底异常
                    throw new CustomizeException(CustomizeErrorCode.PRODUCT_IS_ENPTY);
                }
            }
            ProductSelectParam productSelectParam=new ProductSelectParam();
            productSelectParam.setOffset(limit);
            productSelectParam.setSize(size);
            productSelectParam.setSearch(search);
            List<ProductSimpleINFO> products = productExMapper.selectBySearch(productSelectParam);
            Iterator<ProductSimpleINFO> iterator = products.iterator();
            while (iterator.hasNext()){
                    ProductSimpleINFO next = iterator.next();
                    next.setUrls(next.getUrls().split(",")[0]);
                }
            return products;
        }
        else{//搜索内容不能为空
            throw new CustomizeException(CustomizeErrorCode.SEARCH_IS_ENPTY);
        }
    }
}
