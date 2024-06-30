package com.mindgate.main.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.CustomerDetail;
import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.service.AccountDetailServiceInterface;
import com.mindgate.main.service.CustomerDetailsService;
import com.mindgate.main.service.LoginDetailsServiceImpl;

@RestController
@RequestMapping("customerrest")
public class CustomerRestController {
	@Autowired
	AccountDetailServiceInterface accountDetailServiceInterface;

	@Autowired
	CustomerDetailsService customerDetailsServiceImpl;

	@Autowired
	private LoginDetailsServiceImpl loginDetailsServiceImpl;

	@GetMapping("login")
	public ResponseEntity getLoginDetailsObject(@RequestParam("loginId") String loginId,@RequestParam("password") String password) {
		if (loginDetailsServiceImpl.checkId(loginId)) {
			LoginDetails loginDetails = loginDetailsServiceImpl.checkCredentials(loginId, password);
			if (loginDetails != null) {
				if (loginDetails.getRole().equalsIgnoreCase("admin")) {

					return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(loginDetails);
				} else {
					CustomerDetail customerDetail = customerDetailsServiceImpl.getCustomerDetails(loginId);
					customerDetail.setLoginDetails(loginDetails);
					if (customerDetail.getLoginAttempt() < 4) {
						List<Account> accounts = accountDetailServiceInterface
								.getAccountDetailsById(customerDetail.getCustomerId());
						for (Account account : accounts) {
							if (account.getIsApproved().equals("A")) {
								customerDetail.getAccountList().add(account);
							}
						}

						if (customerDetail.getAccountList().size() == 0) {

							return ResponseEntity.status(HttpStatusCode.valueOf(401))
									.body("Your Account Approval is pending!!!");

						}
					} else {
						return ResponseEntity.status(HttpStatusCode.valueOf(401))
								.body("You are blocked..! please contact to administrator");

					}

					return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(customerDetail);
				}

			}

			else {

				CustomerDetail customerDetail2 = customerDetailsServiceImpl.getCustomerDetails(loginId);

				if (customerDetail2 != null) {
					customerDetailsServiceImpl.updateLoginCount(loginId);

					int count = customerDetail2.getLoginAttempt();
					if (count > 3) {
						return ResponseEntity.status(HttpStatusCode.valueOf(401))
								.body("You are blocked..! please contact to administrator");
					} else {

						return ResponseEntity.status(HttpStatusCode.valueOf(401))
								.body("Invalid password!!!attempts remaining " + (3 - count));
					}

				}
			}
		}
			return ResponseEntity.status(HttpStatusCode.valueOf(401)).body("Wrong UserId or Password");
		
	}
	
	@GetMapping("getcustomerdetails")
	public ResponseEntity getCustomerDetail(@RequestParam String loginId)
	{
		CustomerDetail customerDetail=customerDetailsServiceImpl.getCustomerDetails(loginId);
		if(customerDetail!=null)
		{
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(customerDetail);
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(null);
	}
	



	@GetMapping("upadtebalance")
	public Account updateBalance(@RequestParam int amount, @RequestParam long accountNumber) {
		int result = accountDetailServiceInterface.updateBalance(amount, accountNumber);
		if (result > 0) {
			return accountDetailServiceInterface.getAccountDetailsByAccountNumber(accountNumber);
		}
		return null;
	}

	@PostMapping("register")
	public ResponseEntity addNewCustomer(@RequestBody CustomerDetail customer,@RequestParam String accountType) {
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
		CustomerDetail insertedCustomerDetail =customerDetailsServiceImpl.addNewCustomer(customer);
		if(insertedCustomerDetail==null)
		{
			return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("failed to register");
			
		}
		

		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(insertedCustomerDetail);
	}
	
	

}
