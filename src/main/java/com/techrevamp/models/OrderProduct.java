package com.techrevamp.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

//@Data engloba todo lo que necesitamos en un models
@Data
@Entity
@Table(name = "order_products")
public class OrderProduct {
    @EmbeddedId
    private OrderProductKey id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", nullable = false)
    private Order orderId;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product productId;
}