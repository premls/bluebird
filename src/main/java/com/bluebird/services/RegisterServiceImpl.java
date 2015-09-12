package com.bluebird.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebird.dto.RegisterDTO;
import com.bluebird.exception.ViewException;
import com.bluebird.manager.RegisterManager;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterManager registerManager;
	
	public void register(RegisterDTO registerDTO) throws ViewException {
		registerManager.register(registerDTO);
	}

	public void verifyTrader(RegisterDTO registerDTO) {
		registerManager.verifyTrader(registerDTO);
	}
}
