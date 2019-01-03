package com.sagroup.tracibility.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = {"password"})
public class UserEntity implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private int role;   //-1 test；0 admin；1 user

    @Column(name="sex")
    private String sex;

    @Column(name="img")
    private String img;

    @Column(name="tel")
    private String tel;

    @Column(name="intro")
    private String intro;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //权限获取
        return null;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getUsername(){
        return username;
    }

    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean isAccountNonExpired(){
        //账号是否未过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        //账号是否未被锁定
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        //账号凭证是否未过期
        return true;
    }

    @Override
    public boolean isEnabled(){
        //账号是否可用
        return true;
    }
}
