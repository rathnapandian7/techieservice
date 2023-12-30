package org.example.repository;

import org.example.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Repository
public interface UserRepository    extends JpaRepository<UserEntity, Integer> {

    public Optional<UserEntity> findByUserName(String username);

    @Query(value = "select*from user where user_id=:userId", nativeQuery = true)
    public UserEntity findByUserId(@RequestParam("userId") String userId);

//    @Transactional
//    @Modifying
//    @Query(value = "update User u set u.status = 'B' where u.user_Name = :userName",nativeQuery = true)
//    void blockUser(@Param("userName") String userName);


}
