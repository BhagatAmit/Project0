package com.banking.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.banking.exception.BankingException;
import com.banking.model.Account;
import com.banking.model.Bank;
import com.banking.model.Customer;
import com.banking.model.Transaction;
import com.banking.service.BankCrudService;
import com.banking.service.BankLoginService;
import com.banking.service.BankSearchService;
import com.banking.serviceImpl.BankCrudServiceImpl;
import com.banking.serviceImpl.BankLoginServiceImpl;
import com.banking.serviceImpl.BankSearchServiceImpl;

public class BankingMain {
private static Logger log = Logger.getLogger(BankingMain.class);
	public static void main(String[] args) throws BankingException {
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do {
			log.info("Welcome to BankApp V1.0");
			log.info("==================================");
			log.info("\nBank Menu");
			log.info("1)Login");
			log.info("2)Register as a Customer");
			log.info("3)EXIT");
			log.info("\nEnter your Choice 1-3");
			try {
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {

			}
			switch(ch) {
			case 1: log.info("\n1)Login as Employee");
					log.info("\n2)Login as Customer");
					log.info("\nEnter your Choice 1-2");
					int ch1=0;
					do {
						try {
							ch1 = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
						}
						switch(ch1) {
						case 1: Bank bank = null;
								BankLoginService bankLoginService=null;
							   log.info("\nWelcome to Employee Login Screen");
							   log.info("\nEnter Username:");
							   String empUsername = sc.nextLine();
							   log.info("\nEnter Password:");
							   String empPassword = sc.nextLine();
							   bank = new Bank(empUsername,empPassword);
							   try {
								   bankLoginService = new BankLoginServiceImpl();
								   bank =bankLoginService.employeeLogin(bank);
								   if(bank.getEmpUsername().equals(empUsername) && bank.getEmpPassword().equals(empPassword)){
										log.info("Employee Login Successfully");
										  int ch2=0;
										   do {
											   log.info("\nWelcome "+empUsername+"\n");
												log.info("\n1)Open Account");
												log.info("\n2)Approve or Reject an Account");
												log.info("\n3)View All Customer Personal Details");
												log.info("\n4)View Customer Account Details");
												log.info("\n5)View Transaction of Customers");
												log.info("\n6)Logout");
												log.info("\nEnter Your Choice 1-5");
												try {
													ch2 = Integer.parseInt(sc.nextLine());
												} catch (NumberFormatException e) {
												}
												switch(ch2) {
												case 1: BankCrudService bankCrudService = new BankCrudServiceImpl();
														log.info("Enter Your Username");
														String userName = sc.nextLine();
														log.info("Enter Your First Name");
														String fName = sc.nextLine();
														log.info("Enter Your Last Name");
														String lName = sc.nextLine();
														log.info("Enter Your Gender");
														String gender = sc.nextLine();
														log.info("Enter Your Date of Birth in (yyy-mm-dd)");
														String dob = sc.nextLine();
														log.info("Enter Your Mobile Number(10-Digits)");
														long custmobile = Long.parseLong(sc.nextLine());
														log.info("Enter your Occupation");
														String panNumber = sc.nextLine();
														log.info("Enter Your City");
														String city = sc.nextLine();
														log.info("Enter Your State");
														String state = sc.nextLine(); 
														log.info("Set Initial Amount(Min 500)");
														float initialAmount = Float.parseFloat(sc.nextLine());
														bank = new Bank(userName,fName,lName,gender,dob,custmobile,panNumber,city,state,initialAmount);
														try {
															bankCrudService.openCustomerAccount(bank);
															log.info("\nBank Account Created Successfully...");
														} catch (BankingException e) {
															log.warn(e.getMessage());
															throw new BankingException("Bank Account  Creation Failed!!");
														};
													break;
												case 2: 
													break;
												case 3: BankCrudService bankCrudService1 = new BankCrudServiceImpl();
												try {
													List<Bank> bankList=bankCrudService1.getAllCustomerDetails();
													for(Bank b : bankList) {
														log.info(b);
													}
												}catch(BankingException e) {log.error(e.getMessage());}
														
												
													break;
												case 4:
													break;
												case 5:
													break;
												case 6: 
													log.info("\nLogout Successfully............\n");
													log.info("\nGoing to Main Menu............");
													break;
												}
										   }while(ch2!=6);
									}
									else {
										log.info("Invalid Details");
									}
							   }catch (BankingException e) {
									log.warn(e.getMessage());
									throw new BankingException("Employee Login Failed!!!");
								};
							break;
						case 2: Customer customer = null;
								log.info("\nWelcome to Customer Login Screen");
								log.info("\n Enter Username:");
								String custUserName = sc.nextLine();
								log.info("\n Enter Password:");
								String custPassword = sc.nextLine();
//								System.out.println(custUserName);
//								System.out.println(custPassword);
								customer = new Customer(custUserName,custPassword);
								try {
									 bankLoginService = new BankLoginServiceImpl();
									  customer =bankLoginService.customerLogin(customer);
//									  System.out.println(customer.getCustUserName());
//									  System.out.println(customer.getCustUserName());
									  if(customer.getCustUserName().equals(custUserName) && customer.getCustPassword().equals(custPassword)){
										  log.info("Employee Login Successfully\n");
										  int ch3=0;
											do {
												log.info("Welcome "+custUserName);
												log.info("\n1)Open Account");
												log.info("\n2)Transfer Amount");
												log.info("\n3)Withdraw Amount");
												log.info("\n4)Deposit Amount");
												log.info("\n5)View statement");
												log.info("\n6)Logout");
												log.info("\nEnter Your Choice 1-6");
												try {
													ch3 = Integer.parseInt(sc.nextLine());
												} catch (NumberFormatException e) {
												}
												switch(ch3) {
												case 1:BankCrudService bankCrudService = new BankCrudServiceImpl();
												log.info("Enter Your Username");
												String userName = sc.nextLine();
												log.info("Enter Your First Name");
												String fName = sc.nextLine();
												log.info("Enter Your Last Name");
												String lName = sc.nextLine();
												log.info("Enter Your Gender");
												String gender = sc.nextLine();
												log.info("Enter Your Date of Birth in (yyy-mm-dd)");
												String dob = sc.nextLine();
												log.info("Enter Your Mobile Number(10-Digits)");
												long mobileno = Long.parseLong(sc.nextLine());
												log.info("Enter your PanCard Number");
												String panNumber = sc.nextLine();
												log.info("Enter Your City");
												String city = sc.nextLine();
												log.info("Enter Your State");
												String state = sc.nextLine(); 
												log.info("Set Initial Amount(Min 500)");
												float initialAmount = Float.parseFloat(sc.nextLine());
												bank = new Bank(userName,fName,lName,gender,dob,mobileno,panNumber,city,state,initialAmount);
												try {
													bankCrudService.openCustomerAccount(bank);
													log.info("\nBank Account Created Successfully...");
												} catch (BankingException e) {
													log.warn(e.getMessage());
													throw new BankingException("Bank Account  Creation Failed!!");
												};
														break;
												case 2:log.info("\nEnter Customer Username");
														String customerUsername = sc.nextLine(); 
														log.info("\nEnter Customer Mobile Number");
														double customerMobileNumber = Double.parseDouble(sc.nextLine());
														log.info("\nEnter the Amount to Transfer(min 500)");
														double amountTransfer = Double.parseDouble(sc.nextLine());
														log.info("\nAmount Transfered SuccessFully!!!"); //valid
														break;
														
												case 3: BankSearchService bankSearchService1 = new BankSearchServiceImpl();
														BankCrudService bankCrudService2 = new BankCrudServiceImpl();
														Transaction transaction1 =new Transaction();
														Account account1 = new Account();
														log.info("Enter your Account Number");
														int accno1 = Integer.parseInt(sc.nextLine());
														log.info("\nEnter the Amount to Withdraw(min 500)");
														float amountWithdraw = Float.parseFloat(sc.nextLine());
														account1 = bankSearchService1.getBalanceByAccountNumber(accno1);
														float openingBalance1 = account1.getOpeningbalance();
														String transType1 = "Withdraw";
														float closingBalance1 = Math.abs(openingBalance1-amountWithdraw);
														transaction1 = new Transaction(transType1,openingBalance1,amountWithdraw,closingBalance1,accno1);
														 transaction1 = bankCrudService2.depositAmount(transaction1);
														 log.info("Amount " + amountWithdraw
																	+ "Successfully Withdrawed from your Account Number = "
																	+ accno1);
															log.info(transaction1);
														log.info("\nAmount Withdrawed SuccessFully!!!"); //valid
														break;
												case 4: BankSearchService bankSearchService = new BankSearchServiceImpl();
														BankCrudService bankCrudService1 = new BankCrudServiceImpl();
														Transaction transaction =new Transaction();
														Account account = new Account();
														log.info("Enter your Account Number");
														int accno = Integer.parseInt(sc.nextLine());
														log.info("\nEnter the Amount to Deposit(min 500)");
														float amountDeposit = Float.parseFloat(sc.nextLine());
														account = bankSearchService.getBalanceByAccountNumber(accno);
														float openingBalance = account.getOpeningbalance();
														//System.out.println("THIS IS MY OPENING BALANCE"+openingBalance);
														String transType = "Deposit";
														float closingBalance = openingBalance+amountDeposit;
														//System.out.println(closingBalance);
														 transaction = new Transaction(transType,openingBalance,amountDeposit,closingBalance,accno);
														 transaction = bankCrudService1.depositAmount(transaction);
														 log.info("Amount " + amountDeposit
																	+ "Successfully deposited into your Account Number = "
																	+ accno);
															log.info(transaction);
														/*
														 * BankCrudService bankCrudService2 = new BankCrudServiceImpl();
											BankSearchService bankSearchService1 = new BankSearchServiceImpl();
											// Transaction transaction=new Transaction();
											Account account1 = new Account();
											log.info("Enter Your 11 Digit Account Number");
											long accountNumber = Long.parseLong(sc.nextLine());
											log.info("enter Amount to be deposited");
											double amount = Double.parseDouble(sc.nextLine());
											account1 = bankSearchService1.getBalanceByAccountNumber(accountNumber);
											double balance = account1.getOpeningBalance();
											String transType = "Deposit";
											double closingBalance = balance + amount;
											
											Transaction transaction = new Transaction(accountNumber, amount, balance,
													closingBalance, transType);
											transaction = bankCrudService2.depositAmount(transaction);
											log.info("Amount " + amount
													+ "Successfully deposited into your Account Number"
													+ accountNumber);
											log.info(transaction);
														 * 
														 * 
														 * 
														 * 
														 * 
														 * */
														log.info("\nAmount Deposited SuccessFully!!!"); //valid
														break;
												case 5: log.info("View Statement");
														break;
												case 6:
													log.info("\nLogout Successfully............");
													log.info("\nGoing to Main Menu............\n");
													break;
													
												}
											}while(ch3!=6);	
									  }
									  else {
											log.info("Invalid Details..");
										}
								}catch(BankingException e) {
									log.warn(e.getMessage());
									throw new BankingException("Customer Login Failed!!!");
								};
								break;
								
						}
						break; //for employee logout
					}while(ch1!=2);
					break; //for customer logout
			case 2: BankCrudService bankCrudService =null;
						Bank bank = null;
						log.info("\nWelcome to Cutomer Login Page\n");
						log.info("\nEnter Your Name");
						String name = sc.nextLine();
						log.info("\nEnter Your Email");
						String email = sc.nextLine();
						log.info("\nEnter Your Username");
						String userName = sc.nextLine();
						log.info("\nEnter Your Password");
						String password = sc.nextLine();
						bank=new Bank(name,email,userName,password);
						bankCrudService = new BankCrudServiceImpl();
				try {
					bankCrudService.registerCustomer(bank);
					log.info("\n Bank Account Registered Successfully...\n");
				} catch (BankingException e) {
					log.warn(e.getMessage());
					throw new BankingException("Bank Account not Registered!!");
				};
					break;
			case 3:
				log.info("Thanks for using our App.. See you soon. :)");
				break;
			default:
				log.warn("Invalid Choice... Please enter input between 1-4");
				break;
			}
		}while(ch!=3);
	}

}