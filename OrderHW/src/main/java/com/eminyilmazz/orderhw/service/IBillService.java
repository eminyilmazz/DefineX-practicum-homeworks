package com.eminyilmazz.orderhw.service;

import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.entity.dto.BillDto;

import java.util.List;

public interface IBillService {
    List<BillDto> getAll();
    List<BillDto> getBillsOfCustomerCreatedInJune();
    String getTotalCountOfBillsByCustomerCreatedInJune();
    List<BillDto> getAllBillsAbove(Long amount);
    String getAverageAbove(Long amount);
}
