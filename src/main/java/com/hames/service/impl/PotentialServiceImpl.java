package com.hames.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import com.hames.bean.Potential;
import com.hames.dao.PotentialDao;
import com.hames.exception.ValidationException;
import com.hames.service.GenericService;
import com.hames.service.PotentialService;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;
import com.hames.validator.PotentialValidator;

@Service
public class PotentialServiceImpl extends GenericService implements PotentialService{

	private static final Logger logger = LoggerFactory.getLogger(PotentialServiceImpl.class);
	
	@Autowired
	public PotentialDao potentialDao;
	
	@Override
	public void savePotential(Potential potential) {
		
		try{
			validate(potential);
		}catch(ValidationException e){
			throw new ValidationException(e.getMessage());
		}
		
		logger.debug("Saving Entity : {},{}",getEntityClass(),potential.toString());
		potentialDao.save(potential);
		logger.debug("Values Saves successfully");
	}

	@Override
	public Validator getValidator() {
		return new PotentialValidator();
	}

	@Override
	public Class<?> getEntityClass() {
		return Potential.class;
	}

	@Override
	public DatatableResponse getDatatable(DatatableRequest request) {
		return potentialDao.buildDatatable(request);
	}

	@Override
	public List<Potential> getAllPotential() {
		return potentialDao.findAllPotential();
	}

	@Override
	public Potential getPotentialById(String potentialId) {
		return potentialDao.findByPotentialId(potentialId);
	}

	@Override
	public long getPotentialCount() {
		return potentialDao.findPotentialCount();
	}

}
