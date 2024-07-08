package com.techrevamp.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

//@Data engloba todo lo que necesitamos en un models
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
    //No tendría que ser tipo Long¿?

    @Column(name = "order_code", nullable = false, unique = true)
    private String orderCode;

    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;
}
