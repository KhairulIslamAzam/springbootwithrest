package com.luv2code.springboot.restdemo.springbootcrudwithrest.rest;

import com.luv2code.springboot.restdemo.springbootcrudwithrest.entity.Customer;
import com.luv2code.springboot.restdemo.springbootcrudwithrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId){

        Customer customer = customerService.getCustomerId(customerId);

        if(customer == null){
            throw new CustomerNotFoundException("Customer not found "+ customerId);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer theCustomer){
        //setid 0 means every time inserting a new customer instead of update
        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);

        return theCustomer;


    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer){

        customerService.saveCustomer(theCustomer);

        return theCustomer;


    }

    @DeleteMapping("/customers/{customerId}")
    public Customer deleteCustomerById(@PathVariable int customerId){

        Customer customer = customerService.getCustomerId(customerId);

        if(customer == null){
            throw new CustomerNotFoundException("Customer not found "+ customerId);
        }
        customerService.deleteCustomer(customerId);

        return customer;
    }
}
