package com.techrevamp.services;

import com.techrevamp.models.User;
import com.techrevamp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  
  public List<User> getAllUsers(){
    return userRepository.findAll();
  }
  
  
}