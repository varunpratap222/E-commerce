package com.example.EcommerceProject.controller;

import com.example.EcommerceProject.Security.JwtUtil;
import com.example.EcommerceProject.dto.CheckoutRequestDTO;
import com.example.EcommerceProject.dto.OrderResponseDTO;
import com.example.EcommerceProject.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/my-orders")
    public ResponseEntity<?> getMyOrders(
            HttpServletRequest request
    ) {

        try {

            String email = extractEmail(request);

            List<OrderResponseDTO> orders =
                    orderService.getUserOrders(email);

            return ResponseEntity.ok(orders);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(
                    Map.of(
                            "success", false,
                            "message", e.getMessage()
                    )
            );
        }
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(
            @RequestBody CheckoutRequestDTO dto,
            HttpServletRequest request
    ) {

        try {

            String email = extractEmail(request);

            String message = orderService.placeOrder(email, dto);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", message
            ));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", e.getMessage()
            ));
        }
    }

}