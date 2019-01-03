package com.sagroup.tracibility.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Entity
@Table(name="admin")
@JsonIgnoreProperties(value = {"adminPassword"})
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="admin_id")
    private int adminId;

    @Column(name="admin_name")
    private String adminName;

    @Column(name="admin_password")
    private String adminPassword;
}
