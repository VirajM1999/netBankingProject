package com.mindgate.main.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.FixDeposite;
import com.mindgate.main.service.AccountDetailServiceInterface;
import com.mindgate.main.service.FixDepositeService;

@RestController
@RequestMapping("customerrest")
public class FixDepositeRestController {
	
	@Autowired
	private FixDepositeService fixDepositeService;
	
	@Autowired
	private AccountDetailServiceInterface accountDetailServiceInterface;
	
	@PostMapping("insertfixDeposite")
	public ResponseEntity savefixDeposite(@RequestBody FixDeposite fixDeposite)
	{
		Account dbAccount=accountDetailServiceInterface.getAccountDetailsByAccountNumber(fixDeposite.getAccountNumber());
		if(dbAccount !=null)
		{
			boolean status=fixDepositeService.createNewFixDeposite(fixDeposite);
			if(status)
			{
				return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(status);
			}
			return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(status);
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Account does not exist");
		
	}
	
	@GetMapping("getAllFixDeposite/{accountId}")
	public ResponseEntity getAllFD(@PathVariable ("accountId") long accountId)
	{
		Account dbAccount=accountDetailServiceInterface.getAccountDetailsByAccountNumber(accountId);	
		
		if(dbAccount!=null)
		{
			List<FixDeposite> fixDeposites=fixDepositeService.getFixDepositeDetailsByAccountNumber(accountId);
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(fixDeposites);
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Account does not exist");
	}
	
	

}
