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
@Table(name = "shopping_carts")
public class ShoppingCart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cart_id;
  
  @ManyToOne()
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  private User user_id;
  
  @Column(name = "creation_date", nullable = false)
  private Timestamp creation_date;
  
}
