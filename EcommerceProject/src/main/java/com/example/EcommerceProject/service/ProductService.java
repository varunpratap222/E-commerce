package com.example.EcommerceProject.service;

import com.example.EcommerceProject.dto.ProductRequestDTO;
import com.example.EcommerceProject.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO addProduct(ProductRequestDTO dto);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(Long id);

    List<ProductResponseDTO> searchProducts(String keyword);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto);

    String deleteProduct(Long id);
}