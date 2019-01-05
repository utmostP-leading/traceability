package com.sagroup.tracibility.services;

import com.sagroup.tracibility.daos.CommentDao;
import com.sagroup.tracibility.entities.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public void deleteComment(int commentId){
        commentDao.deleteByCommentId(commentId);
    }

    public CommentEntity getCommentByCommentId(int commentId){return commentDao.findByCommentId(commentId);}

    public void changeCommentState(CommentEntity comment){commentDao.save(comment);}

    public List<CommentEntity> getAllTipComments(){
        List<CommentEntity> commentList=commentDao.findAllByReportFlag(1);
        return commentList;
    }


}
