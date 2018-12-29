package com.sagroup.tracibility.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Entity
@Table(name="event_node")
public class EventNodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_node_id")
    private int eventNodeId;

    @Column(name="event_id")
    private int eventId;

    @Column(name="event_node_fever")
    private int eventNodeFever;

    @Column(name="event_node_title")
    private String eventNodeTitle;

    @Column(name="event_node_description")
    private String eventNodeDescription;

    @Column(name="positive_fever")
    private int positiveFever;

    @Column(name="neutral_fever")
    private int neutralFever;

    @Column(name="negative_fever")
    private int negativeFever;

    @Column(name="event_node_time")
    private Date eventNodeTime;
}
