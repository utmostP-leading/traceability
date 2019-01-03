package com.sagroup.tracibility.services;

import com.sagroup.tracibility.daos.SubscriptionDao;
import com.sagroup.tracibility.entities.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Subscribe subscribe=new Subscribe(userId,eventId);
        subscriptionDao.save(subscribe);
    }

    public void cancelSubscription(int userId,int eventId){
        subscriptionDao.deleteByUserIdAndEventId(userId,eventId);
    }
}
