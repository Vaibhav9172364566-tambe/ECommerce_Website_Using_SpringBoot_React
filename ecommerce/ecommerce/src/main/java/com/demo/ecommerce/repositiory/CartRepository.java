package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.Cart;

public interface CartRepository  extends JpaRepository<Cart,Long>{

    
} 
