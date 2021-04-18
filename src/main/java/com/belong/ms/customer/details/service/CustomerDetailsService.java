package com.belong.ms.customer.details.service;

import com.belong.ms.customer.details.api.*;
import com.belong.ms.customer.details.exception.*;
import com.belong.ms.customer.details.repository.CustomerDetailsRepository;
import com.belong.ms.customer.details.repository.PhoneNumberRepository;
import com.belong.ms.customer.details.repository.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.*;

import java.util.*;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {

    private final CustomerDetailsRepository customerDetailsRepository;
    private final PhoneNumberRepository phoneNumberRepository;

    public CustomerDetailsResponse getAllPhoneNumbers() {
        List<CustomerPhone> phoneList = phoneNumberRepository.findAll();
        if(CollectionUtils.isEmpty(phoneList)) {
            throw new CustomerDetailsException("There are no phone numbers present:", Status.NOT_FOUND);
        }
        ;
        return CustomerDetailsResponse.builder().customerPhoneList(phoneList.stream().map(CustomerPhone::getPhoneNumber).collect(Collectors.toList())).build();
    }

    public CustomerDetailsResponse getPhoneNumberByCustomer(String customerName) {
        List<Customer> customerList = customerDetailsRepository.findPhoneNumberByCustomerName(customerName);

        if(CollectionUtils.isEmpty(customerList) || CollectionUtils.isEmpty(customerList.get(0).getPhoneNumbers())) {
            throw new CustomerDetailsException("There are no phonenumbers found for this customer.", Status.NOT_FOUND);
        }
        List<String> phoneNumbers = customerList.get(0).getPhoneNumbers().stream().map(CustomerPhone::getPhoneNumber).collect(Collectors.toList());
        return CustomerDetailsResponse.builder().customerPhoneList(phoneNumbers).build();
    }

    public CustomerDetailsResponse activatePhoneNumber(String phoneNumber) {
        List<CustomerPhone> customerPhoneList = phoneNumberRepository.findByPhoneNumber(phoneNumber);
        if(CollectionUtils.isEmpty(customerPhoneList)) {
            throw new CustomerDetailsException("There are no records present for this phone number.", Status.NOT_FOUND);
        }
        CustomerPhone customerPhone = customerPhoneList.get(0);
        customerPhone.setIsActive(true);
        customerPhone = phoneNumberRepository.save(customerPhone);
        return CustomerDetailsResponse.builder().isPhoneActive(customerPhone.getIsActive()).phoneNumber(phoneNumber).build();
    }
}
