package com.tca.service;

import com.tca.entity.Order;

public interface OrderService {
	
	public Order fetchOrderById(Long oid);
	public Order updateOrderStatus(Order order);   
}
