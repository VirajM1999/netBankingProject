package com.mindgate.main.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.BankSlip;
import com.mindgate.main.service.BankSlipService;

 


@RestController
@RequestMapping("customerrest")
public class BankSlipRestController {
	@Autowired
	BankSlipService bankSlipService;
	
	@PostMapping("savebankslip")
	public ResponseEntity saveBankSlip(@RequestBody BankSlip bankSlip)
	{
		if(bankSlipService.saveBankSlipsDetails(bankSlip))
		{
			return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(true);
		}
		
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(false);
	}

}
