package com.sagroup.tracibility.entities;

import javax.persistence.*;

/**
 * @Description: 关系 - 订阅
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Entity
@Table(name="subscribe")
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="event_id")
    private int eventId;

    public Subscribe() {
    }

    public Subscribe(int userId,int eventId) {
        this.userId = userId;
        this.eventId=eventId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}

