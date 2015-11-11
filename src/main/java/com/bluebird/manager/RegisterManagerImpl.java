package com.bluebird.manager;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebird.controller.io.RegisterResponse;
import com.bluebird.dto.RegisterDTO;
import com.bluebird.entity.CustomerPreSignupEntity;
import com.bluebird.entity.TraderPreSignupEntity;
import com.bluebird.exception.InvalidRequestException;
import com.bluebird.repository.CustomerPreSignupRepository;
import com.bluebird.repository.TraderPreSignupRepository;
import com.bluebird.services.EmailService;
import com.bluebird.services.MailerServiceImpl;
import com.bluebird.util.DateUtil;
import com.bluebird.util.StatusAndError;
import com.bluebird.util.UserType;

@Service
public class RegisterManagerImpl implements RegisterManager {

	private static final Logger logger = LoggerFactory.getLogger(RegisterManagerImpl.class);
	@Autowired
	private CustomerPreSignupRepository customerPreSignupRepository;
	
	@Autowired
	private TraderPreSignupRepository traderPreSignupRepository;
	
	public RegisterResponse register(RegisterDTO registerDTO) {
		
		RegisterResponse registerResponse = new RegisterResponse();
		try{
			validate(registerDTO);

			if(registerDTO.getUserType() == UserType.CUSTOMER.getId()) {
				customerRegister(registerDTO);
			} else if (registerDTO.getUserType() == UserType.TRADER.getId()) {
				traderRegister(registerDTO);
			}
			
			registerResponse.setResponseStatus(StatusAndError.SUCCESS);
		} catch (InvalidRequestException e) {
			registerResponse.setResponseStatus(e.getError());
			logger.error(registerDTO.toString(),e.getMessage());
		} catch (Exception e) {
			// TODO handle mail failure exception , what needs to be done for customer
			registerResponse.setResponseStatus(StatusAndError.REGISTRATION_FAILED);
			logger.error(registerDTO.toString(),e);
		}
		return registerResponse;
	}
	
	private void validate(RegisterDTO registerDTO) throws InvalidRequestException {
		// TODO server side validation
		if(StringUtils.isEmpty(registerDTO.getEmail())) {
			throw new InvalidRequestException(StatusAndError.EMAIL_MANDATORY);
		}
		
	}

	private void customerRegister(RegisterDTO registerDTO) throws Exception {
		CustomerPreSignupEntity customerPreSignup = new CustomerPreSignupEntity();
		customerPreSignup.setTitle(registerDTO.getTitle());
		customerPreSignup.setFirstName(registerDTO.getFirstName());
		customerPreSignup.setLastName(registerDTO.getLastName());
		//TODO encrypt pwd
		customerPreSignup.setPassword(registerDTO.getPassword());
		customerPreSignup.setEmail(registerDTO.getEmail());
		customerPreSignup.setMobile(registerDTO.getMobile());
		customerPreSignup.setCreatedAt(DateUtil.getCurrentDate());
		customerPreSignupRepository.save(customerPreSignup);
		
		// TODO : Send mail to customer for verification
		EmailService emailService = new MailerServiceImpl();
		emailService.sendVerificationMail(registerDTO);
		
	}

	private void traderRegister(RegisterDTO registerDTO) {
		

		TraderPreSignupEntity traderPreSignupEntity = new TraderPreSignupEntity();
		traderPreSignupEntity.setTitle(registerDTO.getTitle());
		traderPreSignupEntity.setFirstName(registerDTO.getFirstName());
		traderPreSignupEntity.setLastName(registerDTO.getLastName());
		traderPreSignupEntity.setEmail(registerDTO.getEmail());
		//TODO encrypt pwd
		traderPreSignupEntity.setPassword(registerDTO.getPassword());
		traderPreSignupEntity.setMobile(registerDTO.getMobile());
		traderPreSignupEntity.setExpertise(registerDTO.getExpertise());
		traderPreSignupEntity.setCreatedAt(DateUtil.getCurrentDate());
		traderPreSignupRepository.save(traderPreSignupEntity);
		
		
	}

	public void verifyTrader(RegisterDTO registerDTO) {
//		traderPreSignupRepository.findBy(registerDTO.get)
		
	}

}
