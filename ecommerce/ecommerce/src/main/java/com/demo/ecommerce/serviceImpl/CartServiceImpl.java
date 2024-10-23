package com.demo.ecommerce.serviceImpl;

import org.springframework.stereotype.Service;

import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.CartItem;
import com.demo.ecommerce.modal.Product;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.repositiory.CartItemRepository;
import com.demo.ecommerce.repositiory.CartRepository;
import com.demo.ecommerce.service.CartService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    @Override
    public CartItem addCartItem(User user, Product product, String size, int quantity) {
      

        Cart cart=findUserCart(user);
        CartItem isPresent=cartItemRepository.findByCartAndProduct(cart, product);
       if(isPresent ==null){
        CartItem cartItem=new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setUserId(user.getId());
        cartItem.setSize(size);
        
        int totalPrice=quantity*product.getSellingPrice();
        cartItem.setSellingPrice(totalPrice);
        cartItem.setMrpPrice(quantity*product.getMrpPrice());

        cart.getCartItems().add(cartItem);
        cartItem.setCart(cart);

        return cartItemRepository.save(cartItem);


       }
       return isPresent;
    }




    @Override
    public Cart findUserCart(User user) {
         
   Cart cart=cartRepository.findByUserId(user.getId());
   int totalPrice=0;
   int totalDiscountPrice=0;
   int totalItem=0;
   for(CartItem cartItem:cart.getCartItems()){
    totalPrice+=cartItem.getMrpPrice();
    totalDiscountPrice+=cartItem.getSellingPrice();
    totalItem+=cartItem.getQuantity();
   } 
   cart.setTotalMrpPrice(totalItem);
   cart.setTotalItem(totalItem);
   cart.setTotalSellingPrice(totalDiscountPrice);
   cart.setDiscount(calculateDiscountPercentage(totalPrice, totalDiscountPrice));
   cart.setTotalItem(totalItem);
   
        return cart;


        
    }
    private int calculateDiscountPercentage(int mrpPrice, int sellingPrice) {
       
        if(mrpPrice<=0){
            return 0;
        }
        double discount=mrpPrice-sellingPrice;
        double discountPercentage=(discount/mrpPrice)*100;
        return (int)discountPercentage;
    }


}
