package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.BankSlip;

public interface BankSlipServiceInterface {
	public List<BankSlip>getBankSlipsDetails(String bankslipId);
	public boolean saveBankSlipsDetails(BankSlip bankSlip);

}
