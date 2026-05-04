package com.example.EcommerceProject.service;

import com.example.EcommerceProject.dto.CartResponseDTO;

import java.util.List;

public interface CartService {

    String addToCart(Long productId, String userEmail);

    List<CartResponseDTO> getUserCart(String userEmail);

    String removeFromCart(Long cartId);
}