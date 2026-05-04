package com.example.EcommerceProject.repository;

import com.example.EcommerceProject.entity.Cart;
import com.example.EcommerceProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUser(User user);
}