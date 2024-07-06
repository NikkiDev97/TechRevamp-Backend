package com.techrevamp.services;

import com.techrevamp.models.User;
import com.techrevamp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(Long userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public User updateUser(Long userId, User updatedUser) {
        User existingUser = getUserById(userId);
        if (existingUser != null) {
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
        }
        return existingUser;
    }

    public void deleteUser(Long userId) {
        users.removeIf(user -> user.getUserId().equals(userId));
    }
}
