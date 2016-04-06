package com.hames.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hames.bean.ProjectDetails;

public class ProjectDetailsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProjectDetails.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProjectDetails projectDetails = (ProjectDetails) target;
		
		if(projectDetails.getProjectName() == null || projectDetails.getProjectName().isEmpty()){
			errors.rejectValue("projectName", "", "Project Name Required");
		}
	}

}
