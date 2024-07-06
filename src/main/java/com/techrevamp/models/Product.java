package com.techrevamp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long product_id;
  
  @Column(name = "name", nullable = false)
  private String name;
  
  @Column(name = "description")
  private String description;
  
  @Column(name = "price", nullable = false)
  private Double price;
  
  @Column(name = "category", nullable = false)
  private String category;
}
