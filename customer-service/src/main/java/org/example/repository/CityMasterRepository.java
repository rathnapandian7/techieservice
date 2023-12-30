package org.example.repository;

import org.example.model.CityMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityMasterRepository extends JpaRepository<CityMaster,Long> {


    Optional<CityMaster> findByCityName(String cityName);
}
