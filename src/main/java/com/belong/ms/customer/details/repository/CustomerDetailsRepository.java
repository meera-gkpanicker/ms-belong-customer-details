package com.belong.ms.customer.details.repository;

import com.belong.ms.customer.details.repository.dto.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<Customer, Long> {

    @Query("Select c from Customer c where c.customerName = :customerName")
    List<Customer> findPhoneNumberByCustomerName(String customerName);
}
