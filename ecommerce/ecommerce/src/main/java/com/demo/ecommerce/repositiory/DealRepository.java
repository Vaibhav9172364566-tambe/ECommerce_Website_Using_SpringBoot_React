package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.Deal;

public interface DealRepository extends JpaRepository<Deal,Long> {

}
