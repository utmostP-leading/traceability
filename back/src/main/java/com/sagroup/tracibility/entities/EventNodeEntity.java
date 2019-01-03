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

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventNodeDescription() {
        return eventNodeDescription;
    }

    public void setEventNodeDescription(String eventNodeDescription) {
        this.eventNodeDescription = eventNodeDescription;
    }

    public int getEventNodeFever() {
        return eventNodeFever;
    }

    public void setEventNodeFever(int eventNodeFever) {
        this.eventNodeFever = eventNodeFever;
    }

    public int getEventNodeId() {
        return eventNodeId;
    }

    public void setEventNodeId(int eventNodeId) {
        this.eventNodeId = eventNodeId;
    }

    public Date getEventNodeTime() {
        return eventNodeTime;
    }

    public void setEventNodeTime(Date eventNodeTime) {
        this.eventNodeTime = eventNodeTime;
    }

    public String getEventNodeTitle() {
        return eventNodeTitle;
    }

    public void setEventNodeTitle(String eventNodeTitle) {
        this.eventNodeTitle = eventNodeTitle;
    }

    public int getNegativeFever() {
        return negativeFever;
    }

    public void setNegativeFever(int negativeFever) {
        this.negativeFever = negativeFever;
    }

    public int getNeutralFever() {
        return neutralFever;
    }

    public void setNeutralFever(int neutralFever) {
        this.neutralFever = neutralFever;
    }

    public int getPositiveFever() {
        return positiveFever;
    }

    public void setPositiveFever(int positiveFever) {
        this.positiveFever = positiveFever;
    }
}
