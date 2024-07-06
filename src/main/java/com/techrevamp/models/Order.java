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
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long order_id;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  private User user_id;

  @Column(name = "order_code", nullable = false)
  private String order_code;

  @Column(name = "order_date", nullable = false)
  private Timestamp order_date;
}
