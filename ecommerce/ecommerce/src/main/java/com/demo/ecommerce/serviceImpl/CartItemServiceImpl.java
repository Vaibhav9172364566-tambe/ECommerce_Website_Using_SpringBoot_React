package com.demo.ecommerce.serviceImpl;

import org.springframework.stereotype.Service;

import com.demo.ecommerce.modal.CartItem;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.repositiory.CartItemRepository;
import com.demo.ecommerce.service.CartItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CartItemServiceImpl implements CartItemService{

    private final CartItemRepository cartItemRepository;
    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws Exception {

        CartItem item=findCartItemById(id);
        User cartItemUser=item.getCart().getUser();
        if(cartItemUser.getId().equals(userId)){
            item.setQuantity(cartItem.getQuantity());
            item.setMrpPrice(item.getQuantity()*item.getProduct().getMrpPrice());
            item.setSellingPrice(item.getQuantity()*item.getProduct().getSellingPrice());
            return cartItemRepository.save(item);

        }
        throw new Exception("you can`t update this cartitem");
       
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws Exception {
       
        CartItem item=findCartItemById(cartItemId);
        User CartItemUser=item.getCart().getUser();
        if(CartItemUser.getId().equals(userId)){
            cartItemRepository.delete(item);

        }
        else throw new Exception("You can`t delete this item");
    }

    @Override
    public CartItem findCartItemById(Long id) throws Exception {

        return cartItemRepository.findById(id).orElseThrow(()->
        new Exception("cart item not found with id :"+id));
        
    }

}
