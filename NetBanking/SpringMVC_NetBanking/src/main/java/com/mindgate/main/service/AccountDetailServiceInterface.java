package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Account;

public interface AccountDetailServiceInterface {
	
	public Account addNewAccount(Account account);
    
    public List<Account> getAccountDetailsById(String customerId);
    
    public Account getAccountDetailsByAccountNumber(long accountNumber);
    public int updateBalance(double amount,long accountNumber);
    
    public Account credit(long accountNumber,double amount );
    public Account debit(long accountNumber,double amount);

	int updateOverDraftBalance(double amount, long accountNumber);
	public List<Account> NAList();
	
	public int updateStatus(long accountNumber) ;

    
    

}