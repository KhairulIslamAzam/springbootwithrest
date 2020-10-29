package com.luv2code.springboot.restdemo.springbootcrudwithrest.dao;

import com.luv2code.springboot.restdemo.springbootcrudwithrest.entity.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDAOJpaImpl implements CustomerDAO {

    @Autowired
    private EntityManager entityManager;

    public CustomerDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> getCustomers() {

        String qry = "from Customer";

        //create a query
        Query theQuery = entityManager.createQuery(qry); //abr run koren

        //execute query and get the all result
        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {

       // Session currentSession = entityManager.unwrap(Session.class);

        Customer dbCustomer = entityManager.merge(customer);

        //save or update customer
        customer.setId(dbCustomer.getId());
    }

    @Override
    public Customer getCustomerId(int id) {

       // Session currentSession = entityManager.unwrap(Session.class);

        Customer customer = entityManager.find(Customer.class, id);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        //Session session = entityManager.unwrap(Session.class);

       Query theQuery = entityManager.createQuery("delete from Customer where id=:customerId");

       theQuery.setParameter("customerId",id);

       theQuery.executeUpdate();
    }

//    @Override
//    public List<Customer> searchCustomers(String searchName) {
//
//        Session session = entityManager.unwrap(Session.class);
//
//        Query theQuery = null;
//
//        if (searchName != null && searchName.trim().length() > 0){
//            // search for firstName or lastName ... case insensitive
//            theQuery =session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
//            theQuery.setParameter("theName", "%" + searchName.toLowerCase() + "%");
//        }  else {
//            // theSearchName is empty ... so just get all customers
//            theQuery =session.createQuery("from Customer", Customer.class);
//        }
//
//        // execute query and get result list
//        List<Customer> customers = theQuery.getResultList();
//
//        // return the results
//        return customers;
//    }
}
