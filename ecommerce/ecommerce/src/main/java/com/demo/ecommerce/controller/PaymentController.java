package com.demo.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.service.PaymentService;
import com.stripe.service.climate.OrderService;
import com.demo.ecommerce.modal.PaymentOrder;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.response.*;
import com.demo.ecommerce.service.*;
import com.demo.ecommerce.modal.*;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final  UserService userservice;
    private final SellerService sellerService;
    private OrderService orderService;
    private final SellerReportService sellerReportService;
private final TransactionService transactionService;

    @GetMapping("/{paymentId")
    public ResponseEntity<ApiResponse> paymentSuccessHandler(
        @PathVariable String paymentId,
        @RequestParam String paymentLinkId,
        @RequestHeader("Authorization") String jwt) throws Exception{

            User user=userservice.findUserByJwtTokan(jwt);

            PaymentLinkResponse paymentResponse;
            PaymentOrder paymentOrder=paymentService.getPaymentOrderByPaymentId(paymentLinkId);

            boolean paymentSuccess=paymentService.ProceedPaymentOrder(paymentOrder, paymentId, paymentLinkId);


            if(paymentSuccess){
                for(Order order:paymentOrder.getOrders()){
                    transactionService.createTransaction(order);
                    Seller seller=sellerService.getSellerById(order.getSellerId());
                    SellerReport report=sellerReportService.getSellerReport(seller);
                    report.setTotalOrders(report.getTotalOrders()+1);
                    report.setTotalEarnings(report.getTotalEarnings()+order.getTotalSellingPrice());
                    report.setTotalSales(report.getTotalSales()+order.getOrderItem().size());
                    sellerReportService.updateSellerReport(report);

                }

                 
            }
            ApiResponse res=new ApiResponse();
            res.setMessage("Payment successfull");
            return new ResponseEntity<>(res,HttpStatus.CREATED);

        }



}
