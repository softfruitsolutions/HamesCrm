package com.hames.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hames.bean.NewLead;

public class LeadValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return NewLead.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		NewLead newLead	= (NewLead) obj;
		
		if(newLead.getFirstName() == null || newLead.getFirstName().isEmpty()){
			errors.rejectValue("firstName", "", "First Name Required");
		}
		if(newLead.getLastName() == null || newLead.getLastName().isEmpty()){
			errors.rejectValue("lastName", "", "Last Name Required");
		}
		if(newLead.getLeadSource()==null || newLead.getLeadSource().isEmpty()){
			errors.rejectValue("Lead Source", "", "Lead Source Required");
		}
		if(newLead.getMobileNo() == null || newLead.getMobileNo().isEmpty()){
			errors.rejectValue("mobileNo", "", "Mobile Number Required");
		}
		if(newLead.getAddress() == null || newLead.getAddress().isEmpty()){
			errors.rejectValue("address", "" , "Address Required");
		}
	}

}
