package com.mindgate.main.domain;

import java.time.LocalDate;

public class BankSlip {
   private String bankSlipId;
   private Account account;
   private LocalDate bankslipDate;
   private double amount;
   private Cheque chequeNumber;
   
   public BankSlip() {
	// TODO Auto-generated constructor stub
}

public BankSlip(String bankSlipId, Account accountNumber, LocalDate bankslipDate, double amount, Cheque chequeNumber) {
	super();
	this.bankSlipId = bankSlipId;
	this.account = accountNumber;
	this.bankslipDate = bankslipDate;
	this.amount = amount;
	this.chequeNumber = chequeNumber;
}

public String getBankSlipId() {
	return bankSlipId;
}

public void setBankSlipId(String bankSlipId) {
	this.bankSlipId = bankSlipId;
}

public Account getAccountNumber() {
	return account;
}

public void setAccountNumber(Account accountNumber) {
	this.account = accountNumber;
}

public LocalDate getBankslipDate() {
	return bankslipDate;
}

public void setBankslipDate(LocalDate bankslipDate) {
	this.bankslipDate = bankslipDate;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public Cheque getChequeNumber() {
	return chequeNumber;
}

public void setChequeNumber(Cheque chequeNumber) {
	this.chequeNumber = chequeNumber;
}

@Override
public String toString() {
	return "BankSlip [bankSlipId=" + bankSlipId + ", account=" + account + ", bankslipDate=" + bankslipDate
			+ ", amount=" + amount + ", chequeNumber=" + chequeNumber + "]";
}


   

   
   

}
