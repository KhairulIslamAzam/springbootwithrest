package com.luv2code.springboot.restdemo.springbootcrudwithrest.dao;

import com.luv2code.springboot.restdemo.springbootcrudwithrest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    //no need to any implementation
}

