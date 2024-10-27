package com.demo.ecommerce.service;

import java.util.List;

import com.demo.ecommerce.modal.HomeCategory;

public interface HomeCategoryService {

    HomeCategory createHomeCategory(HomeCategory homeCategory);
    List<HomeCategory> createCategorries(List<HomeCategory> homeCategories);
    

    HomeCategory updateHomeCategory(HomeCategory homeCategory,Long id) throws Exception;
    List<HomeCategory> getAllHomeCategories();
}
