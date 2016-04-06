package com.hames.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hames.bean.Potential;

public class PotentialValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Potential.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Potential potential = (Potential) target;
		
		if(potential.getPotentialName() == null || potential.getPotentialName().isEmpty()){
			errors.rejectValue("potentialName", "", "Potential Name Required");
		}
		
		if(potential.getDeliveryDate() == null ){
			errors.rejectValue("deliveryDate", "", "Delivery Date Required");
		}
		
		if(potential.getQuotedAmount() == null || potential.getQuotedAmount().isEmpty()){
			errors.rejectValue("quotedAmount", "", "Quoted Amount Required");
		}
		if(potential.getNegotiatedAmount() == null || potential.getNegotiatedAmount().isEmpty()){
			errors.rejectValue("negotiatedAmount", "", "Negotiated Amount Required");
		}
		
	}

}
