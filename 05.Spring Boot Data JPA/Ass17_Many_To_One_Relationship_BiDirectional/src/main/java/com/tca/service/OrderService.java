package com.tca.service;

import com.tca.entity.Customer;
import com.tca.entity.Order;

public interface OrderService {
	
	public Order saveOrder(Order order, Customer customer);
	public Order fetchOrderById(Long oid);
	public Order updateOrderStatus(Order order);   
	public void deleteById(Long oid);
	public void softDeleteById(Long oid);
}
