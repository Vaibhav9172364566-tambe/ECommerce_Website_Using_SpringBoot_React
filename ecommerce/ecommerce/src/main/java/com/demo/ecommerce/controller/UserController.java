package com.demo.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.domain.USER_ROLE;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.response.AuthResponse;
import com.demo.ecommerce.service.SignupRequest;
import com.demo.ecommerce.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


     @GetMapping("/users/profile")
    public ResponseEntity<User> createUserHandler(@RequestHeader("Authorization") String jwt) throws Exception{

        User user=userService.findUserByJwtTokan(jwt);

        
        

        return ResponseEntity.ok(user);

    }

}
