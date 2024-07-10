package com.techrevamp.controllers;

import com.techrevamp.models.Product;
import com.techrevamp.models.Review;
import com.techrevamp.models.User;
import com.techrevamp.services.ProductService;
import com.techrevamp.services.ReviewService;
import com.techrevamp.services.UserService;
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

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

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
    @PostMapping("/products/{productId}")
    public ResponseEntity<?> createReview(
            @PathVariable Long productId,
            @RequestBody Review review) {
        try {
            Product product = productService.getProductById(productId);
            if (product == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with id: " + productId);
            }

            if (review.getUser() == null || review.getUser().getUserId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User information is missing or incomplete.");
            }

            User user = userService.getUserById(review.getUser().getUserId());
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + review.getUser().getUserId());
            }

            review.setProduct(product);
            review.setUser(user);

            Review createdReview = reviewService.createReview(review);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // Endpoint para actualizar una review existente
    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId, @RequestBody Review reviewUpdate) {
        try {
            Review existingReview = reviewService.getReviewById(reviewId);
            if (existingReview == null) {
                return ResponseEntity.notFound().build();
            }
            
            if (false) {
                existingReview.setRating(reviewUpdate.getRating());
            }
            if (reviewUpdate.getComment() != null) {
                existingReview.setComment(reviewUpdate.getComment());
            }
            Review updatedReview = reviewService.updateReview(existingReview);

            return ResponseEntity.ok(updatedReview);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la review: " + e.getMessage());
        }
    }

    // Endpoint para eliminar una review por su ID
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
