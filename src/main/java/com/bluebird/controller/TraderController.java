package com.bluebird.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluebird.controller.io.TraderListResponse;
import com.bluebird.dto.TraderDTO;
import com.bluebird.services.TraderService;
import com.bluebird.util.StatusAndError;

@Controller
@RequestMapping("/traders")
public class TraderController {

	@Autowired
	private TraderService traderService;
	
	
	@RequestMapping(value = "/list" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public TraderListResponse listTraders() {
		List<TraderDTO> traderList = traderService.listTraders();
		TraderListResponse traderListResponse = new TraderListResponse();
		if (traderList == null || traderList.isEmpty()) {
			traderListResponse.setResponseStatus(StatusAndError.TRADERS_NOT_AVAILABLE);
			return traderListResponse;
		}
		traderListResponse.setTraderlist(traderList);
		traderListResponse.setResponseStatus(StatusAndError.SUCCESS);
		return traderListResponse;
	}
	
}
