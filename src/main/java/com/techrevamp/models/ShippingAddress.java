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
@Table(name = "shipping_addresses")
public class ShippingAddress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long address_id;
  
  @ManyToOne()
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  private User user_id;
  
  @Column(name="street", nullable = false)
  private String street;
  
  @Column(name="city", nullable = false)
  private String city;
  
  @Column(name="state", nullable = false)
  private String state;
  
  @Column(name="postal_code", nullable = false)
  private String postal_code;
  
  @Column(name="country", nullable = false)
  private String country;
  
}