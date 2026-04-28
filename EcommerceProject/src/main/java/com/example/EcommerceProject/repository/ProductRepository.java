package com.example.EcommerceProject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EcommerceProject.entity.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
}