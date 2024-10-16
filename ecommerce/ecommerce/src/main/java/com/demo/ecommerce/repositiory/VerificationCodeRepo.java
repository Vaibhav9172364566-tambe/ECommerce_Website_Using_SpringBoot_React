package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.VerificationCode;

public interface VerificationCodeRepo  extends JpaRepository<VerificationCode,Long>{
    VerificationCode findByEmail(String email);


    
}
