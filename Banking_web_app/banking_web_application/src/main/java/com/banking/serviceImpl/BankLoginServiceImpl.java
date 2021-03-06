package com.banking.serviceImpl;

import com.banking.dao.BankingDao;
import com.banking.dao.impl.BankingDaoImpl;
import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.model.Customer;
import com.banking.service.BankLoginService;

public class BankLoginServiceImpl implements BankLoginService{
	private BankingDao bankDAO=new BankingDaoImpl();
	@Override
	public Bank employeeLogin(Bank bank) throws BankingException {
		if(bank.getEmpUsername()!=null && bank.getEmpPassword()!=null) {
			bank = bankDAO.employeeLogin(bank);
		}
		else {
			throw new BankingException("Invalid Details...");
		}
		return bank;
	}
	@Override
	public boolean customerLogin(Customer customer) throws BankingException {
		boolean b=false;
		if(customer.getCustUserName()!=null && customer.getCustPassword()!=null) {
			b = bankDAO.customerLogin(customer);
		}
		else {
			throw new BankingException("Invalid Details...");
		}
		return b;
		
	}
	

	

}