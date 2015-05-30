package com.bluebird.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebird.dto.TraderDTO;
import com.bluebird.manager.TraderManager;

@Service
public class TraderServiceImpl implements TraderService {

	@Autowired
	private TraderManager traderManager;
	
	public List<TraderDTO> listTraders() {
		return traderManager.listTraders();
	}

	
}
