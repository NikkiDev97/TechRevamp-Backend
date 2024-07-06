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
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long user_id;
  
  @Column(name = "first_name", nullable = false)
  private String first_name;
  
  @Column(name = "last_name", nullable = false)
  private String last_name;
  
  @Column(name = "phone", nullable = false)
  private String phone;
  
  @Column(name = "email", nullable = false)
  private String email;
  
  @Column(name = "password", nullable = false)
  private String password;
  
  @Column(name = "is_logged_in")
  private Boolean is_logged_in;
}
