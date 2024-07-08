package com.techrevamp.services;

import com.techrevamp.models.User;
import com.techrevamp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User user) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public List<User> findByFullName(String fullName) {
        return userRepository.findByFullName(fullName);
    }

    public List<User> findLoggedInUsers() {
        return userRepository.findLoggedInUsers();
    }
}