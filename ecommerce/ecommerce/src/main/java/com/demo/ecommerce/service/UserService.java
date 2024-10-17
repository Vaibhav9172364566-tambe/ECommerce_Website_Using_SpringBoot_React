package com.demo.ecommerce.service;

import com.demo.ecommerce.modal.User;

public interface UserService {

    public User findUserByJwtTokan(String jwt) throws Exception;
    User findUserByEmail(String email) throws Exception;
    
} 