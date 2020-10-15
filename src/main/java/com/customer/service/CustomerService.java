package com.customer.service;

import java.util.List;

import com.customer.controller.dto.Customer;
import com.customer.exceptions.CustomerNotFoundException;

public interface CustomerService {

    /**
     * Method which return a list with the customers registered
     * @return
     */
    List<Customer> findAllCustomers();

    /**
     * Method which return a customer by id
     * @param id
     * @return
     * @throws CustomerNotFoundException
     */
    Customer findCustomerById(Long id) throws CustomerNotFoundException;

    /**
     * Method which register a new customer
     * @param customer
     * @return
     */
    Customer createCustomer(Customer customer);

    /**
     * Method which update a customer
     * @param customer
     * @return
     */
    Customer updateCustomer(Customer customer);

    /**
     * Method which delete a customer
     * @param id
     * @return
     */
    Customer deleteCustomer(Long id);
}
