package com.eminyilmazz.orderhw.entity.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private double cost;
    private String customerId;
    private String companyId;
}
