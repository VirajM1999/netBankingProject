package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.FixDeposite;

public class FixDepositeRowMapper implements RowMapper<FixDeposite>{

	@Override
	public FixDeposite mapRow(ResultSet rs, int rowNum) throws SQLException {
		String fixdepositeId = rs.getString("fixdeposite_id");
		long accountNumber=rs.getLong("account_number");
		LocalDate dateOfCreation=rs.getDate("Date_of_creation").toLocalDate();
		double rateOfInterest=rs.getDouble("rate_of_interest");
		double fdAmount=rs.getDouble("fd_amount");
		return new FixDeposite(fixdepositeId, accountNumber, dateOfCreation, rateOfInterest,fdAmount);
	}

}
