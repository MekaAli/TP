package com.example.tp5.repository;

import com.example.tp5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // No need to add any code here, JpaRepository provides standard CRUD operations
}
