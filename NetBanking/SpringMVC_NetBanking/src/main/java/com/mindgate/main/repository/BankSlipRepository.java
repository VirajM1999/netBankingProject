package com.mindgate.main.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.BankSlip;

@Repository
public class BankSlipRepository implements BankSlipRepositoryInterface {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static  final String SELECT_ALL_BANKSLIP_DETAILS="select * from bankslip where cheque_number=?";
	private static final String INSERT_ALL_BANKSLIP_DETAILS="insert into bankslip values('MGSBankSlip'||bankslip_idsequence.nextval,?,?,?,?)";

	@Override
	public List<BankSlip> getAllBankSlipDetails(String BankslipId) {
		BankSlipRowMapper bankSlipRowMapper = new BankSlipRowMapper();
		List<BankSlip>getAllBankSlipDetails=jdbcTemplate.query(SELECT_ALL_BANKSLIP_DETAILS,bankSlipRowMapper,BankslipId);
		
		return getAllBankSlipDetails;
	}

	@Override
	public boolean bankSlipDetails(BankSlip bankSlip) {
		System.err.println("bankSlip"+bankSlip);
		LocalDate currDate=LocalDate.now();
        
//        DateTimeFormatter formater=DateTimeFormatter.ofPattern("dd-MM-yy");
//        String strDate=currDate.format(formater);
//      
		
		
		
		Object[]parameters= {bankSlip.getAccountNumber().getAccountNumber(),currDate,bankSlip.getAmount(),bankSlip.getChequeNumber().getChequeNumber()};
		int resultCount=jdbcTemplate.update(INSERT_ALL_BANKSLIP_DETAILS,parameters);
		if(resultCount>0)
			return true;
		
		return false;
	}

}
