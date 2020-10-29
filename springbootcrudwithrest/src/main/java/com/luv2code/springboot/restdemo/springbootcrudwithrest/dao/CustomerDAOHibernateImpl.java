package com.luv2code.springboot.restdemo.springbootcrudwithrest.dao;

import com.luv2code.springboot.restdemo.springbootcrudwithrest.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {

    @Autowired
    private EntityManager entityManager;

    public CustomerDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> getCustomers() {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        String qry = "from Customer";

        //create a query
        Query<Customer> theQuery =
                currentSession.createQuery(qry, Customer.class); //abr run koren

        //execute query and get the all result
        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session currentSession = entityManager.unwrap(Session.class);

        //save or update customer
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomerId(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Customer customer = currentSession.get(Customer.class, id);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = entityManager.unwrap(Session.class);

       Query theQuery = session.createQuery("delete from Customer where id=:customerId");

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
