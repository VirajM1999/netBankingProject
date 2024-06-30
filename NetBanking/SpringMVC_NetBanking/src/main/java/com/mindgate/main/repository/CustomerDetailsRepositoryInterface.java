package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.CustomerDetail;

public interface CustomerDetailsRepositoryInterface {
	public List<CustomerDetail> getAllCustomerDetail();
	
	public CustomerDetail getCustomerDetails(String loginId);
	
	public boolean updateLoginCount(String  loginId) ;
	
	public int updateLoginCounttoZero(String loginid);
	
	
	public CustomerDetail addNewCustomer(CustomerDetail customerDetail);
	
	public int updateLoginCounttoZeroBYCustomerId(String customerId);
	
}
