package com.sagroup.tracibility.daos;

import com.sagroup.tracibility.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Repository
public interface EventDao extends JpaRepository<EventEntity, String>, JpaSpecificationExecutor<EventEntity> {

    EventEntity findByEventId(int eventId);
}
