package com.demo.ecommerce.modal;

import com.demo.ecommerce.domain.AccountStatus;
import com.demo.ecommerce.domain.USER_ROLE;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sellerName;

    private String mobile;

    @Column(unique = true,nullable = false)
    private String email;
    private String password;

    @Embedded 
   private  BusinessDetails businessDetails=new BusinessDetails();
   
   @Embedded
   private BankDetails bankDetails=new BankDetails();

   @OneToOne(cascade = CascadeType.ALL)
   private Address pickupAddress=new Address();
  
    private String GSTIN;

    private USER_ROLE role=USER_ROLE.ROLE_SELLER;

    private boolean isEmailVerified=false;

    private AccountStatus accountStatus=AccountStatus.PENDING_VERIFICATION;


}


