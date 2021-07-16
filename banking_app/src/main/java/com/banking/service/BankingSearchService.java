package com.banking.service;

import com.banking.exception.BankingException;
import com.banking.model.Customer;
import java.util.List;

public interface BankingSearchService {
	public List<Customer> getCustomerByName(String name) throws BankingException; 
	public List<Customer> getCustomerByDob(String dob) throws BankingException;
	public List<Customer> getCustomerMobile(long mobile) throws BankingException; 
	public Customer getCustomerByCustomerId(int customerId) throws BankingException;
	public List<Customer> getCustomerByAccountNumber(long accountNumber);


}
