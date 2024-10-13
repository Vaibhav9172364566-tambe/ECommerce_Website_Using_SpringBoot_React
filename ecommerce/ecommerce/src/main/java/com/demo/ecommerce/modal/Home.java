package com.demo.ecommerce.modal;
import java.util.*;

import lombok.Data;

@Data
public class Home {

    private List<HomeCategory> grid;
    private List<HomeCategory> shopByCategories;
    private List<HomeCategory> electricCategories;
    private List<HomeCategory> dealsCategories;

    private List<Deal> deals;

}
