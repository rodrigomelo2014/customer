package com.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = CustomerEntity.ENTITY_NAME)
@Table(name = CustomerEntity.TABLE_NAME)
public class CustomerEntity {

    public static final String ENTITY_NAME = "Customer";
    public static final String TABLE_NAME = "CUSTOMER";
    public static final String SEQUENCE_NAME = "SQ_CUSTOMER_IDT";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CustomerEntity.SEQUENCE_NAME)
    @SequenceGenerator(
            name = CustomerEntity.SEQUENCE_NAME,
            sequenceName = CustomerEntity.SEQUENCE_NAME,
            allocationSize = 1)
    @Column(name = "IDT_CUSTOMER")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 255)
    private String name;

    @Column(name = "CPF", nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(name = "ADDRESS", nullable = false, length = 255)
    private String address;

    public CustomerEntity(String name, String cpf, String address) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
    }
}
