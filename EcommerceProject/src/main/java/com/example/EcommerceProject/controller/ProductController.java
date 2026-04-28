package com.example.EcommerceProject.controller;
import com.example.EcommerceProject.dto.ProductRequestDTO;
import com.example.EcommerceProject.dto.ProductResponseDTO;
import com.example.EcommerceProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.EcommerceProject.entity.Product;

@RestController
@RequestMapping("/api/users/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // ✅ ADD PRODUCT
    @PostMapping
    public ProductResponseDTO addProduct(@RequestBody ProductRequestDTO dto) {
        return service.addProduct(dto);
    }

    // ✅ GET ALL PRODUCTS
    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return service.getAllProducts();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public ProductResponseDTO getById(@PathVariable Long id) {
        return service.getProductById(id);
    }
    // ✅ SEARCH
    @GetMapping("/search")
    public List<ProductResponseDTO> search(@RequestParam String keyword) {
        return service.searchProducts(keyword);
    }
}