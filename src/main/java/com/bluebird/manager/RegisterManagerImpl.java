package com.bluebird.manager;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebird.dto.RegisterDTO;
import com.bluebird.entity.CustomerPreSignupEntity;
import com.bluebird.entity.TraderPreSignupEntity;
import com.bluebird.exception.ViewException;
import com.bluebird.repository.CustomerPreSignupRepository;
import com.bluebird.repository.TraderPreSignupRepository;
import com.bluebird.util.DateUtil;
import com.bluebird.util.StatusAndError;
import com.bluebird.util.UserType;

@Service
public class RegisterManagerImpl implements RegisterManager {

	@Autowired
	private CustomerPreSignupRepository customerPreSignupRepository;
	
	@Autowired
	private TraderPreSignupRepository traderPreSignupRepository;
	
	public void register(RegisterDTO registerDTO) throws ViewException {

		if(StringUtils.isEmpty(registerDTO.getEmail())) {
			throw new ViewException(StatusAndError.EMAIL_MANDATORY);
		}
		
		if(registerDTO.getUserType() == UserType.CUSTOMER.getId()){
			customerRegister(registerDTO);
		} else if (registerDTO.getUserType() == UserType.TRADER.getId()) {
			traderRegister(registerDTO);
		}
	}
	
	private void customerRegister(RegisterDTO registerDTO) {
		CustomerPreSignupEntity customerPreSignup = new CustomerPreSignupEntity();
		customerPreSignup.setEmail(registerDTO.getEmail());
		customerPreSignupRepository.save(customerPreSignup);
		
		// TODO : Send mail to customer for verification
	}

	private void traderRegister(RegisterDTO registerDTO) {
		
		// TODO Validate mandatory data
		TraderPreSignupEntity traderPreSignupEntity = new TraderPreSignupEntity();
		traderPreSignupEntity.setEmail(registerDTO.getEmail());
		traderPreSignupEntity.setName(registerDTO.getName());
		traderPreSignupEntity.setDirectorName(registerDTO.getDirectorName());
		traderPreSignupEntity.setCompanyRegisterNumber(registerDTO.getCompanyRegisterNumber());
		traderPreSignupEntity.setCompanyVatNumber(registerDTO.getCompanyVatNumber());
		traderPreSignupEntity.setContactPerson(registerDTO.getContactPerson());
		traderPreSignupEntity.setTelephone1(registerDTO.getTelephone1());
		traderPreSignupEntity.setTelephone2(registerDTO.getTelephone2());
		traderPreSignupEntity.setTelephone3(registerDTO.getTelephone3());
		traderPreSignupEntity.setMobile(registerDTO.getMobile());
		traderPreSignupEntity.setWebsiteUrl(registerDTO.getWebsiteUrl());
		traderPreSignupEntity.setFbUrl(registerDTO.getFbUrl());
		traderPreSignupEntity.setTwitterUrl(registerDTO.getTwitterUrl());
		traderPreSignupEntity.setCreatedAt(DateUtil.getCurrentDate());
		traderPreSignupRepository.save(traderPreSignupEntity);
		
		
	}

	public void verifyTrader(RegisterDTO registerDTO) {
//		traderPreSignupRepository.findBy(registerDTO.get)
		
	}

}
