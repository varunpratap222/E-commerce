package com.example.EcommerceProject.repository;

import com.example.EcommerceProject.entity.Cart;
import com.example.EcommerceProject.entity.Product;
import com.example.EcommerceProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUser(User user);

    Optional<Cart> findByUserAndProduct(User user, Product product);
}