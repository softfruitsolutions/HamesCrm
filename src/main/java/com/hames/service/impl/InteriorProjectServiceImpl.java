package com.hames.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Validator;

import com.hames.bean.InteriorProject;
import com.hames.dao.InteriorProjectDao;
import com.hames.exception.ValidationException;
import com.hames.service.GenericService;
import com.hames.service.InteriorProjectService;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;
import com.hames.validator.InteriorValidator;

/**
 * 
 * @author Raneef ibn ali nhelat
 *
 */
@Repository
public class InteriorProjectServiceImpl extends GenericService implements InteriorProjectService{

	private static final Logger logger = LoggerFactory.getLogger(InteriorProjectServiceImpl.class);
	
	@Autowired
	private InteriorProjectDao interiorProjectDao;
	
	@Override
	public Validator getValidator() {
		return new InteriorValidator();
	}

	@Override
	public Class<?> getEntityClass() {
		return InteriorProject.class;
	}
	
	/**
	 * Save function for the details of the project
	 */
	@Override
	public void saveProjectDetails(InteriorProject interiorProject) {
		 try{
			 validate(interiorProject);
		 }catch(ValidationException e){
			 throw new ValidationException(e.getMessage());
		 }
		 
		 logger.debug("Saving Entity : {},{}",getEntityClass(),interiorProject.toString());
		 interiorProjectDao.save(interiorProject);
		 logger.debug("Values Saved Successfully");
	}
	
	/**
	 * function for taking the value from the database
	 */
	@Override
	public DatatableResponse getDatatable(DatatableRequest request) {
		return interiorProjectDao.buildDataTableResponse(request);
	}

	/**
	 * Function for editing the values by id
	 */
	@Override
	public InteriorProject getProjectId(String projectId) {
		return interiorProjectDao.findByProjectId(projectId);
	}

	@Override
	public long getProjectCount() {
		return interiorProjectDao.interiorProjectCount();
	}

}
