package com.eminyilmazz.orderhw.entity;

import com.eminyilmazz.orderhw.enums.Industry;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Table(name = "companies")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companies_gen")
    @SequenceGenerator(name = "companies_gen", sequenceName = "companies_seq", initialValue = 3, allocationSize = 100)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "industry")
    @Enumerated(EnumType.STRING)
    private Industry industry;
    @Column(name = "name")
    private String name;

}
