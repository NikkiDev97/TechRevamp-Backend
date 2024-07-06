package com.techrevamp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "reviews")
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long review_id;
  
  @ManyToOne()
  @JoinColumn(name = "product_id", referencedColumnName = "product_id")
  private Product product_id;
  
  @ManyToOne()
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  private User user_id;
  
  // pendiente* Buscar max y min
  @Column(name = "rating")
  @Min(value = 1, message = "The rating must be at least 1")
  @Max(value = 5, message = "The rating must be at most 5")
  private Integer name;
  
  @Column(name = "comment")
  private String comment;
  
  @Column(name = "review_date", nullable = false)
  private Timestamp review_date;
}
