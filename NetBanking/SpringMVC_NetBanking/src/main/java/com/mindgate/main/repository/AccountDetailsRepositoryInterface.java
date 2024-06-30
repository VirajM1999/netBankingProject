package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Account;

public interface AccountDetailsRepositoryInterface {
	
	 public Account addNewAccount(Account account);
    
    public List<Account> getAccountDetailsById(String customerId);
    
    public Account getAccountDetailsByAccountNumber(long accountNumber);
    
    public int updateBalance(double amount,long accountNumber);
    
    public int updateOverDraftBalance(double amount,long accountNumber);
    public List<Account> NAList();
	
	public int updateStatus(long accountNumber) ;


}