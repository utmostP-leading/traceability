package com.sagroup.tracibility.services;

import com.sagroup.tracibility.daos.EventDao;
import com.sagroup.tracibility.entities.EventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
