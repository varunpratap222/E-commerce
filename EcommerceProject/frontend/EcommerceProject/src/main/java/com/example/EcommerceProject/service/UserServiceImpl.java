package com.example.EcommerceProject.service;

import com.example.EcommerceProject.entity.User;
import com.example.EcommerceProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String registerUser(User user) {

        // check if user already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Email already registered";
        }

        userRepository.save(user);
        return "User registered successfully";
    }
}