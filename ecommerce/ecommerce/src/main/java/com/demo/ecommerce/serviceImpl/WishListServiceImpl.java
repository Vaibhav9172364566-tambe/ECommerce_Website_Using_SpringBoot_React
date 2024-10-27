package com.demo.ecommerce.serviceImpl;

import org.springframework.stereotype.Service;

import com.demo.ecommerce.modal.Product;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.modal.WishList;
import com.demo.ecommerce.repositiory.WishListRepository;
import com.demo.ecommerce.service.WishListService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService {
    private final WishListRepository wishListRepository;

    @Override
    public WishList createWishList(User user) {
        
        WishList wishList=new WishList();
        wishList.setUser(user);
        return wishListRepository.save(wishList);
    }

    @Override
    public WishList getWishListByUserId(User user) {

         WishList wishList=wishListRepository.findByUserId(user.getId());
         if(wishList==null){
            wishList=createWishList(user);
         }     
         return wishList; 
    }

    @Override
    public WishList addProductToWishList(User user, Product product) {
        
        WishList wishList=getWishListByUserId(user);
        if(wishList.getProducts().contains(product)){
            wishList.getProducts().remove(product);

        }
        else wishList.getProducts().add(product);
        return wishListRepository.save(wishList);
    }

}
