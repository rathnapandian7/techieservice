package org.example.repository;


import org.example.model.ZoneMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZoneMasterRepository extends JpaRepository<ZoneMaster,Long> {



    Optional<ZoneMaster> findByZoneName(String zoneName);
}
