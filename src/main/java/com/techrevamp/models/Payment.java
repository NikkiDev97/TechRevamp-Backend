package com.techrevamp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


//@Data engloba todo lo que necesitamos en un models
@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order orderId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;
}