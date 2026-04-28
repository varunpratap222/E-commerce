package com.example.EcommerceProject.dto;
import lombok.Data;
@Data
public class ProductRequestDTO {
    private String name;
    private String description;
    private Double price;
    private String imageUrl;

}
