package com.eminyilmazz.orderhw.repository;

import com.eminyilmazz.orderhw.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
    @Query(value = "SELECT * FROM customer WHERE EXTRACT(MONTH FROM created_date) = '06'", nativeQuery = true)
    List<Customer> getCustomersCreatedInJune();
}
