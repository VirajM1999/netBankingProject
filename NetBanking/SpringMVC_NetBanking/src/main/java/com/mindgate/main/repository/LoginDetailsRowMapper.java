package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.LoginDetails;

public class LoginDetailsRowMapper implements RowMapper<LoginDetails> {

	@Override
	public LoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		String loginId=rs.getString("login_id");
		String password=rs.getString("password");
		String role=rs.getString("role");
		
		LoginDetails lgDetails=new LoginDetails(loginId, password, role);
		
		return lgDetails;
	}
	
	

}
