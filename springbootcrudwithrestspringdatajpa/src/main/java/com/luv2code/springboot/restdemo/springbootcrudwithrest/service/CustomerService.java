package com.luv2code.springboot.restdemo.springbootcrudwithrest.service;

import com.luv2code.springboot.restdemo.springbootcrudwithrest.entity.Customer;

import java.util.List;

public interface CustomerService {

     List<Customer> findAll();

     void save(Customer customer);

     Customer findById(int id);

     void deleteById(int id);

    // List<Customer> searchCustomers(String searchName);
}
