package com.sagroup.tracibility.daos;

import com.sagroup.tracibility.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<UserEntity,String> {
    UserEntity findByUsername(String username);

    UserEntity findById(int Id);

}

