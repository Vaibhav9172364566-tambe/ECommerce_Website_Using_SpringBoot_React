package com.demo.ecommerce.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.modal.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findBySellerId(Long sellerId);
}
