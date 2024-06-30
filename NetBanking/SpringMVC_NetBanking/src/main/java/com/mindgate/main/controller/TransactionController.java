package com.mindgate.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.CustomerDetail;
import com.mindgate.main.domain.TransactionDetails;
import com.mindgate.main.service.AccountDetailServiceInterface;
import com.mindgate.main.service.TransactionDetailsServiceInterface;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class TransactionController {
	@Autowired
	TransactionDetailsServiceInterface transactionDetailsServiceInterface;
	
	@Autowired
	AccountDetailServiceInterface accountDetailServiceInterface;
	
	@RequestMapping("sendmoney")
	public String sendMoney()
	{
		return "moneyTransfer";
	}
	
	@RequestMapping("tranfermoney")
	public String tranferMoney(@RequestParam long senderAccountNumber,@RequestParam long receiverAccountNumber,@RequestParam double amount,HttpSession session,Model model)
	{
		
		TransactionDetails transactionDetails=new TransactionDetails();
		transactionDetails.setTransactionAmount(amount);
		Account reciverAccount=new Account();
		reciverAccount.setAccountNumber(receiverAccountNumber);
		transactionDetails.setRecieverAccount(reciverAccount);
		transactionDetails.setTransactionDate(LocalDate.now());
		
		Account senderAccount=(Account)session.getAttribute("myAccountKey");		
		CustomerDetail customerDetail =(CustomerDetail)session.getAttribute("customerDetailsKey");
		
		
		transactionDetails.setSenderAccount(senderAccount);
		boolean isTransactionSuccess=false;
			
		transactionDetails=transactionDetailsServiceInterface.tranferMoney(transactionDetails);
		if(transactionDetails!=null)
		{
			Account updatedSenderAccount=accountDetailServiceInterface.getAccountDetailsByAccountNumber(transactionDetails.getSenderAccount().getAccountNumber());
			session.setAttribute("myAccountKey", updatedSenderAccount);			
			List<Account> accounts= customerDetail.getAccountList();
			for(Account acc:accounts)
			{
				if(acc.getAccountNumber()==updatedSenderAccount.getAccountNumber())
				{
					acc.setBalance(updatedSenderAccount.getBalance());
					acc.setOverdraftBalance(updatedSenderAccount.getOverdraftBalance());
				}
			}
			session.setAttribute("customerDetailsKey", customerDetail);
			isTransactionSuccess=true;
			
		}
		
		if(isTransactionSuccess)
		{
			session.setAttribute("popUpMessage","transactionSuccess");
		}
		else
		{
			session.setAttribute("popUpMessage","transactionFail");
		}
		
		session.setAttribute("displayMsg",true);
		return "redirect:/customer/home";
	}
	
	@RequestMapping("allTransactions/{accountNumber}")
	public String showTrasectionDetails(@PathVariable("accountNumber") long accountNumber,Model model) {
	    
		
	    List<TransactionDetails>  TrasectionlistAll= transactionDetailsServiceInterface.getAllTransactionDetailsbyAccountNumber(accountNumber);
	    model.addAttribute("TrasectionlistAll",TrasectionlistAll);    
	    
	    	    
	    return "myTransactionDetails";
	}
	

}
