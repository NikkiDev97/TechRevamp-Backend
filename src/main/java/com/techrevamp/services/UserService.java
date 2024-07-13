package com.techrevamp.services;

import com.techrevamp.models.Order;
import com.techrevamp.models.User;
import com.techrevamp.repositories.OrderRepository;
import com.techrevamp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtener un usuario por ID
    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }

    // Crear un nuevo usuario
    public User createUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear usuario: " + e.getMessage());
        }
    }

    // Actualizar un usuario existente por ID
    public User updateUser(Long userId, User user) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            try {
                User existingUser = userOptional.get();
                existingUser.setFirstName(user.getFirstName());
                existingUser.setLastName(user.getLastName());
                existingUser.setEmail(user.getEmail());
                existingUser.setPassword(user.getPassword());
                existingUser.setPhone(user.getPhone());
                return userRepository.save(existingUser);
            } catch (Exception e) {
                // Manejar la excepción según sea necesario (por ejemplo, registrarla)
                throw new RuntimeException("Error al actualizar usuario con ID: " + userId, e);
            }
        } else {
            return null; // Devolver null si no se encuentra el usuario
        }
    }

    // Eliminar un usuario por ID
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // Buscar usuarios por email
    public User findByEmail(String email) {
       // if(!userRepository.findByEmail(email).isEmpty()) {
            return userRepository.findByEmail(email);
       // }else{
        //    return null;
       // }
    }

    // Buscar usuarios por primer nombre
    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    // Buscar usuarios por apellido
    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    // Buscar usuarios por nombre completo
    public List<User> findByFullName(String fullName) {
        return userRepository.findByFullName(fullName);
    }

    // Buscar usuarios que están logueados
    public List<User> findLoggedInUsers() {
        return userRepository.findLoggedInUsers();
    }

    // Obtener órdenes de un usuario por ID de usuario
    public List<Order> getOrdersByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return orderRepository.findByUser(user);
    }
}