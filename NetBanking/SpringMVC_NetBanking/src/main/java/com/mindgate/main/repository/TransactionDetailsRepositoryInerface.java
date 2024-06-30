package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.TransactionDetails;

public interface TransactionDetailsRepositoryInerface {
	 List<TransactionDetails> getAllTransactionDetailsbyAccountNumber(long accountNumber);
	 public boolean saveTrasectionDetails(TransactionDetails transactionDetails);
	

}
