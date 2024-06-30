package com.mindgate.main.RestController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.TransactionDetails;
import com.mindgate.main.service.AccountDetailServiceInterface;
import com.mindgate.main.service.TransactionDetailsServiceInterface;

@RestController
@RequestMapping("customerrest")
public class TransactionRestController {
	
	@Autowired
	private TransactionDetailsServiceInterface transactionDetailsServiceInterface;
	
	@Autowired
	private AccountDetailServiceInterface accountDetailServiceInterface;
	
	
	@GetMapping("getAllTransaction")
	public ResponseEntity showTrasectionDetails(@RequestParam("accountNumber") long accountNumber) {
	    
		Account account=accountDetailServiceInterface.getAccountDetailsByAccountNumber(accountNumber);
		if(account!=null)
		{
			List<TransactionDetails> transactions= transactionDetailsServiceInterface.getAllTransactionDetailsbyAccountNumber(accountNumber);
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(transactions);
			
		}    
	    	    
	    return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Account does not exist..!");
	}
	
	@PostMapping("tranfermoney")
	public ResponseEntity tranferMoney(@RequestParam long senderAccountNumber,@RequestParam long receiverAccountNumber,@RequestParam double amount )
	{
		Account senderAccountAccount=accountDetailServiceInterface.getAccountDetailsByAccountNumber(senderAccountNumber);
		if(senderAccountAccount!=null)
		{
			Account reciverAccount=accountDetailServiceInterface.getAccountDetailsByAccountNumber(receiverAccountNumber);
			if(reciverAccount!=null)
			{
				TransactionDetails transactionDetails=new TransactionDetails();
				transactionDetails.setSenderAccount(senderAccountAccount);
				transactionDetails.setRecieverAccount(reciverAccount);
				transactionDetails.setTransactionAmount(amount);
				transactionDetails.setTransactionDate(LocalDate.now());
				
				TransactionDetails transactionDetails2=transactionDetailsServiceInterface.tranferMoney(transactionDetails);
				if(transactionDetails2!=null)
				{
					return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(transactionDetails2);
				}
				return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Transaction Failed..!");
			}
			else
			{
				return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Reciver Account does not exist...!");
			}
			
		}
		else
		{
			return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Sender account does not exist");
		}
		
		
	}
}
