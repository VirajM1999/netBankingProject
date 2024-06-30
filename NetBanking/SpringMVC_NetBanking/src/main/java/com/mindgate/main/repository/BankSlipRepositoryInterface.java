package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.BankSlip;

public interface BankSlipRepositoryInterface {
	List<BankSlip>getAllBankSlipDetails (String BankslipId);
	public boolean bankSlipDetails(BankSlip bankSlip);
	

}
