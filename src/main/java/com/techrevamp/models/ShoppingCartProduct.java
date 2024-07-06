package com.techrevamp.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
  private ShoppingCart shoppingCart;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  private Product product;
}