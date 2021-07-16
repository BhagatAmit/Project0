package com.banking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.banking.dbutil.PostgresConnection;
import com.banking.dao.BankingDao;
import com.banking.exception.BankingException;
import com.banking.model.Customer;
import com.banking.model.Transaction;
import com.banking.model.User;

public class bankingDaoImpl implements BankingDao {

	@Override
	public Customer createCustomer(Customer customer) throws BankingException {
		try(Connection connection=PostgresConnection.getConnection()){
			
			String sql="insert into banking_schema.customer(fname,mname,lname,dob,mobile,address,fatherName,userName,passWord,idProof,pan,email) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, customer.getFname());
			preparedStatement.setString(2, customer.getMname());
			preparedStatement.setString(3, customer.getLname());
			preparedStatement.setString(4, customer.getDob());
			preparedStatement.setString(5, customer.getMobile());
			preparedStatement.setString(6, customer.getAddress());
			preparedStatement.setString(7, customer.getFatherName());
			preparedStatement.setString(8, customer.getUserName());
			preparedStatement.setString(9, customer.getPassWord());
			preparedStatement.setString(10, customer.getIdProof());
			preparedStatement.setString(11, customer.getPan());
			preparedStatement.setString(12, customer.getEmail());
			
			
			int c=preparedStatement.executeUpdate();
			if(c==1) {
				ResultSet resultSet=preparedStatement.getGeneratedKeys();
				if(resultSet.next()) {
					customer.setCustomerId(resultSet.getInt(1));
				}
			}else {
				throw new BankingException("Product Registration Failure Please Retry!!!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//logger
			throw new BankingException("Internal error occured... Kindly conatct SYSADMIN........");
		}

		return customer;
	}

	@Override
	public List<Customer> getCustomerByUserName(String userName) throws BankingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(String userId) throws BankingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) throws BankingException {
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="insert in banking_schema.user(userName,passWord,balance)values(?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,user.getUserId());
			preparedStatement.setString(2,user.getPassword());
			preparedStatement.setFloat(3,user.getBalance());
			
			int c=preparedStatement.executeUpdate();
			
				


		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public int updateUser(User user) throws BankingException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserById(String userId) throws BankingException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void makeDeposit(String userId, float depositAmount) throws BankingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeWithdrawal(String userId, float withdrawAmount) throws BankingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Transaction getTransactionById(int transactionId) throws BankingException {
		// TODO Auto-generated method stub
		return null;
	}


}