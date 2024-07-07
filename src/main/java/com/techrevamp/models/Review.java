package com.techrevamp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

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

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "rating", nullable = false)
  @Min(value = 1, message = "The rating must be at least 1")
  @Max(value = 5, message = "The rating must be at most 5")
  private int rating;

  @Column(name = "comment")
  private String comment;

  @Column(name = "review_date", nullable = false)
  private Timestamp reviewDate;
}