package com.demo.ecommerce.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ecommerce.domain.AccountStatus;
import com.demo.ecommerce.modal.Seller;
import java.util.*;

public interface SellerRepository extends JpaRepository<Seller,Long>{
    Seller findByEmail(String email);
    List<Seller> findByAccountStatus(AccountStatus status);

}
