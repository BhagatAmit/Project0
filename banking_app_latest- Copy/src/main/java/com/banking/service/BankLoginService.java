package com.banking.service;

import com.banking.exception.BankingException;
import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.model.Customer;

public interface BankLoginService {
	public  Bank employeeLogin(Bank bank) throws BankingException;
	public Customer customerLogin(Customer customer) throws BankingException;
}