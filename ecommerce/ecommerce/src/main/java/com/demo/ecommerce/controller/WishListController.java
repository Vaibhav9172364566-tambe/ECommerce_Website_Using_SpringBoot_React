package com.demo.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.modal.Product;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.modal.WishList;
import com.demo.ecommerce.service.ProductService;
import com.demo.ecommerce.service.UserService;
import com.demo.ecommerce.service.WishListService;
import com.demo.ecommerce.serviceImpl.ProductServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wishlist")
public class WishListController {

    private final WishListService wishListService;
    private final UserService userService;
    private final ProductService productService;


    @GetMapping()
    public ResponseEntity<WishList> getWishListByUserId(@RequestHeader("Authorization")String jwt) throws Exception{
        User user=userService.findUserByJwtTokan(jwt);
        WishList wishList=wishListService.getWishListByUserId(user);
        return ResponseEntity.ok(wishList);
    }

    @PostMapping("/add-product/{productId}")
    public ResponseEntity<WishList> addProductToWishList(@PathVariable Long productId,
    @RequestHeader("Authorization") String jwt) throws Exception{

        Product product=productService.findProductsById(productId);
        User user=userService.findUserByJwtTokan(jwt);
        WishList updateWishList=wishListService.addProductToWishList(user, product);
    
    return ResponseEntity.ok(updateWishList);


}}
