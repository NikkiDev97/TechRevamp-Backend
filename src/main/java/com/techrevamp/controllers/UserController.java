package com.techrevamp.controllers;

import com.techrevamp.models.User;
import com.techrevamp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint para obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Endpoint para actualizar un usuario existente
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    // Endpoint para eliminar un usuario
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
