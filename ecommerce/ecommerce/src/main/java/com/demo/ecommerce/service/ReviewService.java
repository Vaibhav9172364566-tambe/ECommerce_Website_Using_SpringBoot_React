package com.demo.ecommerce.service;

import java.util.List;

import com.demo.ecommerce.modal.Product;
import com.demo.ecommerce.modal.Review;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.request.CreateReviewRequest;

public interface ReviewService {

    Review createReview(CreateReviewRequest req,User userr,Product product);
    List<Review> getReviewByProductId(Long productId);

    Review updateReview(Long reviewId,String reviewText,double rating,Long userId) throws Exception;
    void deleteReview(Long reviewId,Long userId) throws Exception;
    Review getReviewById(Long reviewId) throws Exception;

}
