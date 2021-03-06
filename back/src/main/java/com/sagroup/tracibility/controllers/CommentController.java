package com.sagroup.tracibility.controllers;

import com.sagroup.tracibility.entities.CommentEntity;
import com.sagroup.tracibility.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: yaoxueer
 * @Date: 2018/01/04
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("comments")
    @ResponseBody
    public Map<String, Object> creatComment(@RequestBody Map map){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String createTime = df.format(new Date());
        System.out.println(createTime);// new Date()为获取当前系统时间

        CommentEntity comment =new CommentEntity(Integer.parseInt(map.get("userId").toString()),Integer.parseInt(map.get("eventId").toString()),map.get("content").toString(),createTime,0,0);
        commentService.createComment(comment);


        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",201);
        return data;
    }

    @DeleteMapping("comments/{commentId}")
    @ResponseBody
    public Map<String, Object> deleteComment(@PathVariable int commentId){
        commentService.deleteComment(commentId);

        //返回数据
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",204);
        return data;
    }
    @GetMapping("tippedList")
    @ResponseBody
    public Map<String, Object> getAllTipComments(){
        List<CommentEntity> commentList=commentService.getAllTipComments();
        //返回数据
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",200);
        data.put("tipped_comment",commentList);
        return data;
    }
    @GetMapping("checkTippedList")
    @ResponseBody
    public Map<String, Object> getCheckedTipComments(){
        List<CommentEntity> commentList=commentService.getCheckedTipComments();
        //返回数据
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",200);
        data.put("checkedTipped_comment",commentList);
        return data;
    }

}
