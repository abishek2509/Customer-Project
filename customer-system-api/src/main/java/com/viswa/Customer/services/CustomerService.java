package com.viswa.Customer.services;

import com.viswa.Customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    List<Customer> getAllCustomers();

    boolean deleteCustomer(Long id);


    Customer getCustomerById(Long id);

    Customer updateCustomer(Long id, Customer customer);
}
