package com.techrevamp.controllers;

import com.techrevamp.models.Review;
import com.techrevamp.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Endpoint para obtener todas las reviews
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Endpoint para obtener una review por su ID
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
        Review review = reviewService.getReviewById(reviewId);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para crear una nueva review
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }

    // Endpoint para actualizar una review existente
    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(reviewId, review);
        if (updatedReview != null) {
            return ResponseEntity.ok(updatedReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar una review por su ID
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
