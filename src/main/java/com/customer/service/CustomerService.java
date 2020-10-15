package com.customer.service;

import java.util.List;

import com.customer.controller.dto.Customer;
import com.customer.exceptions.CustomerNotFoundException;

public interface CustomerService {

    List<Customer> findAll();

    Customer findCustomer(Long id) throws CustomerNotFoundException;

    Customer create(Customer customer);
}
