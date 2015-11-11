package com.bluebird.manager;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebird.dto.TraderDTO;
import com.bluebird.entity.TraderEntity;
import com.bluebird.repository.TraderRepository;

@Service
public class TraderManagerImpl implements TraderManager {

	@Autowired
	private TraderRepository traderRepository;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	public List<TraderDTO> listTraders() {
		List<TraderDTO> traderDTOs = null;
		try {
			List<TraderEntity> allTraders = traderRepository.findAll();
			traderDTOs = new ArrayList<TraderDTO>(allTraders.size());

			for(int index = 0 ; index < allTraders.size() ; index++){
				TraderDTO traderDTO = new TraderDTO();
				BeanUtils.copyProperties(allTraders.get(index), traderDTO);
				traderDTOs.add(traderDTO);
			}
			
		} catch (Exception e) {
			logger.error("Exception occurred while fetching traders ", e);
		}
		return traderDTOs;
	}

}
