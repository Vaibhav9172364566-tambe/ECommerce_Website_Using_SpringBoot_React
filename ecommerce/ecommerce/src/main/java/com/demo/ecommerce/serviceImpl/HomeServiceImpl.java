package com.demo.ecommerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.ecommerce.domain.HomeCategorySection;
import com.demo.ecommerce.modal.Deal;
import com.demo.ecommerce.modal.Home;
import com.demo.ecommerce.modal.HomeCategory;
import com.demo.ecommerce.repositiory.DealRepository;
import com.demo.ecommerce.service.HomeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {
    
    private final DealRepository dealRepository;
    

    @Override
    public Home createHomePageData(List<HomeCategory> allCategories) {


        
        List<HomeCategory> gridCategories = allCategories.stream()
        .filter(category -> category.getSection() == HomeCategorySection.GRID) // Corrected filter syntax
        .collect(Collectors.toList());


        List<HomeCategory> shopByCategories = allCategories.stream()
        .filter(category -> category.getSection() == HomeCategorySection.SHOP_BY_CATEGORIES) // Corrected filter syntax
        .collect(Collectors.toList());

        List<HomeCategory> eleCategories = allCategories.stream()
        .filter(category -> category.getSection() == HomeCategorySection.ELECTRIC_CATEGORIES) // Corrected filter syntax
        .collect(Collectors.toList());

        List<HomeCategory> dealCategories = allCategories.stream()
        .filter(category -> category.getSection() == HomeCategorySection.DEALS) // Corrected filter syntax
        .collect(Collectors.toList());

        List<Deal> createdDeals=new ArrayList<>();

        if(dealRepository.findAll().isEmpty()){
            List<Deal> deals=allCategories.stream()
            .filter(category->category.getSection()==HomeCategorySection.DEALS)
            .map(category ->new Deal(null,10,category))
            .collect(Collectors.toList());


            createdDeals=dealRepository.saveAll(deals);

        }
        else createdDeals=dealRepository.findAll();

        Home home=new Home();
        home.setGrid(gridCategories);
        home.setShopByCategories(shopByCategories);
        home.setElectricCategories(eleCategories);
        home.setDeals(createdDeals);
        home.setDealsCategories(dealCategories);

        return home;

         

    }

}
