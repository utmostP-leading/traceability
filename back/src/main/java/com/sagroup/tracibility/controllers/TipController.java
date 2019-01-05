package com.sagroup.tracibility.controllers;

import com.sagroup.tracibility.entities.CommentEntity;
import com.sagroup.tracibility.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: yaoxueer
 * @Date: 2018/01/04
 */
@RestController
public class TipController {
    @Autowired
    private CommentService commentService;

    @PatchMapping("comments")    //涓炬姤璇勮
    @ResponseBody
    public Map<String, Object> tipComment(@RequestBody Map map){
        CommentEntity comment =commentService.getCommentByCommentId(Integer.parseInt(map.get("commentId").toString()));
        comment.setReportFlag(1);
        comment.setReportReason(map.get("tipReason").toString());
        commentService.changeCommentState(comment);


        //杩斿洖鏁版嵁
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",201);
        return data;

    }
    @PatchMapping("tippedComments")    //鍚屾剰涓炬姤璇ヨ瘎璁?    @ResponseBody
    public Map<String, Object> tipped(@RequestBody Map map){
        CommentEntity comment =commentService.getCommentByCommentId(Integer.parseInt(map.get("commentId").toString()));
        comment.setReportFlag(2);

        commentService.changeCommentState(comment);


        //杩斿洖鏁版嵁
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",201);
        return data;
    }

    @PatchMapping("nonTippedComments")    //鍚﹀喅涓炬姤璇ヨ瘎璁?    @ResponseBody
    public Map<String, Object> nonTipped(@RequestBody Map map){
        CommentEntity comment =commentService.getCommentByCommentId(Integer.parseInt(map.get("commentId").toString()));
        comment.setReportFlag(3);

        commentService.changeCommentState(comment);


        //杩斿洖鏁版嵁
        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",201);
        return data;
    }

    @GetMapping("tippedDetails/{commentId}")
    @ResponseBody
    public Map<String, Object> showTipDetails(@PathVariable int commentId){
        CommentEntity comment =commentService.getCommentByCommentId(commentId);


        Map<String , Object> data = new HashMap<String ,Object>();
        data.put("statusCode",200);
        data.put("commentId",comment.getCommentId());
        data.put("content",comment.getCommentContent());
        data.put("tippedReason",comment.getReportReason());


        return data;
    }

}
