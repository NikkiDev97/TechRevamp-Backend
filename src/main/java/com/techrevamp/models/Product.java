package com.techrevamp.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

//@Data engloba todo lo que necesitamos en un models
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "category", nullable = false)
    private String category;
}
