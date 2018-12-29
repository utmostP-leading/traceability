package com.sagroup.tracibility.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = {"user_password"})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_password")
    private String userPassword;

    @Column(name="user_sex")
    private int userSex;    //0男，1女，2不公开

    @Column(name="user_img")
    private String userImg;

    @Column(name="user_tel")
    private String userTel;

    @Column(name="user_intro")
    private String userIntro;
}
