package com.viswa.Customer.controller;

import com.viswa.Customer.model.Customer;
import com.viswa.Customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {
    @Autowired

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customer = null;
        customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }


    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
                                                   @RequestBody Customer customer){
            customer = customerService.updateCustomer(id,customer);
            return ResponseEntity.ok(customer);
    }



    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable Long id){
        boolean deleted = false;
        deleted = customerService.deleteCustomer(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }

}
