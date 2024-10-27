package com.demo.ecommerce.serviceImpl;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.config.JwtProvider;
import com.demo.ecommerce.domain.AccountStatus;
import com.demo.ecommerce.domain.USER_ROLE;
import com.demo.ecommerce.exception.SellerException;
import com.demo.ecommerce.modal.Address;
import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.repositiory.AddressRepository;
import com.demo.ecommerce.repositiory.SellerRepository;
import com.demo.ecommerce.service.SellerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService{

    private final SellerRepository sellerRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final AddressRepository addressRepository;



    @Override
    public Seller getSellerProfile(String jwt) throws Exception {
        String email=jwtProvider.getEmailFromJwtTokan(jwt);
        return this.getSellerByEamil(email);
       
    }



    @Override
    public Seller creatSeller(Seller seller) throws Exception {


        Seller sellerExit=sellerRepository.findByEmail(seller.getEmail());
        if(sellerExit!=null){
            throw new Exception("Seller already exist ,used different email");
        }

        Address savedAdress=addressRepository.save(seller.getPickupAddress());
        Seller newSeller=new Seller();
        newSeller.setEmail(seller.getEmail());
        newSeller.setPassword(passwordEncoder.encode(seller.getPassword()));
        newSeller.setSellerName(seller.getSellerName());
        newSeller.setPickupAddress(seller.getPickupAddress());
        newSeller.setGSTIN(seller.getGSTIN());
        newSeller.setRole(USER_ROLE.ROLE_SELLER);
        newSeller.setMobile(seller.getMobile());
        newSeller.setBankDetails(seller.getBankDetails());
        newSeller.setBusinessDetails(seller.getBusinessDetails());
        return sellerRepository.save(newSeller); 
       
    }

    @Override
    public Seller getSellerById(Long id) throws SellerException{
        return sellerRepository.findById(id).orElseThrow(()->new SellerException("Seller not found with id : "+id));
        
    }

    @Override
    public Seller getSellerByEamil(String email) throws Exception {
        Seller seller =sellerRepository.findByEmail(email);
        if(seller==null){
            throw new Exception("Seller not found....");
        }
        return seller;
      
    }

    @Override
    public List<Seller> getAllSeller(AccountStatus status) {
        return sellerRepository.findByAccountStatus(status); 
       
    }

    @Override
    public Seller updateSeller(Long id, Seller seller) throws Exception {

        Seller exitSeller=this.getSellerById(id);


        if(seller.getSellerName() !=null){
            exitSeller.setSellerName(seller.getSellerName());
        }
        if(seller.getMobile() !=null){
            exitSeller.setMobile(seller.getMobile());
        }
        if(seller.getEmail() !=null){
            exitSeller.setEmail(seller.getEmail());
        }
        if(seller.getBusinessDetails() !=null && seller.getBusinessDetails().getBusinessName() !=null){
            exitSeller.getBusinessDetails().setBusinessName(seller.getBusinessDetails().getBusinessName());
        }
        if(seller.getBankDetails() !=null
           && seller.getBankDetails().getAccountHolderName() !=null
           && seller.getBankDetails().getIfscCode() !=null
           && seller.getBankDetails().getAccountNumber() !=null
        )
        {
            exitSeller.getBankDetails().setAccountHolderName(
                seller.getBankDetails().getAccountHolderName()
            );
            exitSeller.getBankDetails().setAccountNumber(
                seller.getBankDetails().getAccountNumber()
            );
            exitSeller.getBankDetails().setIfscCode(
                seller.getBankDetails().getIfscCode()
            );
        }
        if(seller.getPickupAddress() !=null

           && seller.getPickupAddress().getAddress() !=null
           && seller.getPickupAddress().getMobile() !=null
           && seller.getPickupAddress().getCity() !=null
           && seller.getPickupAddress().getState() !=null
        
        ){
            exitSeller.getPickupAddress()
                          .setAddress(seller.getPickupAddress().getAddress());
            exitSeller.getPickupAddress().setCity(seller.getPickupAddress().getCity()); 
            
            exitSeller.getPickupAddress().setState(seller.getPickupAddress().getState());     

            exitSeller.getPickupAddress().setMobile(seller.getPickupAddress().getMobile());     

            exitSeller.getPickupAddress().setPincode(seller.getPickupAddress().getPincode());     

        }
        if(seller.getGSTIN() !=null){
            exitSeller.setGSTIN(seller.getGSTIN());
        } 
        return sellerRepository.save(exitSeller);

    }

    @Override
    public void deleteSeller(Long id) throws Exception {
        
        Seller seller=getSellerById(id);
        sellerRepository.delete(seller);
    }

    @Override
    public Seller verifyEmail(String email, String otp) throws Exception {
        Seller seller=getSellerByEamil(email);
        seller.setEmailVerified(true);
        return sellerRepository.save(seller);
        
    }

    @Override
    public Seller updateSellerAccountStatus(Long sellerId, AccountStatus status) throws Exception {

        Seller seller=getSellerById(sellerId);
        seller.setAccountStatus(status);
        return sellerRepository.save(seller);
        
    }
}


