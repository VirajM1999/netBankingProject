package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Cheque;
import com.mindgate.main.service.AccountDetailServiceInterface;
import com.mindgate.main.service.ChequeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class ChequeController {
	
	@Autowired
	private ChequeService chequeService;
	@Autowired
	private AccountDetailServiceInterface accountDetailsService;
	
	
//	@RequestMapping("receivedCheque")
//	public String showReceivedCheq() {
//		return 
//	}
//	
	
	
	
	
	@RequestMapping("receivedCheque/{receiverAccountNo}")
	public String receivedCheqList(@PathVariable("receiverAccountNo") Long receiverAccountNo,Model model) {
		
		List<Cheque> receivedCheques=chequeService.receivedChecks(receiverAccountNo);
		List<Cheque> bouncedCheqs=chequeService.ChequesBounced(receiverAccountNo);
		List<Cheque> ClearedCheqs=chequeService.ChequesCleared(receiverAccountNo);
		
		
		model.addAttribute("receivedChecks", receivedCheques);
		model.addAttribute("bouncedCheqs", bouncedCheqs);
		model.addAttribute("ClearedCheqs", ClearedCheqs);
		
		
		return "chequeListForm";
		
	}
	
	@RequestMapping("sentCheque/{accountNo}")
	public String sentCheqList(@PathVariable("accountNo") Long accountNo,Model model) {
		
		List<Cheque> sentCheques=chequeService.sentChecks(accountNo);
		
		System.err.println(sentCheques);
		
		model.addAttribute("sentCheques", sentCheques);
		
		
		
		return "sentchequepage";
		
	}
	 
	@RequestMapping("insert")
    public String insertCheque(@ModelAttribute("cheque")Cheque cheque,@RequestParam("recieverAccountNumber")String recieverAccountNumber,@RequestParam("senderAccountNumber") String senderAccountNumber,Model model,RedirectAttributes redirect)
    {
        String message=null;
        boolean status=false;
        System.err.print(cheque);
        System.err.print(recieverAccountNumber);
        System.err.print(senderAccountNumber);
        long recieverAccNo = Long.parseLong(recieverAccountNumber);
        long senderrAccNo = Long.parseLong(senderAccountNumber);
//        System.out.print(recieverAccNo);
//        System.out.print(senderrAccNo);
        Account recieverAccount=accountDetailsService.getAccountDetailsByAccountNumber(recieverAccNo);
        Account senderAccount=accountDetailsService.getAccountDetailsByAccountNumber(senderrAccNo);
        if(recieverAccount==null)
        {
            message="This Account Number does not exists.";
            status=true;
            redirect.addFlashAttribute("messageError", message);
            
            redirect.addFlashAttribute("statusFor", status);
            return "redirect:/customer/chequeForm";
        }
        cheque.setRecieverAccount(recieverAccount);
        cheque.setSenderAccount(senderAccount);
        cheque.setStatus("Not Received");
        chequeService.saveChequeDetails(cheque);
        
        return "redirect:/customer/home";
    }
	
	@RequestMapping("updateCheque/{chequeNumber}")
    public String updateChequeStatus(@PathVariable("chequeNumber") String chequeNumber,HttpSession session)
    {
        
        boolean updateChequeIfBounced = chequeService.updateChequeIfBounced(chequeNumber);
        Cheque cheque=chequeService.getChequeByChequeNo(chequeNumber);
        long recieverAccountNumber=cheque.getRecieverAccount().getAccountNumber();
        return "redirect:/customer/receivedCheque/"+recieverAccountNumber;
    }
	
	@RequestMapping("chequeForm")
    public String displayCheque()
    {
        return "insertcheque";
    }

}
