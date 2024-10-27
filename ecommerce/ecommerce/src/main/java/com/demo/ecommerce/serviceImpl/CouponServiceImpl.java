package com.demo.ecommerce.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.Coupon;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.repositiory.CartRepository;
import com.demo.ecommerce.repositiory.CouponRepository;
import com.demo.ecommerce.repositiory.UserRepository;
import com.demo.ecommerce.service.CouponService;

import jakarta.el.ELException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
    
    private final CouponRepository couponRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    
    @Override
    public Cart applyCoupon(String code, double orderValue, User user) throws Exception {
       
        Coupon coupon=couponRepository.findByCode(code);

        Cart cart=cartRepository.findByUserId(user.getId());
        if (coupon == null) {
            throw new Exception("Coupon not valid");
        }
        
        if(user.getUsedCopons().contains(coupon)){
            throw new Exception("coupon already used");
        }
        if(orderValue<coupon.getMinimunOrderValue()){
            throw new Exception("valid for minimum order value :" +coupon.getMinimunOrderValue());
        }

        if(coupon.isActive() && LocalDate.now().isAfter(coupon.getValidityStartData())
        && LocalDate.now().isBefore(coupon.getValidityEndDate())
        ){
            user.getUsedCopons().add(coupon);
            userRepository.save(user);

            double discountedPrice=(cart.getTotalSellingPrice()+coupon.getDiscountPercentage())/100;

            cart.setTotalSellingPrice(cart.getTotalSellingPrice()-discountedPrice);

            cart.setCouponCode(code);
            cartRepository.save(cart);

            return cart;

        }
        throw new Exception("coupon not valid");
        
    }

    @Override
    public Cart removeCoupon(String code, User user) throws Exception {
        Coupon coupon=couponRepository.findByCode(code);

        if(coupon==null){
            throw new Exception("coupon not found");
        }
        Cart cart=cartRepository.findByUserId(user.getId());

        double discountedPrice=(cart.getTotalSellingPrice()+coupon.getDiscountPercentage())/100;

            cart.setTotalSellingPrice(cart.getTotalSellingPrice()-discountedPrice);

            cart.setCouponCode(null);
            return cartRepository.save(cart);
      
    }

    @Override
    public Coupon findCouponById(Long id) throws Exception {

        return couponRepository.findById(id).orElseThrow(()-> new Exception("coupon not found"));
        
    }

    @Override
    @PreAuthorize("hasRole ('Admin')")
    public Coupon createCoupon(Coupon coupon) {

        return couponRepository.save(coupon);
        
    }

    @Override
    public List<Coupon> findAllCoupons() {
        return couponRepository.findAll();
       
    }

    @Override
    @PreAuthorize("hasRole ('Admin')")
    public void deleteCoupon(Long id) throws Exception {

        findCouponById(id);
        couponRepository.deleteById(id);
        
    }

}
