package com.mindgate.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.CustomerDetail;
import com.mindgate.main.service.AccountDetailService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class AccountController {
	@Autowired
    private AccountDetailService  accountDetailService;
    
    @RequestMapping("addaccount")
    public String showNewAccountPage() {
        return "newaccountpage";
    }
    
    
    @PostMapping("saveaccount")
    public String saveNewAccount(@RequestParam("accountType") String accountType,HttpSession session) {
        System.err.println("from create new Account");
    	CustomerDetail customer=(CustomerDetail) session.getAttribute("customerDetailsKey");
        
        String customerId=customer.getCustomerId();
        Account newAccount=new Account();
        newAccount.setAccountType(accountType);
        newAccount.setCustomerId(customerId);
        newAccount.setIsApproved("NA");
        
        accountDetailService.addNewAccount(newAccount);            
        
        return"redirect:/customer/home";
    }
    
    @RequestMapping("changeaccount")
    public String changeAccount(HttpSession httpSession,@RequestParam long accountNumber)
    {
    	Account chanedAccountNumber=accountDetailService.getAccountDetailsByAccountNumber(accountNumber);
    	System.err.println(accountNumber);
    	httpSession.setAttribute("myAccountKey", chanedAccountNumber);
    	
    	return"redirect:/customer/home";
    }

}
