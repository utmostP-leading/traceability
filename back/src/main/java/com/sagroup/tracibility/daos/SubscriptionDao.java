package com.sagroup.tracibility.daos;

import com.sagroup.tracibility.entities.Subscribe;
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
public interface SubscriptionDao extends JpaRepository<Subscribe, String>, JpaSpecificationExecutor<Subscribe> {

    List<Subscribe> findAll();

    @Transactional
    void deleteByUserIdAndEventId(int userId,int eventId);

    List<Subscribe> findAllByUserId(int userId);
}
