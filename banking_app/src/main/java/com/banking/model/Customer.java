package com.banking.model;

public class Customer {
	//for Customer Login
			private String custUserName;
			private String CustPassword;
			public Customer() {
				// TODO Auto-generated constructor stub
			}
			public Customer(String custUserName, String custPassword) {
				super();
				this.custUserName = custUserName;
				CustPassword = custPassword;
			}
			public String getCustUserName() {
				return custUserName;
			}
			public void setCustUserName(String custUserName) {
				this.custUserName = custUserName;
			}
			public String getCustPassword() {
				return CustPassword;
			}
			public void setCustPassword(String custPassword) {
				CustPassword = custPassword;
			}
}