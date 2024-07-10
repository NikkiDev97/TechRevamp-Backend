package com.techrevamp.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "shipping_addresses")
public class ShippingAddress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long addressId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("userId")
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