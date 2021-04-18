package com.belong.ms.customer.details.repository;

import com.belong.ms.customer.details.repository.dto.CustomerPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PhoneNumberRepository extends JpaRepository<CustomerPhone, Long> {

    List<CustomerPhone> findByPhoneNumber(String phoneNumber);

}
