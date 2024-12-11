package com.example.tp6.repository;

import com.example.tp6.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    // Find a user by their email
    Optional<Users> findByEmail(String email);
    
    // You can add more custom queries if needed, for example:
    Optional<Users> findByName(String name);

}
