package com.tca.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.CustomerLoan;
import com.tca.entity.CustomerLoanId;
import com.tca.service.CustomerLoanService;

@Component
public class MyRunners implements ApplicationRunner {

	@Autowired
	private CustomerLoanService customerLoanService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

	/*	//Test Case : Save CustomerLoan 
		
		CustomerLoanId customerLoanId=new CustomerLoanId(101L,9001L);
		
		CustomerLoan customerLoan=new CustomerLoan();
		customerLoan.setLoneAmount(50000.0);
		customerLoan.setPeriodMonths(12);
		
		customerLoan.setCustomerLoanId(customerLoanId);  //Set Composite key
		
		customerLoanService.saveCustomerLoan(customerLoan);
		
	*/
		
	/*	//TEST CASE : Fetched Customer Loan
		
		CustomerLoanId customerLoanId =new CustomerLoanId(102L, 9002L);
		CustomerLoan customerLoan=customerLoanService.findById(customerLoanId);
		
		System.out.println("Customer Loan Amount :"+customerLoan.getLoneAmount());
		System.out.println("Customer period monts :"+customerLoan.getPeriodMonths());
	*/
		
		
		
	}

}
