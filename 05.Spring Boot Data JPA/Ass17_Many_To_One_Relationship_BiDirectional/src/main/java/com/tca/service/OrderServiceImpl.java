package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Customer;
import com.tca.entity.Order;
import com.tca.repository.OrderRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order fetchOrderById(Long oid) {
		return orderRepository.findById(oid).orElse(null);
	}

	@Override
	public Order updateOrderStatus(Order order) {
		return  orderRepository.save(order);
	}

	@Override
	public Order saveOrder(Order order, Customer customer) {
		order.setCustomer(customer);
		return orderRepository.save(order);
	}

	@Override
	public void deleteById(Long oid) {
		orderRepository.deleteById(oid);
	}

	@Override
	public void softDeleteById(Long oid) {
		orderRepository.softDelete(oid);
	}
}
