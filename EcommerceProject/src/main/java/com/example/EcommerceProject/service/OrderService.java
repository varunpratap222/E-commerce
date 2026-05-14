package com.example.EcommerceProject.service;

import com.example.EcommerceProject.dto.CheckoutRequestDTO;

public interface OrderService {

    String placeOrder(String email, CheckoutRequestDTO dto);
}