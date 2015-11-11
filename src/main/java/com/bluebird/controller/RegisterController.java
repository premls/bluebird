package com.bluebird.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluebird.controller.io.RegisterResponse;
import com.bluebird.dto.RegisterDTO;
import com.bluebird.exception.ViewException;
import com.bluebird.services.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public RegisterResponse register(@ModelAttribute RegisterDTO registerDTO) throws ViewException {
		return registerService.register(registerDTO);
	}
	
	@RequestMapping(value = "/verifytrader", method = RequestMethod.POST)
	public void verifyTrader(@ModelAttribute RegisterDTO registerDTO, HttpServletRequest request) {
		// TODO : session validation 
		registerService.verifyTrader(registerDTO);
	}
}
