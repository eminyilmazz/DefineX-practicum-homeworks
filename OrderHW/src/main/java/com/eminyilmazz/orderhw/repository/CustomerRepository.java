package com.eminyilmazz.orderhw.repository;

import com.eminyilmazz.orderhw.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
    @Query(value = "SELECT Customer FROM Customer c WHERE MONTH(c.createdDate) = 6")
    List<Customer> getCustomersCreatedInJune();
}
