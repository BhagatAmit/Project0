package com.banking.serviceImpl;

import java.util.List;

import com.banking.dao.BankingDao;
import com.banking.dao.impl.BankingDaoImpl;
import com.banking.exception.BankingException;
import com.banking.model.Account;
import com.banking.model.Bank;
import com.banking.model.Transaction;
import com.banking.service.BankSearchService;

public class BankSearchServiceImpl implements BankSearchService{

	@Override
	public List<Bank> getCustomerDetailsByUsername(String username) throws BankingException {
	
		return null;
	}

	@Override
	public List<Transaction> getTransactionDetailsByTid(int tid) throws BankingException {
		
		return null;
	}

	@Override
	public Account getBalanceByAccountNumber(float accno) throws BankingException {
		Account account = new Account();
		BankingDao bankDAO = new BankingDaoImpl();
		if(accno!=0) {
			account = bankDAO.getBalanceByAccountNumber(accno);
		}
		return account;
	}



}