package com.demo.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ecommerce.exception.ProductException;
import com.demo.ecommerce.modal.Cart;
import com.demo.ecommerce.modal.CartItem;
import com.demo.ecommerce.modal.Product;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.request.AddItemRequest;
import com.demo.ecommerce.response.ApiResponse;
import com.demo.ecommerce.service.CartItemService;
import com.demo.ecommerce.service.CartService;
import com.demo.ecommerce.service.ProductService;
import com.demo.ecommerce.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")

public class CartControoler {
    private final CartService cartService;
    private final CartItemService cartItemService;
    private final UserService userService;
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Cart> findUserCartHandler(
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtTokan(jwt);
        Cart cart = cartService.findUserCart(user);

        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity<CartItem> addItemToCart(@RequestBody AddItemRequest req,
            @RequestHeader("Authorization") String jwt) throws ProductException,Exception {
                User user=userService.findUserByJwtTokan(jwt);
                Product product=productService.findProductsById(req.getProductId());

              CartItem item=cartService.addCartItem(user, product, jwt, req.getQuantity());

              ApiResponse res=new ApiResponse();
              res.setMessage("Item added to cart Succefully");
              return new ResponseEntity<>(item,HttpStatus.ACCEPTED);

    }


     @DeleteMapping("/item/{cartItemId}")
        public ResponseEntity<ApiResponse> deleteCartItemHandler(
            @PathVariable Long cartItemid,
            @RequestHeader("Authorization") String jwt
        ) throws Exception{
            User user=userService.findUserByJwtTokan(jwt);
            cartItemService.removeCartItem(user.getId(), cartItemid);
            ApiResponse res=new ApiResponse();
            res.setMessage("Item remove from Cart");
            return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
            
        }

        @PutMapping("/item/{cartItemId}")
             public ResponseEntity<CartItem> updateCartItemHandler(
                @PathVariable Long cartItemId,
                @RequestBody CartItem cartItem,
                @RequestHeader("Authorization") String jwt) throws Exception{

                    User user=userService.findUserByJwtTokan(jwt);
                    CartItem updatedCartItem=null;
                    if(cartItem.getQuantity() >0){
                        updatedCartItem=cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);
                    }

                    return new ResponseEntity<>(updatedCartItem,HttpStatus.ACCEPTED);

                }

    

}
