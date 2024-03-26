package com.viswa.Customer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private String state;

}
