package com.example.EcommerceProject.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {

    private Long orderId;

    private String status;

    private Double totalAmount;

    private LocalDateTime orderDate;

    private List<OrderItemResponseDTO> items;
}