package com.banking.service;

import java.util.List;

import com.banking.exception.BankingException;
import com.banking.model.Account;
import com.banking.model.Bank;
import com.banking.model.Transaction;

public interface BankSearchService {
	public List<Bank> getCustomerDetailsByUsername(String username) throws BankingException;
	public List<Transaction> getTransactionDetailsByTid(int tid) throws BankingException;
	public Account getBalanceByAccountNumber(float accountNumber) throws BankingException;

}