package com.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.customer.constants.Messages;
import com.customer.controller.dto.Customer;
import com.customer.entity.CustomerEntity;
import com.customer.exceptions.CustomerNotFoundException;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.customer.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        for (CustomerEntity customer : customerRepository.findAll()) {
            customerList.add(
                    new Customer(
                            customer.getId(),
                            customer.getName(),
                            customer.getCpf(),
                            customer.getAddress()));
        }
        log.info(LogUtil.formatLog("findAll", null, customerList.toString()));
        return customerList;
    }

    @Override
    public Customer findCustomer(Long id) throws CustomerNotFoundException {
        CustomerEntity customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new CustomerNotFoundException(Messages.CUSTOMER_NOT_FOUND);
        }
        log.info(LogUtil.formatLog("findCustomer", id.toString(), customer.toString()));
        return new Customer(
                customer.getId(), customer.getName(), customer.getCpf(), customer.getAddress());
    }

    @Override
    public Customer create(Customer customer) {
        CustomerEntity customerEntity =
                customerRepository.save(
                        new CustomerEntity(
                                customer.getName(), customer.getCpf(), customer.getAddress()));
        log.info(LogUtil.formatLog("create", customer.toString(), customerEntity.toString()));
        return new Customer(
                customerEntity.getId(),
                customer.getName(),
                customer.getCpf(),
                customer.getAddress());
    }
}
