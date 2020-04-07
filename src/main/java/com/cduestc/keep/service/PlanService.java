package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.AchievePlanDto;
import com.cduestc.keep.dto.DeliverPlanDTO;
import com.cduestc.keep.mapper.*;
import com.cduestc.keep.model.*;
import com.cduestc.keep.provider.Sports;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    PlanProgressExMapper planProgressExMapper;
    @Autowired
    PlanExMapper planExMapper;
    @Autowired
    RedisPlanService redisPlanService;
    @Autowired
    RedisPlanProgressService redisPlanProgressService;
    @Autowired
    RedisTemplate redisTemplate;

    //创建一个计划 接口
    public int createPlan(AchievePlanDto planDto, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String redisTableName="user:"+user.getUserId()+":plan:*";
        //将redis中的计划表删除(这样可以使得用户访问到redis的时候是会去mysql中找最新的值)
        if(redisTemplate.keys(redisTableName)!=null){
             redisTemplate.delete(redisTableName);
        }
        String sportsType = planDto.getSportsType();
        String[] arr = sportsType.split(","); // 用,分割
        Map<String,List> idListMap = chooseSport(arr, planDto.getWeight());
        List<String> planStringList=new ArrayList<>();
        for(int i=0;i<planDto.getDays();i++){
            StringBuilder s=new StringBuilder();
            if(idListMap.get("A")!=null){

                s.append("A"+(idListMap.get("A").get(getRandom(0,idListMap.get("A").size()-1))));
            }
            if(idListMap.get("F")!=null){

                s.append(",F"+(idListMap.get("F").get(getRandom(0,idListMap.get("F").size()-1))));
            }
            if(idListMap.get("C")!=null){

                s.append(",C"+(idListMap.get("C").get(getRandom(0,idListMap.get("C").size()-1))));
            }
            if(idListMap.get("B")!=null){

                s.append(",B"+(idListMap.get("B").get(getRandom(0,idListMap.get("B").size()-1))));
            }

            if(idListMap.get("E")!=null){

                s.append(",E"+(idListMap.get("E").get(getRandom(0,idListMap.get("E").size()-1))));
            }
            if(idListMap.get("T")!=null){

                s.append(",T"+(idListMap.get("T").get(getRandom(0,idListMap.get("T").size()-1))));
            }
            if(idListMap.get("S")!=null){

                s.append(",S" +(idListMap.get("S").get(getRandom(0,idListMap.get("S").size()-1))));
            }

            planStringList.add(s.toString());
        }
          int insert=0;
        Iterator<String> iterator = planStringList.iterator();
        int i=0;
        while (iterator.hasNext()){
            i++;
            Plan plan=new Plan();
            String next = iterator.next();
            plan.setSports(next);
            plan.setOwnerId(user.getUserId());
            plan.setState(0);
            insert=planExMapper.insert(plan);
            String redisTableName1 = "user:" + user.getUserId() + ":plan:" + plan.getPlanId();
            //同步到redis中
            redisPlanService.insert(redisTableName1,plan);
            if(i==planDto.getDays()){//设置初始的计划的进程值(可以异步的去做)
                PlanProgress planProgress=new PlanProgress();
                planProgress.setOwnerId(user.getUserId());
                planProgress.setCurrentState(plan.getPlanId()-planDto.getDays()+1);
                planProgress.setStartPlanid(plan.getPlanId()-planDto.getDays()+1);
                planProgress.setEndPlanid(plan.getPlanId());
                //插入数据库，并且ID会返回在planProgress的planProgressid
                planProgressExMapper.insert(planProgress);
                //同步到redis
                String redisTableName3="user:"+user.getUserId()+":PP:"+planProgress.getPlanProgressid();
                redisPlanProgressService.insert(redisTableName3,planProgress);
            }
        }
           return insert;

    }



    //修改当前计划为已经完成的状态 接口
    public int updateState(Long ID,User user){
        String redisTableName="user:"+user.getUserId()+":plan:"+ID;
        Plan plan=new Plan();
        plan.setPlanId(ID);
        plan.setState(1);
        //修改数据库中的状态
        int i = planMapper.updateByPrimaryKeySelective(plan);
        //同步到redis中
        if(redisTemplate.keys(redisTableName).size()==0){//同步到redis中
            PlanExample planExample=new PlanExample();
            planExample.createCriteria().andOwnerIdEqualTo(user.getUserId());
            List<Plan> plans = planMapper.selectByExample(planExample);
            Iterator<Plan> iterator = plans.iterator();
            while (iterator.hasNext()){
                Plan next = iterator.next();
                redisPlanService.insert("user:"+user.getUserId()+":plan:"+plan.getPlanId(),next);
            }

        }
        else{//如果redis里面有这个键值，那么就直接改变这个键值
            redisTemplate.opsForHash().put(redisTableName,"state",1);
        }
        return i;
    }


    //获取所有的计划 接口
    public List<DeliverPlanDTO> getAllPlansByUserId(HttpServletRequest request) {
        List<DeliverPlanDTO> deliverPlanDTOS=new ArrayList<>();
        PlanExample planExample=new PlanExample();
        User user = (User) request.getSession().getAttribute("user");
        planExample.createCriteria().andOwnerIdEqualTo(user.getUserId());
        List<Plan> plans = planMapper.selectByExample(planExample);
        Long currentState=0l;//当前运动的状态
        if(plans==null||plans.size()==0){
            return null;
        }
        else{
            if(redisTemplate.keys("user:"+user.getUserId()+":PP:*").size()==0){//判断计划进程表是否存在于redis中
                //查询计划进程表
                //将计划的状态同步到redis
                PlanProgressExample planProgress=new PlanProgressExample();
                planProgress.createCriteria().andOwnerIdEqualTo(user.getUserId());
                List<PlanProgress> planProgresses = planProgressMapper.selectByExample(planProgress);
                String redisTableName3="user:"+user.getUserId()+":PP:"+planProgresses.get(0).getPlanProgressid();
                redisPlanProgressService.insert(redisTableName3,planProgresses.get(0));
                currentState=planProgresses.get(0).getCurrentState();
            }
              //将计划表同步到redis中
            Iterator<Plan> iterator = plans.iterator();
            while(iterator.hasNext()){
                Plan next = iterator.next();
                DeliverPlanDTO deliverPlanDTO=new DeliverPlanDTO();
                deliverPlanDTO.setState(next.getState());
                deliverPlanDTO.setPlanId(next.getPlanId());
                deliverPlanDTO.setSports(getSportsURLS(next.getSports()));
                if(deliverPlanDTO.getPlanId().equals(currentState)){
                 deliverPlanDTO.setCurrent(true);
                }
                 deliverPlanDTOS.add(deliverPlanDTO);
                 //运动计划同步到redis中
                    Map<String,Object> map = JSONObject.parseObject(JSON.toJSONString(next));
                    redisTemplate.opsForHash().putAll("user:"+user.getUserId()+":plan:"+next.getPlanId(),map);

                }
            }
        return deliverPlanDTOS;
    }


    //获取到用户选择的运动的所有id的集合的map 辅助方法
    public Map<String,List> chooseSport(String[] strings,int weight){
        Map<String,List> idListMap=new HashMap<>();
        for (String a:strings){
            switch (a){
                case"A":
                    List integersA = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("A",integersA);
                    break;
                case"F":
                    List integersF = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("F",integersF);
                    break;
                case"C":
                    List integersC = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("C",integersC);
                    break;
                case"B":
                    List integersB = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("B",integersB);
                    break;
                case"E":
                    List integersE = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("E",integersE);
                    break;
                case"T":
                    List integersT = armSportsExMapper.selectIdByWeight(weight);
                    idListMap.put("T",integersT);
                    break;
                case"S":
                    List integersS = armSportsExMapper.selectIdByWeight(weight);
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


    //A：大臂，F：小臂，C：胸部，B：背部，E：腹部，T：大腿，S：小腿
    //辅助方法,获取运动的地址
    private List<Sports> getSportsURLS(String sportsString){
        List<Sports> sportsList=new ArrayList<>();
        String[] arr = sportsString.split(","); // 用,分割
        Map a;
        Sports sports=new Sports();
        JSON o;
        String sportsID;
        for(int i=0;i<arr.length;i++){
            char c = arr[i].charAt(0);
            switch (c){
                case 'A':
                    sportsID=arr[i].substring(1);
                    ArmSports armSports;
                    armSports=armSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                    BeanUtils.copyProperties(armSports,sports);
                    sportsList.add(sports);
                    break;
                case 'F':
                    sportsID= arr[i].substring(1);
                    ForearmSports forearmSports;
                    forearmSports=forearmSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                    BeanUtils.copyProperties(forearmSports,sports);
                    sportsList.add(sports);
                    break;
                case 'C':
                    sportsID=arr[i].substring(1);
                    ChestSports chestSports;
                    chestSports=chestSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                    BeanUtils.copyProperties(chestSports,sports);
                    sportsList.add(sports);
                    break;
                case 'B':
                    sportsID=arr[i].substring(1);
                    BackSports backSports;
                    backSports=backSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                    BeanUtils.copyProperties(backSports,sports);
                    sportsList.add(sports);
                    break;
                case 'E':
                    sportsID=arr[i].substring(1);
                   BellySports bellySports;
                   bellySports=bellySportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                   BeanUtils.copyProperties(bellySports,sports);
                sportsList.add(sports);
                    break;
                case 'T':
                    sportsID=arr[i].substring(1);
                   ThighSports thighSports;
                   thighSports=thighSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                   BeanUtils.copyProperties(thighSports,sports);
                   sportsList.add(sports);
                    break;
                case 'S':
                    sportsID=arr[i].substring(1);
                    ShankSports shankSports;
                    shankSports=shankSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                    BeanUtils.copyProperties(shankSports,sports);
                    sportsList.add(sports);
                    break;
            }
        }
        return sportsList;
    }
}



