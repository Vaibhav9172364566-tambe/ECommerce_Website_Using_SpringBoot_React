package com.demo.ecommerce.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.Deal;

public interface DealService {

    List<Deal> getDeals();
    Deal createDeal(Deal deal);
    Deal updateDeal(Deal deal,Long id) throws Exception;
    void deleteDeal( Long id) throws Exception;


    
} 