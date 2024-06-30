package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Cheque;
import com.mindgate.main.repository.ChequeRepository;

@Service
public class ChequeService implements ChequeServiceInterface{

	@Autowired
	private ChequeRepository chequeRepository;
	@Override
	public boolean saveChequeDetails(Cheque cheque) {
		
		return chequeRepository.saveChequeDetails(cheque);
	}
	@Override
	public List<Cheque> getAllCheques() {
		// TODO Auto-generated method stub
		return chequeRepository.getAllCheques();
	}
	@Override
	public List<Cheque> receivedChecks(Long receiverAccountId) {
		// TODO Auto-generated method stub
		return chequeRepository.receivedChecks(receiverAccountId);
	}
	@Override
	public Cheque getChequeByChequeNo(String ChequeNo) {
		// TODO Auto-generated method stub
		return chequeRepository.getChequeByChequeNo(ChequeNo);
	}
	
	@Override
    public List<Cheque> getChecuesToApprove() {
        // TODO Auto-generated method stub
        return chequeRepository.getChecuesToApprove();
    }
    @Override
    public int updateStatusForApprove(String chequeNumber,String status) {
        // TODO Auto-generated method stub
        return chequeRepository.updateStatusForApprove(chequeNumber,status);
    }
	@Override
	public List<Cheque> ChequesCleared(Long receiverAccountId) {
		// TODO Auto-generated method stub
		return chequeRepository.ChequesCleared(receiverAccountId);
	}
	@Override
	public List<Cheque> ChequesBounced(Long receiverAccountId) {
		// TODO Auto-generated method stub
		return chequeRepository.ChequesBounced(receiverAccountId);
	}
	@Override
	public List<Cheque> sentChecks(Long accountNumber) {
		// TODO Auto-generated method stub
		return chequeRepository.sentChecks(accountNumber);
	}
	@Override
	public boolean updateChequeIfBounced(String chequeNumber) {
		// TODO Auto-generated method stub
		return chequeRepository.updateChequeIfBounced(chequeNumber);
	}

}
