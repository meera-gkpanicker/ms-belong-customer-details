package unit.com.belong.ms.customer.details;

import com.belong.ms.customer.details.api.*;
import com.belong.ms.customer.details.exception.*;
import com.belong.ms.customer.details.repository.*;
import com.belong.ms.customer.details.repository.dto.*;
import com.belong.ms.customer.details.service.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import org.mockito.quality.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerDetailsServiceTest {

    @InjectMocks
    private CustomerDetailsService customerDetailsService;

    @Mock
    private CustomerDetailsRepository customerDetailsRepository;

    @Mock
    private PhoneNumberRepository phoneNumberRepository;

    @Test
    public void testGetAllPhoneNumbersThrowException() {
        List<CustomerPhone>  customerPhoneList = new ArrayList<>();
        when(phoneNumberRepository.findAll()).thenReturn(customerPhoneList);
        CustomerDetailsException exception = assertThrows(CustomerDetailsException.class, () -> customerDetailsService.getAllPhoneNumbers());
        assertEquals(exception.getMessage(), "There are no phone numbers present:");
        assertEquals(exception.getStatus(), Status.NOT_FOUND);
    }

    @Test
    public void testGetPHoneNumberByCustomerThrowException() {
        List<Customer> customerList = new ArrayList<>();
        when(customerDetailsRepository.findPhoneNumberByCustomerName(anyString())).thenReturn(customerList);
        CustomerDetailsException exception = assertThrows(CustomerDetailsException.class, () -> customerDetailsService.getPhoneNumberByCustomer("customer1"));
        assertEquals(exception.getMessage(), "There are no phonenumbers found for this customer.");
        assertEquals(exception.getStatus(), Status.NOT_FOUND);
    }

    @Test
    public void testActivatePhoneThrowException() {
        List<CustomerPhone> customerList = new ArrayList<>();
        when(phoneNumberRepository.findByPhoneNumber(anyString())).thenReturn(customerList);
        CustomerDetailsException exception = assertThrows(CustomerDetailsException.class, () -> customerDetailsService.activatePhoneNumber("1234567890"));
        assertEquals(exception.getMessage(), "There are no records present for this phone number.");
        assertEquals(exception.getStatus(), Status.NOT_FOUND);
    }
}
