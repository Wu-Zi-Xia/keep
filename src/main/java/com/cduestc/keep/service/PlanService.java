package com.cduestc.keep.service;

import com.cduestc.keep.dto.PlanDto;
import com.cduestc.keep.mapper.*;
import com.cduestc.keep.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class PlanService {
    @Autowired
    PlanMapper planMapper;
    @Autowired
    ArmSportsExMapper armSportsExMapper;
    @Autowired
    BackSportsExMapper backSportsExMapper;
    @Autowired
    BellySportsExMapper bellySportsExMapper;
    @Autowired
    ChestSportsExMapper chestSportsExMapper;
    @Autowired
    ForearmSportsExMapper forearmSportsExMapper;
    @Autowired
    ShankSportsExMapper shankSportsExMapper;
    @Autowired
    ThighSportsExMapper thighSportsExMapper;
    @Autowired
    ArmSportsMapper armSportsMapper;
    @Autowired
    BackSportsMapper backSportsMapper;
    @Autowired
    BellySportsMapper bellySportsMapper;
    @Autowired
    ChestSportsMapper chestSportsMapper;
    @Autowired
    ForearmSportsMapper forearmSportsMapper;
    @Autowired
    ShankSportsMapper shankSportsMapper;
    @Autowired
    ThighSportsMapper thighSportsMapper;
    @Autowired
    PlanProgressMapper planProgressMapper;
    @Autowired
    PlanExMapper planExMapper;

//创建一个计划 接口
    public int createPlan(PlanDto planDto, HttpServletRequest request, HttpServletResponse response) {
        String sportsType = planDto.getSportsType();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String[] arr = sportsType.split(","); // 用,分割
        Map<String, List<Integer>> idListMap = chooseSport(arr, planDto.getWeight());
        List<String> planStringList=new ArrayList<>();
        for(int i=0;i<planDto.getDays();i++){
            StringBuilder s=new StringBuilder();
            s.append("A"+Integer.toString(idListMap.get("A").get(getRandom(0,idListMap.get("A").size()))));
            s.append(",F"+Integer.toString(idListMap.get("F").get(getRandom(0,idListMap.get("F").size()))));
            s.append(",C"+Integer.toString(idListMap.get("C").get(getRandom(0,idListMap.get("C").size()))));
            s.append(",B"+Integer.toString(idListMap.get("B").get(getRandom(0,idListMap.get("B").size()))));
            s.append(",E"+Integer.toString(idListMap.get("E").get(getRandom(0,idListMap.get("E").size()))));
            s.append(",T"+Integer.toString(idListMap.get("T").get(getRandom(0,idListMap.get("T").size()))));
            s.append(",S" + Integer.toString(idListMap.get("S").get(getRandom(0, idListMap.get("S").size()))));
            planStringList.add(s.toString());
        }
          int insert=0;
        Iterator<String> iterator = planStringList.iterator();
        while (iterator.hasNext()){
            Plan plan=new Plan();
            plan.setSports(iterator.next());
            plan.setOwnerId(user.getUserId());
            plan.setState(0);
           insert=planMapper.insert(plan);
        }
        if(insert>0){//设置初始的计划的进程值
            PlanProgress planProgress=new PlanProgress();
            planProgress.setOwnerId(user.getUserId());
            planProgress.setCurrentState(count()-planDto.getDays());
            planProgress.setStartPlanid(count()-planDto.getDays());
            planProgress.setEndPlanid(count());
            Cookie cookie = new Cookie("PP","PP");   // 新建Cookie
            cookie.setMaxAge(Integer.MAX_VALUE);// 设置生命周期为MAX_VALUE
            response.addCookie(cookie);
            // 输出到客户端
            request.getSession().setAttribute("PP",planProgress);//将 计划进程 放入session中
            planProgressMapper.insert(planProgress);
        }
           return insert;

    }

    //修改当前计划为已经完成的状态 接口
    public int updateState(HttpServletRequest request){
        User user =(User) request.getSession().getAttribute("user");
        Plan plan=new Plan();
        plan.setState(1);
        PlanExample planExample=new PlanExample();
        planExample.createCriteria().andOwnerIdEqualTo(user.getUserId());
        int i = planMapper.updateByExampleSelective(plan, planExample);
        return i;
    }

    //获取所有的计划 接口
    public List<Plan> getAllPlansByUserId(HttpServletRequest request) {
        PlanExample planExample=new PlanExample();
        User user = (User) request.getSession().getAttribute("user");
        planExample.createCriteria().andOwnerIdEqualTo(user.getUserId());
        List<Plan> plans = planMapper.selectByExample(planExample);
        if(plans==null||plans.size()==0){
            return null;
        }
        return plans;
    }


    //获取到用户选择的运动的所有id的集合的map 辅助方法
    public Map<String,List<Integer>> chooseSport(String[] strings,int weight){
        Map<String,List<Integer>> idListMap=new HashMap<>();
        for (String a:strings){
            switch (a){
                case"A":
                    List<Integer> integersA = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("A",integersA);
                    break;
                case"F":
                    List<Integer> integersF = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("F",integersF);
                    break;
                case"C":
                    List<Integer> integersC = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("C",integersC);
                    break;
                case"B":
                    List<Integer> integersB = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("B",integersB);
                    break;
                case"E":
                    List<Integer> integersE = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("E",integersE);
                    break;
                case"T":
                    List<Integer> integersT = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("T",integersT);
                    break;
                case"S":
                    List<Integer> integersS = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("S",integersS);
                    break;
            }
        }
        return idListMap;
    }

    //获取随机数 辅助方法
    public  int getRandom(int start,int end) {

        int num=(int) (Math.random()*(end-start+1)+start);
        return num;
    }

    //获取当前表的数据的总数 辅助方法
    public Long count(){
        return planExMapper.count();

    }
}
