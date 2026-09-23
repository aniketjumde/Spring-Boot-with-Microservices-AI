package com.tca.runners;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tca.entity.Customer;
import com.tca.entity.Order;
import com.tca.enums.OrderStatus;
import com.tca.service.CustomerService;
import com.tca.service.OrderService;

@Component
public class MyRunners implements ApplicationRunner {

	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {

	/* Test CASE : The Problem Is FK is NULL Because we can not set Order to cust_id
	 * 
		Order o1=new Order();
		o1.setOrderId(101L);
		o1.setDatePurchased(LocalDate.now());
		o1.setOrderStatus(OrderStatus.PROCESSING);
		
		

		Order o2=new Order();
		o2.setOrderId(102L);
		o2.setDatePurchased(LocalDate.now());
		o2.setOrderStatus(OrderStatus.PROCESSING);
		
		Customer customer=new Customer();
		customer.setName("AAA");
		customer.setPhoneNo(9999L);
		
		customer.setOrders(Arrays.asList(o1,o2));
		
		customerService.saveCustomer(customer);
		
		*/
		
	
		
		/*
		
		
		// TEST CASE : Saved The Orders  (The Problme is Customer is Saved Doubled )
		/// 
		/// 
		Customer customer=new Customer();
		customer.setName("AAA");
		customer.setPhoneNo(9999L);
		
		Order o1=new Order();
		o1.setOrderId(101L);
		o1.setDatePurchased(LocalDate.now());
		o1.setOrderStatus(OrderStatus.PROCESSING);
		
		

		Order o2=new Order();
		o2.setOrderId(102L);
		o2.setDatePurchased(LocalDate.now());
		o2.setOrderStatus(OrderStatus.PROCESSING);
		
		orderService.saveOrder(o1, customer);
		orderService.saveOrder(o2, customer);

		*/
		
		
	/*	
		// Save the Customer
		Customer customer=new Customer();
		customer.setName("AAA");
		customer.setPhoneNo(9999L);
		
		customerService.saveCustomer(customer);
	*/
		
	
		/*
		//Test Case : Order Side view
		
		Customer customer=customerService.fetchCustomerById(1L);
		
		Order o1=new Order();
		o1.setOrderId(101L);
		o1.setDatePurchased(LocalDate.now());
		o1.setOrderStatus(OrderStatus.PROCESSING);
		
		

		Order o2=new Order();
		o2.setOrderId(102L);
		o2.setDatePurchased(LocalDate.now());
		o2.setOrderStatus(OrderStatus.PROCESSING);
		
		orderService.saveOrder(o1, customer);
		orderService.saveOrder(o2, customer);
		
		*/
		
		
	/*
		//TEST CASE : Saved The Orders With an Customer
		
		Order o1=new Order();
		o1.setOrderId(101L);
		o1.setDatePurchased(LocalDate.now());
		o1.setOrderStatus(OrderStatus.PROCESSING);
		
		

		Order o2=new Order();
		o2.setOrderId(102L);
		o2.setDatePurchased(LocalDate.now());
		o2.setOrderStatus(OrderStatus.PROCESSING);
		
		Customer customer=new Customer();
		customer.setName("AAA");
		customer.setPhoneNo(9999L);
		
		customer.setOrders(Arrays.asList(o1,o2));
		
		o1.setCustomer(customer); // Set the Cutsomer 
		o2.setCustomer(customer); // Set The Customer
				
		customerService.saveCustomer(customer);
		*/
	
		
		
		/*
		//TEST Case: Fetched the Customer
		
		Customer c=customerService.fetchCustomerById(1L);
		
		System.out.println("Customer ID 	  ==>" + c.getCid());
		System.out.println("Customer Name ==>" + c.getName());
		System.out.println("Customer Phone ==>" + c.getPhoneNo());
		
		System.out.println("----------------------------------------------------------");
		
		List<Order> orders = c.getOrders();
		
		for (Order o : orders)
		{
			System.out.println("Order Id    :" + o.getOrderId());
			System.out.println("Order Date  :" + o.getDatePurchased());
			System.out.println("Order Status:" + o.getOrderStatus());
			System.out.println("=======================================================");
		}
		
		*/
		
		
		/*
		// TEST CASE : Fetch The Orders
		
		Order o=orderService.fetchOrderById(101L);
		Customer c = o.getCustomer();
		
		System.out.println("Order Id    :" + o.getOrderId());
		System.out.println("Order Date  :" + o.getDatePurchased());
		System.out.println("Order Status:" + o.getOrderStatus());
		System.out.println("=======================================================");
		System.out.println("Customer ID    ==>" + c.getCid());
		System.out.println("Customer Name  ==>" + c.getName());
		System.out.println("Customer Phone ==>" + c.getPhoneNo());
		*/

		
		

		
////		//Delete Record From  Order
////		// The Problem is "Cascade.ALL" Delete the Records of Customer ALSO BUT in Orders Table Constraints Violation Error are Occured"
//			orderService.deleteById(101L);
//		
		//Delete After Cascade.Remove
		
		//orderService.deleteById(101L);
		
		// Soft Delete
		
		orderService.softDeleteById(102L);

	}

}
