package org.customer.service.repository;

import org.customer.service.entity.TokenDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface TokenDetailRepository extends JpaRepository<TokenDetailEntity, Integer> {

    TokenDetailEntity findByToken(String header);

    @Query(value = "SELECT * FROM token_detail where user_id = :id", nativeQuery = true)
    TokenDetailEntity getTokenById(@Param("id") Integer id);

    @Query(value = "delete FROM token_detail where user_id = :id", nativeQuery = true)
    int deleteTokenById1(@Param("id") Integer id);


    @Transactional
    @Modifying
    @Query(value = "Delete FROM token_detail where user_id = :id", nativeQuery = true)
    public void deleteTokenById(@Param(value = "id") Integer id);


}
