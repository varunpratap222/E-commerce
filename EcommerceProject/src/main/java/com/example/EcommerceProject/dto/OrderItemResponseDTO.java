package com.example.EcommerceProject.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponseDTO {

    private String productName;

    private String imageUrl;

    private Integer quantity;

    private Double price;
}