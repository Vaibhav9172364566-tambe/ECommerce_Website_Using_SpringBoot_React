package com.demo.ecommerce.service;

import java.util.List;

import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.Coupon;
import com.demo.ecommerce.modal.User;

public interface CouponService {
    Cart applyCoupon(String code,double orderValue,User user) throws Exception;
    Cart removeCoupon(String code,User user) throws Exception;
    Coupon findCouponById(Long id) throws Exception;
    Coupon createCoupon(Coupon coupon);
    List<Coupon> findAllCoupons();
    void deleteCoupon(Long id) throws Exception;


}
