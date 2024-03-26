package com.viswa.Customer.services;

import com.viswa.Customer.entity.CustomerEntity;
import com.viswa.Customer.model.Customer;
import com.viswa.Customer.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
        private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer,customerEntity);
        customerRepository.save(customerEntity);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        List<Customer> customers = customerEntities
                .stream()
                .map(cus -> new Customer(
                        cus.getId(),
                        cus.getFirstName(),
                        cus.getLastName(),
                        cus.getEmail(),
                        cus.getPhoneNumber(),
                        cus.getCity(),
                        cus.getState()))
                .collect(Collectors.toList());
        return customers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id).get();
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerEntity,customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        CustomerEntity customerEntity = customerRepository.findById(id).get();
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerEntity.setCity(customer.getCity());
        customerEntity.setState(customer.getState());
        customerRepository.save(customerEntity);
        return customer;
    }


    @Override
    public boolean deleteCustomer(Long id) {
        CustomerEntity customer = customerRepository.findById(id).get();
        customerRepository.delete(customer);
        return true;
    }




}
