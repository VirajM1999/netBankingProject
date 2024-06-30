package com.mindgate.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.repository.LogindetailsRepository;

@Service
public class LoginDetailsServiceImpl implements LoginDetailService {
	
	@Autowired
	private LogindetailsRepository logindetailsRepositoryImpl;
	
	

	@Override
	public LoginDetails checkCredentials(String loginId, String password) {
		LoginDetails checkIDPass=logindetailsRepositoryImpl.checkCredentials(loginId, password);
		
		
		return checkIDPass;
	}



	@Override
	public boolean checkId(String loginId) {
		
		return logindetailsRepositoryImpl.checkId(loginId) ;
	}



	@Override
	public LoginDetails insertLoginDetails(String password, String role) {
		// TODO Auto-generated method stub
		return logindetailsRepositoryImpl.insertLoginDetails(password, role);
	}



	
	
	

}
