package com.mindgate.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindgate.main.domain.BankSlip;
import com.mindgate.main.domain.Cheque;
import com.mindgate.main.service.BankSlipService;

import com.mindgate.main.service.ChequeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class BankSlipController {
	
	
	@Autowired
	private ChequeService chequeService;
	
	
	@Autowired
	private BankSlipService bankSlipService;
	
	@RequestMapping("/bankslip/{chequeNo}")
	public String bankslipForm(@PathVariable("chequeNo")String chequeNo,HttpSession session)
	{		
		session.setAttribute("cheque", chequeService.getChequeByChequeNo(chequeNo));
		
		return "bankslipform";
		
	}
	
	@PostMapping("/savebankslip")
	public String saveBankslipForm(@ModelAttribute("bankSlip") BankSlip bankSlip,HttpSession bankslipsession,Model model)
	{
		Cheque cheque= (Cheque) bankslipsession.getAttribute("cheque");
		model.addAttribute("cheque", cheque);
		long receiverAccountNo=cheque.getRecieverAccount().getAccountNumber();
		
		
		String status="sent For Clearence";
		
		
		bankSlip.setAccountNumber(cheque.getRecieverAccount());	
		bankSlip.setChequeNumber(cheque);	
		
		chequeService.updateStatusForApprove(cheque.getChequeNumber(),status);
		bankSlipService.saveBankSlipsDetails(bankSlip);
		
		return "redirect:receivedCheque/"+receiverAccountNo;
		
		
	}

}
