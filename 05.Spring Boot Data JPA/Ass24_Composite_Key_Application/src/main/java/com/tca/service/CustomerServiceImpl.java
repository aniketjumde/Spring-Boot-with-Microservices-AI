package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.CustomerLoan;
import com.tca.entity.CustomerLoanId;
import com.tca.repository.CustomerLoanRepository;

@Service("customerLoan")
public class CustomerServiceImpl implements CustomerLoanService {

	@Autowired
	private CustomerLoanRepository customerLoanRepository;
	
	@Override
	public CustomerLoan saveCustomerLoan(CustomerLoan customerLoan) {
		return customerLoanRepository.save(customerLoan);
	}

	@Override
	public CustomerLoan findById(CustomerLoanId customerLoanId) {
		return customerLoanRepository.findById(customerLoanId).get();
	}

	@Override
	public void removeById(CustomerLoanId customerLoanId) {
		customerLoanRepository.deleteById(customerLoanId);
	}

}
