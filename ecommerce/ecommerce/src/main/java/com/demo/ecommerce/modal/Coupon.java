package com.demo.ecommerce.modal;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Coupon {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private double discountPercentage;
    private LocalDate validityStartData;
    private LocalDate validityEndDate;
    private double minimunOrderValue;
    private boolean isActive=true;
    @ManyToMany(mappedBy = "useCopons")
    private Set<User> usedByUsers=new HashSet<>();



}
