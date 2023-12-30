package org.example.repository;


import org.example.model.LocalMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalMasterRepository extends JpaRepository<LocalMaster,Long> {

    Optional<LocalMaster> findByLocalName(String localName);
}
