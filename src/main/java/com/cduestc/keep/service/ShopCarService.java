package com.cduestc.keep.service;

import com.cduestc.keep.dto.AchieveProductDTO;
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
    SportEquipmentMapper sportEquipmentMapper;
@Autowired
    SportWearMapper sportWearMapper;
@Autowired
    SportLifeMapper sportLifeMapper;
@Autowired
    SubstituteFoodMapper substituteFoodMapper;


   public Car insertShopCar(Car car, AchieveProductDTO achieveProductDTO){
       String type = achieveProductDTO.getType();
       switch (type){
           case "W":
               SportWear sportWear = sportWearMapper.selectByPrimaryKey(achieveProductDTO.getProductID());
              //判断商品是否在购物车里，在的话就将num加上接收过来的num参数，不在的话，新建一个productionItem
             if(!productIsExit(car,type,sportWear.getWearId(),achieveProductDTO)){
                 ProductItem productItem=new ProductItem();
                 productItem.setId(sportWear.getWearId());
                 productItem.setNumber(achieveProductDTO.getNumber());
                 productItem.setPrice(sportWear.getPrice());
                 productItem.setResourceUrl(sportWear.getImageUrl());
                 productItem.setTotalFee(productItem.getPrice()*productItem.getNumber());
                 productItem.setType(type);
                 productItem.setProductName(sportWear.getWearName());
                 car.getProductItems().add(productItem);
             }
               break;
           case "L":
               SportLife sportLife = sportLifeMapper.selectByPrimaryKey(achieveProductDTO.getProductID());
               if(!productIsExit(car,type,sportLife.getProductId(),achieveProductDTO)){
                   ProductItem productItem=new ProductItem();
                   productItem.setId(sportLife.getProductId());
                   productItem.setNumber(achieveProductDTO.getNumber());
                   productItem.setPrice(sportLife.getPrice());
                   productItem.setResourceUrl(sportLife.getImageUrl());
                   productItem.setTotalFee(productItem.getPrice()*productItem.getNumber());
                   productItem.setType(type);
                   productItem.setProductName(sportLife.getProductName());
                   car.getProductItems().add(productItem);
               }
               break;
           case "E":
               SportEquipment sportEquipment = sportEquipmentMapper.selectByPrimaryKey(achieveProductDTO.getProductID());
               if(!productIsExit(car,type,sportEquipment.getEquipmentId(),achieveProductDTO)){
                   ProductItem productItem=new ProductItem();
                   productItem.setId(sportEquipment.getEquipmentId());
                   productItem.setNumber(achieveProductDTO.getNumber());
                   productItem.setPrice(sportEquipment.getPrice());
                   productItem.setResourceUrl(sportEquipment.getImageUrl());
                   productItem.setTotalFee(productItem.getPrice()*productItem.getNumber());
                   productItem.setType(type);
                   productItem.setProductName(sportEquipment.getEquipmentName());
                   car.getProductItems().add(productItem);
               }
               break;
           case "S":
               SubstituteFood substituteFood = substituteFoodMapper.selectByPrimaryKey(achieveProductDTO.getProductID());
               if(!productIsExit(car,type,substituteFood.getFoodId(),achieveProductDTO)){
                   ProductItem productItem=new ProductItem();
                   productItem.setId(substituteFood.getFoodId());
                   productItem.setNumber(achieveProductDTO.getNumber());
                   productItem.setPrice(substituteFood.getPrice());
                   productItem.setResourceUrl(substituteFood.getImageUrl());
                   productItem.setTotalFee(productItem.getPrice()*productItem.getNumber());
                   productItem.setType(type);
                   productItem.setProductName(substituteFood.getFoodName());
                   car.getProductItems().add(productItem);
               }
               break;
}
         return car;
   }
   //辅助方法
   public  boolean productIsExit(Car car,String type,Long ID,AchieveProductDTO achieveProductDTO){
       List<ProductItem> productItems = car.getProductItems();
       if(productItems==null||productItems.size()==0){
           car.setSellerName("keep自营");
           car.setProductItems(new ArrayList<>());
           return false;
       }
       Iterator<ProductItem> iterator = productItems.iterator();
       while (iterator.hasNext()){
           ProductItem next = iterator.next();
           if(next.getType().equals(type)&&next.getId().equals(ID)){
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
                if(next1.getId()==next2.getId()&&next1.getType().equals(next2.getType())){//商品重复只需要将商品数量和总价算出即可
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
