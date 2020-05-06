package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.cduestc.keep.dto.AchieveProductDTO;
import com.cduestc.keep.dto.AchieveShopCarProductDto;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.mapper.*;
import com.cduestc.keep.model.*;
import com.cduestc.keep.pojo.Car;
import com.cduestc.keep.pojo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ShopCarService {
    //W:运动服饰，L：运动生活，E：运动装备，S：轻食代餐
@Autowired
ProductSpecsMapper productSpecsMapper;
@Autowired
ProductMapper productMapper;
@Autowired
UserRecordService userRecordService;


   public Car insertShopCar(Car car, AchieveShopCarProductDto achieveProductDTO){
       car.setId(achieveProductDTO.getProductId());
       Product product = productMapper.selectByPrimaryKey(achieveProductDTO.getProductId());
       if(product==null){
           throw new CustomizeException(CustomizeErrorCode.PRODUCT_NOT_FOUND);
       }
       ProductSpecs productSpecs = productSpecsMapper.selectByPrimaryKey(achieveProductDTO.getId());
       if(productSpecs==null){
           throw new CustomizeException(CustomizeErrorCode.PRODUCT_NOT_FOUND);
       }

       //判断商品是否在购物车里，在的话就将num加上接收过来的num参数，不在的话，新建一个productionItem
             if(!productIsExit(car,achieveProductDTO)){
                 ProductItem productItem=new ProductItem();
                 productItem.setId(achieveProductDTO.getId());
                 productItem.setNumber(achieveProductDTO.getNumber());
                 productItem.setPrice(productSpecs.getProductPrice());
                 productItem.setResourceUrl(productSpecs.getUrl());
                 productItem.setTotalFee(productItem.getPrice()*productItem.getNumber());
                 productItem.setProductName(product.getName());
                 productItem.setProductSpecs(JSON.parseObject(productSpecs.getProductSpecs()));
                 car.getProductItems().add(productItem);
}
         return car;
   }
   //辅助方法
   public  boolean productIsExit(Car car,AchieveShopCarProductDto achieveProductDTO){
       List<ProductItem> productItems = car.getProductItems();
       if(productItems==null||productItems.size()==0){
           car.setId(achieveProductDTO.getProductId());
           car.setSellerName("keep自营");
           car.setProductItems(new ArrayList<>());
           return false;
       }
       Iterator<ProductItem> iterator = productItems.iterator();
       while (iterator.hasNext()){
           ProductItem next = iterator.next();
           if(next.getId().equals(achieveProductDTO.getId())){
               next.setNumber(next.getNumber()+achieveProductDTO.getNumber());
              //当明细数量小于等于0,移除此商品
               if(next.getNumber()<=0){
                   productItems.remove(next);
               }
               //当购物车里面的商品数量为空的时候，置空购物车
               if(productItems.size()<=0){
                   car.setProductItems(null);
               }
               next.setTotalFee(next.getPrice()*next.getNumber());
               return true;
           }
       }
       return false;
   }
  //合并购物车
    public Car mergeShopCar(Car car1,Car car2){
       if(car1==null||car1.getProductItems()==null){
           return car2;
       }
       if(car2==null||car2.getProductItems()==null){
           return car1;
       }
        List<ProductItem> productItems1 = car1.getProductItems();

        for(int i=0;i<productItems1.size();i++){
            ProductItem next1 = productItems1.get(i);//car1中的每个商品详情
            List<ProductItem> productItems2 = car2.getProductItems();
            for(int j=0;j<productItems2.size();j++){
                ProductItem next2 = productItems2.get(j);
                if(next1.getId()==next2.getId()){//商品重复只需要将商品数量和总价算出即可
                   next1.setNumber(next1.getNumber()+next2.getNumber());
                   next1.setTotalFee(next1.getNumber()*next1.getPrice());
                   productItems2.remove(next2);
                }
                else{ //不重复，将商品添加到car1的商品详情里面
                    productItems1.add(next2);
                    productItems2.remove(next2);
                }
            }


        }
        return car1;
    }

}
