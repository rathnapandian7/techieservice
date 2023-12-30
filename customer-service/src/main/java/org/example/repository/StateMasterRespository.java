package org.example.repository;


import org.example.model.SiteMaster;
import org.example.model.StateMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface StateMasterRespository extends JpaRepository<StateMaster, Long> {

    Optional<StateMaster> findByStateName(String stateName);
}
