package com.demo.ecommerce.service;

import com.demo.ecommerce.modal.Product;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.modal.WishList;

public interface WishListService {

WishList createWishList(User user);
WishList getWishListByUserId(User user);
WishList addProductToWishList(User user,Product product);

}
