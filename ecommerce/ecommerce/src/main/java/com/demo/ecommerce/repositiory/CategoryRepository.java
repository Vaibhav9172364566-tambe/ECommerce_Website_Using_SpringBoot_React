package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByCategoryId(String categoryId);

    
} 