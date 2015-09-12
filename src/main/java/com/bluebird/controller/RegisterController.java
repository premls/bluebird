package com.bluebird.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluebird.dto.RegisterDTO;
import com.bluebird.exception.ViewException;
import com.bluebird.services.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(RegisterDTO registerDTO) throws ViewException {
		registerService.register(registerDTO);
	}
	
	@RequestMapping(value = "/verifytrader", method = RequestMethod.POST)
	public void verifyTrader(RegisterDTO registerDTO, HttpServletRequest request) {
		// TODO : session validation 
		registerService.verifyTrader(registerDTO);
	}
}
