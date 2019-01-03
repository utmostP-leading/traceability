package com.sagroup.tracibility.services;

import com.sagroup.tracibility.daos.CommentDao;
import com.sagroup.tracibility.entities.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public List<CommentEntity> getCommentList(int eventId){
        return commentDao.findAllByEventId(eventId);
    }

    public void createComment(CommentEntity comment){
        commentDao.save(comment);
    }
}
