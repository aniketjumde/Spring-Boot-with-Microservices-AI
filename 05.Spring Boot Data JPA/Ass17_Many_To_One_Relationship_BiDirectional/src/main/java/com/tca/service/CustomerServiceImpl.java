package com.tca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Customer;
import com.tca.entity.Order;
import com.tca.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}


	@Override
	public void deleteCustomerById(Long cid) {
		
		customerRepository.deleteById(cid);
	}

	@Override
	public Customer fetchCustomerById(Long id) {
		
		Optional<Customer> customer=customerRepository.findById(id);
		
		if(customer.isPresent())
		{
			return customer.get();
		}
		else
		{
			return null;
		}
		
		
	}

	@Override
	public void updateOrderforCustomer(Long cid, Order o) {

		customerRepository.updateOrder(o.getOrderId(),o.getDatePurchased(),o.getOrderStatus(), cid);
	}

	

}
