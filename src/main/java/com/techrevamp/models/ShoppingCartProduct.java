package com.techrevamp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct {
  
  @ManyToMany()
  @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", nullable = false)
  private ShoppingCart cart_id;
  
  @ManyToMany()
  @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
  private Product product_id;
  
  @Column(name = "quantity", nullable = false)
  private Integer quantity;
}
