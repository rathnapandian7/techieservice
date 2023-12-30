package org.example.repository;

import org.example.model.RoleMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.Optional;

@Repository
public interface RoleMasterRepository extends JpaRepository<RoleMaster, Long> {

    Optional<RoleMaster> findByRoleType(String type);

}
