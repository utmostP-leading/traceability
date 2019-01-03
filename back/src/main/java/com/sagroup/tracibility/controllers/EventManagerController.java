package com.sagroup.tracibility.controllers;

import com.sagroup.tracibility.entities.EventEntity;
import com.sagroup.tracibility.services.EventService;
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
public class EventManagerController {

    @Autowired
    private EventService eventService;

    //CRD
    @GetMapping("events")
    @ResponseBody
    public Map<String, Object> getAllEvents(){
        List<EventEntity> eventList=eventService.getAllEvents();
        //返回数据
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",200);
        data.put("eventList",eventList);
        return data;
    }

    //CRD
    @DeleteMapping("event/{eventId}")
    @ResponseBody
    public Map<String, Object> deleteEvent(@PathVariable int eventId){
        eventService.deleteEvent(eventId);
        //返回数据
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",204);
        return data;
    }
}
