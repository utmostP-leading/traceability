package com.sagroup.tracibility.controllers;

import com.sagroup.tracibility.entities.UserEntity;
import com.sagroup.tracibility.services.RegisterService;
import com.sagroup.tracibility.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
    @Autowired
    RegisterService registerService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestParam(name="username") String username, @RequestParam(name="password") String password){
        return registerService.register(username,password);
    }

    @GetMapping("profiles/{userId}")               //yxe  get涓汉淇℃伅
    @ResponseBody
    public Map<String, Object> showProfiles(@PathVariable int userId){
        UserEntity userProfile =userService.findByUserId(userId);

        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",200);
        data.put("userProfile",userProfile);

        return data;
    }

    @PutMapping("profiles")
    @ResponseBody
    public Map<String, Object> modifyProfiles(@RequestBody Map map){
        UserEntity profile =userService.findByUserId(Integer.parseInt(map.get("userId").toString()));
        profile.setSex(map.get("userSex").toString());
        profile.setImg(map.get("userImg").toString());
        profile.setTel(map.get("userTel").toString());
        profile.setIntro(map.get("userIntro").toString());
        userService.changeUserProfiles(profile);

        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",201);
        return data;

    }






}
