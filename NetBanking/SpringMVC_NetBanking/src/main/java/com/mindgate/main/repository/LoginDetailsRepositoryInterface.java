package com.mindgate.main.repository;

import com.mindgate.main.domain.LoginDetails;

public interface LoginDetailsRepositoryInterface {
	
	public LoginDetails checkCredentials(String loginId,String password);
	
	public boolean checkId(String loginId);
	
	public LoginDetails insertLoginDetails(String password,String role);
	
	
	
	

	
	
	

}
