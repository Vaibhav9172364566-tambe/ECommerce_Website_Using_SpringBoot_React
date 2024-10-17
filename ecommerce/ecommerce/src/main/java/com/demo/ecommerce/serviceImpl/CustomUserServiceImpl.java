package com.demo.ecommerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.domain.USER_ROLE;
import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.repositiory.SellerRepository;
import com.demo.ecommerce.repositiory.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserServiceImpl  implements UserDetailsService{


    private final UserRepository userRepository;
    private final SellerRepository sellerRepository;
    private static final String SELLER_PREFIX="seller_";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {

        if(username.startsWith(SELLER_PREFIX)){
            String actualUserName=username.substring(SELLER_PREFIX.length());
               Seller seller=sellerRepository.findByEmail(actualUserName);
               if(seller!=null){
                return buildUserDetails(seller.getEmail(), seller.getPassword(),seller.getRole());
               }

        }else{
            
            User user= userRepository.findByEmail(username);
            if(user!=null){
                
                 
                 return buildUserDetails(user.getEmail(), user.getPassword(), user.getRole());
            }
        }
      
        throw new UsernameNotFoundException("user or seller not found with email : "+username);

    }

    private UserDetails buildUserDetails(String email,String password,USER_ROLE role){
        if(role==null) role=USER_ROLE.ROLE_CUSTOMER;
        List<GrantedAuthority> authoritiesList=new ArrayList<>();
        authoritiesList.add(new SimpleGrantedAuthority(role.toString()));
         

        return new org.springframework.security.core.userdetails.User(email,password,authoritiesList) ;

    }

}
