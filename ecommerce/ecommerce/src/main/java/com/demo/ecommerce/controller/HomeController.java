package com.demo.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.resources.ApiResources;

@RestController
public class HomeController {

@GetMapping
    public ApiResources HomeControllerHandler(){
        ApiResources apiResources=new ApiResources();
        apiResources.setMessage("hello Vaibhva");
        return apiResources;
    }


}
