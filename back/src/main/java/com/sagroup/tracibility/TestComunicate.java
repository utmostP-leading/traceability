package com.sagroup.tracibility;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestComunicate {
    @RequestMapping(value="/test",method= RequestMethod.POST)
    @ResponseBody
    public Object test(){
        return "test ok";
    }
}
