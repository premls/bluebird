package com.bluebird.services;

import com.bluebird.dto.RegisterDTO;
import com.bluebird.exception.ViewException;

public interface RegisterService {

	void register(RegisterDTO registerDTO) throws ViewException;

	void verifyTrader(RegisterDTO registerDTO);
}
