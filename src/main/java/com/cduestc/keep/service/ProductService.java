package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.AchieveProductDTO;
import com.cduestc.keep.dto.DelieverProductDto;
import com.cduestc.keep.dto.DelieverSimpleProductDto;
import com.cduestc.keep.dto.DeliverProductSpecsDto;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.mapper.*;
import com.cduestc.keep.model.*;
import com.cduestc.keep.provider.PostSelectParameter;
import com.cduestc.keep.provider.ProductSelectParam;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
  @Autowired
  private ProductExMapper productExMapper;
  @Autowired
  ProductCategoryService productCategoryService;
  @Autowired
    ProductSpecsMapper productSpecsMapper;
   @Autowired
    UserRecordMapper userRecordMapper;
   @Autowired
    ProductCategoryExMapper productCategoryExMapper;
    public DelieverProductDto getProductById(Long id) {
        Product product = productMapper.selectByPrimaryKey(id);
        if(product==null){//商品不存在
            throw new CustomizeException(CustomizeErrorCode.PRODUCT_NOT_FOUND);
        }
        DelieverProductDto delieverProductDto=new DelieverProductDto();
        ProductSpecsExample productSpecsExample=new ProductSpecsExample();
        ProductSpecsExample.Criteria criteria = productSpecsExample.createCriteria();
        criteria.andProductIdEqualTo(product.getId());
        List<ProductSpecs> productSpecs = productSpecsMapper.selectByExample(productSpecsExample);
        delieverProductDto.setProductSpecsList(productSpecs);
        BeanUtils.copyProperties(product,delieverProductDto);
        delieverProductDto.setAttributeList(JSON.parseObject(product.getAttributeList()));
        delieverProductDto.setPublicAttribute(JSON.parseObject(product.getPublicAttribute()));
        String urls = product.getUrls();
        String[] as = urls.split(",");
        delieverProductDto.setUrls(as);
        return delieverProductDto;
    }

    public List<DelieverSimpleProductDto> selectByLimit(long limit, long size,String type) {

       if(StringUtils.isBlank(type)){
           throw  new CustomizeException(CustomizeErrorCode.PRODUCT_CATEGORY_IS_ENPTY);
       }
        ProductSelectParam productSelectParam=new ProductSelectParam();
        List<Long> longs=null;
        if (type.equals("E")||type.equals("W")||type.equals("S")) {//商品类别是否已经存在
            switch (type) {
                case "E":
                    longs = productCategoryService.selectProductIdByCategoryId(6l);
                    break;
                case "W":
                    longs = productCategoryService.selectProductIdByCategoryId(3l);
                    break;
                case "S":
                    longs = productCategoryService.selectProductIdByCategoryId(8l);
                    break;
            }
        }
        else{//商品类别不存在
            throw new CustomizeException(CustomizeErrorCode.PRODUCT_CATEGORY_IS_NOT_EXIST);
        }


        productSelectParam.setOffset(limit);
        productSelectParam.setSize(size);
        Map<String,Object> map=new HashMap<>();
        map.put("page",limit);
        map.put("offsize",size);
        long pageCount = longs.size() - limit;
        if(pageCount<0){//是否超过数据库已经有的
           throw  new CustomizeException(CustomizeErrorCode.PRODUCT_IS_ENPTY);
        }
        map.put("ids",longs);
        List<Product> products = productExMapper.selectByLimit(map);
        if(products==null||products.size()==0){
            throw new CustomizeException(CustomizeErrorCode.RESOURCE_NOT_FOUND);
        }
        Iterator<Product> iterator = products.iterator();
        List<DelieverSimpleProductDto> delieverSimpleProductDtos=new ArrayList<>();
        while (iterator.hasNext()){
            DelieverSimpleProductDto delieverSimpleProductDto=new DelieverSimpleProductDto();
            Product next = iterator.next();
            BeanUtils.copyProperties(next,delieverSimpleProductDto);
            //delieverSimpleProductDto.setSellerCount(next.getSellerCount());
            String urls = next.getUrls();
            String[] as = urls.split(",");
            delieverSimpleProductDto.setUrls(as[0]);
            delieverSimpleProductDtos.add(delieverSimpleProductDto);
        }
        return delieverSimpleProductDtos;
    }

    public DeliverProductSpecsDto getDetils(AchieveProductDTO achieveProductDTO) {
        ProductSpecsExample productSpecsExample=new ProductSpecsExample();
        ProductSpecsExample.Criteria criteria = productSpecsExample.createCriteria();
        criteria.andProductIdEqualTo(achieveProductDTO.getId());
        String json = achieveProductDTO.getJson();
        criteria.andProductSpecsEqualTo(json);
        List<ProductSpecs> productSpecs = productSpecsMapper.selectByExample(productSpecsExample);
        if(productSpecs==null||productSpecs.size()==0){//商品不存在

                throw new CustomizeException(CustomizeErrorCode.PRODUCT_NOT_FOUND);
        }
        DeliverProductSpecsDto deliverProductSpecsDto=new DeliverProductSpecsDto();
         BeanUtils.copyProperties(productSpecs.get(0),deliverProductSpecsDto);
         deliverProductSpecsDto.setProductSpecs(JSON.parseObject(productSpecs.get(0).getProductSpecs()));
        return deliverProductSpecsDto;
    }

    public List<DelieverSimpleProductDto>guessLike(Long userId, int page,int size) {
        UserRecordExample userRecordExample=new UserRecordExample();
        userRecordExample.createCriteria().andOwnerIdEqualTo(userId);
        List<UserRecord> userRecords = userRecordMapper.selectByExample(userRecordExample);
        Iterator<UserRecord> iterator = userRecords.iterator();
        List<Long> ids=new ArrayList<>();
        while(iterator.hasNext()){
            UserRecord next = iterator.next();
            ids.add(next.getProductId());
        }
        int totalCount = productCategoryExMapper.countByParentId(ids);
        List<Long> longs = productCategoryExMapper.selectProductIdByCategoryIds(ids);
        int totalPage=0;
        int i = totalCount % size;
        if(i>0){
            totalPage=totalCount/size+1;
        }
        if(i==0){
            totalPage=totalCount/size;
        }
        if(page>totalPage){
            throw  new CustomizeException(CustomizeErrorCode.PRODUCT_IS_ENPTY);
        }
       int offset=size*(page-1);
        Map<String,Object> map=new HashMap<>();
        map.put("page",offset);
        map.put("offsize",size);
        map.put("ids",longs);
        List<Product> products = productExMapper.selectByLimit(map);
        List<DelieverSimpleProductDto> list=new ArrayList<>();
        Iterator<Product> iterator1 = products.iterator();
        while (iterator1.hasNext()){
            Product next = iterator1.next();
            DelieverSimpleProductDto delieverProductDto=new DelieverSimpleProductDto();
            BeanUtils.copyProperties(next,delieverProductDto);
            delieverProductDto.setUrls(next.getUrls().split(",")[0]);
            list.add(delieverProductDto);
        }
        return list;
    }
}
