// package com.demo.ecommerce.serviceImpl;
// import java.util.*;


// import org.springframework.security.authentication.BadCredentialsException;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.demo.ecommerce.config.JwtProvider;
// import com.demo.ecommerce.domain.USER_ROLE;
// import com.demo.ecommerce.modal.Cart;
// import com.demo.ecommerce.modal.Seller;
// import com.demo.ecommerce.modal.User;
// import com.demo.ecommerce.modal.VerificationCode;
// import com.demo.ecommerce.repositiory.CartRepository;
// import com.demo.ecommerce.repositiory.SellerRepository;
// import com.demo.ecommerce.repositiory.UserRepository;
// import com.demo.ecommerce.repositiory.VerificationCodeRepo;
// import com.demo.ecommerce.response.AuthResponse;
// import com.demo.ecommerce.service.AuthService;
// import com.demo.ecommerce.service.EmailService;
// import com.demo.ecommerce.service.SignupRequest;
// import com.demo.ecommerce.util.OtpUtil;

// import lombok.RequiredArgsConstructor;


// @Service
// @RequiredArgsConstructor
// public class AuthServiceImpl implements AuthService{

    

//     private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//     private final CartRepository cartRepository;
//     private final JwtProvider jwtProvider;
//     private final VerificationCodeRepo verificationCodeRepo;
//     private final EmailService emailService;
//     private final CustomUserServiceImpl customUserServiceImpl;
//     private final SellerRepository sellerRepository;

    
//     @Override
//     public String createUser(SignupRequest req) throws Exception {

//       VerificationCode verificationCode=verificationCodeRepo.findByEmail(req.getEmail());

//       if(verificationCode==null ||!verificationCode.getOtp().equals(req.getOtp())){
//         throw new Exception("Wrong otp...");


//       }

//         //user are all ready exit or not
//         User user=userRepository.findByEmail(req.getEmail());
        
//     if(user==null){
//         User createdUser=new User();
//         createdUser.setEmail(req.getEmail());
//         createdUser.setFullName(req.getFullName());
//         createdUser.setRole(USER_ROLE.ROLE_CUSTOMER);
//         createdUser.setMobile("917236566");
//         createdUser.setPassword(passwordEncoder.encode(req.getOtp()));
//         user=userRepository.save(createdUser);

//         Cart  cart=new Cart();
//         cart.setUser(user);
//         cartRepository.save(cart);
//     }
      
//        List<GrantedAuthority> authorities=new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(USER_ROLE.ROLE_CUSTOMER.toString()));
//        Authentication authentication=new UsernamePasswordAuthenticationToken(req.getEmail(),null,authorities);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        
       
//         return jwtProvider.generateTokan(authentication);
        
//     }


//     @Override
//     public void sentLoginOtp(String email,USER_ROLE role) throws Exception {
//       String SIGNING_PREFIX="signing_";


//       if(email.startsWith(SIGNING_PREFIX)){
//         email=email.substring(SIGNING_PREFIX.length());



//         if(role.equals(USER_ROLE.ROLE_SELLER)){

//           Seller seller=sellerRepository.findByEmail(email);
//           if(seller==null){
//             throw new Exception("Seller not found");
//           }

          
//         }
//         else{
//           System.out.println("email :" +email);
//           User user=userRepository.findByEmail(email);
//           if(user ==null){
//             throw new Exception("user not exit with provided email");
//           }
          
//         }
        
//         User user=userRepository.findByEmail(email);
//         if(user==null){
//           throw new Exception("user not exit with provided email"); 
//         }
//       }
//       VerificationCode isExit=verificationCodeRepo.findByEmail(email);
//       if(isExit!=null){
//         verificationCodeRepo.delete(isExit);
        
//       }
//       String otp=OtpUtil.generateOtp();
//       VerificationCode verificationCode=new VerificationCode();
//       verificationCode.setOtp(otp);
//       verificationCode.setEmail(email);

//       verificationCodeRepo.save(verificationCode);

//       String subject="vaibhav bazar login/signup otp";

//       String text="your login/signup otp is -"+otp;

//       emailService.sendVerificationOtpEmail(email,otp,subject,text);


      
//     }


   
//     //verify otp 

//     @Override
//     public AuthResponse siging(com.demo.ecommerce.request.LoginRequest req) throws Exception {


//       String username=req.getEmail();
//       String otp=req.getOtp();


//       Authentication  authentication=authenticate(username,otp);
//       SecurityContextHolder.getContext().setAuthentication(authentication);


//       String tokan=jwtProvider.generateTokan(authentication);

//       AuthResponse authResponse=new AuthResponse();
//       authResponse.setJwt(tokan);
//       authResponse.setMessage("Login success");


