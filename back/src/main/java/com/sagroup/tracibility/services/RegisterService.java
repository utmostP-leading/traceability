package com.sagroup.tracibility.services;

import com.sagroup.tracibility.daos.UserDao;
import com.sagroup.tracibility.entities.ResultEntity;
import com.sagroup.tracibility.entities.UserEntity;
import com.sagroup.tracibility.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2019/1/4
 */
@Service
public class RegisterService {

    @Autowired
    private UserDao userDao;

    public ResultEntity register(String username, String password){

        //检查是否有重复
        UserEntity userEntity=userDao.findByUsername(username);
        if(userEntity!=null){
            //用户名已存在
            return ResultUtil.resultBadReturner("用户名已存在");
        }else {
            //加密
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            password = encoder.encode(password);

            //存入数据库
            UserEntity newUser = new UserEntity();
            newUser.setUsername(username);
            newUser.setPassword(password);
            userDao.save(newUser);

            return ResultUtil.resultReturner(0, "注册成功", null);

        }
    }
}
