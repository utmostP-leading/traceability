package com.sagroup.tracibility.services;

import com.sagroup.tracibility.daos.UserDao;
import com.sagroup.tracibility.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        UserEntity userEntity=userDao.findByUsername(username);
        if(userEntity==null){
            return null;
        }
        return userEntity;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                if (charSequence.toString().equals(s)){
//                    return true;
//                }else {
//                    return false;
//                }
//            }
//        };
        return new BCryptPasswordEncoder();
    }
}
