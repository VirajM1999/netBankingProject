package com.mindgate.main.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Account;

@Repository
public class AccountDetailsRepository implements AccountDetailsRepositoryInterface{
    @Autowired
    JdbcTemplate jdbcTemplate;
    
   
    
    
    private static final String INSERT_IN_ACCOUNTDETAILS="Insert into account values(?,?,?,?,?,?,?,?)";
    private static final String GET_ACCOUNTDETAILS_BY_ID="Select * from account where customer_id=? order by account_creation_date asc";
    private static final String GET_ACCOUNTDETAILS_BY_ACCOUNTNO="select * from account where account_number=?";
    private static final String UPDATE_BALANCE="update account set balance=? where account_number=?";
    private static final String UPDATE_OVER_DRAFT_BALANCE="update account set overdraft_balance=? where account_number=?";
    private static final String GET_NONAPPROVED_LIST="select * from account where is_approved='NA'";    
    private static final String UPDATE_STATUS_APPROVED="update account set is_approved='A' where account_number=?";
    
    
    
    public Account addNewAccount(Account account) {
    	LocalDate currDate=LocalDate.now();
        
        DateTimeFormatter formater=DateTimeFormatter.ofPattern("dd-MM-yy");
        String strDate=currDate.format(formater);
      
        
        
        account.setAccountCreationDate(strDate);
    	
    	long accountNumber = jdbcTemplate.queryForObject("SELECT account_number_sequence.NEXTVAL FROM dual",
				Integer.class);
    	
    	Object[] parameters= {accountNumber,account.getAccountType(),account.getCustomerId(),account.getBalance(),account.getOverdraftBalance(),account.getRateOfInterest(),account.getIsApproved(),account.getAccountCreationDate()};
    	int result =jdbcTemplate.update(INSERT_IN_ACCOUNTDETAILS, parameters);
    	if(result>0)
    	{
    		account.setAccountNumber(accountNumber);
    		return account;
    	}
    	return null;
    }
    
    @Override
    public List<Account> getAccountDetailsById(String customerId) {
        
        AccountRowMapper accountRowMapper= new AccountRowMapper();
        
        try {
            List<Account> accounts =jdbcTemplate.query(GET_ACCOUNTDETAILS_BY_ID,accountRowMapper,customerId);
            return accounts;
        } catch (Exception e) {
            return null;
        }
        
    }
    @Override
    public Account getAccountDetailsByAccountNumber(long accountNumber) {
        AccountRowMapper accountRowMapper= new AccountRowMapper();
        
        try {
            Account account =jdbcTemplate.queryForObject(GET_ACCOUNTDETAILS_BY_ACCOUNTNO,accountRowMapper,accountNumber);
            return account;
        } catch (Exception e) {
            return null;
        }
    
    }
    @Override
    public int updateBalance(double amount,long accountNumber) {
        Object [] parameters= { amount,accountNumber};
        int result=jdbcTemplate.update(UPDATE_BALANCE, parameters);
        return result;
    }
    @Override
    public int updateOverDraftBalance(double amount, long accountNumber) {
        
        Object [] parameters= { amount,accountNumber};
        int result=jdbcTemplate.update(UPDATE_OVER_DRAFT_BALANCE, parameters);
        return result;
    }

	@Override
	public List<Account> NAList() {
		AccountRowMapper accountRowMapper = new AccountRowMapper();

		try {
			List<Account> accounts = jdbcTemplate.query(GET_NONAPPROVED_LIST, accountRowMapper);
			return accounts;
		} catch (Exception e) {
			return null;
		}

	}
	
	 @Override
	    public int updateStatus(long accountNumber) {
	        System.err.println("accountNumber"+accountNumber);
	      
	        int result=jdbcTemplate.update(UPDATE_STATUS_APPROVED, accountNumber);
	        return result;
	    }

}