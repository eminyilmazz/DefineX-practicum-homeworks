package com.eminyilmazz.orderhw.util.mapper;

import com.eminyilmazz.orderhw.entity.Bill;
import com.eminyilmazz.orderhw.entity.dto.BillDto;

import static com.eminyilmazz.orderhw.util.UtilityService.formatCurrency;

public class BillMapper {
    public static BillDto toDto(Bill bill) {
        return BillDto.builder()
                .id(bill.getId())
                .amount(formatCurrency(bill.getCost()))
                .companyIndustry(bill.getCompany().getIndustry().getValue())
                .companyName(bill.getCompany().getName())
                .customerId(String.valueOf(bill.getCustomer().getId()))
                .customerName(bill.getCustomer().getFullName())
                .build();
    }
}
