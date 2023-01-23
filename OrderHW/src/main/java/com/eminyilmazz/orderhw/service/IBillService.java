package com.eminyilmazz.orderhw.service;

import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.entity.dto.BillDto;

import java.util.List;

public interface IBillService {
    List<BillDto> getBillsOfCustomerCreatedInJune();
}
