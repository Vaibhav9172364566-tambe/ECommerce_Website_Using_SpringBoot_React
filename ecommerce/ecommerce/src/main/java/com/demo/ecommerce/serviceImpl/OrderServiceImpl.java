package com.demo.ecommerce.serviceImpl;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.ecommerce.domain.OrderStatus;
import com.demo.ecommerce.domain.PaymentStatus;
import com.demo.ecommerce.modal.Address;
import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.CartItem;
import com.demo.ecommerce.modal.Order;
import com.demo.ecommerce.modal.OrderItem;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.repositiory.AddressRepository;
import com.demo.ecommerce.repositiory.OrderItemRepository;
import com.demo.ecommerce.repositiory.OrderRepository;
import com.demo.ecommerce.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl  implements OrderService{

    private final OrderRepository orderRepository;
    private final  AddressRepository addressRepository;
    private final OrderItemRepository orderItemRepository;


    @Override
    public Set<Order> createOrder(User user, Address shippingAddress, Cart cart) {
        
        if (!user.getAddress().contains(shippingAddress)) {
            user.getAddress().add(shippingAddress);
        }
        Address address=addressRepository.save(shippingAddress);

      
    // Group cart items by seller
    Map<Long, List<CartItem>> itemsBySeller = cart.getCartItems().stream()
    .collect(Collectors.groupingBy(item -> item.getProduct().getSeller().getId()));

Set<Order> orders = new HashSet<>();

        // Iterate through each seller's items to create individual orders
    for (Map.Entry<Long, List<CartItem>> entry : itemsBySeller.entrySet()) {
        Long sellerId = entry.getKey();
        List<CartItem> items = entry.getValue();

        int totalOrderPrice = items.stream().mapToInt(CartItem::getSellingPrice).sum();
        int totalItem = items.stream().mapToInt(CartItem::getQuantity).sum();

        // Create a new order
        Order createOrder = new Order();
        createOrder.setUser(user);
        createOrder.setSellerId(sellerId);
        createOrder.setTotalMrpPrice(totalOrderPrice);
        createOrder.setTotalSellingPrice(totalOrderPrice); // Adjust if needed for discounts
        createOrder.setTotalItem(totalItem);
        createOrder.setShippingAddress(address);
        createOrder.setOrderStatus(OrderStatus.PENDING);
        createOrder.getPaymentDetails().setStatus(PaymentStatus.PENDING);

        // Save the order and add it to the set of orders
        Order savedOrder = orderRepository.save(createOrder);
        orders.add(savedOrder);


        List<OrderItem> orderItems=new ArrayList<>();
        for(CartItem item:items){
            OrderItem orderItem=new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setMrpPrice(item.getMrpPrice());
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setSize(item.getSize());
            orderItem.setUserId(item.getUserId());
            orderItem.setSellingPrice(item.getSellingPrice());
            savedOrder.getOrderItem().add(orderItem);

            OrderItem savedOrderItem=orderItemRepository.save(orderItem);
            orderItems.add(savedOrderItem);

        }
        }

        return orders;
     
    }

    @Override
    public Order findOrderById(Long id) throws Exception {
        return orderRepository.findById(id).orElseThrow(()->
        new Exception("Order not found"));
    }

    @Override
    public List<Order> usersOrderHistory(Long userId) {
        return orderRepository.findByUserId(userId);

    }

    

    @Override
    public List<Order> sellerOrder(Long sellerId) {
        
        return orderRepository.findBySellerId(sellerId);
    }

    @Override
    public Order updateOrderStatus(Long orderId, OrderStatus orderStatus) throws Exception {
        
        Order order=findOrderById(orderId);
        order.setOrderStatus(orderStatus);
        return orderRepository.save(order);
    }

    @Override
    public Order cancleOrder(Long orderId, User user) throws Exception {

        
        Order order=findOrderById(orderId);
        if(user.getId().equals(order.getUser().getId())){
            throw new Exception("you don`t have access to this order");
        }
        order.setOrderStatus(OrderStatus.CANCELLED);
        return orderRepository.save(order);

        
    }

    @Override
    public OrderItem getOrderItemById(Long id) throws Exception {
        return orderItemRepository.findById(id).orElseThrow(()-> 
        new Exception("order item not exit...."));
      
    }

   

    
}
