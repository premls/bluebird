package com.bluebird.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluebird.dto.TraderDTO;
import com.bluebird.services.TraderService;

@Controller
@RequestMapping("/traders")
public class TraderController {

	@Autowired
	private TraderService traderService;
	
	
	@RequestMapping(value = "/list" ,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TraderDTO> listTraders() {
		return traderService.listTraders();
	}
	
}
