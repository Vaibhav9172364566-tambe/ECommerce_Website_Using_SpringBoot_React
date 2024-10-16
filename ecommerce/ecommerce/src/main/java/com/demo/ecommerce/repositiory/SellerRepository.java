package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long>{
    Seller findByEmail(String email);

}
