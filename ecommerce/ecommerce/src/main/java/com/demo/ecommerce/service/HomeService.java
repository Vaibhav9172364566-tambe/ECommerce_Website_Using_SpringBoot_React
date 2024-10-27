package com.demo.ecommerce.service;

import java.util.List;

import com.demo.ecommerce.modal.Home;
import com.demo.ecommerce.modal.HomeCategory;

public interface HomeService {

    public Home createHomePageData(List<HomeCategory> allCategories);

    


    
} 