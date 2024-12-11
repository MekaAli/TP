package com.example.tp5.controller;

import com.example.tp5.model.User;
import com.example.tp5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Display the list of users
    @GetMapping("/users")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    // Display form to add a new user
    @GetMapping("/users/new")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    // Process form to add a new user
    @PostMapping("/users")
    public String addUser(@ModelAttribute User user) {
        userRepository.save(user);  // Saves the new user to the database
        return "redirect:/users";
    }

    // Delete a user by ID
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);  // Deletes the user from the database
        return "redirect:/users";
    }
}
