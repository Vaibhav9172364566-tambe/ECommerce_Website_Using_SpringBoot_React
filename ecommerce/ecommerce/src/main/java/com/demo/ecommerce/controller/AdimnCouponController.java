package com.demo.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.Coupon;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.service.CartService;
import com.demo.ecommerce.service.CouponService;
import com.demo.ecommerce.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coupons")
public class AdimnCouponController {
    private final CouponService couponService;
    private final UserService userService;
    private final CartService cartService;

    @PostMapping("/apply")

    public ResponseEntity<Cart> applyCoupon(
        @RequestParam String apply,
        @RequestParam String code,
        @RequestParam double orderValue,
        @RequestHeader("Authorization") String jwt
    ) throws Exception{
        User user=userService.findUserByJwtTokan(jwt);
        Cart cart;
        if(apply.equals("true")){
            cart=couponService.applyCoupon(code, orderValue, user);
        }
        else{
            cart=couponService.removeCoupon(code, user);
        }
        return ResponseEntity.ok(cart);
    }


      //admin operation

      @PostMapping("/admin/create")
      public ResponseEntity<Coupon> createCoupon(
        @RequestBody Coupon coupon
      ){
        Coupon createCoupon=couponService.createCoupon(coupon);
        return ResponseEntity.ok(createCoupon);
      }


      @DeleteMapping("admin/delete/{id}")
      public ResponseEntity<?> deleteCoupon(
        @PathVariable Long id
      ) throws Exception{
        couponService.deleteCoupon(id);
        return ResponseEntity.ok("coupon deleted successfully");
      }

      @GetMapping("/admin/all")
      public ResponseEntity<List<Coupon>> getAllCoupons(){
        List<Coupon> coupons=couponService.findAllCoupons();
        return ResponseEntity.ok(coupons);
      }


}
