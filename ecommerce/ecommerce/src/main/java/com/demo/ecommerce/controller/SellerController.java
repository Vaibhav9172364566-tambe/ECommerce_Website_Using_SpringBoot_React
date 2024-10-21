// package com.demo.ecommerce.controller;
// import java.util.*;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestHeader;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.demo.ecommerce.domain.AccountStatus;
// import com.demo.ecommerce.modal.Seller;
// import com.demo.ecommerce.modal.VerificationCode;
// import com.demo.ecommerce.repositiory.VerificationCodeRepo;
// import com.demo.ecommerce.request.LoginRequest;
// import com.demo.ecommerce.response.AuthResponse;
// import com.demo.ecommerce.service.AuthService;
// import com.demo.ecommerce.service.EmailService;
// import com.demo.ecommerce.service.SellerService;
// import com.demo.ecommerce.util.OtpUtil;

// import lombok.RequiredArgsConstructor;

// @RestController
// @RequiredArgsConstructor
// @RequestMapping("/sellers")
// public class SellerController {



//     private final VerificationCodeRepo verificationCodeRepo;
//     private final AuthService authService;
//     private final SellerService sellerService;
//  private final EmailService emailService;

    
 


//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> loginSeller(@RequestBody LoginRequest req) throws Exception {


//         String otp = req.getOtp();
//         String email = req.getEmail();

//         req.setEmail("seller_ " + email);
//         System.out.println(otp +" : "+email);

//         AuthResponse authResponse = authService.siging(req);
        
//         return ResponseEntity.ok(authResponse);

         
//     }

//     @PatchMapping("/verify/{otp}")
//     public ResponseEntity<Seller> verifyEntity(@PathVariable String otp) throws Exception {


//         VerificationCode verificationCode=verificationCodeRepo.findByOtp(otp);
//         if(verificationCode ==null  || !verificationCode.getOtp().equals(otp)){
//             throw new Exception("wrong otp");
//         }
//         Seller seller=sellerService.verifyEmail(verificationCode.getEmail(), otp);
//         return new ResponseEntity<>(seller,HttpStatus.OK);


//     }



//     @PostMapping
//     public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) throws Exception{


//         Seller savedSeller=sellerService.creatSeller(seller);

//         String otp=OtpUtil.generateOtp();

//       VerificationCode verificationCode=new VerificationCode();

//       verificationCode.setOtp(otp);
//       verificationCode.setEmail(seller.getEmail());

//       verificationCodeRepo.save(verificationCode);

//       String subject="Vaibhav Bazar email verification code";
//       String text="Welcome to vaibhav Bazar ,verify your account using this link";
//       String frontend_url="http://localhost:3000/verify-seller/";
//       emailService.sendVerificationOtpEmail(seller.getEmail(), verificationCode.getOtp(), subject, text+frontend_url);
//       return new ResponseEntity<>(savedSeller,HttpStatus.CREATED);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Seller> getSellerById(@PathVariable Long id) throws Exception{
//         Seller seller=sellerService.getSellerById(id);
//         return new ResponseEntity<>(seller,HttpStatus.OK);
//     }

//     @GetMapping("/profile")
//     public ResponseEntity<Seller> getSellerJwt(@RequestHeader("Authorization") String jwt) throws Exception{
//         Seller seller=sellerService.getSellerProfile(jwt);
//         return new ResponseEntity<>(seller,HttpStatus.OK);
//     }

    
//     @GetMapping
//     public ResponseEntity<List<Seller>> getAllSeller(@RequestParam(required = false) AccountStatus status){
//         List<Seller> sellers=sellerService.getAllSeller(status);
//         return ResponseEntity.ok(sellers);
//     }


//     @PatchMapping()
//     public ResponseEntity<Seller> updateSeller(@RequestHeader("Authorization") String jwt,@RequestBody Seller seller) throws Exception{
//         Seller profile=sellerService.getSellerProfile(jwt);
//         Seller updatedSeller=sellerService.updateSeller(profile.getId(), seller);
//         return ResponseEntity.ok(updatedSeller);

//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteSeller(@PathVariable Long id) throws Exception{
//         sellerService.deleteSeller(id);
//         return ResponseEntity.noContent().build();
//     }

