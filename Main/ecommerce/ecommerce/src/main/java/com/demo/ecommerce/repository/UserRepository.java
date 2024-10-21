package com.demo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
    

    
} 