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
@Table(name = "payments")
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long payment_id;
  
  @ManyToOne()
  @JoinColumn(name = "order_id", referencedColumnName = "order_id")
  private Order order_id;
  
  @Column(name = "amount", nullable = false)
  private Double amount;
  
  @Column(name = "payment_method", nullable = false)
  private String payment_method;
  
  @Column(name = "payment_date", nullable = false)
  private Timestamp payment_date;
  
}
