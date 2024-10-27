package com.demo.ecommerce.service;

import java.util.List;

import com.demo.ecommerce.modal.Order;
import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.modal.Transaction;

public interface TransactionService {

    Transaction createTransaction(Order order);
    List<Transaction> getTransactionBySellerId(Seller seller);
    List<Transaction> getAllTransaction();
} 