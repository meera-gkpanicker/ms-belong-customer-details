package com.belong.ms.customer.details.controller;

import com.belong.ms.customer.details.api.CustomerDetailsResponse;
import com.belong.ms.customer.details.service.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class CustomerDetailsController {

    private static final String GET_ALL_PHONE_NUMBERS = "/phonenumbers/list";
    private static final String GET_PHONE_NUMBERS_BY_CUSTOMER = "/phonenumbers/{customer}";
    private static final String ACTIVATE_PHONE_NUMBER = "/activate/{phoneNumber}";

    private final CustomerDetailsService customerDetailsService;

    @GetMapping(GET_ALL_PHONE_NUMBERS)
    public ResponseEntity<CustomerDetailsResponse> getAllPhoneNumbers(final HttpServletRequest httpServletRequest,
                                                                   @RequestHeader final HttpHeaders requestHeaders) {

        return new ResponseEntity<>(customerDetailsService.getAllPhoneNumbers(), HttpStatus.OK);
    }

    @GetMapping(GET_PHONE_NUMBERS_BY_CUSTOMER)
    public ResponseEntity<CustomerDetailsResponse> getPhoneNumbersByCustomer(@PathVariable final String customer,
                                                                            final HttpServletRequest httpServletRequest,
                                                                            @RequestHeader final HttpHeaders requestHeaders) {
        return new ResponseEntity<>(customerDetailsService.getPhoneNumberByCustomer(customer), HttpStatus.OK);
    }

    @PostMapping(ACTIVATE_PHONE_NUMBER)
    public ResponseEntity<CustomerDetailsResponse> activatePhoneNumber(@PathVariable final String phoneNumber,
                                                                            final HttpServletRequest httpServletRequest,
                                                                            @RequestHeader final HttpHeaders requestHeaders) {
        return new ResponseEntity<>(customerDetailsService.activatePhoneNumber(phoneNumber), HttpStatus.OK);
    }
}
