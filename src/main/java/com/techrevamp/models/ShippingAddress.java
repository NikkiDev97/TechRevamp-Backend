package com.techrevamp.models;

import jakarta.persistence.*;
import lombok.*;


//@Data engloba todo lo que necesitamos en un models
@Data
@Entity
@Table(name = "shipping_addresses")
public class ShippingAddress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long address_id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "street", nullable = false)
  private String street;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "state", nullable = false)
  private String state;

  @Column(name = "postal_code", nullable = false)
  private String postalCode;

  @Column(name = "country", nullable = false)
  private String country;
}