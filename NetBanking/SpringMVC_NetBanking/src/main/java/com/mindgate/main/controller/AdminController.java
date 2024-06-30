package com.mindgate.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Cheque;
import com.mindgate.main.domain.CustomerDetail;
import com.mindgate.main.domain.TransactionDetails;
import com.mindgate.main.service.AccountDetailService;
import com.mindgate.main.service.AccountDetailServiceInterface;
import com.mindgate.main.service.ChequeService;
import com.mindgate.main.service.CustomerDetailsServiceInterface;
import com.mindgate.main.service.TransactionDetailsServiceInterface;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private ChequeService chequeService;
	
	@Autowired
	CustomerDetailsServiceInterface customerDetailsServiceInterface;
	
	@Autowired
	TransactionDetailsServiceInterface transactionDetailsServiceInterface;
	
	@Autowired
	AccountDetailServiceInterface accountDetailServiceInterface;

	@RequestMapping("home")
	public String showAdminpage(Model model) {
		List<Account> accList = accountDetailServiceInterface.NAList();
		List<Cheque> chequeListToApp = chequeService.getChecuesToApprove();
		
		List<CustomerDetail> cDetailsList= customerDetailsServiceInterface.getAllCustomerDetail();
		
		model.addAttribute("AccountList", accList);
		model.addAttribute("chequeListToApp", chequeListToApp);
		model.addAttribute("cDetailsList", cDetailsList);
		

		return "adminpage";
	}

	@RequestMapping("updateStatus/{accountnumber}")
	public String updateAccountStatus(@PathVariable("accountnumber") long accountnumber) {
			
		Account acc=accountDetailServiceInterface.getAccountDetailsByAccountNumber(accountnumber);
		if(acc.getAccountType().equals("saving")){
			accountDetailServiceInterface.updateBalance(10000, accountnumber);
		}else {
			accountDetailServiceInterface.updateBalance(10000, accountnumber);
			accountDetailServiceInterface.updateOverDraftBalance(50000, accountnumber);
		}
		
		accountDetailServiceInterface.updateStatus(accountnumber);

		return "redirect:/admin/home";
	}

	@RequestMapping("updateStatusOfCheque/{chequeNumber}")
    public String updateStatusOfCheq(@PathVariable("chequeNumber") String chequeNumber,
                                        HttpSession session,Model model) {
        
        Cheque cheque= chequeService.getChequeByChequeNo(chequeNumber);
        
        double amount=cheque.getAmount();
        String status;
        
        TransactionDetails transactionDetails=new TransactionDetails();
        transactionDetails.setTransactionAmount(amount);
        transactionDetails.setTransactionDate(LocalDate.now());
        transactionDetails.setRecieverAccount(cheque.getRecieverAccount());
        transactionDetails.setSenderAccount(cheque.getSenderAccount());
        
        
        transactionDetails=transactionDetailsServiceInterface.tranferMoney(transactionDetails);
        
        if(transactionDetails!=null) {
            
            status="Cleared";
            chequeService.updateStatusForApprove(chequeNumber,status);
        
            
            
        }else  {
            status="Bounced";
            
            Account recieverAccountHolder = accountDetailServiceInterface.getAccountDetailsByAccountNumber(cheque.getRecieverAccount().getAccountNumber());
            Account senderAccountHolder = accountDetailServiceInterface.getAccountDetailsByAccountNumber(cheque.getSenderAccount().getAccountNumber());
            accountDetailServiceInterface.updateBalance(recieverAccountHolder.getBalance()-100,recieverAccountHolder.getAccountNumber());
            accountDetailServiceInterface.updateBalance(senderAccountHolder.getBalance()-100,senderAccountHolder.getAccountNumber());
            chequeService.updateStatusForApprove(chequeNumber,status);
        }
        

        return "redirect:/admin/home";
    }
	
	 @RequestMapping("logout")
	    public String logoutFromBank(HttpSession httpSession)
	    {
	        httpSession.invalidate();

	        return "redirect:/";
	    }
	 
	 @RequestMapping("updateLoginAttempts/{customerId}")
		public String updateAccountStatus(@PathVariable("customerId") String  customerId) {
			
		
			
		 customerDetailsServiceInterface.updateLoginCounttoZeroBYCustomerId(customerId);

			return "redirect:/admin/home";
		}

	 

}
