package org.example.repository;


import org.example.model.SiteMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteMasterRepository extends JpaRepository<SiteMaster, Long> {


    Optional<SiteMaster> findBySiteName(String siteName);

}
