package com.cduestc.keep.controller;

import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.dto.SportsEquipmentResultDto;
import com.cduestc.keep.model.ShopCar;
import com.cduestc.keep.model.SportEquipment;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.shopcarqueue.ProductStack;
import com.cduestc.keep.service.ShopCarService;
import com.cduestc.keep.service.SportsEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
//关于商品的搜索
@Controller
public class OnlineShopController {
    @Autowired
    SportsEquipmentService sportsEquipmentService;
    @Autowired
    ShopCarService shopCarService;
    @RequestMapping("shop/getSportsEquipment")
    public @ResponseBody
    Object getSportsEquipment(
            @RequestParam(value = "page",defaultValue ="1") int page,
            @RequestParam(value = "size",defaultValue = "20") int size,
            @RequestParam("type") String type,
            @RequestParam(value = "search",required =false) String search){
        if(search==null){//证明用户没有使用搜索的功能
            SportsEquipmentResultDto sportsEquipmentList = sportsEquipmentService.getByTag(type,page,size);
            return ResultDto.oxOf(sportsEquipmentList);
        }
        //加了搜索条件
        List<SportEquipment> sportEquipments = sportsEquipmentService.selectBySearch(page, size, search,type);
        return ResultDto.oxOf(sportEquipments);
    }

    @RequestMapping("shop/getProductByID")
    @ResponseBody
    public SportEquipment getSportsEquipmentById(@RequestParam("id")Integer id){
        SportEquipment sportEquipment = sportsEquipmentService.getByID(id);
        return sportEquipment;
    }
}
