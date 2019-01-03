package com.sagroup.tracibility.entities;

import javax.persistence.*;

/**
 * @Description: 事件实体
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Entity
@Table(name="event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id")
    private int eventId;

    @Column(name="event_title")
    private String eventTitle;

    @Column(name="event_intro")
    private String eventIntro;

    @Column(name="subscription_num")
    private int subscriptionNum;

    public EventEntity() {
    }

    public int getSubscriptionNum() {
        return subscriptionNum;
    }

    public void setSubscriptionNum(int subscriptionNum) {
        this.subscriptionNum = subscriptionNum;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventIntro() {
        return eventIntro;
    }

    public void setEventIntro(String eventIntro) {
        this.eventIntro = eventIntro;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public EventEntity(String eventTitle,String eventIntro) {
        this.eventTitle = eventTitle;
        this.eventIntro = eventIntro;
    }

    public EventEntity(int eventId,String eventTitle, String eventIntro) {
        this.eventId=eventId;
        this.eventTitle = eventTitle;
        this.eventIntro = eventIntro;
    }
}
