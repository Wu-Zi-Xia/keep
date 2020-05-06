package com.cduestc.keep.controller;

import com.cduestc.keep.dto.*;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.model.*;
import com.cduestc.keep.pojo.ProductSimpleINFO;
import com.cduestc.keep.provider.shopcarqueue.ProductStack;
import com.cduestc.keep.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Autowired
    UserRecordService userRecordService;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
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
    public @ResponseBody Object getFourProducts(@RequestParam(name = "id") Long id,
                                                HttpServletRequest request){
        //获取cookie
        String token = request.getHeader("token");
        //获取登录的用户id
        User user = (User)request.getSession().getAttribute(sessionNamePre+token);
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        DelieverProductDto productById = productService.getProductById(id);
        //可以异步的去添加到userRecord里面
        UserRecord userRecord=new UserRecord();
        userRecord.setProductId(id);
        userRecord.setOwnerId(user.getUserId());
        userRecordService.insertUserRecord(userRecord);
        return productById;
    }
    @RequestMapping("getProductDetils")
    public @ResponseBody Object  getProduct(@RequestBody AchieveProductDTO achieveProductDTO)
    {
        DeliverProductSpecsDto detils = productService.getDetils(achieveProductDTO);

        return ResultDto.oxOf(detils);
    }
    @RequestMapping("guessLike")
    public @ResponseBody Object guessLike(HttpServletRequest request,
                                          @RequestParam(name= "page",defaultValue = "1") int page,
                                          @RequestParam(name = "size",defaultValue= "10",required = false) int size){
        //获取cookie
        String token = request.getHeader("token");
        //获取登录的用户id
        User user = (User)request.getSession().getAttribute(sessionNamePre+token);
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        List<DelieverSimpleProductDto> products = productService.guessLike(user.getUserId(), page, size);
        return ResultDto.oxOf(products);
    }


}
