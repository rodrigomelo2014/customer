package com.customer.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotEmpty
    private String name;

    /** Customer CPF */
    @NotNull
    @Size(min=11, max=11)
    private String cpf;

    /** Customer address */
    @NotEmpty
    private String address;
}
