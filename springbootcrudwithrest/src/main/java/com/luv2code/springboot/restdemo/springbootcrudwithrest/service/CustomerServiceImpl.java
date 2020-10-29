package com.luv2code.springboot.restdemo.springbootcrudwithrest.service;

import com.luv2code.springboot.restdemo.springbootcrudwithrest.dao.CustomerDAO;
import com.luv2code.springboot.restdemo.springbootcrudwithrest.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {

        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomerId(int id) {
        return customerDAO.getCustomerId(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

//    @Override
//    @Transactional
//    public List<Customer> searchCustomers(String searchName) {
//        return customerDAO.searchCustomers(searchName);
//    }
}
