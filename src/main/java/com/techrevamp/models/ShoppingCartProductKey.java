package com.techrevamp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Embeddable
class ShoppingCartProductKey implements Serializable {
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "product_id")
    private Long productId;
}
