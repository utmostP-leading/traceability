package com.sagroup.tracibility.controllers;

import com.sagroup.tracibility.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@RestController
public class UserController {
    @Autowired
    RegisterService registerService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestParam(name="username") String username, @RequestParam(name="password") String password){
        return registerService.register(username,password);
    }
}
