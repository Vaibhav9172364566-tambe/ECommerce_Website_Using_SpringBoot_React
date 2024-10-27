package com.demo.ecommerce.serviceImpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.modal.Deal;
import com.demo.ecommerce.modal.HomeCategory;
import com.demo.ecommerce.repositiory.DealRepository;
import com.demo.ecommerce.repositiory.HomeCattegoryRepository;
import com.demo.ecommerce.service.DealService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DealServiceImpl  implements DealService{
    private final DealRepository dealRepository;
    private final HomeCattegoryRepository homeCattegoryRepository;

    @Override
    public List<Deal> getDeals() {
        return dealRepository.findAll();
        
    }

    @Override
    public Deal createDeal(Deal deal) {
        HomeCategory category=homeCattegoryRepository.findById(deal.getCategory().getId()).orElse(null);
        Deal newDeal=dealRepository.save(deal);
        newDeal.setCategory(category);
        newDeal.setDiscount(deal.getDiscount());
        return dealRepository.save(newDeal);

    }

    @Override
    public Deal updateDeal(Deal deal,Long id) throws Exception {

        Deal existingdeal=dealRepository.findById(id).orElse(null);
        HomeCategory category=homeCattegoryRepository.findById(deal.getCategory().getId()).orElse(null);

        if(existingdeal!=null){
            if(deal.getDiscount()!=null){
                existingdeal.setDiscount(deal.getDiscount());
            }
            if(category!=null){
                existingdeal.setCategory(category);
            }
            return dealRepository.save(existingdeal);
        }
        throw new Exception("Deal not found");






    }

    @Override
    public void deleteDeal(Long id) throws Exception {

        Deal deal=dealRepository.findById(id).orElseThrow(()->
        new Exception("deal not found"));
        
    }

}