// }





package com.demo.ecommerce.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.ecommerce.domain.AccountStatus;
import com.demo.ecommerce.domain.USER_ROLE;
import com.demo.ecommerce.exception.SellerException;
import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.modal.VerificationCode;
import com.demo.ecommerce.repositiory.VerificationCodeRepo;
import com.demo.ecommerce.request.LoginRequest;
import com.demo.ecommerce.response.AuthResponse;
import com.demo.ecommerce.service.AuthService;
import com.demo.ecommerce.service.EmailService;
import com.demo.ecommerce.service.SellerService;
import com.demo.ecommerce.util.OtpUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellers")
public class SellerController {

    private final VerificationCodeRepo verificationCodeRepo;
    private final AuthService authService;
    private final SellerService sellerService;
    private final EmailService emailService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginSeller(@RequestBody LoginRequest req) throws Exception {
        req.setEmail("seller_" + req.getEmail().trim());
        AuthResponse authResponse = authService.siging(req);
        return ResponseEntity.ok(authResponse);
    }

    // @PatchMapping("/verify/{otp}")
    // public ResponseEntity<Seller> verifyEntity(@PathVariable String otp) throws Exception {
    //     VerificationCode code = verificationCodeRepo.findByOtp(otp);
    //     if (code == null) {
    //         throw new Exception("Invalid verification code.");
    //     }
    //     Seller seller = sellerService.verifyEmail(code.getEmail(), otp);
    //     return new ResponseEntity<>(seller, HttpStatus.OK);
    // }

    @PatchMapping("/verify/{otp}")
        public ResponseEntity<Seller> verifyEntity(@PathVariable String otp) throws Exception {
    
    
            VerificationCode verificationCode=verificationCodeRepo.findByOtp(otp);
            if(verificationCode ==null  || !verificationCode.getOtp().equals(otp)){
                throw new Exception("wrong otp");
            }
            Seller seller=sellerService.verifyEmail(verificationCode.getEmail(), otp);
            return new ResponseEntity<>(seller,HttpStatus.OK);
    
        }


    @GetMapping("/otp/{email}")
    public ResponseEntity<String> sendSellerOtp(@PathVariable String email) throws Exception {
        authService.sentLoginOtp(email, USER_ROLE.ROLE_SELLER);
        return new ResponseEntity<>("OTP sent successfully", HttpStatus.OK);
    }




        @PostMapping
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) throws Exception{


        Seller savedSeller=sellerService.creatSeller(seller);

        String otp=OtpUtil.generateOtp();

      VerificationCode verificationCode=new VerificationCode();

      verificationCode.setOtp(otp);
      verificationCode.setEmail(seller.getEmail());

      verificationCodeRepo.save(verificationCode);

      String subject="Vaibhav Bazar email verification code";
      String text="Welcome to vaibhav Bazar ,verify your account using this link";
      String frontend_url="http://localhost:3000/verify-seller/";
      emailService.sendVerificationOtpEmail(seller.getEmail(), verificationCode.getOtp(), subject, text+frontend_url);
      return new ResponseEntity<>(savedSeller,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) throws SellerException{
        Seller seller=sellerService.getSellerById(id);
        return new ResponseEntity<>(seller,HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<Seller> getSellerJwt(@RequestHeader("Authorization") String jwt) throws Exception{
        Seller seller=sellerService.getSellerProfile(jwt);
        return new ResponseEntity<>(seller,HttpStatus.OK);
    }

    
    @GetMapping
    public ResponseEntity<List<Seller>> getAllSeller(@RequestParam(required = false) AccountStatus status){
        List<Seller> sellers=sellerService.getAllSeller(status);
        return ResponseEntity.ok(sellers);
    }


    @PatchMapping()
    public ResponseEntity<Seller> updateSeller(@RequestHeader("Authorization") String jwt,
    @RequestBody Seller seller) throws Exception{
        Seller profile=sellerService.getSellerProfile(jwt);
        Seller updatedSeller=sellerService.updateSeller(profile.getId(), seller);
        return ResponseEntity.ok(updatedSeller);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) throws Exception{
        sellerService.deleteSeller(id);
        return ResponseEntity.noContent().build();
    }
}

