package com.sagroup.tracibility.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description: 关系 - 举报评论
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Entity
@Table(name="report_comment")
public class ReportComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

//    @ManyToOne
//    @JoinColumn(name="comment_id",nullable = false)
    @Column(name="comment_id")
    private int commentId;

//    @ManyToOne
//    @JoinColumn(name="user_id",nullable = false)
    @Column(name="user_id")
    private int userId;

//    @ManyToOne
//    @JoinColumn(name="comment_time",nullable = false)
    @Column(name="comment_time")
    private Date commentTime;

//    @ManyToOne
//    @JoinColumn(name="content",nullable = false)
    @Column(name="content")
    private String content;

    @Column(name="report_reason")
    private String reportReason;

}
