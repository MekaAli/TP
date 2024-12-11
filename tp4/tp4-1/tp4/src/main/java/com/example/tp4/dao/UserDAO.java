package com.example.tp4.dao;

import java.util.List;

import com.example.tp4.model.User;

public interface UserDAO {
    User findById(Long id);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(Long id);
}
