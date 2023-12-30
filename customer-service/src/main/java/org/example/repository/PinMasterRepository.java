package org.example.repository;


import org.example.model.PinMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PinMasterRepository extends JpaRepository<PinMaster, Long> {
    Optional<PinMaster> findByPinName(String pinName);
}
