package com.eminyilmazz.orderhw.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "customer")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "created_date", columnDefinition = "TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT NOW()")
    @CreatedDate
    private LocalDateTime createdDate;
    @Transient
    @OneToMany
    private List<Bill> bills;
}
