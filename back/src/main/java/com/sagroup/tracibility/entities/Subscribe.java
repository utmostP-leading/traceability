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

//    @ManyToOne
//    @JoinColumn(name="user_id",nullable = false)
    @Column(name="user_id")
    private int userId;

//    @ManyToOne
//    @JoinColumn(name="event_id",nullable = false)
    @Column(name="event_id")
    private int eventId;
}
