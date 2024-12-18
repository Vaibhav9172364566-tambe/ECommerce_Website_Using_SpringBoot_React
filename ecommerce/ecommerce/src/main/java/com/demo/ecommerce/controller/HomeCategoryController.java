package com.demo.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.modal.Home;
import com.demo.ecommerce.modal.HomeCategory;
import com.demo.ecommerce.service.HomeCategoryService;
import com.demo.ecommerce.service.HomeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class HomeCategoryController {

    private final HomeCategoryService homeCategoryService;
    private final HomeService homeService;

    @PostMapping("/home/categories")

    public ResponseEntity<Home> createHomeCategory(
        @RequestBody List<HomeCategory> homeCategories
    ){
        List<HomeCategory> categories=homeCategoryService.createCategorries(homeCategories);
        Home home=homeService.createHomePageData(categories);
        return new ResponseEntity<>(home,HttpStatus.ACCEPTED);
        
    }
    @GetMapping("/admin/home-category")
    public ResponseEntity<List<HomeCategory>> getHomeCategory() {
        List<HomeCategory> categories=homeCategoryService.getAllHomeCategories();
        return ResponseEntity.ok(categories);
    }

    @PatchMapping("/admin/home-category/{id}")
    public ResponseEntity<HomeCategory> updateHomeCategory(@PathVariable Long id,@RequestBody HomeCategory homeCategory) throws Exception{

        HomeCategory updatedCategory=homeCategoryService.updateHomeCategory(homeCategory, id);
        
        return ResponseEntity.ok(updatedCategory);
    }

     




}
