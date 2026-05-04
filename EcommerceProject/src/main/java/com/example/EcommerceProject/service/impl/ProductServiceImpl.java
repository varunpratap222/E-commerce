package com.example.EcommerceProject.service.impl;

import com.example.EcommerceProject.dto.ProductRequestDTO;
import com.example.EcommerceProject.dto.ProductResponseDTO;
import com.example.EcommerceProject.entity.Product;
import com.example.EcommerceProject.repository.ProductRepository;
import com.example.EcommerceProject.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    private ProductResponseDTO mapToDTO(Product p) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setDescription(p.getDescription());
        dto.setPrice(p.getPrice());
        dto.setImageUrl(p.getImageUrl());
        dto.setStock(p.getStock());
        dto.setCategory(p.getCategory());
        return dto;
    }

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO dto) {
        Product p = new Product();
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());
        p.setImageUrl(dto.getImageUrl());
        p.setStock(dto.getStock());
        p.setCategory(dto.getCategory());

        Product saved = repo.save(p);
        return mapToDTO(saved);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return mapToDTO(p);
    }

    @Override
    public List<ProductResponseDTO> searchProducts(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {

        Product existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setPrice(dto.getPrice());
        existing.setImageUrl(dto.getImageUrl());
        existing.setStock(dto.getStock());
        existing.setCategory(dto.getCategory());

        Product updated = repo.save(existing);

        return mapToDTO(updated);
    }

    @Override
    public String deleteProduct(Long id) {

        Product existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        repo.delete(existing);

        return "Product deleted successfully";
    }
}