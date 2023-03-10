package com.eminyilmazz.orderhw.entity.dto;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String id;
    private String fullName;
    private String createdDate;
}
