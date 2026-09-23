package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Order;
import com.tca.repository.OrderRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderReposiotory;

	@Override
	public Order fetchOrderById(Long oid) {
		return orderReposiotory.findById(oid).orElse(null);
	}

	@Override
	public Order updateOrderStatus(Order order) {
		return  orderReposiotory.save(order);
	}
}
