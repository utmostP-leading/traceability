package com.sagroup.tracibility.daos;

import com.sagroup.tracibility.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Repository
public interface EventDao extends JpaRepository<EventEntity, String>, JpaSpecificationExecutor<EventEntity> {

    EventEntity findByEventId(int eventId);

    EventEntity findByEventTitle(String title);

    List<EventEntity> findAll();

    List<EventEntity> findAllByEventId(int eventId);

    @Transactional
    void deleteByEventId(int eventId);

}
