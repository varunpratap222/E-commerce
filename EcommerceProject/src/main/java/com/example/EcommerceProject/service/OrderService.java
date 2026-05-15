package com.example.EcommerceProject.service;

import com.example.EcommerceProject.dto.CheckoutRequestDTO;
import com.example.EcommerceProject.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {

    String placeOrder(String email, CheckoutRequestDTO dto);
    List<OrderResponseDTO> getUserOrders(String email);
}