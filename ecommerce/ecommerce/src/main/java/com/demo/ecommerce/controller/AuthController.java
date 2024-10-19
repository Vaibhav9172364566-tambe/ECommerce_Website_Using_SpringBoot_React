package com.demo.ecommerce.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.domain.USER_ROLE;
import com.demo.ecommerce.modal.VerificationCode;
import com.demo.ecommerce.repositiory.UserRepository;
import com.demo.ecommerce.request.LoginOtpRequest;
import com.demo.ecommerce.request.LoginRequest;
import com.demo.ecommerce.response.ApiResponse;
import com.demo.ecommerce.response.AuthResponse;
import com.demo.ecommerce.service.AuthService;
import com.demo.ecommerce.service.SignupRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {

    private final UserRepository userRepository;
    private final AuthService authService;



    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody SignupRequest req ) throws Exception{
        
        String jwt=authService.createUser(req);
        AuthResponse res=new AuthResponse();
        res.setJwt(jwt);
        res.setMessage("Register success");
        res.setRole(USER_ROLE.ROLE_CUSTOMER);


        return ResponseEntity.ok(res);

    }
    
    @PostMapping("/sent/login-signup-otp")
    public ResponseEntity<ApiResponse> sendOtpHandler(@RequestBody LoginOtpRequest req ) throws Exception{
        
        authService.sentLoginOtp(req.getEmail(),req.getRole());

        ApiResponse res = new ApiResponse();
        res.setMessage("OTP sent successfully");
        return ResponseEntity.ok(res);

    }


    @PostMapping("/signing")
    public ResponseEntity<AuthResponse> loginHandler
    (@RequestBody LoginRequest req ) throws Exception{
        
        AuthResponse authResponse =authService.siging(req);

        
        return ResponseEntity.ok(authResponse);

    }


}


