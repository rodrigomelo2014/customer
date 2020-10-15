package com.customer.controller.dto;

import javax.validation.constraints.NotEmpty;

import com.customer.validator.CPFValid;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    /** Customer id */
    private Long id;

    /** Customer name */
    @NotEmpty private String name;

    /** Customer CPF */
    @NotEmpty @CPFValid private String cpf;

    /** Customer address */
    @NotEmpty private String address;
}
