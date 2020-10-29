package com.luv2code.springboot.restdemo.springbootcrudwithrest.service;

import com.luv2code.springboot.restdemo.springbootcrudwithrest.entity.Customer;

import java.util.List;

public interface CustomerService {

     List<Customer> getCustomers();

     void saveCustomer(Customer customer);

     Customer getCustomerId(int id);

     void deleteCustomer(int id);

    // List<Customer> searchCustomers(String searchName);
}
