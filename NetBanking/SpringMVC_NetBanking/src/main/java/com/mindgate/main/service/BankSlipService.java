package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.BankSlip;
import com.mindgate.main.repository.BankSlipRepositoryInterface;

@Service
public class BankSlipService implements BankSlipServiceInterface {
	
	@Autowired
	BankSlipRepositoryInterface bankSlipRepositoryInterface;
	

	@Override
	public List<BankSlip> getBankSlipsDetails(String BankslipId) {
		// TODO Auto-generated method stub
		return bankSlipRepositoryInterface.getAllBankSlipDetails(BankslipId);
	}

	@Override
	public boolean saveBankSlipsDetails(BankSlip bankSlip) {
		// TODO Auto-generated method stub
		return bankSlipRepositoryInterface.bankSlipDetails(bankSlip);
	}

}
