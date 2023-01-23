package com.eminyilmazz.orderhw.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "bills")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bills_seq_gen")
    @SequenceGenerator(name = "bills_seq_gen", sequenceName = "bills_seq", initialValue = 1000, allocationSize = 7)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "cost", columnDefinition = "BIGINT DEFAULT 0")
    private Long cost;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "company_id")
    private Company company;


}
