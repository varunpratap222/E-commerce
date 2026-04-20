package com.example.EcommerceProject.service;

import com.example.EcommerceProject.entity.User;

public interface UserService {
    String login(User user);
    String register(User user);
}