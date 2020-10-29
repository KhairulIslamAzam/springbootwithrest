package com.luv2code.springboot.restdemo.springbootcrudwithrest.dao;

import com.luv2code.springboot.restdemo.springbootcrudwithrest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    //no need to any implementation
}

