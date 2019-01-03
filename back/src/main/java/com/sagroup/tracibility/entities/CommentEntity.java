package com.sagroup.tracibility.entities;

import javax.persistence.*;
import java.util.Date;

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
    private Date commentTime;

    @Column(name="comment_content")
    private String commentContent;

    @Column(name="report_flag")
    private boolean reportFlag; //举报标志

    @Column(name="typical_flag")
    private boolean typicalFlag;

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

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public boolean isReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(boolean reportFlag) {
        this.reportFlag = reportFlag;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public boolean isTypicalFlag() {
        return typicalFlag;
    }

    public void setTypicalFlag(boolean typicalFlag) {
        this.typicalFlag = typicalFlag;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
