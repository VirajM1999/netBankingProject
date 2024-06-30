package com.mindgate.main.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Cheque;
import com.mindgate.main.service.ChequeService;

@RestController
@RequestMapping("customerrest")
public class ChequeRestController {
	
	@Autowired
	private ChequeService chequeService;
	
	@PostMapping("insertCheque")
	public ResponseEntity saveCheque(@RequestBody Cheque cheque)
	{
		if(chequeService.saveChequeDetails(cheque))
		{
			return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(true);
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(false);
		
	}
	@GetMapping("getallcheck")
	public ResponseEntity getAllCheques()
	{
		List<Cheque> cheques=chequeService.getAllCheques();
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(cheques);
	}
	
	@GetMapping("getallAcheques")
	public ResponseEntity getAllRecivedCheque(@RequestParam long accountNumber)
	{
		List<Cheque>cheques=chequeService.receivedChecks(accountNumber);
		
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(cheques);
	}
	
	@PutMapping("updateCheque")
	public ResponseEntity updateStatusForApprove(@RequestParam String chequeNumber, @RequestParam String status)
	
	{
		int result= chequeService.updateStatusForApprove(chequeNumber, status);
		
		if(result>0)
		{
			Cheque  cheque =chequeService.getChequeByChequeNo(chequeNumber);
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(cheque);
		}
		
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Failed to update cheque");
	}
	
	@GetMapping("getclearedcheque")
	public ResponseEntity getCelaredCheque(@RequestParam long accountNumber)
	{
		List<Cheque>cheques=chequeService.ChequesCleared(accountNumber);
		
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(cheques);
		
	}
	
	@GetMapping("getbounsedchque")
	public ResponseEntity getBouncedCheque(@RequestParam long accountNumber)
	{
		List<Cheque>cheques=chequeService.ChequesBounced(accountNumber);
		
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(cheques);
	}
	
	@GetMapping("getsentcheque")
	public ResponseEntity getSentcheque(@RequestParam long accountNumber)
	{
		List<Cheque>cheques=chequeService.sentChecks(accountNumber);
		
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(cheques);
	}
	
	

}
