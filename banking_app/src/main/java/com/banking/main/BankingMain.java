package com.banking.main;

import java.util.Scanner;
import static com.banking.validity.Validity.*;


import org.apache.log4j.Logger;

import com.banking.dao.BankingDao;
import com.banking.dao.impl.bankingDaoImpl;
import com.banking.exception.BankingException;
import com.banking.main.BankingMain;
import com.banking.model.Customer;
import com.banking.model.Login;
import com.banking.model.User;


public class BankingMain {
	private static Logger log = Logger.getLogger(BankingMain.class);

	public static void main(String[] args) {
		String userName=null;
		String passWord=null;

		Scanner sc=new Scanner(System.in);
		int ch=0;
		do {
			log.info("Welcome to Engineer's Bank");
			log.info("1)Login");
			log.info("2)Sign up");
			log.info("3)Forgot password");
			log.info("4)EXIT");
			log.info("Enter your choice 1-4");
			try {
			ch=Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
			
			}
			switch (ch){
			
			case 1:
				log.info("Enter the username");
				 userName=sc.nextLine();
				
				log.info("Enter the password");
				 passWord=sc.nextLine();
				
				
				break;
			case 2:
//				log.info("Welcome to  the Engineer's Bank");
//				log.info("Enter the First Name");
//				String fname=sc.nextLine();
//				
//				log.info("Enter the Middle Name");
//				String mname=sc.nextLine();
//				
//				log.info("Enter the Last Name");
//				String lname=sc.nextLine();
//				
//				log.info("Enter the Date of Birth in dd/mm/yyyy format");
//				
//				boolean valid=false;
//				String dob;
//				do
//					{
//					 dob=sc.nextLine();
//					if(isValid_dob(dob))
//						valid=true;
//					else {
//						log.info("Please enter valid Date of Birth");
//					}
//					}while(!valid);
//				
//				log.info("Enter the Father Name");
//				String fatherName=sc.nextLine();
//				
//				
//				log.info("Enter the Mobile No.");
//				String mobile=null;
//				valid=false;
//				do {
//					 mobile=sc.nextLine();
//					if(isValid_mobile(mobile))
//						valid=true;
//					else 
//						System.out.println("Please enter valid mobile no");
//					}while(!valid);
//				
//				log.info("Enter the email address");
//				String email=sc.nextLine();
//				
//				log.info("Enter the Address");
//				String address=sc.nextLine();
//				
//				log.info("Select the id proof\n1:Aadhar card with DOB\n2:Voter Card\n3:Passport\n4:Driving License ");
//				int idchoice=Integer.parseInt(sc.nextLine());
//				boolean correct=true;
//				String idProof=null;
//				while(correct) {
//				switch(idchoice)
//				{
//				
//				case 1:
//					System.out.println("Enter Aadhar number");
//					 valid=false;
//					do {
//						String aadhar=sc.nextLine();
//						idProof=aadhar;
//						if(isValid_aadhar(aadhar))
//							valid=true;
//						else
//							log.info("Please Enter correct aadhar number");
//					}while(!valid);	
//					
//					correct=false;
//					break;
//				case 2:
//					log.info("Enter Voter Card number:");
//					valid=false;
//					do {
//					String voter=sc.nextLine();
//					 idProof=voter;
//					if(isValid_voter(voter))
//						valid=true;
//					else
//						log.info("Please Enter correct voter number");
//					}while(!valid)	;
//					correct=false;
//
//					break;
//				case 3:
//					valid=false;
//					log.info("Enter Passport number:");
//					do {
//						
//					String passport=sc.nextLine();
//					 idProof=passport;
//					if(isValid_passport(passport))
//						valid=true;
//					else
//						log.info("Please Enter correct passport number");
//					
//					}while(!valid);
//					correct=false;
//					break;
//				case 4:
//					valid=false;
//					
//					log.info("Enter Driving Licence  number:");
//					do {
//						String driving=sc.nextLine();
//						 idProof=driving;
//						if(isValid_driving(driving))
//							valid=true;
//						else
//							log.info("Please Enter correct driving license number");
//
//					}while(!valid);
//				
//						correct=false;
//				
//						break;
//					
//					default:
//						log.info("Please Enter the Valid choice");
//				}
//					
//				}
//				
//				log.info("Enter the PAN number");
//				String pan;
//				 valid=false;
//				do {
//				 pan=sc.nextLine();
//				if(isValid_pan(pan))
//					valid=true;
//				else
//					log.info("Please Enter correct pan number");
//				}while(!valid);
//
//					
//				
//				//outer=false;
//				
				log.info("Enter the username:");
				String username=sc.nextLine();
			
				log.info("Enter the password:");
//				valid=false;
//				do {
//					try {
						String password=sc.nextLine();
						log.info("enter the starting balance");
						float balance =Float.parseFloat(sc.nextLine());
//					}
//					catch (Exception e) {
//						// TODO: handle exception
//					}
//				if(isValid_password(passWord))
//					valid=true;
//				else
//					log.info("Password Invalid");
//				}while(!valid); 
//			Customer customer=new Customer(fname,mname,lname,dob,mobile,address,
//				fatherName,userName,passWord,idProof,pan,email);
				User user=new User(userName,passWord,balance);
			BankingDao bankingDao=new bankingDaoImpl();
				try {
				user =bankingDao.createUser(user);
					if(user.getUserId()!=null) {
						System.out.println("Customer Registered Succesfully");
						System.out.println(user);}
//			try {
//				customer =bankingDao.createCustomer(customer);
//				if(customer.getCustomerId()!=0) {
//					System.out.println("Customer Registered Succesfully");
//					System.out.println(customer);
//				}
//				
			}catch (BankingException e) {
				System.out.println(e.getMessage());
			}
				
				log.info("Registered successfully");
				
				break;
				//register block ends
				
			case 3:
				
				break;
			case 4:
				log.info("Thanks for using our Banking  App");

				
				break;

			default:
				log.warn("Invalid Choice... Please enter input between 1-4");

				break;
			}
			
		}while(ch!=4);
				
	}
}


	


