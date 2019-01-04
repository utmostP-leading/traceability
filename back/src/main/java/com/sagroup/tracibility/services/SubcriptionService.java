package com.sagroup.tracibility.services;

import com.sagroup.tracibility.daos.SubscriptionDao;
import com.sagroup.tracibility.entities.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Service
public class SubcriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;

    public void addSubscription(int userId,int eventId){
        Subscribe subscribe=new Subscribe(userId,eventId,1);
        subscriptionDao.save(subscribe);
    }

    public void cancelSubscription(int userId,int eventId){
        subscriptionDao.deleteByUserIdAndEventId(userId,eventId);
    }

    public List<Subscribe> getSubEvents(int userId){
        return subscriptionDao.findAllByUserId(userId);
    }

    public void updateReadFlag(int eventId){
        List<Subscribe> subscribeList=subscriptionDao.findAllByEventId(eventId);
        for(int i=0;i<subscribeList.size();i++){
            subscribeList.get(i).setRead_flag(0);
            subscriptionDao.save(subscribeList.get(i));
        }
    }
}
