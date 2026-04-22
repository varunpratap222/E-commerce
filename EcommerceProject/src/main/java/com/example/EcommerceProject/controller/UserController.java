package com.example.EcommerceProject.controller;

import com.example.EcommerceProject.entity.User;
import com.example.EcommerceProject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        String message = userService.register(user);

        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", message
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        String token = userService.login(user);

        return ResponseEntity.ok(Map.of(
                "success", true,
                "token", token
        ));
    }


}