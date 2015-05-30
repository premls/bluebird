package com.bluebird.manager;

import java.util.List;

import com.bluebird.dto.TraderDTO;

public interface TraderManager {

	/**
	 * This method List all traders.
	 *
	 * @return the list
	 */
	List<TraderDTO> listTraders();

}
