package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.CustomerDetail;
import com.mindgate.main.domain.LoginDetails;

public class CustomerRowMapper implements RowMapper<CustomerDetail>{

	@Override
	public CustomerDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		String customerId=rs.getString("customer_id");
		String firstName=rs.getString("first_name");
		String lastName=rs.getString("last_name");
		String email=rs.getString("email");
		long phoneNumber=rs.getLong("phone_no");
		String city=rs.getString("city");
		String panNo=rs.getString("pan_no");
		String adhaarNo=rs.getString("adhaar_no");
		int loginAttempt=rs.getInt("login_attempt");
		String loginId=rs.getString("login_id");
		LoginDetails loginDetails=new LoginDetails();
		loginDetails.setloginId(loginId);
		
		CustomerDetail customerDetail=new CustomerDetail(customerId, firstName, 
				lastName, email, phoneNumber, city, panNo, adhaarNo,loginAttempt,loginDetails);
		
		
		return customerDetail;
	}

}
