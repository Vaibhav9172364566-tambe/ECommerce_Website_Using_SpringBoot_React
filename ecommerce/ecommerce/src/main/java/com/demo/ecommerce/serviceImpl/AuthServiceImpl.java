package com.demo.ecommerce.serviceImpl;
import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.config.JwtProvider;
import com.demo.ecommerce.domain.USER_ROLE;
import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.modal.VerificationCode;
import com.demo.ecommerce.repositiory.CartRepository;
import com.demo.ecommerce.repositiory.UserRepository;
import com.demo.ecommerce.repositiory.VerificationCodeRepo;
import com.demo.ecommerce.request.LoginRequest;
import com.demo.ecommerce.response.AuthResponse;
import com.demo.ecommerce.service.AuthService;
import com.demo.ecommerce.service.EmailService;
import com.demo.ecommerce.service.SignupRequest;
import com.demo.ecommerce.util.OtpUtil;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    

    private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;
    private final JwtProvider jwtProvider;
    private final VerificationCodeRepo verificationCodeRepo;
    private final EmailService emailService;
    private final CustomUserServiceImpl customUserServiceImpl;

    
    @Override
    public String createUser(SignupRequest req) throws Exception {

      VerificationCode verificationCode=verificationCodeRepo.findByEmail(req.getEmail());

      if(verificationCode==null ||!verificationCode.getOtp().equals(req.getOtp())){
        throw new Exception("Wrong otp...");


      }

        //user are all ready exit or not
        User user=userRepository.findByEmail(req.getEmail());
        
    if(user==null){
        User createdUser=new User();
        createdUser.setEmail(req.getEmail());
        createdUser.setFullName(req.getFullName());
        createdUser.setRole(USER_ROLE.ROLE_CUSTOMER);
        createdUser.setMobile("917236566");
        createdUser.setPassword(passwordEncoder.encode(req.getOtp()));
        user=userRepository.save(createdUser);

        Cart  cart=new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
    }
      
       List<GrantedAuthority> authorities=new ArrayList<>();
       authorities.add(new SimpleGrantedAuthority(USER_ROLE.ROLE_CUSTOMER.toString()));
       Authentication authentication=new UsernamePasswordAuthenticationToken(req.getEmail(),null,authorities);
       SecurityContextHolder.getContext().setAuthentication(authentication);
        
       
        return jwtProvider.generateTokan(authentication);
        
    }


    @Override
    public void sentLoginOtp(String email) throws Exception {
      String SIGNING_PREFIX="signin_";
      if(email.startsWith(SIGNING_PREFIX)){
        email.substring(SIGNING_PREFIX.length());
        
        User user=userRepository.findByEmail(email);
        if(user==null){
          throw new Exception("user not exit with provided email"); 
        }
      }
      VerificationCode isExit=verificationCodeRepo.findByEmail(email);
      if(isExit!=null){
        verificationCodeRepo.delete(isExit);
        
      }
      String otp=OtpUtil.generateOtp();
      VerificationCode verificationCode=new VerificationCode();
      verificationCode.setOtp(otp);
      verificationCode.setEmail(email);

      verificationCodeRepo.save(verificationCode);

      String subject="vaibhav bazar login/signup otp";

      String text="your login/signup otp is -"+otp;

      emailService.sendVerificationOtpEmail(email,otp,subject,text);


      
    }


   
    //verify otp 

    @Override
    public AuthResponse siging(com.demo.ecommerce.request.LoginRequest req) {
      String username=req.getEmail();
      String otp=req.getOtp();
      Authentication  authentication=authenticate(username,otp);
      SecurityContextHolder.getContext().setAuthentication(authentication);
      String tokan=jwtProvider.generateTokan(authentication);
      AuthResponse authResponse=new AuthResponse();
      authResponse.setJwt(tokan);
      authResponse.setMessage("Login success");
      Collection<? extends GrantedAuthority > authorities=authentication.getAuthorities();
      String roleName=authorities.isEmpty()?null:authorities.iterator().next().getAuthority();
      authResponse.setRole(USER_ROLE.valueOf(roleName));

      return authResponse;
    }


    private Authentication authenticate(String username, String otp) {
     UserDetails userDetails= customUserServiceImpl.loadUserByUsername(username);
     if(userDetails==null){
      throw new BadCredentialsException("Invalid username or password");

     }
     VerificationCode verificationCode=verificationCodeRepo.findByEmail(username);
     if(verificationCode==null || !verificationCode.getOtp().equals(otp)){
      throw new BadCredentialsException("wrong otp");
     } 

     return new UsernamePasswordAuthenticationToken(
      userDetails,
      null,
      userDetails.getAuthorities()
     );


    }

}

