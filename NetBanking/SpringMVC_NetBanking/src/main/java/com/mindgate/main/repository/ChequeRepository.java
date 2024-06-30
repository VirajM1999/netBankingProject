package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Cheque;
import com.mindgate.main.domain.LoginDetails;

@Repository
public class ChequeRepository implements ChequeRepositoryInterface{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_CHEQUE_DETAILS="insert into cheque (cheque_number,receiver_account_number,sender_account_number,cheque_date,amount,status) values(cheque_number_sequence.nextval,?,?,?,?,?)";
	private static final String FETCH_ALL_CHEQUE_DETAILS="select * from cheque";
	private static final String FETCH_CHEQUE_DETAILS_BY_ACCOUNTID="select * from cheque WHERE receiver_account_number=? and STATUS='Not Received'";
	private static final String FETCH_SENT_CHEQUE="select * from cheque WHERE sender_account_number=?";
	private static final String FETCH_CHEQUE_DETAILS_BY_ACCOUNTID_BOUNCED="select * from cheque WHERE receiver_account_number=? AND STATUS='Bounced'";
	private static final String FETCH_CHEQUE_DETAILS_BY_ACCOUNTID_CLEARED="select * from cheque WHERE receiver_account_number=? AND STATUS='Cleared'";

	private static final String FETCH_CHEQUE_DETAILS_BY_NO="select * from cheque where CHEQUE_NUMBER=?";
	private static final String GET_CHEQUES_FORAPPROVAL="SELECT * FROM CHEQUE WHERE status='sent For Clearence' order by SENDER_ACCOUNT_NUMBER";
    private static final String UPDATE_STATUS_APPROVED="update CHEQUE set status=? where cheque_number=?";
	private static final String UPDATE_STATUS_OF_BOUNCED_CHEQUE="update CHEQUE set status='Not Received' where cheque_number=?";   
	
    @Override
	public boolean saveChequeDetails(Cheque cheque) {
		Object[] parameters= {cheque.getRecieverAccount().getAccountNumber(),cheque.getSenderAccount().getAccountNumber(),cheque.getChequeDate(),cheque.getAmount(),cheque.getStatus()};
		int insertCheque = jdbcTemplate.update(INSERT_CHEQUE_DETAILS, parameters);
		if(insertCheque>0)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Cheque> getAllCheques() {
		try {
			
			List<Cheque> allChequeTable = jdbcTemplate.query(FETCH_ALL_CHEQUE_DETAILS, new ChequeRowMapper());
			return allChequeTable;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Cheque> receivedChecks(Long receiverAccountId) {
		
		try {
			
			List<Cheque> allChequeTable = jdbcTemplate.query(FETCH_CHEQUE_DETAILS_BY_ACCOUNTID, new ChequeRowMapper(),receiverAccountId);
			return allChequeTable;
		}
		catch(Exception e) {
		
			return null;
		}
	}
	
	
	@Override
	public List<Cheque> sentChecks(Long accountNumber) {
		
		try {
			
			List<Cheque> allChequeTable = jdbcTemplate.query(FETCH_SENT_CHEQUE, new ChequeRowMapper(),accountNumber);
			return allChequeTable;
		}
		catch(Exception e) {
		
			return null;
		}
	}
	
	@Override
	public List<Cheque> ChequesBounced(Long receiverAccountId) {
		
		try {
			
			List<Cheque> allChequeTable = jdbcTemplate.query(FETCH_CHEQUE_DETAILS_BY_ACCOUNTID_BOUNCED, new ChequeRowMapper(),receiverAccountId);
			return allChequeTable;
		}
		catch(Exception e) {
		
			return null;
		}
	}
	
	@Override
	public List<Cheque> ChequesCleared(Long receiverAccountId) {
		
		try {
			
			List<Cheque> allChequeTable = jdbcTemplate.query(FETCH_CHEQUE_DETAILS_BY_ACCOUNTID_CLEARED, new ChequeRowMapper(),receiverAccountId);
			return allChequeTable;
		}
		catch(Exception e) {
		
			return null;
		}
	}

	@Override
	public Cheque getChequeByChequeNo(String ChequeNo) {
		try {
			

			Cheque chequeDetails = jdbcTemplate.queryForObject(FETCH_CHEQUE_DETAILS_BY_NO, new ChequeRowMapper(), ChequeNo);
			return chequeDetails;
		} catch (Exception e) {

			return null;
		}
	}
	
	
	@Override
    public int updateStatusForApprove(String chequeNumber,String status) {
       
      
        int result=jdbcTemplate.update(UPDATE_STATUS_APPROVED, status,chequeNumber);
        return result;
    }
	
	
	@Override
    public List<Cheque> getChecuesToApprove() {
        

        try {
            List<Cheque> chequesForApproval = jdbcTemplate.query(GET_CHEQUES_FORAPPROVAL, new ChequeRowMapper());
            return chequesForApproval;
        } catch (Exception e) {
            return null;
        }

    }
	
                                                                                                                                                @Override
    public boolean updateChequeIfBounced( String chequeNumber) {
        Object[]parameters= {chequeNumber};
        int update = jdbcTemplate.update(UPDATE_STATUS_OF_BOUNCED_CHEQUE, parameters);
        if(update>0)
        {
            return true;
        }
        return false;
    }
	
//	@Override
//	public boolean checkId(String loginId) {
//		try {
//			LoginDetailsRowMapper rowMapper = new LoginDetailsRowMapper();
//
//			LoginDetails loginidcheck = jdbcTemplate.queryForObject(CHECK_LOGIN_ID, rowMapper, loginId);
//			return true;
//		} catch (Exception e) {
//
//			return false;
//		}
//
//	}
	
	
	

}
