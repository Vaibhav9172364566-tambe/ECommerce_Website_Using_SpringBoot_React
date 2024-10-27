package com.demo.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.modal.Product;
import com.demo.ecommerce.modal.Review;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.request.CreateReviewRequest;
import com.demo.ecommerce.response.ApiResponse;
import com.demo.ecommerce.service.ProductService;
import com.demo.ecommerce.service.ReviewService;
import com.demo.ecommerce.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class ReviewController {
    private final UserService userService;
    private final ReviewService reviewService;
    private final ProductService productService;

    @GetMapping("/products/{productId}/reviews")
    public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable
    Long productId
    ){

        List<Review> reviews=reviewService.getReviewByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/products/{productId}/reviews")
    public ResponseEntity<Review> writeReview(
        @RequestBody CreateReviewRequest req,
        @PathVariable Long productId,
        @RequestHeader("Authorization") String jwt
    ) throws Exception{
        User user=userService.findUserByJwtTokan(jwt);
        Product product=productService.findProductsById(productId);
        Review review=reviewService.createReview(req, user, product);
        return ResponseEntity.ok(review);
    }

    @PatchMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> updateReview(
        @RequestBody CreateReviewRequest req,
        @PathVariable Long reviewId,
        @RequestHeader("Authorization") String jwt
    ) throws Exception{
        User user=userService.findUserByJwtTokan(jwt);
        Review review=reviewService.updateReview(reviewId, 
        req.getReviewText(),
        req.getReviewRating(),
        user.getId()
        
         );
         return ResponseEntity.ok(review);
    }

    @DeleteMapping("?reviews/{reviewId}")
    public ResponseEntity<ApiResponse> deleteReview(
        @PathVariable Long reviewId,
        @RequestHeader("Authorization") String jwt
    ) throws Exception{
        User user=userService.findUserByJwtTokan(jwt);
        reviewService.deleteReview(reviewId, user.getId());

        ApiResponse res=new ApiResponse();
        res.setMessage("REview Deletes Successfully");
        return ResponseEntity.ok(res);
    }
     
} 