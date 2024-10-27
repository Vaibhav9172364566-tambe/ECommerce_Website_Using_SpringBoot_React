package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.WishList;

public interface WishListRepository extends JpaRepository<WishList,Long> {

    WishList findByUserId(Long userId);


}
