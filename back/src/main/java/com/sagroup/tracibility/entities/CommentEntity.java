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
}
