package com.sagroup.tracibility.daos;

import com.sagroup.tracibility.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface CommentDao extends JpaRepository<CommentEntity, String>, JpaSpecificationExecutor<CommentEntity> {

    List<CommentEntity> findAllByEventId(int eventId);


    CommentEntity findByCommentId(int commentId);

    @Transactional
    void deleteByCommentId(int commentId);

    List<CommentEntity> findAllByReportFlag(int reportFlag);

}

