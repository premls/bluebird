package com.bluebird.controller.io;

import java.util.List;

import com.bluebird.dto.TraderDTO;

public class TraderListResponse extends BaseResponse {

	private List<TraderDTO> traderlist;

	public List<TraderDTO> getTraderlist() {
		return traderlist;
	}

	public void setTraderlist(List<TraderDTO> traderlist) {
		this.traderlist = traderlist;
	}
	
	
}
