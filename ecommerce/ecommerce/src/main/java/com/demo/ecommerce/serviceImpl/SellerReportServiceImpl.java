package com.demo.ecommerce.serviceImpl;

import org.springframework.stereotype.Service;

import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.modal.SellerReport;
import com.demo.ecommerce.repositiory.SellerReportRepository;
import com.demo.ecommerce.service.SellerReportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellerReportServiceImpl implements SellerReportService {

    private final SellerReportRepository sellerReportRepository;

    @Override
    public SellerReport getSellerReport(Seller seller) {
     
        SellerReport sr=sellerReportRepository.findBySellerId(seller.getId());
     if(sr==null){
        SellerReport newReport=new SellerReport();
        newReport.setSeller(seller);
        return sellerReportRepository.save(newReport);
     }
     return sr;
    }

    @Override
    public SellerReport updateSellerReport(SellerReport sellerReport) {
        return sellerReportRepository.save(sellerReport);
    }

}
