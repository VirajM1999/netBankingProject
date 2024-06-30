package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.BankSlip;
import com.mindgate.main.domain.Cheque;


public class BankSlipRowMapper implements RowMapper<BankSlip>{

	@Override
	public BankSlip mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		String bankslipId=rs.getString("bankslip_id");
		
		Account acc=new Account();
		Long accountNumber=rs.getLong("account_number");
		acc.setAccountNumber(accountNumber);
		LocalDate bankslipDate=rs.getDate("bankslip_date").toLocalDate();
		double amount=rs.getDouble("amount");
		Cheque cheq=new Cheque();
		String  chequeNumber=rs.getString("cheque_number");
		cheq.setChequeNumber(chequeNumber);
		
		BankSlip bankSlip = new BankSlip(bankslipId,acc,bankslipDate,amount,cheq);	
		
		return bankSlip;
	}

}
