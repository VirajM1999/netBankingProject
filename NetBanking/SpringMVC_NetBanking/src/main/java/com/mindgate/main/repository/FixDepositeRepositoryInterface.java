package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.FixDeposite;

public interface FixDepositeRepositoryInterface {

	public boolean saveFixDeposite(FixDeposite fixDeposite);
	public List<FixDeposite> getFixDepositeDetailsByAccountNumber(long accountNumber);
	public int updateFixDepositeDetails(FixDeposite fixDeposite,String fixdepositeId);
	
}
