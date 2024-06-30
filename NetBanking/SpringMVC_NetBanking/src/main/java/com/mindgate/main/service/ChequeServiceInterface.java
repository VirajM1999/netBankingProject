package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Cheque;

public interface ChequeServiceInterface {
	public boolean saveChequeDetails(Cheque cheque);
	public List<Cheque> getAllCheques();
	
	public List<Cheque> receivedChecks(Long receiverAccountId);
	
	public Cheque getChequeByChequeNo(String ChequeNo);
	
	public List<Cheque> getChecuesToApprove();
	
	 public int updateStatusForApprove(String status,String chequeNumber);
	 
	 public List<Cheque> ChequesCleared(Long receiverAccountId);
		
	 public List<Cheque> ChequesBounced(Long receiverAccountId) ;
	 public List<Cheque> sentChecks(Long accountNumber);
	 public boolean updateChequeIfBounced(String chequeNumber);

}
