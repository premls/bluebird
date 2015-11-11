package com.bluebird.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void verifyLogin(String userName, String password) {
		
	}

}
