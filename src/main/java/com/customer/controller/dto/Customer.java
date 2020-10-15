package com.customer.controller.dto;

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
    private String name;

    /** Customer CPF */
    private String cpf;

    /** Customer address */
    private String address;
}
