package com.banking.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.banking.model.Login;
import com.banking.serviceImpl.BankSearchServiceImpl;


class BankSearchServiceTest {
private static BankSearchService service;
	
	@BeforeAll
	public static void setUp() {
		service=new  BankSearchServiceImpl();
	}
	@Test
	void testGetCustomerByUsername() {
		fail("Not yet implemented");
	}

//	@Test
//	void testGetPassWordByUsernameForExisting() {
//	//	Login login=new Login("Amit%123");
//		login.setUserName("amit123");
//		fail("Not yet implemented");
//	}

	@Test
	void testGetCustomerByAccountno() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCurrbalanceByAccountno() {
		fail("Not yet implemented");
	}

}
