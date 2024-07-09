package com.techrevamp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

// @Data engloba todo lo que necesitamos en un models
@Data
@Embeddable
class OrderProductKey implements Serializable {
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;
}