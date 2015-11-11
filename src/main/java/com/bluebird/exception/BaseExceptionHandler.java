package com.bluebird.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.net.HttpHeaders;

@ControllerAdvice
public class BaseExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseExceptionHandler.class);
	private static final String GLOBAL_ERROR_MESSAGE ="We are sorry something isn't right"; 
	
	/***
	 * @author prem 
	 * @Desc This method acts as the global exception handler for all the uncaught exceptions thrown from
	 * any controller
	 * This will take the user to home page by just give's a generic error message
	 * 
	 * 
	 * */
	@ExceptionHandler({Exception.class})
	public ModelAndView ConnectionException(HttpServletRequest request,Exception e) {
		
		logThisError(request, e);
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("errorMsg", GLOBAL_ERROR_MESSAGE);
		modelView.setViewName("redirect:home");
		return modelView;
	}
	
	private void logThisError(HttpServletRequest request,Exception e) {
		LOGGER.error("Exception occured for this request referer url-{} || Requested url - {} || from ip - {} ||",  
				request.getHeader(HttpHeaders.REFERER),request.getRequestURL(),
				request.getRemoteAddr()+"-"+request.getHeader("X-FORWARDED-FOR"));
		LOGGER.error("",e);
	}
}
