package com.tca.service;

import com.tca.entity.CustomerLoan;
import com.tca.entity.CustomerLoanId;

public interface CustomerLoanService {

	public CustomerLoan saveCustomerLoan(CustomerLoan customerLoan);
	public CustomerLoan findById(CustomerLoanId customerLoanId);
	public void removeById(CustomerLoanId customerLoanId);
}
