package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.AchieveProductDTO;
import com.cduestc.keep.dto.DelieverProductDto;
import com.cduestc.keep.dto.DelieverSimpleProductDto;
import com.cduestc.keep.dto.DeliverProductSpecsDto;
import com.cduestc.keep.mapper.ProductExMapper;
import com.cduestc.keep.mapper.ProductMapper;
import com.cduestc.keep.mapper.ProductSpecsMapper;
import com.cduestc.keep.model.Product;
import com.cduestc.keep.model.ProductSpecs;
import com.cduestc.keep.model.ProductSpecsExample;
import com.cduestc.keep.provider.PostSelectParameter;
import com.cduestc.keep.provider.ProductSelectParam;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public DelieverProductDto getProductById(Long id) {
        Product product = productMapper.selectByPrimaryKey(id);
        if(product==null){
            return null;
        }
        DelieverProductDto delieverProductDto=new DelieverProductDto();
        BeanUtils.copyProperties(product,delieverProductDto);
        delieverProductDto.setAttributeList(JSON.parseObject(product.getAttributeList()));
        delieverProductDto.setPublicAttribute(JSON.parseObject(product.getPublicAttribute()));
        String urls = product.getUrls();
        String[] as = urls.split(",");
        delieverProductDto.setUrls(as);
        return delieverProductDto;
    }

    public List<DelieverSimpleProductDto> selectByLimit(int limit, int size,String type) {
        ProductSelectParam productSelectParam=new ProductSelectParam();
        productSelectParam.setOffset(limit);
        productSelectParam.setSize(size);
        List<Long> longs=null;
        switch (type){
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
        Map<String,Object> map=new HashMap<>();
        map.put("page",limit);
        map.put("offsize",size);
        map.put("ids",longs);
        List<Product> products = productExMapper.selectByLimit(map);
        if(products==null||products.size()==0){
            return null;
        }
        Iterator<Product> iterator = products.iterator();
        List<DelieverSimpleProductDto> delieverSimpleProductDtos=new ArrayList<>();
        while (iterator.hasNext()){
            DelieverSimpleProductDto delieverSimpleProductDto=new DelieverSimpleProductDto();
            Product next = iterator.next();
            BeanUtils.copyProperties(next,delieverSimpleProductDto);
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
        if(productSpecs==null||productSpecs.size()==0){
            return null;
        }
        DeliverProductSpecsDto deliverProductSpecsDto=new DeliverProductSpecsDto();
         BeanUtils.copyProperties(productSpecs.get(0),deliverProductSpecsDto);
         deliverProductSpecsDto.setProductSpecs(JSON.parseObject(productSpecs.get(0).getProductSpecs()));
        return deliverProductSpecsDto;
    }
}
