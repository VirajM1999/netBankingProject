package com.mindgate.main.service;


import java.util.List;

import com.mindgate.main.domain.CustomerDetail;

public interface CustomerDetailsServiceInterface {
	
	public CustomerDetail getCustomerDetails(String loginId);
    public boolean updateLoginCount(String loginId) ;
	
	public int updateLoginCounttoZero(String loginid);
	
	public CustomerDetail addNewCustomer(CustomerDetail customerDetail);
	public List<CustomerDetail> getAllCustomerDetail();
	
	public int updateLoginCounttoZeroBYCustomerId(String customerId);
	
}
