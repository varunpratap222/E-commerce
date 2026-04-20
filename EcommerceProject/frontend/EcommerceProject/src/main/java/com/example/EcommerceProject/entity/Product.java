package com.example.EcommerceProject.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Product {

    // Getters & Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    public Product() {

    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

}