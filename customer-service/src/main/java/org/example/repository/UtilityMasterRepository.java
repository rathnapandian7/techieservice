package org.example.repository;

import org.example.model.UtilityMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilityMasterRepository extends JpaRepository<UtilityMaster,Long> {

    public Optional<UtilityMaster> findByUtilityName(String name);
}
