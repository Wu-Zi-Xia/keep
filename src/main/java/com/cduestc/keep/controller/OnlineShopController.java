package com.cduestc.keep.controller;

import com.cduestc.keep.dto.*;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.model.*;
import com.cduestc.keep.pojo.ProductSimpleINFO;
import com.cduestc.keep.provider.shopcarqueue.ProductStack;
import com.cduestc.keep.service.OnlineShopService;
import com.cduestc.keep.service.ProductService;
import com.cduestc.keep.service.ShopCarService;
import com.cduestc.keep.service.SportsEquipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
@Slf4j
//关于商品的搜索
@Controller
public class OnlineShopController {
    @Autowired
    OnlineShopService onlineShopService;
    @Autowired
    ShopCarService shopCarService;
    @Autowired
    ProductService productService;
    @RequestMapping("getProducts")
    public @ResponseBody
    Object getProducts(
            @RequestParam(value = "limit",defaultValue ="0") long limit,
            @RequestParam(value = "size",defaultValue = "20") long size,
            @RequestParam(value = "type",required = false) String type){
        List<DelieverSimpleProductDto> products = productService.selectByLimit(limit, size, type);
        if(products==null){
          return ResultDto.errorOf(500,"已经到底了！！");
        }
        return ResultDto.oxOf(products);
    }

    @RequestMapping("search")
    @ResponseBody
    public Object search(@RequestParam(value = "search",required = false) String search,
                         @RequestParam("limit") long limit,
                         @RequestParam("size") long size){
        List<ProductSimpleINFO> search1 = onlineShopService.search(search, limit, size);
            return ResultDto.oxOf(search1);
    }

    @RequestMapping("getProductById")
    public @ResponseBody Object getFourProducts(@RequestParam(name = "id") Long id){
        DelieverProductDto productById = productService.getProductById(id);

        return productById;
    }
    @RequestMapping("getProductDetils")
    public @ResponseBody Object  getProduct(@RequestBody AchieveProductDTO achieveProductDTO)
    {
        DeliverProductSpecsDto detils = productService.getDetils(achieveProductDTO);

        return ResultDto.oxOf(detils);
    }



}
