package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tca.entity.CustomerLoan;
import com.tca.entity.CustomerLoanId;

public interface CustomerLoanRepository extends JpaRepository<CustomerLoan,CustomerLoanId> {

}
