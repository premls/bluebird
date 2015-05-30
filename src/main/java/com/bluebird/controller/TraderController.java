package com.bluebird.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebird.dto.TraderDTO;
import com.bluebird.services.TraderService;

@RestController
@RequestMapping("/traders")
public class TraderController {

	@Autowired
	private TraderService traderService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public List<TraderDTO> listTraders() {
		return traderService.listTraders();
	}
	
}
