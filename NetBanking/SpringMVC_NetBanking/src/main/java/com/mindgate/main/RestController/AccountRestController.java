package com.mindgate.main.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Account;
import com.mindgate.main.service.AccountDetailServiceInterface;

@RestController
@RequestMapping("customerrest")
public class AccountRestController {
	@Autowired
	AccountDetailServiceInterface accountDetailServiceInterface;
	
	@GetMapping("getaccuntbyno")
	public ResponseEntity getAccountByAccountNo(@RequestParam long accountNumber)
	{
		Account accountdetails=accountDetailServiceInterface.getAccountDetailsByAccountNumber(accountNumber);
		
		if(accountdetails!=null)
		{
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(accountdetails);
		}
		
		return  ResponseEntity.status(HttpStatusCode.valueOf(400)).body(null);
	}
	
	@GetMapping("getaccountbyid")
	public ResponseEntity getAccountDetailsById(@RequestParam String customerId) {

		List<Account>accounts= accountDetailServiceInterface.getAccountDetailsById(customerId);
		
		if (accounts!=null)
		{
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(accounts);
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(null);
	}
	
	@GetMapping("getAaccountbyid")
	public ResponseEntity getApprovedAccounts(@RequestParam String customerId)
	{
		List<Account>dbAccounts= accountDetailServiceInterface.getAccountDetailsById(customerId);
		List<Account>approvedAccounts=new ArrayList<Account>();
		
		if (dbAccounts!=null)
		{
			for(Account acc:dbAccounts)
			{
				if(acc.getIsApproved().equals("A"))
				{
					approvedAccounts.add(acc);
				}
			}
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(approvedAccounts);
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(null);
	}
	
	@PutMapping("debit")
	public ResponseEntity debit(@RequestParam double balance ,@RequestParam long accountNumber)
	{
		Account account =accountDetailServiceInterface.debit(accountNumber, accountNumber);
		if(account !=null)
		{
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(account);
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(null);
		
	}
	
	@PutMapping("credit")
	public ResponseEntity credit(@RequestParam double balance ,@RequestParam long accountNumber)
	{
		Account account =accountDetailServiceInterface.credit(accountNumber, accountNumber);
		if(account !=null)
		{
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(account);
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(null);
	}
	
	@PostMapping("createaccount")
	public ResponseEntity createAccount(@RequestParam String acccountType,@RequestParam String customerId)
	{
		Account account =new Account();
		account.setAccountType(acccountType);
		account.setCustomerId(customerId);
		Account newAccount =accountDetailServiceInterface.addNewAccount(account);
		if(newAccount !=null)
		{
			return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(account);
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(null);
	}
	
	@PutMapping("updateaccountsatus")
	public ResponseEntity updateAccountstatus(@RequestParam long accountNumber)
	{
		int status= accountDetailServiceInterface.updateStatus(accountNumber);
		if(status>0)
		{
			Account updatedAccount=accountDetailServiceInterface.getAccountDetailsByAccountNumber(accountNumber);
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(updatedAccount);
		}
		
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(null);
	}
	
	
	


}
