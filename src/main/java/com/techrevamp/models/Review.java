package com.techrevamp.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

//@Data engloba todo lo que necesitamos en un models
@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productId")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("productId")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("userId")
    private User user;

    @Column(name = "rating", nullable = false)
    @Min(value = 1, message = "The rating must be at least 1")
    @Max(value = 5, message = "The rating must be at most 5")
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "review_date", nullable = false)
    private LocalDate reviewDate;

    public void setId(Long reviewId) {
    }
}