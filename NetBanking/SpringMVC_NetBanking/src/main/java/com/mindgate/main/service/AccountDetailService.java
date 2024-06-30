package com.mindgate.main.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.Exception.AccountNotExistException;
import com.mindgate.main.domain.Account;
import com.mindgate.main.repository.AccountDetailsRepositoryInterface;

@Service
public class AccountDetailService implements AccountDetailServiceInterface{
    
    @Autowired
    AccountDetailsRepositoryInterface accountDetailsRepositoryInterface;
    
    @Override
    public List<Account> getAccountDetailsById(String customerId) {
        
        return accountDetailsRepositoryInterface.getAccountDetailsById(customerId);
    }

    @Override
    public Account getAccountDetailsByAccountNumber(long accountNumber) {
        
        return accountDetailsRepositoryInterface.getAccountDetailsByAccountNumber(accountNumber);
    }

    @Override
    public int updateBalance(double amount,long accountNumber) {
        
        return accountDetailsRepositoryInterface.updateBalance(amount,accountNumber);
    }

    @Override
    public int updateOverDraftBalance(double amount, long accountNumber) {
        
        return accountDetailsRepositoryInterface.updateOverDraftBalance(amount, accountNumber);
    }

	@Override
	public Account addNewAccount(Account account) {
		if(account.getAccountType().equals("saving")) {
			account.setBalance(0);//WILL BE UPDATED BY ADMIN
			account.setOverdraftBalance(0);
		}else {
			account.setBalance(0);//WILL BE UPDATED BY ADMIN
			account.setOverdraftBalance(50000);//will be updated by admin
		}
		
		return  accountDetailsRepositoryInterface.addNewAccount(account);
		
			
	}

	@Override
	public Account credit(long accountNumber, double amount) {
		Account account =accountDetailsRepositoryInterface.getAccountDetailsByAccountNumber(accountNumber);
		if(account!=null && amount>0)
		{
			if(account.getAccountType().equals("current") && account.getOverdraftBalance()<50000)
			{
				double diffrance=50000-account.getOverdraftBalance();
				if(amount<=diffrance)
				{
					accountDetailsRepositoryInterface.updateOverDraftBalance(account.getOverdraftBalance()+amount, accountNumber);
					account.setOverdraftBalance(account.getOverdraftBalance()+amount);
					
				}
				else
				{
					accountDetailsRepositoryInterface.updateOverDraftBalance(account.getOverdraftBalance()+diffrance, accountNumber);
					accountDetailsRepositoryInterface.updateBalance(account.getBalance()+(amount-diffrance), accountNumber);
					account.setOverdraftBalance(account.getOverdraftBalance()+diffrance);
					account.setBalance(account.getBalance()+(amount-diffrance));
					
				}
				return account;
			}
			
			else {
					accountDetailsRepositoryInterface.updateBalance(account.getBalance()+amount, accountNumber);
					account.setBalance(amount);
					return account;
				
			}
		}
		else
		{
			throw new AccountNotExistException("Account Does Not Exist");
		}
	
	}
	

	@Override
	public Account debit(long accountNumber, double amount) {
		Account account =accountDetailsRepositoryInterface.getAccountDetailsByAccountNumber(accountNumber);
		if(account!= null && amount>0)
		{
			if(account.getAccountType().equals("saving"))
			{
				if(account.getBalance()-amount>=1000)
				{
					accountDetailsRepositoryInterface.updateBalance(account.getBalance()-amount, accountNumber);
					account.setBalance(account.getBalance()-amount);
					return account;
				}
				else
				{
					return null;
				}
			}
			else
			{
				if(account.getBalance()-amount>0)
				{
					accountDetailsRepositoryInterface.updateBalance(account.getBalance()-amount, accountNumber);
					account.setBalance(account.getBalance()-amount);
					return account;
				}
				else if(account.getBalance()-amount<0 && account.getOverdraftBalance()-(amount-account.getBalance())>0)
				{			
					
					accountDetailsRepositoryInterface.updateBalance(0, accountNumber);
					accountDetailsRepositoryInterface.updateOverDraftBalance( account.getOverdraftBalance()-(amount-account.getBalance()), accountNumber);
					account.setBalance(0);
					account.setOverdraftBalance(account.getOverdraftBalance()-(amount-account.getBalance()));
					return account;
				}
				else
				{
					return null;
				}
			}
		}
		else
		{
			throw  new AccountNotExistException("Account Does Not Exist");
		}
		
		
	}
	@Override
	public List<Account> NAList() {
		
		return accountDetailsRepositoryInterface.NAList();
	}

	@Override
	public int updateStatus(long accountNumber) {
		
		return accountDetailsRepositoryInterface.updateStatus(accountNumber);
	}
    
    
    
     
    
    
    
    

}