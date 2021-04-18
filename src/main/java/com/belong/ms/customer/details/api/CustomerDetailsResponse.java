package com.belong.ms.customer.details.api;

import com.belong.ms.customer.details.repository.dto.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsResponse {

   // List<Account> accountsList;
   // List<AccountTransaction> accountTransactionList;
   List<String> customerPhoneList;
   List<Customer> customerList;
   Boolean isPhoneActive;
   String phoneNumber;
}
