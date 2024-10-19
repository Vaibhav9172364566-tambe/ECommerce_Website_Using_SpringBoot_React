package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.Address;

public interface AddressRepository extends JpaRepository<Address ,Long> {

    
} 
