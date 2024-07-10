package com.techrevamp.services;

import com.techrevamp.models.Review;
import com.techrevamp.repositories.ProductRepository;
import com.techrevamp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    // Método para obtener todas las reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Método para obtener una review por su ID
    public Review getReviewById(Long reviewId) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        return reviewOptional.orElse(null);
    }

    // Método para crear una nueva review
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // Método para actualizar una review existente
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    // Método para eliminar una review por su ID
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
