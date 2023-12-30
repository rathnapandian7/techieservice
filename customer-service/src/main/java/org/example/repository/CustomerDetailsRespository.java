package org.example.repository;

import org.example.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDetailsRespository extends JpaRepository<CustomerDetails, Long> {


    public Optional<CustomerDetails> findByCustomerName(String username);

    @Query(value = "select next_val from CUSTOMER_SEQUENCE", nativeQuery = true)
    public Integer getCustomerSequence();
}
