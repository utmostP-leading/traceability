package com.sagroup.tracibility.controllers;

import com.sagroup.tracibility.entities.CommentEntity;
import com.sagroup.tracibility.entities.EventEntity;
import com.sagroup.tracibility.entities.EventNodeEntity;
import com.sagroup.tracibility.services.CommentService;
import com.sagroup.tracibility.services.EventNodeService;
import com.sagroup.tracibility.services.EventService;
import com.sagroup.tracibility.services.SubcriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    private EventNodeService eventNodeService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private SubcriptionService subcriptionService;

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

    //CRD
    @PostMapping("event")
    @ResponseBody
    public Map<String, Object> creatEvent(@RequestBody Map map){
        EventEntity event=new EventEntity(map.get("eventTitle").toString(),map.get("eventIntro").toString());
        int eventId=eventService.createEvent(event);
        List<EventNodeEntity> eventNodeList=new ArrayList<>();
        List<Map> list=(ArrayList<Map>)map.get("eventNodeList");

        for(int i=0;i<list.size();i++){
            EventNodeEntity eventNode=new EventNodeEntity(
                    eventId,
                    Integer.parseInt(list.get(i).get("eventNodeFever").toString()),
                    list.get(i).get("eventNodeTitle").toString(),
                    list.get(i).get("eventNodeDescription").toString(),
                    Integer.parseInt(list.get(i).get("positiveFever").toString()),
                    Integer.parseInt(list.get(i).get("neutralFever").toString()),
                    Integer.parseInt(list.get(i).get("negativeFever").toString()),
                    list.get(i).get("eventNodeTime").toString()
            );
            eventNodeService.createEventNode(eventNode);
        }

        //返回数据
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",201);
        return data;
    }

    //CRD
    @PutMapping("event")
    @ResponseBody
    public Map<String, Object> updateEvent(@RequestBody Map map){
        EventEntity event=new EventEntity(
                Integer.parseInt(map.get("eventId").toString()),
                map.get("eventTitle").toString(),
                map.get("eventIntro").toString());
        eventService.createEvent(event);
        subcriptionService.updateReadFlag(event.getEventId());

                    List<Map> list=(ArrayList<Map>)map.get("eventNodeList");
        for(int i=0;i<list.size();i++){
                        if(Integer.parseInt(list.get(i).get("eventNodeId").toString())==0){
                            EventNodeEntity eventNode=new EventNodeEntity(
                                    Integer.parseInt(list.get(i).get("eventId").toString()),
                                    Integer.parseInt(list.get(i).get("eventNodeFever").toString()),
                                    list.get(i).get("eventNodeTitle").toString(),
                                    list.get(i).get("eventNodeDescription").toString(),
                        Integer.parseInt(list.get(i).get("positiveFever").toString()),
                        Integer.parseInt(list.get(i).get("neutralFever").toString()),
                        Integer.parseInt(list.get(i).get("negativeFever").toString()),
                        list.get(i).get("eventNodeTime").toString()
                );
                eventNodeService.createEventNode(eventNode);
            }else{
                EventNodeEntity eventNode=new EventNodeEntity(
                        Integer.parseInt(list.get(i).get("eventNodeId").toString()),
                        Integer.parseInt(list.get(i).get("eventId").toString()),
                        Integer.parseInt(list.get(i).get("eventNodeFever").toString()),
                        list.get(i).get("eventNodeTitle").toString(),
                        list.get(i).get("eventNodeDescription").toString(),
                        Integer.parseInt(list.get(i).get("positiveFever").toString()),
                        Integer.parseInt(list.get(i).get("neutralFever").toString()),
                        Integer.parseInt(list.get(i).get("negativeFever").toString()),
                        list.get(i).get("eventNodeTime").toString()
                );
                eventNodeService.createEventNode(eventNode);
            }
        }

        List<Map> clist=(ArrayList<Map>)map.get("commentList");
        for(int i=0;i<clist.size();i++){
            CommentEntity comment=new CommentEntity(
                    Integer.parseInt(clist.get(i).get("commentId").toString()),
                    Integer.parseInt(clist.get(i).get("userId").toString()),
                    Integer.parseInt(clist.get(i).get("eventId").toString()),
                    clist.get(i).get("commentTime").toString(),
                    clist.get(i).get("commentContent").toString(),
                    Integer.parseInt(clist.get(i).get("reportFlag").toString()),
                    Integer.parseInt(clist.get(i).get("typicalFlag").toString()),
                    clist.get(i).get("reportReason").toString()
            );
            commentService.createComment(comment);
        }

        //返回数据
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",201);
        return data;
    }
}
