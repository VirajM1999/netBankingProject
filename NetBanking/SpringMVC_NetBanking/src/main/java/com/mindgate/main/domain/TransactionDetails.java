package com.mindgate.main.domain;

import java.time.LocalDate;

public class TransactionDetails {
	private String transactionId;
	private LocalDate transactionDate;
	private Account recieverAccount;
	private Account senderAccount;
	private double transactionAmount;
	
	public TransactionDetails() {
		// TODO Auto-generated constructor stub
	}
	public TransactionDetails(String transactionId, LocalDate transactionDate, Account recieverAccount,
			Account senderAccount, double transactionAmount) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.recieverAccount = recieverAccount;
		this.senderAccount = senderAccount;
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Account getRecieverAccount() {
		return recieverAccount;
	}
	public void setRecieverAccount(Account recieverAccount) {
		this.recieverAccount = recieverAccount;
	}
	public Account getSenderAccount() {
		return senderAccount;
	}
	public void setSenderAccount(Account senderAccount) {
		this.senderAccount = senderAccount;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", recieverAccount=" + recieverAccount + ", senderAccount=" + senderAccount + ", transactionAmount="
				+ transactionAmount + "]";
	}

	

}
