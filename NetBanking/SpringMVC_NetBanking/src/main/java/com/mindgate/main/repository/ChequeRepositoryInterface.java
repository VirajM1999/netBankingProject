package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Cheque;

public interface ChequeRepositoryInterface {

	public boolean saveChequeDetails(Cheque cheque);
	
	public List<Cheque> getAllCheques();
	
	public List<Cheque> receivedChecks(Long receiverAccountId);
	
	public List<Cheque> sentChecks(Long accountNumber);
	
	public Cheque getChequeByChequeNo(String ChequeNo);
	
	public boolean updateChequeIfBounced(String chequeNumber);
	public int updateStatusForApprove(String status,String chequeNumber);
	
	public List<Cheque> getChecuesToApprove();
	
	public List<Cheque> ChequesCleared(Long receiverAccountId);
	
	public List<Cheque> ChequesBounced(Long receiverAccountId) ;
}