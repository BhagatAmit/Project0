package com.banking.service;

import java.util.List;

import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.model.Transaction;

public interface BankCrudService {
	public Bank registerCustomer(Bank bank) throws BankingException;
	public Bank openCustomerAccount(Bank bank) throws BankingException;
	
//	public List<Bank> getAllCustomerTransactionDetails(Bank bank)throws BusinessException;
	//for deposit
	public Transaction depositAmount(Transaction transaction) throws BankingException;
	public Transaction withDrawAmount(Transaction transaction1);
	public List<Bank> getAllCustomerDetails() throws BankingException;

}