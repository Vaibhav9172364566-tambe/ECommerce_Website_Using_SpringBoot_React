package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.Order;
import com.demo.ecommerce.modal.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{

    
} 