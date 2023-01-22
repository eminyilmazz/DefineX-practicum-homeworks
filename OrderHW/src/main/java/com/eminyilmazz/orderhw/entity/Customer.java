package com.eminyilmazz.orderhw.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.ZonedDateTime;

@Table(name = "customer")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "created_date", columnDefinition = "TIMESTAMP(0) WITH TIME ZONE DEFAULT NOW()")
    @CreatedDate
    private ZonedDateTime createdDate;
}
