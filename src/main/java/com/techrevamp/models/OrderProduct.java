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
@Table(name = "order_products")
public class OrderProduct {
  
  
  @ManyToOne()
  @JoinColumn(name= "order_id",referencedColumnName = "order_id", nullable = false)
  private Order order_id;
  
  @ManyToOne()
  @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
  private Product product_id;
  
  @Column(name = "quantity", nullable = false)
  private Integer quantity;
}