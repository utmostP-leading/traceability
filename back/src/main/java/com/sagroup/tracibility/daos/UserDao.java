package com.sagroup.tracibility.daos;

import com.sagroup.tracibility.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
public interface UserDao extends JpaRepository<UserEntity,String> {
    UserEntity findByUsername(String username);

    UserEntity findById(int id);

}
