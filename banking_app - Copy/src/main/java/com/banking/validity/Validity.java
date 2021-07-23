package com.banking.validity;

import java.util.regex.Pattern;
public class Validity {
	public static boolean isValid_mobile(String mobile)
	{
		if(mobile!=null && mobile.matches("[0-9]{10}"))
			return true;
		else
			return false;
		
	}
	public static boolean isValid_pan(String pan)
	{
		if(pan!=null && pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}"))
			return true;
		else
			return false;
		
	}
	public static boolean isValid_passport(String passport)
	{
		if(passport!=null && passport.matches("^[A-PR-WYa-pr-wy][1-9]\\\\d\\\\s?\\\\d{4}[1-9]$"))
			return true;
		else
			return false;
		
	}
	public static boolean isValid_voter(String voter)
	{
		if(voter!=null && voter.matches("[A-Z]{3}[0-9]{7}"))
			return true;
		else
			return false;
		
	}
	public static boolean isValid_driving(String driving)
	{
		if(driving!=null && driving.matches("[A-Z]{2}[0-9]{2} [0-9]{4} [0-9]{7}"))
			return true;
		else
			return false;
		
	}
	public static boolean isValid_email(String email)
	{
		if(email!=null && email.matches("[A-Z]{2}[0-9]{2}[A-Z]{1}[0-9]{4}"))
			return true;
		else
			return false;
		
	}
	public static boolean isValid_dob(String dob)
	{
		if(dob!=null && dob.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"))
			return true;
		else
			return false;
		
	}
	public static boolean isValid_aadhar(String aadhar)
	{
		if(aadhar!=null && aadhar.matches("[0-9]{12}"))
			return true;
		else
			return false;
		
	}
	public static boolean isValid_password(String password_register)
	{
		final String PASSWORD_REGEX =
		        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
		 
		    final Pattern PASSWORD_PATTERN =
		                                Pattern.compile(PASSWORD_REGEX);
		
		if(PASSWORD_PATTERN.matcher(password_register).matches())
			return true;
		else
			return false;
		
	}

}
