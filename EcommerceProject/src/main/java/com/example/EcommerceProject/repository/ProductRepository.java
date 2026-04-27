package com.example.EcommerceProject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EcommerceProject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}