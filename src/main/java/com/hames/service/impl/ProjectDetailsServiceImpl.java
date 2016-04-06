package com.hames.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Validator;

import com.hames.bean.ProjectDetails;
import com.hames.dao.ProjectDetailsDao;
import com.hames.exception.ValidationException;
import com.hames.service.GenericService;
import com.hames.service.ProjectDetailsService;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;
import com.hames.validator.ProjectDetailsValidator;

@Repository
public class ProjectDetailsServiceImpl extends GenericService implements ProjectDetailsService{

	private static final Logger logger = LoggerFactory.getLogger(ProjectDetailsServiceImpl.class);
	
	@Autowired
	private ProjectDetailsDao projectDetailsDao;
	
	@Override
	public Validator getValidator() {
		return new ProjectDetailsValidator();
	}
	
	@Override
	public void saveProjectDetails(ProjectDetails projectDetails) {
		
		try{
			validate(projectDetails);
		}catch(ValidationException e){
			throw new ValidationException(e.getMessage());
		}
		
		logger.debug("Saving Entity : {},{}",getEntityClass(),projectDetails.toString());
		projectDetailsDao.save(projectDetails);
		logger.debug("Values saved Successfully");
	}


	@Override
	public Class<?> getEntityClass() {
		return ProjectDetails.class;
	}

	@Override
	public DatatableResponse getDatatable(DatatableRequest request) {
		return projectDetailsDao.buildDatatableResonse(request);
	}

	@Override
	public ProjectDetails getProjectId(String projectId) {
		return projectDetailsDao.findByProjectId(projectId);
	}

	@Override
	public long getProjectCount() {
		return projectDetailsDao.findProjectCount();
	}

}
