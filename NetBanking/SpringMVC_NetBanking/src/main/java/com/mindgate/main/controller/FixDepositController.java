package com.mindgate.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.CustomerDetail;
import com.mindgate.main.domain.FixDeposite;
import com.mindgate.main.service.AccountDetailServiceInterface;
import com.mindgate.main.service.FixDepositeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class FixDepositController {
	
	@Autowired
	FixDepositeService fixDepositeService;
	
	@Autowired
	AccountDetailServiceInterface accountDetailServiceInterface;
	
	Logger logger=LoggerFactory.getLogger(CustomerContoller.class);

	@RequestMapping("showFD/{accountNumber}")
	public String getFDPage(@PathVariable("accountNumber") long accountNo,Model model)
	{
		
		List<FixDeposite> fixDepositeDetailsByAccountNumber = fixDepositeService.getFixDepositeDetailsByAccountNumber(accountNo);
		model.addAttribute("fixDepositByAccountKey", fixDepositeDetailsByAccountNumber);
		
		return "showFD";
	}
	
	@RequestMapping("createNewFD")
	public String showCreateFDPage()
	{
		return "createNewFD";
	}

	@RequestMapping("saveFD")

	public String insertFD(@ModelAttribute("fixDeposite")FixDeposite fixDeposite,Model model,HttpSession session,RedirectAttributes redirectAttributes)
	{
		LocalDate currDate=LocalDate.now();
		fixDeposite.setDateOfCreation(currDate);
		boolean saveFixDeposite = fixDepositeService.createNewFixDeposite(fixDeposite);
		
		model.addAttribute("fixDepositByAccountKey", fixDeposite.getAccountNumber());
		if (saveFixDeposite) {
			
			
			CustomerDetail customerDetail =(CustomerDetail)session.getAttribute("customerDetailsKey");
			Account updatedSenderAccount=accountDetailServiceInterface.getAccountDetailsByAccountNumber(fixDeposite.getAccountNumber());
			
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
			session.setAttribute("displayMsg",true);
			session.setAttribute("popUpMessage","fdsuccess");
			
			
			
			return "redirect:/customer/home";
		}
		else {
			session.setAttribute("displayMsg",true);
			session.setAttribute("popUpMessage","fdFail");
			
			return "redirect:/customer/home";
			
		}
		
		
	}
}
