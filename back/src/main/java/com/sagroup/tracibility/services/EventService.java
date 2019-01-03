package com.sagroup.tracibility.services;

import com.sagroup.tracibility.daos.EventDao;
import com.sagroup.tracibility.entities.EventEntity;
import com.sagroup.tracibility.entities.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Service
public class EventService {

    @Autowired
    private EventDao eventDao;

    public void increaseEventSubNum(int eventId){
        EventEntity eventEntity=new EventEntity();
        eventEntity=eventDao.findByEventId(eventId);
        eventEntity.setSubscriptionNum(eventEntity.getSubscriptionNum()+1);
        eventDao.save(eventEntity);
    }

    public void decreaseEventSubNum(int eventId){
        EventEntity eventEntity=new EventEntity();
        eventEntity=eventDao.findByEventId(eventId);
        eventEntity.setSubscriptionNum(eventEntity.getSubscriptionNum()-1);
        eventDao.save(eventEntity);
    }

    public List<EventEntity> getAllRecEvents(){
        List<EventEntity> eventList=eventDao.findAll();
        Collections.sort(eventList,new Comparator<EventEntity> (){
            public int compare(EventEntity arg0, EventEntity arg1) {
                return ((Integer)arg1.getSubscriptionNum()).compareTo(arg0.getSubscriptionNum());
            }
        });
        if(eventList.size()>5){
            List<EventEntity> recEventList=new ArrayList<>();
            for(int i=0;i<5;i++){
                recEventList.add(eventList.get(i));
            }
            return recEventList;
        }
        return eventList;
    }

    public List<EventEntity> getAllEvents(){
        List<EventEntity> eventList=eventDao.findAll();
        return eventList;
    }

    public List<EventEntity> getAllSubEvents(List<Subscribe> subEventIdList){
        List<EventEntity> subEventList=new ArrayList<>();
        System.out.print("输出"+subEventIdList.get(1));
        for(int i=0;i<subEventIdList.size();i++){
            subEventList.add(eventDao.findByEventId(subEventIdList.get(i).getEventId()));
        }
        return subEventList;
    }

    public void deleteEvent(int eventId){
        eventDao.deleteByEventId(eventId);
    }

    public EventEntity getEvent(int eventId){
        return eventDao.findByEventId(eventId);
    }
}
