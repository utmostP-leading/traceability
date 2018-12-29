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
    @Column(name="even_id")
    private int evenId;

    @Column(name="event_title")
    private String eventTitle;

    @Column(name="event_intro")
    private String eventIntro;

    @Column(name="subscription_num")
    private int subscriptionNum;

}
