package com.sagroup.tracibility.entities;

import javax.persistence.*;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Entity
@Table(name="comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private int commentId;

    @Column(name="user_id")
    private int userId;

    @Column(name="event_id")
    private int eventId;

    @Column(name="comment_time")
    private String commentTime;

    @Column(name="comment_content")
    private String commentContent;

    @Column(name="report_flag")
    private int reportFlag; //举报标志

    @Column(name="typical_flag")
    private int typicalFlag;

    @Column(name="report_reason")
    private String reportReason;

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public CommentEntity() {
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public int getReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(int reportFlag) {
        this.reportFlag = reportFlag;
    }

    public int getTypicalFlag() {
        return typicalFlag;
    }

    public void setTypicalFlag(int typicalFlag) {
        this.typicalFlag = typicalFlag;
    }

    public CommentEntity(int userId, int eventId, String commentTime, String commentContent, int reportFlag, int typicalFlag, String reportReason) {
        this.userId = userId;
        this.eventId = eventId;
        this.commentTime = commentTime;
        this.commentContent = commentContent;
        this.reportFlag = reportFlag;
        this.typicalFlag = typicalFlag;
        this.reportReason = reportReason;
    }

    public CommentEntity(int commentId, int userId, int eventId, String commentTime, String commentContent, int reportFlag, int typicalFlag, String reportReason) {
        this.commentId=commentId;
        this.userId = userId;
        this.eventId = eventId;
        this.commentTime = commentTime;
        this.commentContent = commentContent;
        this.reportFlag = reportFlag;
        this.typicalFlag = typicalFlag;
        this.reportReason = reportReason;
    }
}
