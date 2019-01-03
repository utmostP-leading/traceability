package com.sagroup.tracibility.controllers;

import com.sagroup.tracibility.entities.EventEntity;
import com.sagroup.tracibility.entities.Subscribe;
import com.sagroup.tracibility.services.EventService;
import com.sagroup.tracibility.services.SubcriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@RestController
@RequestMapping("v1")
public class EventDisplayController {

    @Autowired
    private EventService eventService;
    @Autowired
    private SubcriptionService subcriptionService;

    //CRD
    @GetMapping("recEvents")
    @ResponseBody
    public Map<String, Object> getAllRecEvents(){
        List<EventEntity> recEventList=eventService.getAllRecEvents();
        //返回数据
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",200);
        data.put("recEventList",recEventList);
        return data;
    }

    //CRD
    @GetMapping("subEvents/{userId}")
    @ResponseBody
    public Map<String, Object> getAllSubEvents(@PathVariable int userId){
        List<Subscribe> subEventIdList=subcriptionService.getSubEvents(userId);
        List<EventEntity> subEventList=eventService.getAllSubEvents(subEventIdList);
        //返回数据
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",200);
        data.put("subEventList",subEventList);
        return data;
    }
}
