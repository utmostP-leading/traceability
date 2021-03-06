package com.sagroup.tracibility.entities;

import javax.persistence.*;

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
    private String eventNodeTime;

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

    public String getEventNodeTime() {
        return eventNodeTime;
    }

    public void setEventNodeTime(String eventNodeTime) {
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

    public EventNodeEntity() {

    }

    public EventNodeEntity(int eventId, int eventNodeFever, String eventNodeTitle, String eventNodeDescription, int positiveFever, int neutralFever, int negativeFever, String eventNodeTime) {
        this.eventId = eventId;
        this.eventNodeFever = eventNodeFever;
        this.eventNodeTitle = eventNodeTitle;
        this.eventNodeDescription = eventNodeDescription;
        this.positiveFever = positiveFever;
        this.neutralFever = neutralFever;
        this.negativeFever = negativeFever;
        this.eventNodeTime = eventNodeTime;
    }

    public EventNodeEntity(int eventNodeId,int eventId, int eventNodeFever, String eventNodeTitle, String eventNodeDescription, int positiveFever, int neutralFever, int negativeFever, String eventNodeTime) {
        this.eventNodeId=eventNodeId;
        this.eventId = eventId;
        this.eventNodeFever = eventNodeFever;
        this.eventNodeTitle = eventNodeTitle;
        this.eventNodeDescription = eventNodeDescription;
        this.positiveFever = positiveFever;
        this.neutralFever = neutralFever;
        this.negativeFever = negativeFever;
        this.eventNodeTime = eventNodeTime;
    }
}
