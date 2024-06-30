package com.mindgate.main.repository;

import java.sql.PreparedStatement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.LoginDetails;

@Repository
public class LogindetailsRepository implements LoginDetailsRepositoryInterface {

	Logger logger = LoggerFactory.getLogger(LogindetailsRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_LOGIN_DETAILS = " insert into login_details values(?,?,?)";

	private static final String checkCredentials = "select * from login_details where login_id=? and password=?";

	private static final String CHECK_LOGIN_ID = "SELECT * FROM login_details where login_id=?";

	@Override
	public LoginDetails checkCredentials(String loginId, String password) {

		System.out.println(loginId);
		System.out.println(password);
		try {
			LoginDetailsRowMapper rowMapper = new LoginDetailsRowMapper();
			Object[] parameters = { loginId, password };
			LoginDetails lgDetails = jdbcTemplate.queryForObject(checkCredentials, rowMapper, parameters);
			return lgDetails;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public boolean checkId(String loginId) {
		try {
			LoginDetailsRowMapper rowMapper = new LoginDetailsRowMapper();

			LoginDetails loginidcheck = jdbcTemplate.queryForObject(CHECK_LOGIN_ID, rowMapper, loginId);
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	@Override
	public LoginDetails insertLoginDetails(String password, String role) {

		// jdbcTemplate.queryForObject("SELECT logindetails_id_sequence.NEXTVAL FROM
		// dual", null, null)
		Integer userid = jdbcTemplate.queryForObject("SELECT logindetails_id_sequence.NEXTVAL FROM dual",
				Integer.class);

		String loginID = "user" + userid;
		LoginDetails loginDetails=new  LoginDetails(loginID, password, role);
		
		Object[] parameters={loginID,password,role};
		
		int result=jdbcTemplate.update(INSERT_LOGIN_DETAILS, parameters);
		if(result>0) {
			return loginDetails;
		}

		return loginDetails;

	}

}
