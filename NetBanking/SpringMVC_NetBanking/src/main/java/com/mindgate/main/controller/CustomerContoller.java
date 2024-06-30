package com.mindgate.main.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Cheque;
import com.mindgate.main.domain.CustomerDetail;
import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.service.AccountDetailService;
import com.mindgate.main.service.ChequeService;
import com.mindgate.main.service.CustomerDetailsService;
import com.mindgate.main.service.LoginDetailsServiceImpl;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("customer")
public class CustomerContoller {
	
	@Autowired
	private LoginDetailsServiceImpl loginDetailsServiceImpl;
	
	@Autowired
	private CustomerDetailsService customerDetailsServiceImpl;
	
	@Autowired
	private AccountDetailService accountDetailService;
	
	
	@RequestMapping("login")
	public String loginCheck(HttpSession session,Model model ,@RequestParam("loginId")String loginId,@RequestParam("password")String password) {		
		String message=null;
		boolean isfailed=false;
		session.removeAttribute("message");
		session.removeAttribute("isfailed");
		if(loginDetailsServiceImpl.checkId(loginId))
		{
			
			LoginDetails logInDetails=loginDetailsServiceImpl.checkCredentials(loginId, password);
		
			if(logInDetails!=null)
			{
				
				
				String role=logInDetails.getRole();
				if(role.equals("admin"))
				{
					
					return "redirect:/admin/home";
				}
				else
				{	
					
				   CustomerDetail customerDetail=customerDetailsServiceImpl.getCustomerDetails(loginId);				   
				   if(customerDetail.getLoginAttempt()<4)
				   {
					   List<Account> accounts=accountDetailService.getAccountDetailsById(customerDetail.getCustomerId());
					  
					   for(Account account:accounts)
					   {
						   
						   if(account.getIsApproved().equals("A"))
						   {
							  
							   customerDetail.getAccountList().add(account);
						   }
					   }
					   
					   if(customerDetail.getAccountList().size()==0) {
						   message="Your Account Approval is pending!!!";
						   isfailed=true;
						   model.addAttribute("message",message);
						   model.addAttribute("isfaild",isfailed);
						   
						   return "redirct:/loginpage";
						   
					   }
					   
					  
					   session.setAttribute("myAccountKey", customerDetail.getAccountList().get(0));
					  
					   
					   session.setAttribute("customerDetailsKey",customerDetail);
					   customerDetailsServiceImpl.updateLoginCounttoZero(loginId);
					   session.setAttribute("displayMsg",false);
					
					   session.setAttribute("popUpMessage","");
					   
					   return "redirect:/customer/home";
					   
				   }
				   else
				   {
					   message="You are blocked..! please contact to administrator";
					   isfailed=true;
					   model.addAttribute("message",message);
					   model.addAttribute("isfaild",isfailed);
					   					   
					   return "loginpage";
				   }
				   
				}
			}			
			else 
			{
				
				CustomerDetail customerDetail2=customerDetailsServiceImpl.getCustomerDetails(loginId);
				
				
				if(customerDetail2 !=null)
				{
					customerDetailsServiceImpl.updateLoginCount(loginId);
					
					int count=customerDetail2.getLoginAttempt();
					if(count>3)
					{
						message="You are blocked..! please contact to administrator";
					}
					else
					{
						message="Invalid password!!!attempts remaining "+(3-count);
					}				
					isfailed=true;
					model.addAttribute("message",message);
					model.addAttribute("isfaild",isfailed);
					return "loginpage";
				}
				
				message="Invalid password!!!";
				isfailed=true;
				model.addAttribute("message",message);
				model.addAttribute("isfaild",isfailed);
				return "loginpage";
				
				
			}
			
			
		}

		
		message= "INVALID LOGIN-ID !!!";
		isfailed=true;
		model.addAttribute("message",message);
		model.addAttribute("isfaild",isfailed);
		return "loginpage";
		
		
	}
	
	
	 @PostMapping("register")
		public String addNewCustomer(@ModelAttribute("customer") CustomerDetail customer,@RequestParam("accountType") String accountType) {
				
				Account acc=new Account();
				acc.setAccountType(accountType);
				acc.setBalance(0.0);
				acc.setOverdraftBalance(0.0);
				acc.setRateOfInterest(0.0);
				acc.setIsApproved("NA");
				
				LocalDate currDate=LocalDate.now();
						
				DateTimeFormatter formater=DateTimeFormatter.ofPattern("dd-MM-yy");
				String strDate=currDate.format(formater);
				
				
				
				acc.setAccountCreationDate(strDate);
				
				

				customer.getAccountList().add(acc);
				
				
			customerDetailsServiceImpl.addNewCustomer(customer);
			
			
			return "loginpage";
		}
	 
	
	
	
	 
	
	
	
	
}
