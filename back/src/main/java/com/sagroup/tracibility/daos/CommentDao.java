package com.sagroup.tracibility.daos;

import com.sagroup.tracibility.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Repository
public interface CommentDao extends JpaRepository<CommentEntity, String>, JpaSpecificationExecutor<CommentEntity> {

    List<CommentEntity> findAllByEventId(int eventId);
}

