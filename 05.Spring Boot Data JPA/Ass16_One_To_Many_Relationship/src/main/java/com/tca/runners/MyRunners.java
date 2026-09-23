package com.tca.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

		
		/*
		 * Test Case 01 : ADD Customers
		Customer customer=new Customer();
		
		customer.setName("BBB");
		customer.setPhoneNo(888L);
		
		customer.setOrders(Arrays.asList(new Order(104L,LocalDate.now(),OrderStatus.CONFIRMED),
				new Order(105L,LocalDate.of(2026,8,16),OrderStatus.PROCESSING)));
		
		
//		Order o1=new Order(101L,LocalDate.now(),OrderStatus.CONFIRMED);
//		Order o2=new Order(102L,LocalDate.of(2026,8,16),OrderStatus.PROCESSING);
//		Order o3=new Order(103L,LocalDate.of(2026,7,21),OrderStatus.DELIVERED);
//		
//		List<Order> orders=new ArrayList<>();
//		orders.add(o1);
//		orders.add(o2);
//		orders.add(o3);
//		
//		customer.setOrders(orders);
		
		customerService.saveCustomer(customer);
		
		*/
		
		
		
		
		
		
	/*	
		// Test Case 02 : Fetch By ID
		
		//Eager Intialization
		
//		Customer customer=customerService.fetchCustomerById(1L);
//		System.out.println(customer);
		
		//Lazy Intialization
		Customer customer=customerService.fetchCustomerById(1L);
		System.out.println("Customer Id :"+customer.getCid());
		System.out.println("Customer Name :"+customer.getName());
		System.out.println("Customer Phone No :"+customer.getPhoneNo());
		
		System.out.println("-------------------------------");
		// In  Lazy Intialization Get Error Becase Sesssion is Closed 
		// If Session is Required to Active then " @Transactional "
		System.out.println("Orders :"+customer.getOrders());

*/
		
	
		/*
		//Test Case 03 : updateOrderforCustomer
		
		Customer customer=new Customer();
		customer.setName("CCC");
		customer.setPhoneNo(989898L);
		customerService.saveCustomer(customer);
		
		// After Adding Customer Required to Update Orders  (Note Without Separate OrdersRepository)
		customerService.updateOrderforCustomer(3L,new Order(106L,LocalDate.now(),OrderStatus.CONFIRMED));
*/
		
		
/*		
		// Test 04 DeleteBy ID With OrphonalRemoval
		
		// OrphonalRemoval is By Default False    It maked CID Null then Delete
		
		Customer customer=customerService.fetchCustomerById(1L);
		//customer.getOrders().remove(0);
		
		//OrphonalRemoval is true Delete Direct
		customerService.deleteCustomerById(1L);
		
*/		
		
		
/*		//Test 05 : Fetch Order Details 
		
		Order order=orderService.fetchOrderById(103L);
		System.out.println(order);
*/
		

/*
		
		//Test 06 : Update the Order Status
		Order order=orderService.fetchOrderById(103L);
		order.setOrderStatus(OrderStatus.PROCESSING);
		orderService.updateOrderStatus(order);
		
		
*/		
		
		
		// Test 07 : Update Object Information  (Internally Update Using the Direct Checking(CASHING MECHANISAM)"
//		Customer customer=customerService.fetchCustomerById(2L);
//		customer.setName("Pradeep Jadhav");
		
		Order order=orderService.fetchOrderById(101L);
		order.setOrderStatus(OrderStatus.SHIPPED);
		
	}

}
