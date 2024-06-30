package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mindgate.main.Exception.AccountNotExistException;
import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.TransactionDetails;
import com.mindgate.main.repository.TransactionDetailsRepositpory;

@Service
public class TransactionDetailsService implements TransactionDetailsServiceInterface{

	@Autowired
	private TransactionDetailsRepositpory transectionDetailsRepository;
	
	@Autowired
	private AccountDetailServiceInterface accountDetailServiceInterface;
	
	
	
	@Override
	public List<TransactionDetails> getAllTransactionDetailsbyAccountNumber(long accountNumber) {
		// TODO Auto-generated method stub
		return transectionDetailsRepository.getAllTransactionDetailsbyAccountNumber(accountNumber);
	}
	

	public boolean saveTrasectionDetails(TransactionDetails transactionDetails) {
		
		return transectionDetailsRepository.saveTrasectionDetails(transactionDetails);
	}


	@Override
	public TransactionDetails tranferMoney(TransactionDetails transactionDetails) {
		Account recieverAccount=accountDetailServiceInterface.getAccountDetailsByAccountNumber(transactionDetails.getRecieverAccount().getAccountNumber());
		if(recieverAccount!=null)
		{
			Account senderAccount=accountDetailServiceInterface.debit(transactionDetails.getSenderAccount().getAccountNumber(), transactionDetails.getTransactionAmount());
			if(senderAccount!=null)
			{
				recieverAccount=accountDetailServiceInterface.credit(transactionDetails.getRecieverAccount().getAccountNumber(), transactionDetails.getTransactionAmount());
				saveTrasectionDetails(transactionDetails);
				return transactionDetails;
			}
			else
			{
				return null;
			}
		}
		
		else
		{
			throw new AccountNotExistException("Reciever Account Not Exist!");
		}
	
	}
	
	

	

}
