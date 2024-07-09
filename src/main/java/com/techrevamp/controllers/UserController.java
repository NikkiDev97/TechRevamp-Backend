package com.techrevamp.controllers;

import com.techrevamp.models.Order;
import com.techrevamp.models.User;
import com.techrevamp.services.OrderService;
import com.techrevamp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<User>> getUsersByEmail(@PathVariable String email) {
        List<User> users = userService.findByEmail(email);
        return ResponseEntity.ok().body(users);
    }
    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<User>> getUsersByFirstName(@PathVariable String firstName) {
        List<User> users = userService.findByFirstName(firstName);
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<User>> getUsersByLastName(@PathVariable String lastName) {
        List<User> users = userService.findByLastName(lastName);
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/fullName/{fullName}")
    public ResponseEntity<List<User>> getUsersByFullName(@PathVariable String fullName) {
        List<User> users = userService.findByFullName(fullName);
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/loggedIn")
    public ResponseEntity<List<User>> getLoggedInUsers() {
        List<User> users = userService.findLoggedInUsers();
        return ResponseEntity.ok().body(users);
    }
    
    @GetMapping("/order/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable Long userId) {
        return userService.getOrdersByUserId(userId);
    }
}
