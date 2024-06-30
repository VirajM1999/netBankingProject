package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.FixDeposite;

public interface FixDepositeServiceInterface {
	
	public boolean createNewFixDeposite(FixDeposite fixDeposite);
	public List<FixDeposite> getFixDepositeDetailsByAccountNumber(long accountNumber);
	public int updateFixDepositeDetails(FixDeposite fixDeposite,String fixdepositeId);
}
