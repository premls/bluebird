package com.bluebird.services;

import com.bluebird.controller.io.RegisterResponse;
import com.bluebird.dto.RegisterDTO;

public interface RegisterService {

	RegisterResponse register(RegisterDTO registerDTO);

	void verifyTrader(RegisterDTO registerDTO);
}
