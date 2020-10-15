package com.customer.controller;

import com.customer.constants.Messages;
import com.customer.controller.dto.ErrorResponse;
import com.customer.exceptions.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomerControllerAdvice {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorResponse> handleException(IllegalArgumentException ex) {
        log.error(ex.getMessage());
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleException(CustomerNotFoundException ex) {
        log.error(ex.getMessage());
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<ErrorResponse> handleException(DataIntegrityViolationException ex) {
        log.error(ex.getMessage());
        ErrorResponse response =
                new ErrorResponse(HttpStatus.BAD_REQUEST.value(), Messages.CPF_ALREADY_REGISTERED);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
