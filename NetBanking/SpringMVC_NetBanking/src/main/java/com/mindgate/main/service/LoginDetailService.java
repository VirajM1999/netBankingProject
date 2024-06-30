package com.mindgate.main.service;

import com.mindgate.main.domain.LoginDetails;

public interface LoginDetailService {
	
	public LoginDetails checkCredentials(String loginId,String password);
	
	public boolean checkId(String loginId);
	
	public LoginDetails insertLoginDetails(String password,String role);

}
