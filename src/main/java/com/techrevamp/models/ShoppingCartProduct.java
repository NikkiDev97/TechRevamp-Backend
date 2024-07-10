package com.techrevamp.models;

import jakarta.persistence.*;
import lombok.*;

//@Data engloba todo lo que necesitamos en un models
@Data
@Entity
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct {
  @EmbeddedId
  private ShoppingCartProductKey id;

  @Column(name = "quantity", nullable = false)
  private int quantity;

  @ManyToOne
  @MapsId("cartId")
  @JoinColumn(name = "cart_id")
  private ShoppingCart shoppingCartId;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  private Product productId;
}