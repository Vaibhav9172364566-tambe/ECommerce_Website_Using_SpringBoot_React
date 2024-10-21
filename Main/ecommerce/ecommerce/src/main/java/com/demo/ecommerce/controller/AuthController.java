package com.demo.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.repository.UserRepository;
import com.demo.ecommerce.response.SignupRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> createUserHandler(@RequestBody SignupRequest req) {
        User user = new User();
        
        // Set values from the SignupRequest
        user.setEmail(req.getEmail()); // Get email from req
        user.setFullName(req.getFullName()); // Get full name from req
        
        // You may want to save the user to the database here
        User savedUser=userRepository.save(user);
        
        return ResponseEntity.ok(savedUser);
    }
}
