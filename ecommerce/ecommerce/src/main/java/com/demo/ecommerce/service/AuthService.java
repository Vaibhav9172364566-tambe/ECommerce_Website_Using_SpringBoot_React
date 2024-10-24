package com.demo.ecommerce.service;

import com.demo.ecommerce.domain.USER_ROLE;
import com.demo.ecommerce.request.LoginRequest;
import com.demo.ecommerce.response.AuthResponse;

public interface AuthService {

    void sentLoginOtp(String email,USER_ROLE role) throws Exception;

    String createUser(SignupRequest req) throws Exception;
    AuthResponse siging(LoginRequest req) throws Exception;

    
} 