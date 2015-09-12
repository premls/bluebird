package com.bluebird.manager;

import com.bluebird.dto.RegisterDTO;
import com.bluebird.exception.ViewException;

public interface RegisterManager {

	void register(RegisterDTO registerDTO) throws ViewException;

	void verifyTrader(RegisterDTO registerDTO);

}
