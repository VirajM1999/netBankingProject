package com.mindgate.main.domain;

import java.time.LocalDate;

public class FixDeposite {
	
	private String fixdepositeId;
	private long accountNumber;
	private LocalDate dateOfCreation;
	private double rateOfInterest;
	private double fdAmount;
	
	public FixDeposite() {
		// TODO Auto-generated constructor stub
	}

	public FixDeposite(String fixdepositeId, long accountNumber, LocalDate dateOfCreation, double rateOfInterest,
			double fdAmount) {
		super();
		this.fixdepositeId = fixdepositeId;
		this.accountNumber = accountNumber;
		this.dateOfCreation = dateOfCreation;
		this.rateOfInterest = rateOfInterest;
		this.fdAmount = fdAmount;
	}

	public String getFixdepositeId() {
		return fixdepositeId;
	}

	public void setFixdepositeId(String fixdepositeId) {
		this.fixdepositeId = fixdepositeId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LocalDate getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(LocalDate dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public double getFdAmount() {
		return fdAmount;
	}

	public void setFdAmount(double fdAmount) {
		this.fdAmount = fdAmount;
	}

	@Override
	public String toString() {
		return "FixDeposite [fixdepositeId=" + fixdepositeId + ", accountNumber=" + accountNumber + ", dateOfCreation="
				+ dateOfCreation + ", rateOfInterest=" + rateOfInterest + ", fdAmount=" + fdAmount + "]";
	}
	
	
	
	
	

}
