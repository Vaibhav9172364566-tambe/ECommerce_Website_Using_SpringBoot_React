package com.demo.ecommerce.request;

import java.util.*;

import lombok.Data;

@Data
public class CreateProductRequest {

    private String title;
    private String description;
    private int mrpPrice;
    private int sellingPrice;
    private String color;
    private List<String> images;
    private String category;
    private String category2;

    private String category3;


    private String sizes;





}
