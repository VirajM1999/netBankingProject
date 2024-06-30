package com.mindgate.main.domain;

import java.time.LocalDate;

public class Cheque {
	
	private String chequeNumber;
	private Account recieverAccount;
	private Account senderAccount;
	private LocalDate chequeDate;
	private double amount;
	private String status;
	
	public Cheque() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	

	public Cheque(String chequeNumber, Account recieverAccountNumber, Account senderAccountNumber, LocalDate chequeDate,
			double amount, String status) {
		super();
		this.chequeNumber = chequeNumber;
		this.recieverAccount = recieverAccountNumber;
		this.senderAccount = senderAccountNumber;
		this.chequeDate = chequeDate;
		this.amount = amount;
		this.status = status;
	}

	public void setRecieverAccount(Account recieverAccountNumber) {
		this.recieverAccount = recieverAccountNumber;
	}

	public void setSenderAccount(Account senderAccountNumber) {
		this.senderAccount = senderAccountNumber;
	}

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	

	public LocalDate getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(LocalDate chequeDate) {
		this.chequeDate = chequeDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public Account getRecieverAccount() {
		return recieverAccount;
	}

	public Account getSenderAccount() {
		return senderAccount;
	}

	@Override
	public String toString() {
		return "Cheque [chequeNumber=" + chequeNumber + ", recieverAccountNumber=" + recieverAccount
				+ ", senderAccountNumber=" + senderAccount + ", chequeDate=" + chequeDate + ", amount=" + amount
				+ ", status=" + status + "]";
	}
	
	

}
