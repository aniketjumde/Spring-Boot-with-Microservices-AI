package com.tca.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tca.entity.Customer;
import com.tca.enums.OrderStatus;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


	@Modifying
	@Transactional
	@Query(value = "INSERT INTO orders(order_id, date_purchased, status, cust_id)VALUES (:oid, :odate, :status, :custid)", nativeQuery = true)
	public int updateOrder(@Param("oid") Long oid, @Param("odate") LocalDate odate,@Param("status") OrderStatus status,@Param("custid") Long custid);
}
