package com.mindgate.main.domain;



public class Account {
    private long accountNumber;
    private String accountType;
    private String customerId; 
    private double balance;
    private double overdraftBalance;
    private double rateOfInterest;
    private String isApproved;
    private String accountCreationDate;
  
    
    public Account(long accountNumber, String accountType, String customerId, double balance, double overdraftBalance,
			double rateOfInterest, String isApproved, String accountCreationDate) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.customerId = customerId;
		this.balance = balance;
		this.overdraftBalance = overdraftBalance;
		this.rateOfInterest = rateOfInterest;
		this.isApproved = isApproved;
		this.accountCreationDate = accountCreationDate;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getOverdraftBalance() {
        return overdraftBalance;
    }
    public void setOverdraftBalance(double overdraftBalance) {
        this.overdraftBalance = overdraftBalance;
    }
    public double getRateOfInterest() {
        return rateOfInterest;
    }
    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }
    public String getIsApproved() {
        return isApproved;
    }
    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }
    
    
    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", customerId=" + customerId
                + ", balance=" + balance + ", overdraftBalance=" + overdraftBalance + ", rateOfInterest="
                + rateOfInterest + ", isApproved=" + isApproved + "]";
    }
	public String getAccountCreationDate() {
		return accountCreationDate;
	}
	public void setAccountCreationDate(String accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}
    
    
    

}