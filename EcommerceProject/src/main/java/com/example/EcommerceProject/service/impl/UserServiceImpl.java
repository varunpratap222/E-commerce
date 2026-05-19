package com.example.EcommerceProject.service.impl;

import com.example.EcommerceProject.Security.JwtUtil;
import com.example.EcommerceProject.dto.ChangePasswordDTO;
import com.example.EcommerceProject.dto.UpdateProfileDTO;
import com.example.EcommerceProject.entity.User;
import com.example.EcommerceProject.repository.UserRepository;
import com.example.EcommerceProject.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String register(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // ✅ VERY IMPORTANT
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public String login(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean matches = passwordEncoder.matches(
                user.getPassword(),
                existingUser.getPassword()
        );

        if (!matches) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(existingUser.getEmail());
    }
    @Override
    public String updateProfile(
            String email,
            UpdateProfileDTO dto
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        // validations

        if(dto.getName() == null || dto.getName().isBlank()) {
            throw new RuntimeException("Name is required");
        }

        if(dto.getPhone() == null || dto.getPhone().length() != 10) {
            throw new RuntimeException("Invalid phone number");
        }

        if(dto.getAddress() == null || dto.getAddress().isBlank()) {
            throw new RuntimeException("Address is required");
        }

        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());

        userRepository.save(user);

        return "Profile updated successfully ✅";
    }
    @Override
    public String updatePassword(
            String email,
            ChangePasswordDTO dto
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        // verify old password

        if (!passwordEncoder.matches(
                dto.getOldPassword(),
                user.getPassword()
        )) {

            throw new RuntimeException(
                    "Old password is incorrect"
            );
        }

        // confirm password check

        if (!dto.getNewPassword()
                .equals(dto.getConfirmPassword())) {

            throw new RuntimeException(
                    "Passwords do not match"
            );
        }

        // password length validation

        if (dto.getNewPassword().length() < 6) {

            throw new RuntimeException(
                    "Password must be at least 6 characters"
            );
        }

        // encode new password

        user.setPassword(
                passwordEncoder.encode(
                        dto.getNewPassword()
                )
        );

        userRepository.save(user);

        return "Password updated successfully ✅";
    }
}