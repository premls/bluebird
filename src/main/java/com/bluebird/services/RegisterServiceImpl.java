package com.bluebird.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebird.controller.io.RegisterResponse;
import com.bluebird.dto.RegisterDTO;
import com.bluebird.manager.RegisterManager;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterManager registerManager;
	
	public RegisterResponse register(RegisterDTO registerDTO) {
		return registerManager.register(registerDTO);
	}

	public void verifyTrader(RegisterDTO registerDTO) {
		registerManager.verifyTrader(registerDTO);
	}
}
