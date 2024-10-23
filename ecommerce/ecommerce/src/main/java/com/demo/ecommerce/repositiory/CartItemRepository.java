package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.CartItem;
import com.demo.ecommerce.modal.Product;

public interface CartItemRepository  extends JpaRepository<CartItem,Long>{

    CartItem findByCartAndProduct(Cart cart, Product product);


    
} 