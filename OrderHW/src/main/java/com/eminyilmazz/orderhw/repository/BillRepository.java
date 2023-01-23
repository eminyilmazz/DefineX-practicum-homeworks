package com.eminyilmazz.orderhw.repository;

import com.eminyilmazz.orderhw.entity.Bill;
import com.eminyilmazz.orderhw.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findBillsByCustomer(Customer customer);
    List<Bill> findBillsByCostGreaterThanEqual(Long cost);
}
