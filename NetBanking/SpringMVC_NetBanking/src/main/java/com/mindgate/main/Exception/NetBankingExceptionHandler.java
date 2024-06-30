package com.mindgate.main.Exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class NetBankingExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView AnyOtherHandler(Exception exception)
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("err","Exception::"+exception.getMessage()+"");
		modelAndView.setViewName("error");
		
		return modelAndView;
	}
	
	

}
