package org.customer.service.repository;

import org.customer.service.entity.UserAuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserAuditRepository extends JpaRepository<UserAuditEntity, Integer> {

    @Query(value = "Select count(u.user_Audit_Id) from User_Audit u where u.user_Id=:userId", nativeQuery = true)
    public int getUserAuditCount(@Param(value = "userId") Integer userId);


    @Transactional
    @Modifying
    @Query(value = "Delete from User_Audit u where u.user_Id=:userId",nativeQuery = true)
    public void deleteUserAudit(@Param(value = "userId") Integer userId);
}
