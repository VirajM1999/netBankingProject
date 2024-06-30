package com.mindgate.main.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerDetail {
	
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;
	private String city;
	private String panNo;
	private String adhaarNo;
	private int loginAttempt;
	private LoginDetails loginDetails;
	List<Account> accountList=new ArrayList<Account>();
	
	public CustomerDetail() {
		super();
	}

	
	


	public CustomerDetail(String customerId, String firstName, String lastName, String email, long phoneNumber,
			String city, String panNo, String adhaarNo, int loginAttempt, LoginDetails loginDetails) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.panNo = panNo;
		this.adhaarNo = adhaarNo;
		this.loginAttempt = loginAttempt;
		this.loginDetails = loginDetails;
	
	}

	



	public CustomerDetail(String customerId, String firstName, String lastName, String email, long phoneNumber,
			String city, String panNo, String adhaarNo, int loginAttempt, LoginDetails loginDetails,
			List<Account> accountList) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.panNo = panNo;
		this.adhaarNo = adhaarNo;
		this.loginAttempt = loginAttempt;
		this.loginDetails = loginDetails;
		this.accountList = accountList;
	}





	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAdhaarNo() {
		return adhaarNo;
	}

	public void setAdhaarNo(String adhaarNo) {
		this.adhaarNo = adhaarNo;
	}

	public int getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}


	

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}





	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}





	public List<Account> getAccountList() {
		return accountList;
	}



	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}



	@Override
	public String toString() {
		return "CustomerDetail [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", city=" + city + ", panNo=" + panNo
				+ ", adhaarNo=" + adhaarNo + ", loginAttempt=" + loginAttempt + ", loginDetails=" + loginDetails
				+ ", accountList=" + accountList + "]";
	}



	

	
	
	
	
	
	
}
