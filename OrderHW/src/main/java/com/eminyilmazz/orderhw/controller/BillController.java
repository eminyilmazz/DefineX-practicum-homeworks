package com.eminyilmazz.orderhw.controller;

import com.eminyilmazz.orderhw.entity.dto.BillDto;
import com.eminyilmazz.orderhw.service.IBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bill/api")
public class BillController {
    private static final Logger logger = LoggerFactory.getLogger(BillController.class);
    @Autowired
    IBillService billService;

    @GetMapping(value = "/getJune")
    public ResponseEntity<List<BillDto>> getBillsOfCustomerCreatedInJune() {
        logger.debug("/bill/api/getJune request received");
        return ResponseEntity.ok(billService.getBillsOfCustomerCreatedInJune());
    }
}
