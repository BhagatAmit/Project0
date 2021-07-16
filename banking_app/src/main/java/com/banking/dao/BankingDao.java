package com.banking.dao;



import java.util.List;

import com.banking.exception.BankingException;
import com.banking.model.Customer;
import com.banking.model.Transaction;
import com.banking.model.User;


public interface BankingDao {
	public   Customer createCustomer(Customer customer) throws BankingException;
	//public List<User> getUser()throws BankingException;
	public List<Customer> getCustomerByUserName(String userName) throws BankingException;
	public User getUserById(String userId) throws BankingException;
	
	public User createUser (User user) throws BankingException;
	public int updateUser(User user) throws BankingException;
	public int deleteUserById(String userId)throws BankingException;
	
	public void makeDeposit(String userId, float depositAmount)throws BankingException;
	public void makeWithdrawal(String userId, float withdrawAmount) throws BankingException;
	public Transaction getTransactionById(int transactionId) throws BankingException;
	

}
