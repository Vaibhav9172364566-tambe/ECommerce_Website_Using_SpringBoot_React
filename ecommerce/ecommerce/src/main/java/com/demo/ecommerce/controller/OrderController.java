package com.demo.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.domain.PaymentMethod;
import com.demo.ecommerce.modal.Address;
import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.Order;
import com.demo.ecommerce.modal.OrderItem;
import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.modal.SellerReport;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.response.PaymentLinkResponse;
import com.demo.ecommerce.service.CartService;
import com.demo.ecommerce.service.OrderService;
import com.demo.ecommerce.service.SellerReportService;
import com.demo.ecommerce.service.SellerService;
import com.demo.ecommerce.service.UserService;
import java.util.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final SellerReportService sellerReportService;
    private final CartService cartService;
    private final SellerService sellerService;

    @PostMapping()
    public ResponseEntity<PaymentLinkResponse> creareOrderHandler(
            @RequestBody Address shippingAddress,
            @RequestParam PaymentMethod paymentMethod,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtTokan(jwt);
        Cart cart = cartService.findUserCart(user);
        Set<Order> orders = orderService.createOrder(user, shippingAddress, cart);
        PaymentLinkResponse res = new PaymentLinkResponse();

        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    @GetMapping("/user")
    public ResponseEntity<List<Order>> userOrderHistoryHandler(
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtTokan(jwt);
        List<Order> orders = orderService.usersOrderHistory(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtTokan(jwt);
        Order order = orderService.findOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
    }
    @GetMapping("/item/{orderItemId}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long orderItemId,@RequestHeader("Authorization")String jwt) throws Exception{
        System.out.println("............controller");
        User user =userService.findUserByJwtTokan(jwt);
        OrderItem orderItem=orderService.getOrderItemById(orderItemId);
        return new ResponseEntity<>(orderItem,HttpStatus.ACCEPTED);

    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancleOrder(
        @PathVariable Long orderId,
        @RequestHeader("Authorization")String jwt
    ) throws Exception{

        User user=userService.findUserByJwtTokan(jwt);
        Order order=orderService.cancleOrder(orderId, user);

        Seller seller=sellerService.getSellerById(order.getSellerId());
        SellerReport report=sellerReportService.getSellerReport(seller);

        report.setCanceledOrders(report.getCanceledOrders()+1);
        report.setTotalRefunds(report.getTotalRefunds()+order.getTotalSellingPrice());
        sellerReportService.updateSellerReport(report);

        return ResponseEntity.ok(order);
    }

}
