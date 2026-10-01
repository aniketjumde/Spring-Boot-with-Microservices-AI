package com.tca.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CustomerLoan {

	@EmbeddedId
	private CustomerLoanId customerLoanId;
	
	private Double loneAmount;
	
	private int periodMonths;
	
	
}
