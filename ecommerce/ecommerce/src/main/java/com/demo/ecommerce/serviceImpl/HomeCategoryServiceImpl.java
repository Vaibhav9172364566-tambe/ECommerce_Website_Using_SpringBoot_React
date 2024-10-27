package com.demo.ecommerce.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.ecommerce.modal.HomeCategory;
import com.demo.ecommerce.repositiory.HomeCattegoryRepository;
import com.demo.ecommerce.service.HomeCategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class HomeCategoryServiceImpl implements HomeCategoryService {
    
    private final HomeCattegoryRepository homeCattegoryRepository;
    
    @Override
    public HomeCategory createHomeCategory(HomeCategory homeCategory) {
        return homeCattegoryRepository.save(homeCategory);


        
    }

    @Override
    public List<HomeCategory> createCategorries(List<HomeCategory> homeCategories) {
        if(homeCattegoryRepository.findAll().isEmpty()){
            return homeCattegoryRepository.saveAll(homeCategories);
        }
        return homeCattegoryRepository.findAll();
       
    }

    @Override
    public HomeCategory updateHomeCategory(HomeCategory category, Long id) throws Exception {
        

        HomeCategory existingCategory=homeCattegoryRepository.findById(id).orElseThrow(()->new Exception("Category not found"));

        if(category.getImage() !=null){
            existingCategory.setImage(category.getImage());

        }
        if(category.getCategoryId()!=null){
            existingCategory.setCategoryId(category.getCategoryId());
        }
        return homeCattegoryRepository.save(existingCategory);
    }

    @Override
    public List<HomeCategory> getAllHomeCategories() {

        return homeCattegoryRepository.findAll();
       
    }

}
