package com.example.tp6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp6.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // No need to add any code here, JpaRepository provides standard CRUD operations
}
