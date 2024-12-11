package com.example.tp4.controller;

import com.example.tp4.dao.JdbcUserDAO;
import com.example.tp4.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final JdbcUserDAO userDAO;

    public UserController(JdbcUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Method to show user list
    @GetMapping("/users")
    public String showUserList(Model model) {
        model.addAttribute("users", userDAO.findAll());
        return "userList";
    }

    // Method to add a user (show form)
    @GetMapping("/users/new")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    // Method to process the form and add user to database
    @PostMapping("/users")
    public String addUser(@ModelAttribute User user) {
        userDAO.save(user);  // Saves the new user to the database
        return "redirect:/users";
    }

    // Method to delete a user by ID
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userDAO.delete(id);  // Deletes the user from the database
        return "redirect:/users";
    }
}
