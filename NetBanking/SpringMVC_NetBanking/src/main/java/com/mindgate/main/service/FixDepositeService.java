package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.FixDeposite;
import com.mindgate.main.repository.FixDepositeRepository;

@Service
public class FixDepositeService implements FixDepositeServiceInterface{

	@Autowired
	private FixDepositeRepository fixDepositeRepository;
	
	@Autowired
	private AccountDetailServiceInterface accountDetailServiceInterface;
	
	
	

	@Override
	public List<FixDeposite> getFixDepositeDetailsByAccountNumber(long accountNumber) {
		// TODO Auto-generated method stub
		return fixDepositeRepository.getFixDepositeDetailsByAccountNumber(accountNumber);
	}

	@Override
	public int updateFixDepositeDetails(FixDeposite fixDeposite,String fixdepositeId) {
		// TODO Auto-generated method stub
		return fixDepositeRepository.updateFixDepositeDetails(fixDeposite,fixdepositeId);
	}

	@Override
	public boolean createNewFixDeposite(FixDeposite fixDeposite) {
		Account account=accountDetailServiceInterface.debit(fixDeposite.getAccountNumber(), fixDeposite.getFdAmount());
		if(account!=null)
		{
			fixDepositeRepository.saveFixDeposite(fixDeposite);
			return true;
		}
		return false;
	}

}
