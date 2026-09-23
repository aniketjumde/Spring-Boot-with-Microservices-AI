package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tca.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

	@Modifying
	@Query("UPDATE Order o SET o.customer = NULL WHERE o.orderId = :oid")
	void softDelete(@Param("oid") Long oid);

}
