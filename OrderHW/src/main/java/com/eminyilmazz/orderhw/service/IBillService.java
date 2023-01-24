package com.eminyilmazz.orderhw.service;

import com.eminyilmazz.orderhw.entity.dto.BillDto;
import com.eminyilmazz.orderhw.entity.dto.OrderDto;
import com.eminyilmazz.orderhw.enums.Industry;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Set;

public interface IBillService {
    List<BillDto> getAll();
    List<BillDto> getBillsOfCustomerCreatedInJune();
    String getTotalCountOfBillsByCustomerCreatedInJune();
    List<BillDto> getAllBillsAbove(Long amount);
    String getAverageAbove(Long amount);
    Set<Industry> getIndustriesBelow(Long amount);
    BillDto order(OrderDto order) throws JsonProcessingException;
}
