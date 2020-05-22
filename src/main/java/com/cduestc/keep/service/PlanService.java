package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.AchievePlanDto;
import com.cduestc.keep.dto.DeliverPlanDTO;
import com.cduestc.keep.dto.UpdatePlanProgressDTO;
import com.cduestc.keep.mapper.*;
import com.cduestc.keep.model.*;
import com.cduestc.keep.provider.Sports;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Autowired
    PlanProgressService planProgressService;
    @Value("${redis.keep.planTable}")
    String redisPlanTable;
    @Value("${redis.keep.planSort}")
    String redisPlanSort;
    //创建一个计划 接口
    public int createPlan(AchievePlanDto planDto, User user, HttpServletResponse response) {
        int insert=0;
        Integer planState= planProgressExMapper.selectStateByOwnerId(user.getUserId());
        //将redis中的计划表删除(这样可以使得用户访问到redis的时候是会去mysql中找最新的值)
        if(redisTemplate.hasKey(redisPlanSort+user.getUserId())){
            //如果已经存在与redis中，那么就删除redis中的数据
            //删除计划的sort集合
            Set planIds= redisTemplate.opsForZSet().range(redisPlanSort + user.getUserId(), 0, -1);
            Iterator iterator = planIds.iterator();
           //删除每一条计划
            while (iterator.hasNext()){
                Object next = iterator.next();
                redisTemplate.delete(next);
            }
        }
        String sportsType = planDto.getSportsType();
        String[] arr = sportsType.split(","); // 用,分割
        Map<String,List> idListMap = chooseSport(arr, planDto.getWeight());
        List<String> planStringList=new ArrayList<>();
        for(int i=0;i<planDto.getDays();i++){
            StringBuilder s=new StringBuilder();
            int j=5;
            while(j>0){
                if(idListMap.get("A")!=null){
                    s.append(",A"+(idListMap.get("A").get(getRandom(0,idListMap.get("A").size()-1))));
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
                if(idListMap.get("S")!=null){

                    s.append(",S" +(idListMap.get("S").get(getRandom(0,idListMap.get("S").size()-1))));
                }
                j--;
        }
        planStringList.add(s.toString().substring(1));
        }
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
            if(i==planDto.getDays()){//设置初始的计划的进程值(可以异步的去做)
                PlanProgress planProgress=new PlanProgress();
                planProgress.setOwnerId(user.getUserId());
                planProgress.setCurrentState(plan.getPlanId()-planDto.getDays()+1);
                planProgress.setStartPlanid(plan.getPlanId()-planDto.getDays()+1);
                planProgress.setEndPlanid(plan.getPlanId());
                planProgress.setState(0);
                //插入数据库，并且ID会返回在planProgress的planProgressid
                planProgressExMapper.insert(planProgress);
            }
        }
           return insert;
    }



    //修改当前计划为已经完成的状态 接口
    public int updateState(Long ID,User user){
        PlanProgressExample planProgressExample=new PlanProgressExample();
        planProgressExample.createCriteria().andOwnerIdEqualTo(user.getUserId());
        List<PlanProgress> planProgresses = planProgressMapper.selectByExample(planProgressExample);
        //证明用户已经完成了计划
        if(planProgresses.get(0).getCurrentState().longValue()==planProgresses.get(0).getEndPlanid().longValue()){
            UpdatePlanProgressDTO u=new UpdatePlanProgressDTO();
            u.setUserId(user.getUserId());
            u.setStatus(1l);
            planProgressExMapper.updateState(u);
        }
        Plan plan=new Plan();
        plan.setPlanId(ID);
        plan.setState(1);
        int i = planMapper.updateByPrimaryKeySelective(plan);
        return i;
    }




    //获取所有的计划 接口
    public List<DeliverPlanDTO> getAllPlansByUserId(User user) {
        List<DeliverPlanDTO> deliverPlanDTOS=new ArrayList<>();
        //获取所有的计划的信息
        PlanExample planExample=new PlanExample();
        planExample.createCriteria().andOwnerIdEqualTo(user.getUserId());
        List<Plan> plans = planMapper.selectByExample(planExample);

        //如果没有计划，就返会null
        if(plans==null||plans.size()==0){
            return null;
        }
        //当前计划的状态
        Long currentState=planProgressExMapper.selectCurrentStateByOwnerId(user.getUserId());
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
            redisTemplate.opsForZSet().add(
                    redisPlanSort+user.getUserId(),
                    redisPlanTable+next.getPlanId(),
                    next.getPlanId());
                    Map<String,Object> map = JSONObject.parseObject(JSON.toJSONString(deliverPlanDTO));
                    redisTemplate.opsForHash().putAll(redisPlanTable+deliverPlanDTO.getPlanId(),map);
        }
        return deliverPlanDTOS;
    }


    //获取到用户选择的运动的所有id的集合的map 辅助方法
    public Map<String,List> chooseSport(String[] strings,int weight){
        Map<String,List> idListMap=new HashMap<>();
        for (String a:strings){
            switch (a){
                case"A":
                    List<Long> integersA = armSportsExMapper.selectIdByWeight(weight);
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
    public List<Sports> getSportsURLS(String sportsString){
        List<Sports> sportsList=new ArrayList<>();
        String[] arr = sportsString.split(","); // 用,分割
        Map a;
        JSON o;
        String sportsID;
        for(int i=0;i<arr.length;i++){
            char c = arr[i].charAt(0);
            switch (c){
                case 'A':
                    sportsID=arr[i].substring(1);
                    ArmSports armSports;
                    Sports sports1 = new Sports();
                    armSports=armSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                    BeanUtils.copyProperties(armSports,sports1);
                    sportsList.add(sports1);
                    break;
                case 'F':
                    sportsID= arr[i].substring(1);
                    ForearmSports forearmSports;
                    Sports sports2 = new Sports();
                    forearmSports=forearmSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                    BeanUtils.copyProperties(forearmSports,sports2);
                    sportsList.add(sports2);
                    break;
                case 'C':
                    sportsID=arr[i].substring(1);
                    ChestSports chestSports;
                    Sports sports3 = new Sports();
                    chestSports=chestSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                    BeanUtils.copyProperties(chestSports,sports3);
                    sportsList.add(sports3);
                    break;
                case 'B':
                    sportsID=arr[i].substring(1);
                    BackSports backSports;
                    Sports sports4 = new Sports();
                    backSports=backSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                    BeanUtils.copyProperties(backSports,sports4);
                    sportsList.add(sports4);
                    break;
                case 'E':
                    sportsID=arr[i].substring(1);
                   BellySports bellySports;
                    Sports sports5 = new Sports();
                   bellySports=bellySportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                   BeanUtils.copyProperties(bellySports,sports5);
                sportsList.add(sports5);
                    break;
                case 'T':
                    sportsID=arr[i].substring(1);
                   ThighSports thighSports;
                    Sports sports6 = new Sports();
                   thighSports=thighSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                   BeanUtils.copyProperties(thighSports,sports6);
                   sportsList.add(sports6);
                    break;
                case 'S':
                    sportsID=arr[i].substring(1);
                    ShankSports shankSports;
                    Sports sports7 = new Sports();
                    shankSports=shankSportsMapper.selectByPrimaryKey(Long.parseLong(sportsID));
                    BeanUtils.copyProperties(shankSports,sports7);
                    sportsList.add(sports7);
                    break;
            }
        }
        return sportsList;
    }

    public void deletePlan(Long userId) {
        //删除计划
        PlanExample planExample=new PlanExample();
        planExample.createCriteria().andOwnerIdEqualTo(userId);
        planMapper.deleteByExample(planExample);
        //删除计划进程表
        PlanProgressExample planProgressExample=new PlanProgressExample();
        planProgressExample.createCriteria().andOwnerIdEqualTo(userId);
        planProgressMapper.deleteByExample(planProgressExample);
    }

    public boolean hasPlan(Long userId) {
        PlanExample planExample=new PlanExample();
        planExample.createCriteria().andOwnerIdEqualTo(userId);
        List<Plan> plans = planMapper.selectByExample(planExample);
        if(plans.size()!=0){
            return true;
        }
        else {
            return false;
        }
    }
}



