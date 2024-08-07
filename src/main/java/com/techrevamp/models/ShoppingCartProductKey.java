package com.techrevamp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

//@Data engloba todo lo que necesitamos en un models
@Data
@Embeddable
class ShoppingCartProductKey implements Serializable {
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "product_id")
    private Long productId;
}
