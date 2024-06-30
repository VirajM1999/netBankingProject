package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.CustomerDetail;
import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.repository.CustomerDetailsRepository;

@Service
public class CustomerDetailsService implements CustomerDetailsServiceInterface {
	
	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;
	
	@Autowired
	private LoginDetailService loginDetailService;
	
	@Autowired
	private AccountDetailServiceInterface accountDetailServiceInterface;
	
	@Autowired
	private EmailSenderService emailSenderService;

	@Override
	public CustomerDetail getCustomerDetails(String loginId) {
		CustomerDetail customerDetail= customerDetailsRepository.getCustomerDetails(loginId);
				
		return customerDetail;
	
		
		
	}
	@Override
	public boolean updateLoginCount(String  loginId) {
		// TODO Auto-generated method stub
		return customerDetailsRepository.updateLoginCount(loginId);
	}



	@Override
	public int updateLoginCounttoZero(String loginId) {
		// TODO Auto-generated method stub
		return customerDetailsRepository.updateLoginCounttoZero(loginId);
	}
	@Override
	public CustomerDetail addNewCustomer(CustomerDetail customerDetail) {
		LoginDetails loginDetails=loginDetailService.insertLoginDetails(customerDetail.getLoginDetails().getPassword(),customerDetail.getLoginDetails().getRole());
		customerDetail.setLoginDetails(loginDetails);

		CustomerDetail insertedCustomerDetail2=customerDetailsRepository.addNewCustomer(customerDetail);
		if(insertedCustomerDetail2!=null)
		{
			emailSenderService.sendMail(insertedCustomerDetail2.getEmail(), "MGS Banking Longin Id", "Welcome To MGS Banking...! \n Thank You..! for registration\nyour loginId is:"+loginDetails.getloginId()+"  \n Your account will get approved with in next three working days");
		}
		
		customerDetail.getAccountList().get(0).setCustomerId(insertedCustomerDetail2.getCustomerId());
		
		Account account =accountDetailServiceInterface.addNewAccount(customerDetail.getAccountList().get(0));
		
		insertedCustomerDetail2.getAccountList().set(0, account);
		
		return insertedCustomerDetail2;
		
		
		
		
		
	}
	
	@Override
	public List<CustomerDetail> getAllCustomerDetail() {
		// TODO Auto-generated method stub
		return customerDetailsRepository.getAllCustomerDetail();
	}
	
	
	@Override
	public int updateLoginCounttoZeroBYCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return customerDetailsRepository.updateLoginCounttoZeroBYCustomerId(customerId);
	}
	
	
	

}
