package com.example.EcommerceProject.controller;

import com.example.EcommerceProject.entity.User;
import com.example.EcommerceProject.repository.UserRepository;
import com.example.EcommerceProject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        try {
            String message = userService.register(user);

            return ResponseEntity.ok(Map.of(
                    "message", message,
                    "success", true
            ));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of(
                    "message", e.getMessage(),
                    "success", false
            ));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        try {
            String token = userService.login(user);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "token", token
            ));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of(
                    "success", false,
                    "message", e.getMessage()
            ));
        }
    }

    // NEW API -> CURRENT LOGGED USER
    @GetMapping("/me")
    public ResponseEntity<?> currentUser(Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseEntity.ok(Map.of(
                "email", user.getEmail(),
                "name", user.getName(),
                "role", user.getRole()
        ));
    }
}