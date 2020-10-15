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
    public List<Customer> findAllCustomers(Integer page, Integer offset) {
        List<Customer> customerList = new ArrayList<>();
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        for (CustomerEntity customer : customerEntityList) {
            customerList.add(
                    new Customer(
                            customer.getId(),
                            customer.getName(),
                            customer.getCpf(),
                            customer.getAddress()));
        }
        log.info(LogUtil.formatLog("findAllCustomers", null, customerList.toString()));
        return customerList;
    }

    @Override
    public Customer findCustomerById(Long id) throws CustomerNotFoundException {
        CustomerEntity customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new CustomerNotFoundException(Messages.CUSTOMER_NOT_FOUND);
        }
        log.info(LogUtil.formatLog("findCustomerById", id.toString(), customer.toString()));
        return new Customer(
                customer.getId(), customer.getName(), customer.getCpf(), customer.getAddress());
    }

    @Override
    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity =
                customerRepository.save(
                        new CustomerEntity(
                                customer.getName(), customer.getCpf(), customer.getAddress()));
        log.info(LogUtil.formatLog("createCustomer", customer.toString(), customerEntity.toString()));
        return new Customer(
                customerEntity.getId(),
                customer.getName(),
                customer.getCpf(),
                customer.getAddress());
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        log.info(LogUtil.formatLog("deleteCustomer", id.toString(), null));
    }
}
