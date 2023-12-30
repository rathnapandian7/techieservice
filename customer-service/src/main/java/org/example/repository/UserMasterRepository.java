package org.example.repository;

import org.example.model.CustomerDetails;
import org.example.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMasterRepository extends JpaRepository<UserDetails, Long> {

    Optional<UserDetails> findByUserName(String username);

    @Query(value = "select next_val from USER_SEQUENCE", nativeQuery = true)
    int getUserSequence();
}