package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.TransactionDetails;

public interface TransactionDetailsServiceInterface {
	public List<TransactionDetails> getAllTransactionDetailsbyAccountNumber(long accountNumber);
	public boolean saveTrasectionDetails(TransactionDetails saveTrasectionDetails);
	public TransactionDetails tranferMoney(TransactionDetails transactionDetails);	

}
