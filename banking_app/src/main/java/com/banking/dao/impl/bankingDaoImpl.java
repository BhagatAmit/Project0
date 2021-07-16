package com.banking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.banking.dao.BankingDao;
import com.banking.dao.BankingDao;
import com.banking.dbutil.PostgresConnection;
import com.banking.exception.BankingException;
import com.banking.model.Account;
import com.banking.model.Bank;
import com.banking.model.Customer;
import com.banking.model.Transaction;

public class BankingDaoImpl implements BankingDao{
	private static Logger log = Logger.getLogger(BankingDao.class);

	@Override
	public List<Bank> getCustomerDetailsByUsername(String username) throws BankingException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Transaction> getTransactionDetailsByTid(int tid) throws BankingException {
//		try(Connection connection = PostgresConnection.getConnection()){
//			String sql = "select ttype,openingbalance,tamount,closingbalance,accno from custtransaction where tid = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, tid);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while(resultSet.next()) {
//				Transaction transaction = new Transaction();
//				transaction.setTid(tid);
//				transaction.setTtype(resultSet.getString("ttype"));
//				transaction.setOpeningbalance(resultSet.getFloat("closingbalance"));
//				transaction.setTamount(resultSet.getFloat("tamount"));
//				transaction.setTamount(resultSet.getFloat("tamount"));
//				
//				
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			log.warn(e.getMessage());
//			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
//		}
//		return null;
//	}

	@Override
	public Bank registerCustomer(Bank bank) throws BankingException {
		try(Connection connection = PostgresConnection.getConnection()){
			String sql = "insert into bank_schema.customerlogin(name,email,username,password) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, bank.getName());
			preparedStatement.setString(2, bank.getEmail());
			preparedStatement.setString(3, bank.getUsername());
			preparedStatement.setString(4, bank.getPassword());
			int rowAffected = preparedStatement.executeUpdate();
			if(rowAffected!=1) {
				log.info("Rows not affected");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}
		return bank;
	}

	@Override
	public Bank openCustomerAccount(Bank bank) throws BankingException {
		try(Connection connection = PostgresConnection.getConnection()){
			String sql = "insert into bank_schema.customerpersonal(custusername,custfname,custlname,custgender,custdob,custmobileno,custpan,custcity,custstate,initialamount)values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1,bank.getCustUserName());
			preparedStatement.setString(2,bank.getCustFname());
			preparedStatement.setString(3,bank.getCustLname());
			preparedStatement.setString(4,bank.getCustGender());
			preparedStatement.setString(5,bank.getCustDob());
			preparedStatement.setLong(6, bank.getCustMobileno());
			preparedStatement.setString(7,bank.getCustPan());
			preparedStatement.setString(8,bank.getCustCity());
			preparedStatement.setString(9,bank.getCustState());
			preparedStatement.setFloat(10, bank.getInitialAmount());
		

			String sql1 = "insert into bank_schema.customeraccount(custusername,custfname,currbalance) values(?,?,?) ";
			PreparedStatement preparedStatement1 = connection.prepareCall(sql1);
			preparedStatement1.setString(1,bank.getCustUserName());
			preparedStatement1.setString(2,bank.getCustFname());
			preparedStatement1.setFloat(3, bank.getInitialAmount());
			int rowAffected = preparedStatement1.executeUpdate();
			preparedStatement.executeUpdate();
			if(rowAffected!=1) {
				log.info("Rows not affected");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}
		return bank;
	}

	@Override
	public List<Bank> getAllCustomerDetails() throws BankingException {
		
		List<Bank> bankList=new ArrayList<>();
		try(Connection connection = PostgresConnection.getConnection()){
			String sql = "select custusername,custfname,custlname,custgender,custdob,custmobile,custpan,custcity,custstate,initialamount from bank_schema.customerpersonal";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Bank bank = new Bank();
				bank.setCustUserName(resultSet.getString("custusername"));
				bank.setCustFame(resultSet.getString("custfname"));
				bank.setCustLname(resultSet.getString("custlname"));
				bank.setCustGender(resultSet.getString("custgender"));
				bank.setCustDob(resultSet.getString("custdob"));
				bank.setCustMobileno(resultSet.getLong("custmobile"));
				bank.setCustPan(resultSet.getString("custpan"));
				bank.setCustCity(resultSet.getString("custcity"));
				bank.setCustState(resultSet.getString("custstate"));
				bank.setInitialAmount(resultSet.getFloat("initialamount"));
				bankList.add(bank);
			}
			System.out.println(bankList.size());
			if(bankList.size()==0) {
				throw new BankingException("No Customer details exists as of now");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured....Kindly Contact SysAdmin");
		}
		return bankList;
	}

	@Override
	public Bank employeeLogin(Bank bank) throws BankingException {
		try(Connection connection = PostgresConnection.getConnection()){
			String sql="select empusername,emppassword from bank_schema.employee";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				bank.setEmpUsername(resultSet.getString("empusername"));
				bank.setEmpPassword(resultSet.getString("emppassword"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}
		return bank;
	}

	@Override
	public Customer customerLogin(Customer customer) throws BankingException {
		try(Connection connection = PostgresConnection.getConnection()){
			String sql="select username,password from bank_schema.customerlogin";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				customer.setCustUserName(resultSet.getString("username"));
				customer.setCustPassword(resultSet.getString("password"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}
		return customer;
	}

	//@Override
//	public Transaction depositAmount(Transaction transaction) throws BankingException {
//		try(Connection connection = PostgresConnection.getConnection()){
//			String sql = "insert into bank_schema.transaction(ttype,openingbalance,tamount,closingbalance,accno) values(?,?,?,?,?)";
//			String sql1 = "update bank_schema.custaccount set openingbalance= ? where accno = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
//			preparedStatement.setString(1,transaction.getTtype());
//			preparedStatement.setFloat(2, transaction.getOpeningbalance());
//			preparedStatement.setFloat(3, transaction.getTamount());
//			preparedStatement.setFloat(4,transaction.getClosingbalance());
//			preparedStatement.setInt(5, transaction.getAccno());
//			preparedStatement1.setFloat(1, transaction.getClosingbalance());
//			preparedStatement1.setInt(2, transaction.getAccno());
//			int c = preparedStatement.executeUpdate();
//			int c1  = preparedStatement.executeUpdate();
//			if(c== 1 && c1 == 1) {
//				ResultSet resultSet = preparedStatement.getGeneratedKeys();
//				if(resultSet.next()) {
//					transaction.setTid(resultSet.getInt(1));
//				}
//			}
//
//		}catch (ClassNotFoundException | SQLException e) {
//			log.warn(e.getMessage());
//			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
//		}
//		return transaction;
//	}
	/*
	 * public Transaction depositAmount(Transaction transaction) throws BankException {
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into bank_schema.transactions(transtype,balance,\"d/w/t(amount)\",updatedbalance,accountnumber) values(?,?,?,?,?)";
			String sql1 = "update bank_schema.accountdetails set balance=? where accountnumber = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement.setString(1, transaction.getTransType());
			preparedStatement.setDouble(2, transaction.getOpeningBalance1());
			preparedStatement.setDouble(3, transaction.getAmount());
			preparedStatement.setDouble(4, transaction.getClosingBalance());
			preparedStatement.setDouble(5, transaction.getAccountNumber());
			preparedStatement1.setDouble(1, transaction.getClosingBalance());
			preparedStatement1.setDouble(2, transaction.getAccountNumber());
			int c = preparedStatement.executeUpdate();
			int c1 = preparedStatement1.executeUpdate();
			if (c == 1 && c1 == 1) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					transaction.setTransId(resultSet.getInt(1));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BankException("Internal error occured... Kindly conatct SYSADMIN........");
		}
		return transaction;
	}*/

	//@Override
	//public Customer getPasswordByUserId(String userId) throws BankingException {
		// TODO Auto-generated method stub
	//	return null;
	//}

	//@Override
//	public Account getBalanceByAccountNumber(float accno) throws BankingException{
//		Account account = new Account();
//		//System.out.println("hi");
//		try (Connection connection = PostgresConnection.getConnection()) {
//			//System.out.println("hi");
//			String sql = "select accno,custFname,custUserName,openingbalance from bank_schema.custacctdetails where accno =?";
//			String sql1 = "select ";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setFloat(1, accno);
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			if (resultSet.next()) {
//				account.setAccno(resultSet.getInt("accno"));
//				account.setCustFname(resultSet.getString("custFname"));
//				account.setCustUserName(resultSet.getString("custUserName"));
//				account.setOpeningbalance(resultSet.getFloat("openingbalance"));
//				//System.out.println(resultSet.getFloat(1));
//				System.out.println(account);
//			} else {
//				throw new BankingException("Invalid Account Number ");
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			log.warn(e);
//			throw new BankingException("Internal error occured... Kindly conatct SYSADMIN........");
//		}
//		return account;
//	}

}