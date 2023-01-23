package com.eminyilmazz.orderhw.entity.dto;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {
    private Long id;
    private String amount;
    private String customerId;
    private String customerName;
    private String companyName;
    private String companyIndustry;
    private String createdDate;
}
