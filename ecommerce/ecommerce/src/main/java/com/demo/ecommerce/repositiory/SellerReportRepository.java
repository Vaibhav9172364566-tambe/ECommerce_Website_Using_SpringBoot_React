package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.SellerReport;

public interface SellerReportRepository extends JpaRepository<SellerReport ,Long>{

    SellerReport findBySellerId(Long sellerId);
    
} 