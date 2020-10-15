package com.customer.service;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.customer.controller.dto.Customer;
import com.customer.entity.CustomerEntity;
import com.customer.exceptions.CustomerNotFoundException;
import com.customer.repository.CustomerRepository;
import com.customer.service.impl.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks private CustomerServiceImpl customerService;
    @Mock private CustomerRepository customerRepository;

    private CustomerEntity customerEntity;
    private Customer customerOK;

    @Before
    public void init() {
        customerOK = new Customer();
        customerOK.setId(1L);
        customerOK.setName("Rodrigo da Silva Melo");
        customerOK.setCpf("44497980820");
        customerOK.setAddress("Rua Lazaro Borba n12");

        customerEntity = new CustomerEntity();
        customerEntity.setId(1L);
        customerEntity.setName("Rodrigo da Silva Melo");
        customerEntity.setCpf("44497980820");
        customerEntity.setAddress("Rua Lazaro Borba n12");
    }

    @Test
    public void findAllCustomersTest() {
        customerService.findAllCustomers(1, 10);
    }

    @Test
    public void findCustomerByIdTest() throws CustomerNotFoundException {
        Mockito.when(customerRepository.findById(1L)).thenReturn((Optional.of(customerEntity)));
        Customer response = customerService.findCustomerById(1L);
        assertEquals(response.getId(), customerEntity.getId());
        assertEquals(response.getName(), customerEntity.getName());
        assertEquals(response.getCpf(), customerEntity.getCpf());
        assertEquals(response.getAddress(), customerEntity.getAddress());
    }

    @Test
    public void createCustomerTest() {
        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customerEntity);
        Customer response = customerService.createCustomer(customerOK);
        assertEquals(response.getId(), customerEntity.getId());
        assertEquals(response.getName(), customerEntity.getName());
        assertEquals(response.getCpf(), customerEntity.getCpf());
        assertEquals(response.getAddress(), customerEntity.getAddress());
    }

    @Test
    public void updateCustomerTest() {
        customerService.updateCustomer(customerOK);
    }

    @Test
    public void deleteCustomerTest() {
        customerService.deleteCustomer(1L);
    }
}
