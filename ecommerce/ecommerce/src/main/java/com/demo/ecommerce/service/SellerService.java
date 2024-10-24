package com.demo.ecommerce.service;

import java.util.List;

import com.demo.ecommerce.domain.AccountStatus;
import com.demo.ecommerce.exception.SellerException;
import com.demo.ecommerce.modal.Seller;

public interface SellerService {

    
 
    Seller getSellerProfile(String jwt) throws Exception;
    Seller creatSeller(Seller seller) throws Exception;
    Seller getSellerById(Long id) throws SellerException;
    Seller getSellerByEamil(String email) throws Exception;
    List<Seller> getAllSeller(String jwt);
    Seller updateSeller(Long id,Seller seller) throws Exception;
    void deleteSeller(Long id) throws Exception;
    Seller verifyEmail(String email,String otp) throws Exception;
    Seller updateSellerAccountStatus(Long sellerId,AccountStatus status) throws Exception;
    

}
