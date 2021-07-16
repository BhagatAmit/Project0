package com.banking.dao;



import java.util.List;

import com.banking.exception.BankingException;
import com.banking.model.Customer;
import com.banking.model.Transaction;



import com.banking.exception.BankingException;
import com.banking.model.Account;
import com.banking.model.Bank;
import com.banking.model.Customer;
import com.banking.model.Transaction;

public interface BankingDao {
	public List<Bank> getCustomerDetailsByUsername(String username) throws BankingException;
	//public List<Transaction> getTransactionDetailsByTid(int tid) throws BankingException;
	///Bank crud service
	public Bank registerCustomer(Bank bank) throws BankingException;
	public Bank openCustomerAccount(Bank bank) throws BankingException;
	public List<Bank> getAllCustomerDetails()throws BankingException;
	//Bank login service
	public Bank employeeLogin(Bank bank) throws BankingException;
	//Bank Customer service
	public Customer customerLogin(Customer customer) throws BankingException;
	//deposit
	//public Transaction depositAmount(Transaction transaction) throws BankingException;
	//public Customer getPasswordByUserId(String userId) throws BankingException;
	//public Account getBalanceByAccountNumber(float accountNumber) throws BankingException;


	//withdrawl
	
}