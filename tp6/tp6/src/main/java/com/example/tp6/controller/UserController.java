/*package com.example.tp6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tp6.model.Users;
import com.example.tp6.repository.UsersRepository;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UsersRepository userRepository;

    // Display the list of users
    @GetMapping("/users")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    // Display form to add a new user
    @GetMapping("/users/new")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new Users());
        return "addUser";
    }

    // Process form to add a new user
    @PostMapping("/users")
    public String addUser(@Valid @ModelAttribute Users user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addUser"; // Return to form if validation fails
        }

        // Check if the email is already taken (for example)
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("emailError", "Email already exists");
            return "addUser";
        }

        userRepository.save(user);  // Saves the new user to the database
        return "redirect:/users";
    }

    // Delete a user by ID
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);  // Deletes the user from the database
        }
        return "redirect:/users";
    }
}
*/
package com.example.tp6.controller;

import com.example.tp6.model.Users;
import com.example.tp6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to register a new user (public access)
    @PostMapping("/register")
    public Users registerUser(@RequestParam String name, @RequestParam String email, 
                              @RequestParam(required = false) String password, @RequestParam List<String> roles) {
        return userService.createUser(name, email, password, roles);
    }

    // Endpoint to get all users (authenticated access)
    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint to delete a user (restricted to admins)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
