package com.demo.ecommerce.serviceImpl;

import org.springframework.stereotype.Service;

import com.demo.ecommerce.config.JwtProvider;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.repositiory.UserRepository;
import com.demo.ecommerce.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserService{

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public User findUserByJwtTokan(String jwt) throws Exception {
        String email=jwtProvider.getEmailFromJwtTokan(jwt);
        User user=this.findUserByEmail(email);
        if(user==null){
            throw new Exception("User not found with email : "+email);
        }

        return user;
       
    }

    @Override
    public User findUserByEmail(String email) throws Exception {

        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new Exception("User not found with email : "+email);

        }
       
        return user;
    }


}
