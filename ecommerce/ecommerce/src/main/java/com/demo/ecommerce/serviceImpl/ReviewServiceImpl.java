package com.demo.ecommerce.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.ecommerce.modal.Product;
import com.demo.ecommerce.modal.Review;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.repositiory.ReviewRepository;
import com.demo.ecommerce.request.CreateReviewRequest;
import com.demo.ecommerce.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService
{


   private final ReviewRepository  reviewRepository;

@Override
    public Review createReview(CreateReviewRequest req, User user, Product product) {
        Review review=new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReviewText(req.getReviewText());
        review.setRating(req.getReviewRating());
        review.setProductImages(req.getProductImages());

        product.getReviews().add(review);
        return reviewRepository.save(review);



        
    }

    @Override
    public List<Review> getReviewByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    @Override
    public Review updateReview(Long reviewId, String reviewText, double rating, Long userId) throws Exception {
        Review review=getReviewById(reviewId);
        if(review.getUser().getId().equals(userId)){
            review.setReviewText(reviewText);
            review.setRating(rating);
            return reviewRepository.save(review);
        }

       throw new Exception("you can`t update this review");
    }

    @Override
    public void deleteReview(Long reviewId, Long userId) throws Exception {
      
        Review review=getReviewById(reviewId);
        if(review.getUser().getId().equals(userId)){
            throw new Exception("you can`t delete this review");
        }
    }

    @Override
    public Review getReviewById(Long reviewId) throws Exception {

        return reviewRepository.findById(reviewId).orElseThrow(()->new Exception("Review not found"));
    }

    
} 