package com.example.EcommerceProject.controller;

import com.example.EcommerceProject.Security.JwtUtil;
import com.example.EcommerceProject.dto.CartResponseDTO;
import com.example.EcommerceProject.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/cart")
@CrossOrigin(origins = "http://localhost:5173")
public class CartController {

    private final CartService cartService;
    private final JwtUtil jwtUtil;

    public CartController(CartService cartService, JwtUtil jwtUtil) {
        this.cartService = cartService;
        this.jwtUtil = jwtUtil;
    }

    private String extractEmail(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String token = authHeader.substring(7);
        return jwtUtil.extractUsername(token);
    }

    @PostMapping("/{productId}")
    public String addToCart(@PathVariable Long productId, HttpServletRequest request) {
        String email = extractEmail(request);
        return cartService.addToCart(productId, email);
    }

    @GetMapping
    public List<CartResponseDTO> getMyCart(HttpServletRequest request) {
        String email = extractEmail(request);
        return cartService.getUserCart(email);
    }

    @DeleteMapping("/{cartId}")
    public String removeCart(@PathVariable Long cartId) {
        return cartService.removeFromCart(cartId);
    }

    @PutMapping("/increase/{cartId}")
    public String increaseQty(@PathVariable Long cartId) {
        return cartService.increaseQuantity(cartId);
    }

    @PutMapping("/decrease/{cartId}")
    public String decreaseQty(@PathVariable Long cartId) {
        return cartService.decreaseQuantity(cartId);
    }
}