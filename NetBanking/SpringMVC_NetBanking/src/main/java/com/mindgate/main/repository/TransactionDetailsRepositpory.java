package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.TransactionDetails;

@Repository
public class TransactionDetailsRepositpory implements TransactionDetailsRepositoryInerface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECTA_ALL_TRASECTION_DETAILS = "SELECT * FROM transaction WHERE reciever_account_number=? OR sender_account_number=? order by TRANSACTION_DATE desc";
	private static final String INSERT_NEW_TRASECTION_DETAILS = "INSERT INTO transaction(TRANSACTION_ID,TRANSACTION_DATE,RECIEVER_ACCOUNT_NUMBER,SENDER_ACCOUNT_NUMBER,TRANSACTION_AMOUNT) VALUES('TXID'||transaction_id_sequence.NEXTVAL,?,?,?,?)";

	@Override
	public List<TransactionDetails> getAllTransactionDetailsbyAccountNumber(long accountNumber) {
		// TODO Auto-generated method stub

		TransactionRowMapper transactionRowMapper = new TransactionRowMapper();
		List<TransactionDetails> allTransactionDetails = jdbcTemplate.query(SELECTA_ALL_TRASECTION_DETAILS,
				transactionRowMapper, accountNumber, accountNumber);
		System.out.println("allTransactionDetails" + allTransactionDetails);
		return allTransactionDetails;
	}
	
	@Override
	public boolean saveTrasectionDetails(TransactionDetails transactionDetails) {
		Object[] parameters = { transactionDetails.getTransactionDate(),transactionDetails.getRecieverAccount().getAccountNumber(), 
				transactionDetails.getSenderAccount().getAccountNumber(),
				transactionDetails.getTransactionAmount()};
		
		
		int resultCount = jdbcTemplate.update(INSERT_NEW_TRASECTION_DETAILS, parameters);
		if (resultCount > 0)
			return true;

		return false;
	}
	
	

}