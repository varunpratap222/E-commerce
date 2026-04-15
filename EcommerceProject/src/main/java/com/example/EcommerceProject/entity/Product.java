package com.example.EcommerceProject.entity;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    // Constructors
    public Product() {}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }

    public void setPrice(double price) { this.price = price; }
}