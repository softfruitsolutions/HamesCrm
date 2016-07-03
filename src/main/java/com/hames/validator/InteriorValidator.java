package com.hames.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hames.bean.InteriorProject;

public class InteriorValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return InteriorProject.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		InteriorProject interiorProject = (InteriorProject) target;
		
		if(interiorProject.getProjectName() == null || interiorProject.getProjectName().isEmpty()){
			errors.rejectValue("projectName", "", "Project Name Required");
		}
		if(interiorProject.getAdvanceAmount() == null || interiorProject.getAdvanceAmount().isEmpty() ){
			errors.rejectValue("advanceAmount", "", "Didn't Pay the advance amount");
		}
	}

	
}
