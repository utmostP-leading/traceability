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

    public void deleteComment(int commentId){
        commentDao.deleteByCommentId(commentId);
    }

    public CommentEntity getCommentByCommentId(int commentId){return commentDao.findByCommentId(commentId);}

    public void changeCommentState(CommentEntity comment){commentDao.save(comment);}

    public List<CommentEntity> getAllTipComments(){
        List<CommentEntity> commentList=commentDao.findAllByReportFlag(1);
        return commentList;
    }
    public List<CommentEntity> getCheckedTipComments(){
        List<CommentEntity> commentList=commentDao.findAllByReportFlag(2);
        List<CommentEntity> commentList2=commentDao.findAllByReportFlag(3);
        commentList.addAll(commentList2);
        return commentList;
    }


}
