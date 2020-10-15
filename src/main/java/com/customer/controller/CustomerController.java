package com.customer.controller;

import java.util.List;

import com.customer.controller.dto.Customer;
import com.customer.exceptions.CustomerNotFoundException;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) throws CustomerNotFoundException {
        return ResponseEntity.ok(customerService.findCustomer(id));
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer request) {
        return ResponseEntity.ok(customerService.create(request));
    }

    @PatchMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer request) {
        return ResponseEntity.ok(new Customer());
    }

    @PutMapping
    public ResponseEntity<Customer> partialUpdateCustomer(@RequestBody Customer request) {
        return ResponseEntity.ok(new Customer());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(new Customer());
    }
}
