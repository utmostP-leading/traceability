package com.sagroup.tracibility.controllers;

import com.sagroup.tracibility.services.EventService;
import com.sagroup.tracibility.services.SubcriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@RestController
@RequestMapping("v1")
public class SubscriptionController {

    @Autowired
    private SubcriptionService subcriptionService;
    @Autowired
    private EventService eventService;

    @PostMapping("subscribe")
    @ResponseBody
    public Map<String, Object> addSubscription(@RequestBody Map map){
        System.out.println("addSubscription!");
        //新增订阅记录
        subcriptionService.addSubscription(
                Integer.parseInt(map.get("userId").toString().trim()),
                Integer.parseInt(map.get("eventId").toString().trim()));
        //更新事件订阅数
        eventService.increaseEventSubNum(Integer.parseInt(map.get("userId").toString().trim()));

        //返回数据
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode","201");
        return data;
    }

    @DeleteMapping("subscribe")
    @ResponseBody
    public Map<String, Object> cancelSubscription(@RequestBody Map map){
        System.out.println("cancelSubscription!");
        //删除订阅记录
        subcriptionService.cancelSubscription(
                Integer.parseInt(map.get("userId").toString().trim()),
                Integer.parseInt(map.get("eventId").toString().trim()));
        //更新事件订阅数
        eventService.decreaseEventSubNum(Integer.parseInt(map.get("userId").toString().trim()));

        //返回数据
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode","204");
        return data;
    }

}
