package component.com.belong.ms.customer.details;

import com.belong.ms.customer.details.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class})
@SpringBootTest(classes = MsBelongCustomerDetailsApplication.class)
@AutoConfigureMockMvc
public class CustomerDetailsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetAllPhoneNumbersReturnSuccess() throws Exception {

        String GET_ALL_PHONE_NUMBERS = "/phonenumbers/list";

        mockMvc.perform(get(GET_ALL_PHONE_NUMBERS)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .header("content-type", MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testGetTransactionsByAccountNumber() throws Exception {
        String GET_PHONE_NUMBERS_BY_CUSTOMER = "/phonenumbers/customer1";

        mockMvc.perform(get(GET_PHONE_NUMBERS_BY_CUSTOMER)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
