package com.demo.ecommerce.controller;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.domain.OrderStatus;
import com.demo.ecommerce.modal.Order;
import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.service.OrderService;
import com.demo.ecommerce.service.SellerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seller/orders")
public class SellerOrderController {
    private final OrderService orderService;
    private final SellerService sellerService;

    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrderHandler(@RequestHeader("Authorization")String jwt) throws Exception{
        Seller seller=sellerService.getSellerProfile(jwt);
        List<Order> orders=orderService.sellerOrder(seller.getId());
        return new ResponseEntity<>(orders,HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{orderId}/status/{orderStatus}")
    public ResponseEntity<Order> updateOrderHandler(
        @RequestHeader("Authorization") String jwt,
        @PathVariable Long orderId,
        @PathVariable OrderStatus orderStatus
    ) throws Exception{
        Order orders=orderService.updateOrderStatus(orderId, orderStatus);
        return new ResponseEntity<>(orders,HttpStatus.ACCEPTED);
    }

}
