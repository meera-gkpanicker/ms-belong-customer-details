package com.belong.ms.customer.details.repository.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "address")
    private String address;

    @Column(name = "suburb")
    private String suburb;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customer", targetEntity = CustomerPhone.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerPhone> phoneNumbers = new ArrayList<>();
}
