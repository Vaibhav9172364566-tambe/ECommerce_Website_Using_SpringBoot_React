package com.demo.ecommerce.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.ecommerce.modal.Order;
import com.demo.ecommerce.modal.Seller;
import com.demo.ecommerce.modal.Transaction;
import com.demo.ecommerce.repositiory.SellerRepository;
import com.demo.ecommerce.repositiory.TransactionRepository;
import com.demo.ecommerce.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final SellerRepository sellerRepository;

    @Override
    public Transaction createTransaction(Order order) {

        Seller seller=sellerRepository.findById(order.getSellerId()).get();
        Transaction transaction=new Transaction();
        transaction.setSeller(seller);
        transaction.setCutomer(order.getUser());
        transaction.setOrder(order);

        return transactionRepository.save(transaction);
        
    }

    @Override
    public List<Transaction> getTransactionBySellerId(Seller seller) {

        return transactionRepository.findBySellerId(seller.getId());
      
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
        
    }

}
