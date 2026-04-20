package com.example.EcommerceProject.service;

import com.example.EcommerceProject.entity.User;
import com.example.EcommerceProject.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String register(User user) {

        try {
            if (userRepository.findByEmail(user.getEmail()) != null) {
                return "Email already registered";
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);

            return "User registered successfully";

        } catch (Exception e) {
            return "Something went wrong during registration";
        }
    }

    @Override
    public String login(User user) {

        try {
            User existingUser = userRepository.findByEmail(user.getEmail());

            if (existingUser == null) {
                return "User not found";
            }

            if (!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
                return "Invalid credentials";
            }

            return "Login successful";

        } catch (Exception e) {
            return "Something went wrong during login";
        }
    }
}