package com.example.EcommerceProject.service;
import com.example.EcommerceProject.dto.ChangePasswordDTO;
import com.example.EcommerceProject.dto.UpdateProfileDTO;
import com.example.EcommerceProject.entity.User;

public interface UserService {
    String login(User user);
    String register(User user);
    String updateProfile(String email, UpdateProfileDTO dto);
    String updatePassword(String email, ChangePasswordDTO dto);
}