package com.banking.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.banking.exception.BankingException;
import com.banking.model.Bank;

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
			log.info("Welcome to Engineer's Bank");
			log.info("==================================");
			log.info("\nBank Menu");
			log.info("1)Login");
			log.info("2)Register as a Customer");
			log.info("3)Forgot  Password");
			log.info("4)EXIT");
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
														log.info("Enter Your Date of Birth in (dd/mm/yyyy)");
														boolean valid=false;
														String dob;
														do {
														 dob = sc.nextLine();
														if(dob!=null && dob.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"))
															valid= true;
														else
															log.info("Please enter DOB in correct format");;
														}while(!valid);
														log.info("Enter Your Mobile Number(10-Digits)");
														
														
														long custmobile = Long.parseLong(sc.nextLine());
														
														
														log.info("Enter your Pan number");
														String panNumber;
														do {
															valid=false;
															
														 panNumber = sc.nextLine();
														if(panNumber!=null && panNumber.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}"))
															valid=true;
														else
															log.info("Please Enter correct Pan Number");
														
														}while(!valid);
														log.info("Enter Your City");
														String city = sc.nextLine();
														log.info("Enter Your State");
														String state = sc.nextLine(); 
														log.info("Set Initial Amount(Min 1000)");
														float initialAmount;
														do {
															valid=false;
														 initialAmount = Float.parseFloat(sc.nextLine());
														if(initialAmount!=0 && initialAmount>=1000)
														{
															valid=true;
														}
														else
															log.info(" Amount should be greater than 999");
														
														}while(!valid);
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
													BankSearchService bankSearchService=new BankSearchServiceImpl();
													log.info("Enter Account Number");
													try {
													Long accountno=Long.parseLong(sc.nextLine());
													List<Transaction> list=bankSearchService.getTransactionByAccountno(accountno);
													if(list!=null && list.size()>0)
													{
														log.info("Below is the list of transaction");
													for(Transaction t:list)
													{
														log.info(t);
													}
													}
													}catch (Exception e) {
														e.getMessage();
													}
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
						case 2: 
							
						
								String str=null;
								log.info("\nWelcome to Customer Login Screen");
								log.info("\n Enter Username:");
								String custUserName = sc.nextLine();
								try {
									BankSearchService bankSearchService=new BankSearchServiceImpl();

									str=bankSearchService.getCustomerByUsername(custUserName);
									if(str!=null)
									{
									//	System.out.println(str);
										//log.info("\n Enter Password:");
										
										try {
											BankSearchService bankSearchService1=new BankSearchServiceImpl();
											boolean valid=false;
											do {
												log.info("\n Enter Password:");

												String custPassword = sc.nextLine();
												String checkPassword=null;
												
											 checkPassword=bankSearchService1.getPassWordByUsername(custUserName,custPassword);
											// System.out.println(checkPassword);
											if(checkPassword!=null)
											{
												//System.out.println("hi");
												//System.out.println(checkPassword);
												log.info("Login Succesfull");
												valid =true;
											}
											else
												
												log.info("Invalid password....please enter again");
											}while(!valid);
											int ch3=0;
											do {
												log.info("Welcome "+custUserName);
												log.info("\n1)Open Account");
												log.info("\n2)View statement");
												log.info("\n3)Withdraw Amount");
												log.info("\n4)Deposit Amount");
											
												log.info("\n5)Logout");
												log.info("\nEnter Your Choice 1-5");
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
												log.info("Enter Your Date of Birth in (dd/mm/yyyy)");
												boolean valid1=false;
												String dob;
												do {
												 dob = sc.nextLine();
												if(dob!=null && dob.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"))
													valid1= true;
												else
													log.info("Please enter DOB in correct format");;
												}while(!valid1);
												log.info("Enter Your Mobile Number(10-Digits)");
												
												
												long custmobile = Long.parseLong(sc.nextLine());
												
												
												log.info("Enter your Pan number");
												String panNumber;
												do {
													valid1=false;
													
												 panNumber = sc.nextLine();
												if(panNumber!=null && panNumber.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}"))
													valid1=true;
												else
													log.info("Please Enter correct Pan Number");
												
												}while(!valid1);
												log.info("Enter Your City");
												String city = sc.nextLine();
												log.info("Enter Your State");
												String state = sc.nextLine(); 
												log.info("Set Initial Amount(Min 1000)");
												float initialAmount;
												do {
													valid1=false;
												 initialAmount = Float.parseFloat(sc.nextLine());
												if(initialAmount!=0 && initialAmount>=1000)
												{
													valid1=true;
												}
												else
													log.info(" Amount should be greater than 999");
												
												}while(!valid1);

												bank = new Bank(custUserName,fName,lName,gender,dob,custmobile,panNumber,city,state,initialAmount);
												try {
													bankCrudService.openCustomerAccount(bank);
													log.info("\nBank Account Created Successfully...");
												} catch (BankingException e) {
													log.warn(e.getMessage());
													throw new BankingException(" Account  Creation Failed!!");
												};
														break;
												case 2:
													
													//BankSearchService bankSearchService2=new BankSearchServiceImpl();
													
													log.info("View Statement");
													log.info("Enter Account Number");
													try {
													Long accountno=Long.parseLong(sc.nextLine());
													List<Transaction> list=bankSearchService.getTransactionByAccountno(accountno);
													if(list!=null && list.size()>0)
													{
														log.info("Below is the list of transaction");
													for(Transaction t:list)
													{
														log.info(t);
													}
													}
													}catch (Exception e) {
														e.getMessage();
													}
													break;
												case 3: 
													log.info("Enter the account no.");
													try {
													long accountno1=Long.parseLong(sc.nextLine());
													long accountpresent=0;
													accountpresent=bankSearchService.getCustomerByAccountno(accountno1);
													double currbalance=bankSearchService.getCurrbalanceByAccountno(accountno1);
												//	double previousBalance=currbalance;
													
												//	System.out.println(currbalance);
													if(accountpresent!=0)
													{
														double withdrawlAmount=0;
														log.info("Enter the amount to be withdrawn"
																+ "");
														do {
															valid1=false;
														withdrawlAmount=Double.parseDouble(sc.nextLine());
														if(withdrawlAmount>0)
															valid1=true;
														else
															log.info("Please Enter the Correct amount");
														
														}while(!valid1);
													//	currbalance=previousBalance+depositedAmount;
														Transaction transaction=new Transaction(accountno1,currbalance, withdrawlAmount,0,currbalance-withdrawlAmount);
														BankCrudService bankCrudService2=new BankCrudServiceImpl();
														try {
														bankCrudService2.withdrawlAmount(transaction);
														if(transaction!=null)
														
															log.info("Amount withdrawl Succesfully");
															log.info(transaction);
														}catch (Exception e) {
															
														}
					
													}
													else
														log.info("no account found with this number");
												
													}catch (BankingException e) {
														e.getMessage();
														
													}
													break;
												case 4: 
														
														log.info("Enter the account no.");
														try {
														long accountno1=Long.parseLong(sc.nextLine());
														long accountpresent=0;
														accountpresent=bankSearchService.getCustomerByAccountno(accountno1);
														double currbalance=bankSearchService.getCurrbalanceByAccountno(accountno1);
													//	double previousBalance=currbalance;
														
													//	System.out.println(currbalance);
														if(accountpresent!=0)
														{
															double depositedAmount=0;
															log.info("Enter the amount to be deposited");
															do {
																valid1=false;
															depositedAmount=Double.parseDouble(sc.nextLine());
															if(depositedAmount>0)
																valid1=true;
															else
																log.info("Please Enter the Correct amount");
															
															}while(!valid1);
														//	currbalance=previousBalance+depositedAmount;
															Transaction transaction=new Transaction(accountno1,currbalance, 0, depositedAmount,currbalance+depositedAmount);
															BankCrudService bankCrudService2=new BankCrudServiceImpl();
															try {
															bankCrudService2.depositedAmount(transaction);
															if(transaction!=null)
															
																log.info("Amount deposited Succesfully");
																log.info(transaction);
															}catch (Exception e) {
																
															}
						
														}
														else
															log.info("no account found with this number");
													
														}catch (BankingException e) {
															e.getMessage();
															
														}
														break;
											
												case 5:
													log.info("\nLogout Successfully............");
													log.info("\nGoing to Main Menu............\n");
													break;
													
												}
											}while(ch3!=5);	

										}catch (Exception e) {
											// TODO: handle exception
										}
										
									}
									else
										log.info("No Customer Registered with Username: "+custUserName);
									
								}catch (Exception e) {
									
								}
								
								
								
								break;
								
						}
						break; //for employee logout
					}while(ch1!=2);
					break; //for customer logout
			case 2: BankCrudService bankCrudService =null;
						Bank bank = null;
						log.info("\nWelcome to Cutomer Registration Page\n");
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
				log.info("Enter your username");
				BankSearchService bankSearchService=new BankSearchServiceImpl();
				try {
				 String custUserName=sc.nextLine();
				String str=bankSearchService.getCustomerByUsername(custUserName);
				log.info("Here you go:)...Your password is:");
				log.info(str);
				}catch (Exception e) {
					e.getMessage();
				}

				break;
			case 4:
				log.info("Thanks for using our App.. See you soon. :)");
				break;
			default:
				log.warn("Invalid Choice... Please enter input between 1-4");
				break;
			}
		}while(ch!=4);
	}

}