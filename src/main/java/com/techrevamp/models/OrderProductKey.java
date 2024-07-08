package com.techrevamp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import jakarta.persistence.*;

//@Data engloba todo lo que necesitamos en un models
@Data
@Entity
@Embeddable
public class OrderProductKey implements Serializable {
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;
}