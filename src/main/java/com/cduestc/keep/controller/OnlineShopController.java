package com.cduestc.keep.controller;

import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.dto.SportsEquipmentResultDto;
import com.cduestc.keep.model.SportEquipment;
import com.cduestc.keep.provider.shopcarqueue.ProductStack;
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

@Controller
public class OnlineShopController {
    @Autowired
    SportsEquipmentService sportsEquipmentService;
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
    @RequestMapping("shop/getSportsEquipmentByID")
    @ResponseBody
    public SportEquipment getSportsEquipmentById(@RequestParam("id")Integer id){
        SportEquipment sportEquipment = sportsEquipmentService.getByID(id);
        return sportEquipment;
    }

    @RequestMapping("addProduct1")
    @ResponseBody
    public Object addProductToShopCar(HttpServletRequest request,
                                    @RequestParam("id")Long id,
                                    HttpServletResponse response){
        SportsEquipmentResultDto sportsEquipmentShopCar = sportsEquipmentService.getSomethingByID(id);
        ProductStack<SportsEquipmentResultDto> stack=new ProductStack<>();

        //判断是否是第一次进行进行购物,是第一次就新建一个栈
        if(request.getSession().getAttribute("isFirst")==null||(int)request.getSession().getAttribute("isFirst")==1){
            ProductStack instance = stack.getInstance(SportsEquipmentResultDto.class, 20);
            instance.push(sportsEquipmentShopCar);
            request.getSession().setAttribute("isFirst",0);
            request.getSession().setAttribute("sportsEquipmentShopCar",instance);
            Cookie cookie=new Cookie("sportsEquipmentShopCar","sportsEquipmentShopCar");
            cookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie);
        }
        else {//不是第一次就从session里面取
            ProductStack<SportsEquipmentResultDto> productStack = null;
            Cookie[] cookies = request.getCookies();
            if(cookies!=null){
                for(Cookie cookie:cookies){
                    if("sportsEquipmentShopCar".equals(cookie.getName())){
                        productStack=(ProductStack<SportsEquipmentResultDto>) request.getSession().getAttribute(cookie.getValue());
                        break;
                    }
                }
                return new ResultDto<>(500,"您还没有添加到购物车哦！！");
            }
            productStack.push(sportsEquipmentShopCar);
            request.getSession().setAttribute("sportsEquipmentShopCar",productStack);
        }
        return new ResultDto(200,"添加购物车成功！！");
    }
    @RequestMapping("getShopCar")
    @ResponseBody
    //获取整个购物车
    public Object getShopCar(HttpServletRequest request,HttpServletResponse response){
        ProductStack<SportsEquipmentResultDto> productStack = null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if("sportsEquipmentShopCar".equals(cookie.getName())){
                   productStack=(ProductStack<SportsEquipmentResultDto>) request.getSession().getAttribute(cookie.getValue());
                   break;
                }
            }
            return new ResultDto<>(500,"您还没有添加到购物车哦！！");
        }
        SportsEquipmentResultDto[] resultDto1 = productStack.getStack();
        SportsEquipmentResultDto[] resultDto2 = new SportsEquipmentResultDto[productStack.getCurrentSize()];
        for(int j=productStack.getCurrentSize()-1,i=0;j>=0;j--){
            resultDto2[i]=resultDto1[j];
            i++;
        }
            return resultDto2;
    }
}
