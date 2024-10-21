package com.demo.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.response.ApiResponse;

@RestController
public class HomeController {

    @GetMapping
    public ApiResponse HomeControllerHandler(){
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setMessage("Vaibhav Tambe");
        return apiResponse;
    }




}

