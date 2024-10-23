package com.demo.ecommerce.service;

import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.CartItem;
import com.demo.ecommerce.modal.Product;
import com.demo.ecommerce.modal.User;

public interface CartService {

    public CartItem addCartItem(
        User user,
        Product product,
        String size,
        int quantity);


        public Cart findUserCart(User user);

    
} 