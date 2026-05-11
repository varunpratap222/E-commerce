package com.example.EcommerceProject.controller;

import com.example.EcommerceProject.Security.JwtUtil;
import com.example.EcommerceProject.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

    private final OrderService orderService;

    private final JwtUtil jwtUtil;

    public OrderController(OrderService orderService,
                           JwtUtil jwtUtil) {

        this.orderService = orderService;
        this.jwtUtil = jwtUtil;
    }

    private String extractEmail(HttpServletRequest request) {

        String header = request.getHeader("Authorization");

        String token = header.substring(7);

        return jwtUtil.extractUsername(token);
    }

    @PostMapping("/checkout")
    public String checkout(HttpServletRequest request) {

        String email = extractEmail(request);

        return orderService.placeOrder(email);
    }
}