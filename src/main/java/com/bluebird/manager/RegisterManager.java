package com.bluebird.manager;

import com.bluebird.controller.io.RegisterResponse;
import com.bluebird.dto.RegisterDTO;

public interface RegisterManager {

	RegisterResponse register(RegisterDTO registerDTO);

	void verifyTrader(RegisterDTO registerDTO);

}
