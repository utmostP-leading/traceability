package com.sagroup.tracibility.services;

import com.sagroup.tracibility.daos.EventNodeDao;
import com.sagroup.tracibility.entities.EventNodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Service
public class EventNodeService {

    @Autowired
    private EventNodeDao eventNodeDao;

    public List<EventNodeEntity> getEventNodeList(int eventId){
        return eventNodeDao.findAllByEventId(eventId);
    }

    public void createEventNode(EventNodeEntity eventNode){
        eventNodeDao.save(eventNode);
    }
}
