package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.FixDeposite;

@Repository
public class FixDepositeRepository implements FixDepositeRepositoryInterface{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_FIXDEPOSITE_DETAILS="insert into fixdeposite (fixdeposite_id,account_number,Date_of_creation,rate_of_interest,fd_amount) values(fixdeposite_id_sequence.nextval,?,?,?,?)";
	private static final String SELECT_FIXDEPOSITE_DETAILS_BY_ACCOUNT_NUMBER="select * from fixdeposite where account_number=? order by date_of_creation";
	private static final String UPDATE_FIXDEPOSITE_DETAILS="update fixdeposite set account_number=?,date_of_creation=?,rate_of_interest=? where fixdeposite_id=?";
	
	@Override
	public boolean saveFixDeposite(FixDeposite fixDeposite) {
		Object[] parameters= { fixDeposite.getAccountNumber(),fixDeposite.getDateOfCreation(),fixDeposite.getRateOfInterest(),fixDeposite.getFdAmount()};
		int insertFixDeposit = jdbcTemplate.update(INSERT_FIXDEPOSITE_DETAILS, parameters);
		if(insertFixDeposit>0)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<FixDeposite> getFixDepositeDetailsByAccountNumber(long accountNumber) {
		try
		{
			FixDepositeRowMapper fixDepositeRowMapper = new FixDepositeRowMapper();
			List<FixDeposite> getAllFixDeposit = jdbcTemplate.query(SELECT_FIXDEPOSITE_DETAILS_BY_ACCOUNT_NUMBER, fixDepositeRowMapper,accountNumber);
			return getAllFixDeposit;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateFixDepositeDetails(FixDeposite fixDeposite,String fixdepositeId ) {
		System.out.println(fixDeposite);
		Object[] parameters= {fixDeposite.getAccountNumber(),fixDeposite.getDateOfCreation(),fixDeposite.getRateOfInterest(),fixdepositeId};
		int updateFixDeposite = jdbcTemplate.update(UPDATE_FIXDEPOSITE_DETAILS, parameters);
		return updateFixDeposite;
	}

	

}
