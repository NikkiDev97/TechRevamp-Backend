/*
package com.techrevamp.controllers;

import com.techrevamp.models.LoginRequest;
import com.techrevamp.models.User;
import com.techrevamp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;


  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
    User user = userRepository.findByEmail(loginRequest.getEmail());
    if (user == null) {
      return ResponseEntity.status(401).body("Correo electrónico inválido.");
    }
    // Verificar la contraseña utilizando BCrypt
    if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
      return ResponseEntity.status(500).body("Contraseña incorrecta.");
    }
    return ResponseEntity.ok("Inicio de sesión exitoso.");
  }
}
*/
