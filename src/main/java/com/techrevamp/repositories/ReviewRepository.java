package com.techrevamp.repositories;

import com.techrevamp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<User, Long> {
}
