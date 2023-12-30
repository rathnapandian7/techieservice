package org.example.repository;

import org.example.model.CountryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryMasterRepository extends JpaRepository<CountryMaster,Long> {


    Optional<CountryMaster> findByCountryName(String countryName);
}
