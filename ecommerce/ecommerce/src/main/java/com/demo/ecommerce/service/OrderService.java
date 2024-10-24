package com.demo.ecommerce.service;

import java.util.*;

import com.demo.ecommerce.domain.OrderStatus;
import com.demo.ecommerce.modal.Address;
import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.Order;
import com.demo.ecommerce.modal.OrderItem;
import com.demo.ecommerce.modal.User;

public interface OrderService {
    Set<Order> createOrder(User user,Address shippingAddress,Cart cart);

    Order findOrderById(Long id) throws Exception;


   List<Order> sellerOrder(Long sellerId);

   Order updateOrderStatus(Long orderId,OrderStatus orderStatus) throws Exception;

   Order cancleOrder(Long orderId,User user) throws Exception;

List<Order> usersOrderHistory(Long id);
OrderItem getOrderItemById(Long id) throws Exception;
    


    
}