package com.example.EcommerceProject.service.impl;

import com.example.EcommerceProject.dto.CartResponseDTO;
import com.example.EcommerceProject.entity.Cart;
import com.example.EcommerceProject.entity.Product;
import com.example.EcommerceProject.entity.User;
import com.example.EcommerceProject.repository.CartRepository;
import com.example.EcommerceProject.repository.ProductRepository;
import com.example.EcommerceProject.repository.UserRepository;
import com.example.EcommerceProject.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepo;
    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    public CartServiceImpl(CartRepository cartRepo,
                           ProductRepository productRepo,
                           UserRepository userRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
        this.userRepo = userRepo;
    }

    @Override
    public String addToCart(Long productId, String userEmail) {

        User user = userRepo.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(1);

        cartRepo.save(cart);

        return "Product added to cart successfully";
    }

    @Override
    public List<CartResponseDTO> getUserCart(String userEmail) {

        User user = userRepo.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return cartRepo.findByUser(user)
                .stream()
                .map(cart -> {
                    CartResponseDTO dto = new CartResponseDTO();
                    dto.setCartId(cart.getId());
                    dto.setProductId(cart.getProduct().getId());
                    dto.setProductName(cart.getProduct().getName());
                    dto.setImageUrl(cart.getProduct().getImageUrl());
                    dto.setPrice(cart.getProduct().getPrice());
                    dto.setQuantity(cart.getQuantity());
                    dto.setTotalPrice(cart.getProduct().getPrice() * cart.getQuantity());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public String removeFromCart(Long cartId) {

        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        cartRepo.delete(cart);

        return "Item removed from cart";
    }
}