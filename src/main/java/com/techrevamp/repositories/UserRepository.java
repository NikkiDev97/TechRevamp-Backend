package com.techrevamp.repositories;

import com.techrevamp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.firstName LIKE %:firstName%")
    List<User> findByFirstName(@Param("firstName") String firstName);

    @Query("SELECT u FROM User u WHERE u.lastName LIKE %:lastName%")
    List<User> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT u FROM User u WHERE CONCAT(u.firstName, ' ', u.lastName) LIKE %:fullName%")
    List<User> findByFullName(@Param("fullName") String fullName);

    @Query("SELECT u FROM User u WHERE u.isLoggedIn = true ")
    List<User> findLoggedInUsers();
}
