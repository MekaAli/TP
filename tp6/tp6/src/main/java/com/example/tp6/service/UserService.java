package com.example.tp6.service;

import com.example.tp6.model.Users;
import com.example.tp6.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Create or register a user
    public Users createUser(String name, String email, String password, List<String> roles) {
        if (password == null || password.isEmpty()) {
            password = "123456789";  // Default password if none provided
        }
        String hashedPassword = passwordEncoder.encode(password);  // Hash password
        Users user = new Users(name, email, hashedPassword, roles);
        return usersRepository.save(user);  // Save to DB
    }

    // Get all users
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    // Delete a user
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);  // Remove user from DB
    }
}
