package com.eminyilmazz.orderhw.repository;

import com.eminyilmazz.orderhw.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
