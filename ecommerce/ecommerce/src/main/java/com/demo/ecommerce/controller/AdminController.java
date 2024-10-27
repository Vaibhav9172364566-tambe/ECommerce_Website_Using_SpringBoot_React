package com.demo.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.domain.AccountStatus;
import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.service.SellerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AdminController {
    private final SellerService sellerService;

    @PatchMapping("/seller/{id}/status/{status}")

    public ResponseEntity<Seller> updateSellerStatus
(
    @PathVariable Long id,
    @PathVariable AccountStatus status
) throws Exception{
    Seller updatedSeller=sellerService.updateSellerAccountStatus(id, status);
    return ResponseEntity.ok(updatedSeller);
}
}
