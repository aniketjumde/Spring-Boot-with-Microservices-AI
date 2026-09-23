package com.tca.service;

import com.tca.entity.Customer;
import com.tca.entity.Order;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	
	public Customer fetchCustomerById(Long id);
		
	public void updateOrderforCustomer(Long cid , Order o); 
	
	public void deleteCustomerById(Long cid);
}
