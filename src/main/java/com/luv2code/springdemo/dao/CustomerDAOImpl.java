package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lu2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query
		Query<Customer> theQuery = currentSession.createQuery("from customer", Customer.class);
		
		// Execute query and get return list
		List<Customer> customers = theQuery.getResultList();
		
		// Return the results
		return customers;
	}

}
