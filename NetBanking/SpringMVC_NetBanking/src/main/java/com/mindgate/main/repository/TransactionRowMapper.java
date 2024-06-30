package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.TransactionDetails;





public class TransactionRowMapper implements RowMapper<TransactionDetails>{

	@Override
	public TransactionDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
	
		String transactionId =rs.getString("transaction_id");
		
		LocalDate transactionDate= rs.getDate("transaction_date").toLocalDate();
		
		Account recieverAccount=new Account();
		recieverAccount.setAccountNumber(rs.getLong("reciever_account_number"));
		
		Account senderAccount=new Account();
		senderAccount.setAccountNumber(rs.getLong("sender_account_number"));
		
		double transactionAmount=rs.getDouble("transaction_amount");
		
		TransactionDetails transectionDetails = new TransactionDetails(transactionId, transactionDate, recieverAccount, senderAccount, transactionAmount);
		return transectionDetails;
		
	}

		
	}

