package com.example.tp3.controller;


import com.example.tp3.model.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 

@Controller
public class UserController {
    private List<User> users = new ArrayList<>();

    // Method to show user list
    @GetMapping("/users")
    public String showUserList(Model model) {
        model.addAttribute("users", users);
        return "userList";
    }
    // Method to add a user (show form)
    @GetMapping("/users/new")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }
        // Method to process the form and add user to list
    @PostMapping("/users")
    public String addUser(@ModelAttribute User user) {
        user.setId((long) (users.size() + 1)); // Simple ID generation
        users.add(user);
        return "redirect:/users";
    }
        // Method to delete a user by ID
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        users.removeIf(user -> user.getId().equals(id));
        return "redirect:/users";
    }
}
