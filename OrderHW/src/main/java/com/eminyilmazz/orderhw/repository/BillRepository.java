package com.eminyilmazz.orderhw.repository;

import com.eminyilmazz.orderhw.entity.Bill;
import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.enums.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findBillsByCustomer(Customer customer);
    List<Bill> findBillsByCostGreaterThanEqual(Long cost);
    List<Bill> findBillsByCostLessThanEqual(Long cost);
    @Query("SELECT b.company.industry from Bill b where b.cost <= :amount")
    List<Industry> findCompanyIndustryWhereCostLessThanEqual(@Param(value = "amount") Long amount);
}
