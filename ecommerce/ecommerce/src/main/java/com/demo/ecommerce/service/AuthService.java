package com.demo.ecommerce.service;

import com.demo.ecommerce.request.LoginRequest;
import com.demo.ecommerce.response.AuthResponse;

public interface AuthService {

    void sentLoginOtp(String email) throws Exception;

    String createUser(SignupRequest req) throws Exception;
    AuthResponse siging(LoginRequest req);

    
} 