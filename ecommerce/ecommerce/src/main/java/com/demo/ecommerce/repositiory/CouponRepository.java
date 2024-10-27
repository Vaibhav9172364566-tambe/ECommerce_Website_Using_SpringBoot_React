package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.Coupon;

public interface CouponRepository extends JpaRepository<Coupon,Long>{

    Coupon findByCode(String code);
    

}
