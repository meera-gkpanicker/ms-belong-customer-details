package unit.com.belong.ms.customer.details;

import com.belong.ms.customer.details.api.*;
import com.belong.ms.customer.details.controller.*;
import com.belong.ms.customer.details.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerDetailsControllerTest {

    @InjectMocks
    private CustomerDetailsController customerDetailsController;

    @Mock
    private CustomerDetailsService customerDetailsService;

    private HttpHeaders httpHeaders;

    @BeforeEach
    public void setUp() {
        httpHeaders = new HttpHeaders();
        httpHeaders.add("content-type", MediaType.APPLICATION_JSON_VALUE);
    }

    @Test
    public void testGetAllPhoneNumbersReturnSuccess() {
        List<String> phoneNumbersList = Arrays.asList(new String[] {"1234567890", "4567890234", "2343243233"});
        when(customerDetailsService.getAllPhoneNumbers()).thenReturn(CustomerDetailsResponse.builder().customerPhoneList(phoneNumbersList).build());
        ResponseEntity<CustomerDetailsResponse> responseEntity = customerDetailsController.getAllPhoneNumbers(new MockHttpServletRequest(), httpHeaders);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(customerDetailsService, times(1)).getAllPhoneNumbers();
    }

    @Test
    public void testGetPhoneNumbersByCustomerReturnSuccess() {

        List<String> phoneNumbersList = Arrays.asList(new String[] {"1234567890", "4567890234", "2343243233"});

        when(customerDetailsService.getPhoneNumberByCustomer(anyString())).thenReturn(CustomerDetailsResponse.builder().customerPhoneList(phoneNumbersList).build());

        ResponseEntity<CustomerDetailsResponse> responseEntity = customerDetailsController.getPhoneNumbersByCustomer("123456", new MockHttpServletRequest(), httpHeaders);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(customerDetailsService, times(1)).getPhoneNumberByCustomer(anyString());
    }

    @Test
    public void testActivatePhoneNumberReturnSuccess() {

        CustomerDetailsResponse customerDetailsResponse = CustomerDetailsResponse.builder().isPhoneActive(true).phoneNumber("1234567890").build();
        when(customerDetailsService.activatePhoneNumber(anyString())).thenReturn(customerDetailsResponse);

        ResponseEntity<CustomerDetailsResponse> responseEntity = customerDetailsController.activatePhoneNumber("123456", new MockHttpServletRequest(), httpHeaders);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(customerDetailsService, times(1)).activatePhoneNumber(anyString());
    }


}
