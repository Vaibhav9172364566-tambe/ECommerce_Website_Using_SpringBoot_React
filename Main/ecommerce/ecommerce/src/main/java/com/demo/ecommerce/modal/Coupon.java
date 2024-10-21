package com.demo.ecommerce.modal;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
 public class Coupon {


    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String code;
    private double dicountPercentage;
    private LocalDate validityStartDate;
    private LocalDate validityEndDate;
    private double minimunOrderValue;
    private boolean isActive=true;
    @ManyToMany(mappedBy = "usedCoupons")
    private Set<User> usedByUser=new HashSet<>();



}