//       Collection<? extends GrantedAuthority > authorities=authentication.getAuthorities();
//       String roleName=authorities.isEmpty()?null:authorities.iterator().next().getAuthority();
//       authResponse.setRole(USER_ROLE.valueOf(roleName));

//       return authResponse;
//     }


//     private Authentication authenticate(String username, String otp) throws Exception {

        
//       UserDetails userDetails = customUserServiceImpl.loadUserByUsername(username);
      

//       String SELLER_PREFIX = "seller_";

//       if (username.startsWith(SELLER_PREFIX)) {
//           username = username.substring(SELLER_PREFIX.length());
//       }
  
//       if (userDetails == null) {
//           throw new BadCredentialsException("Invalid username");
//       }
  
//       VerificationCode verificationCode = verificationCodeRepo.findByEmail(username);

//       if (verificationCode == null || !verificationCode.getOtp().equals(otp)) {
//           throw new Exception("wrong  otp enter please again");
//       }
  
      
  
  
  
//       return new UsernamePasswordAuthenticationToken(
//           userDetails,
//           null,
//           userDetails.getAuthorities()
//       );
//   }
  
  
// }





package com.demo.ecommerce.serviceImpl;

import java.util.*;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.config.JwtProvider;
import com.demo.ecommerce.domain.USER_ROLE;
import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.modal.VerificationCode;
import com.demo.ecommerce.repositiory.CartRepository;
import com.demo.ecommerce.repositiory.SellerRepository;
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
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;
    private final JwtProvider jwtProvider;
    private final VerificationCodeRepo verificationCodeRepo;
    private final EmailService emailService;
    private final CustomUserServiceImpl customUserServiceImpl;
    private final SellerRepository sellerRepository;

    @Override
    public String createUser(SignupRequest req) throws Exception {
        VerificationCode verificationCode = verificationCodeRepo.findByEmail(req.getEmail());

        if (verificationCode == null || !verificationCode.getOtp().equals(req.getOtp())) {
            throw new Exception("Wrong OTP.");
        }

        User user = userRepository.findByEmail(req.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(req.getEmail());
            user.setFullName(req.getFullName());
            user.setRole(USER_ROLE.ROLE_CUSTOMER);
            user.setMobile("917236566");
            user.setPassword(passwordEncoder.encode(req.getOtp()));
            userRepository.save(user);

            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(USER_ROLE.ROLE_CUSTOMER.toString()));
        Authentication authentication = new UsernamePasswordAuthenticationToken(req.getEmail(), null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateTokan(authentication);
    }

    @Override
    public void sentLoginOtp(String email, USER_ROLE role) throws Exception {
        String SIGNING_PREFIX = "signing_";

        if (email.startsWith(SIGNING_PREFIX)) {
            email = email.substring(SIGNING_PREFIX.length());
            if (role.equals(USER_ROLE.ROLE_SELLER)) {
                Seller seller = sellerRepository.findByEmail(email);
                if (seller == null) {
                    throw new Exception("Seller not found");
                }
            } else {
                User user = userRepository.findByEmail(email);
                if (user == null) {
                    throw new Exception("User not found with provided email");
                }
            }
        }

        VerificationCode existingCode = verificationCodeRepo.findByEmail(email);
        if (existingCode != null) {
            verificationCodeRepo.delete(existingCode);
        }

        String otp = OtpUtil.generateOtp();
        VerificationCode verificationCode = new VerificationCode();
        verificationCode.setOtp(otp);
        verificationCode.setEmail(email);
        verificationCodeRepo.save(verificationCode);

        String subject = "Vaibhav Bazar Login/Signup OTP";
        String text = "Your login/signup OTP is: " + otp;
        emailService.sendVerificationOtpEmail(email, otp, subject, text);
    }

    @Override
    public AuthResponse siging(LoginRequest req) throws Exception {
        String username = req.getEmail();
        String otp = req.getOtp();

        Authentication authentication = authenticate(username, otp);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateTokan(authentication);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Login successful");

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String roleName = authorities.isEmpty() ? null : authorities.iterator().next().getAuthority();
        authResponse.setRole(USER_ROLE.valueOf(roleName));

        return authResponse;
    }

    private Authentication authenticate(String username, String otp) throws Exception {
        UserDetails userDetails = customUserServiceImpl.loadUserByUsername(username);

        String SELLER_PREFIX = "seller_";
        if (username.startsWith(SELLER_PREFIX)) {
            username = username.substring(SELLER_PREFIX.length());
        }

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username");
        }

        VerificationCode verificationCode = verificationCodeRepo.findByEmail(username);
        if (verificationCode == null || !verificationCode.getOtp().equals(otp)) {
            throw new Exception("Wrong OTP entered, please try again");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

   
}
