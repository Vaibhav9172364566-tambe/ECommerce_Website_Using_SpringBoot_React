package com.demo.ecommerce.modal;

import org.hibernate.mapping.OneToMany;

import java.util.*;

import com.demo.ecommerce.domain.USER_ROLE;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private String email;

    private String fullName;
    private String mobile;
    private USER_ROLE role=USER_ROLE.ROLE_CUSTOMER;
  


    @jakarta.persistence.OneToMany
    private  Set<Address> address=new  HashSet<>();
    public Set<Address> getAddress() {
        return address;
    }
    @ManyToMany
    @JsonIgnore

    private Set<Coupon> useCopons=new HashSet<>();
    public String getEmail() {
       
        return email;
    }
    public String getPassword() {
        
        return password;
    }
    public USER_ROLE getRole() {
        
        return role;
    }


   


}
