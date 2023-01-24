package com.eminyilmazz.orderhw.service;

import com.eminyilmazz.orderhw.entity.dto.BillDto;
import com.eminyilmazz.orderhw.entity.dto.OrderDto;
import com.eminyilmazz.orderhw.enums.Industry;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IBillService {
    List<BillDto> getAll();
    List<BillDto> getBillsOfCustomerCreatedInJune();
    String getTotalCountOfBillsByCustomerCreatedInJune();
    List<BillDto> getAllBillsAbove(Long amount);
    String getAverageAbove(Long amount);
    List<Industry> getIndustriesBelow(Long amount);
    BillDto order(OrderDto order) throws JsonProcessingException;
}
