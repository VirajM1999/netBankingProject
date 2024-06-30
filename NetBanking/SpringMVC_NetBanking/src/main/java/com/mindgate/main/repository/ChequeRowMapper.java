package com.mindgate.main.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Cheque;

public class ChequeRowMapper implements RowMapper<Cheque>{

	@Override
	public Cheque mapRow(ResultSet rs, int rowNum) throws SQLException {
		String chequeNumber = rs.getString("cheque_number");
		
		Account recieverAccount=new Account();
		recieverAccount.setAccountNumber(rs.getLong("receiver_account_number"));
	
		Account senderAccount=new Account();
		senderAccount.setAccountNumber( rs.getLong("sender_account_number"));
		
		LocalDate chequeDate = rs.getDate("cheque_date").toLocalDate();
		double amount = rs.getDouble("amount");
		String status = rs.getString("status");
		
		return new Cheque(chequeNumber, recieverAccount, senderAccount, chequeDate, amount, status);
	}
	
	

}
