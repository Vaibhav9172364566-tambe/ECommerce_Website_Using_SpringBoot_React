package com.demo.ecommerce.service;

import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.modal.SellerReport;

public interface SellerReportService {

    SellerReport getSellerReport(Seller seller);
    SellerReport updateSellerReport(SellerReport sellerReport);
} 