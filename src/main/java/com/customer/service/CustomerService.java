package com.customer.service;

import java.util.List;

import com.customer.controller.dto.Customer;
import com.customer.exceptions.CustomerNotFoundException;

public interface CustomerService {

    /**
     * Method which return a list with the customers registered
     * @return
     */
    List<Customer> findAll();

    /**
     * Method which return a customer by id
     * @param id
     * @return
     * @throws CustomerNotFoundException
     */
    Customer findCustomer(Long id) throws CustomerNotFoundException;

    /**
     * Method which register a new customer
     * @param customer
     * @return
     */
    Customer create(Customer customer);
}
