package com.customer.controller;

import static com.customer.constants.CustomerConstants.OFFSET;
import static com.customer.constants.CustomerConstants.PAGE;
import static java.util.Optional.ofNullable;

import java.util.List;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import com.customer.controller.dto.Customer;
import com.customer.exceptions.CustomerNotFoundException;
import com.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @Operation(summary = "List all customers registered")
    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomers(
            @PathParam(PAGE) final Integer page, @PathParam(OFFSET) final Integer offset) {
        return ResponseEntity.ok(
                customerService.findAllCustomers(
                        ofNullable(page).orElse(1), ofNullable(offset).orElse(10)));
    }

    @Operation(summary = "Find a customer by id")
    @GetMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id)
            throws CustomerNotFoundException {
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }

    @Operation(summary = "Create a customer")
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(
            @Valid @Parameter(description = "Customer to be created", required = true) @RequestBody
                    Customer request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @Operation(summary = "Update a customer")
    @PatchMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateCustomer(
            @Valid
                    @Parameter(description = "Customer to be fully updated", required = true)
                    @RequestBody
                    Customer request) {
        return ResponseEntity.ok(customerService.updateCustomer(request));
    }

    @Operation(summary = "Partial update a customer")
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> partialUpdateCustomer(
            @Valid
                    @Parameter(description = "Customer to be partially updated", required = true)
                    @RequestBody
                    Customer request) {
        return ResponseEntity.ok(customerService.updateCustomer(request));
    }

    @Operation(summary = "Delete a customer")
    @DeleteMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("OK");
    }
}
