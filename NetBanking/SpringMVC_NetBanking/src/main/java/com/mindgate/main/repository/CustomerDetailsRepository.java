package com.mindgate.main.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.CustomerDetail;
import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.service.AccountDetailServiceInterface;

@Repository
public class CustomerDetailsRepository implements CustomerDetailsRepositoryInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;




	private static final String SELECT_ALL_EMPLOYEE = "select * from customer where login_attempt>3";

	private static final String GET_CUSTOMER_DETAILS = "select * from customer where login_id=?";
	private static final String update_loginCount = "update customer set login_attempt=login_attempt+1 where login_id=?";
	private static final String update_loginCounttoZero = "update customer set login_attempt=0 where login_id=?";

	private static final String INSERT_NEW_CUSTOMER = "INSERT INTO customer VALUES (?,?, ?, ?, ?, ?, ?, ?, ?,?)";
	private static final String GET_CUSTOMER_DETAILS_BY_ACCOUNT_NUMBER="Select * from customer where customer_id=?";
	private static final String update_loginCounttoZero_BYCUSTOMERID="update customer set login_attempt=0 where customer_id=?";
	@Override
	public List<CustomerDetail> getAllCustomerDetail() {
		try {
			CustomerRowMapper customerRowMapper = new CustomerRowMapper();
			List<CustomerDetail> customerDetails = jdbcTemplate.query(SELECT_ALL_EMPLOYEE, customerRowMapper);
			return customerDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CustomerDetail getCustomerDetails(String loginId) {

		try {
			CustomerRowMapper customerRowMapper = new CustomerRowMapper();
			CustomerDetail customer = jdbcTemplate.queryForObject(GET_CUSTOMER_DETAILS, customerRowMapper, loginId);
			return customer;
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public boolean updateLoginCount(String loginId) {

		int result = jdbcTemplate.update(update_loginCount, loginId);
		System.out.println("result" + result);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int updateLoginCounttoZero(String loginid) {
		int result = jdbcTemplate.update(update_loginCounttoZero, loginid);
		return result;
	}

	@Override
	public CustomerDetail addNewCustomer(CustomerDetail customerDetail) {

		long customerid = jdbcTemplate.queryForObject("SELECT customer_id_sequence.NEXTVAL FROM dual", Integer.class);
		String newCustomerId = "MGS" + customerid;
		Object[] parameters = { newCustomerId, customerDetail.getFirstName(), customerDetail.getLastName(),
				customerDetail.getEmail(), customerDetail.getPhoneNumber(), customerDetail.getCity(),
				customerDetail.getPanNo(), customerDetail.getAdhaarNo(), customerDetail.getLoginAttempt(),
				customerDetail.getLoginDetails().getloginId() };
		int result = jdbcTemplate.update(INSERT_NEW_CUSTOMER, parameters);
		customerDetail.setCustomerId(newCustomerId);

		if (result > 0) {
			return customerDetail;
		}

		return null;
	}
	
	@Override
    public int updateLoginCounttoZeroBYCustomerId(String customerId) {
        int result=jdbcTemplate.update(update_loginCounttoZero_BYCUSTOMERID,customerId);
        return result;
    }


	

}
