package com.techrevamp.controllers;

import com.techrevamp.models.Order;
import com.techrevamp.models.User;
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

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Obtener un usuario por ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Actualizar un usuario existente por ID
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    // Buscar usuarios por email
    @GetMapping("/email/{email}")
    public ResponseEntity<List<User>> getUsersByEmail(@PathVariable String email) {
        List<User> users = userService.findByEmail(email);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar usuarios por primer nombre
    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<User>> getUsersByFirstName(@PathVariable String firstName) {
        List<User> users = userService.findByFirstName(firstName);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar usuarios por apellido
    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<User>> getUsersByLastName(@PathVariable String lastName) {
        List<User> users = userService.findByLastName(lastName);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar usuarios por nombre completo
    @GetMapping("/fullName/{fullName}")
    public ResponseEntity<List<User>> getUsersByFullName(@PathVariable String fullName) {
        List<User> users = userService.findByFullName(fullName);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar usuarios que están logueados
    @GetMapping("/loggedIn")
    public ResponseEntity<List<User>> getLoggedInUsers() {
        List<User> users = userService.findLoggedInUsers();
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener órdenes de un usuario por ID de usuario
    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        List<Order> orders = userService.getOrdersByUserId(userId);
        if (!orders.isEmpty()) {
            // Filtrar el usuario para que aparezca una sola vez y sus órdenes
            User user = orders.get(0).getUser(); // Tomamos el usuario del primer pedido
            user.setOrders(orders); // Establecemos las órdenes en el usuario

            // Limpiamos la referencia circular para evitar la serialización infinita
            for (Order order : orders) {
                order.setUser(null);
            }

            return ResponseEntity.ok(orders);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
