package com.hames.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hames.bean.Task;

public class TaskValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Task.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Task task = (Task) target;
		
		if(task.getTaskOwner() == null || task.getTaskOwner().isEmpty()){
			errors.rejectValue("taskOwner", "ER002", "Task Owner Name Required");
		}
		
		if(task.getEventName() == null || task.getEventName().isEmpty()){
			errors.rejectValue("eventName", "", "Task Name Required");
		}
		
		if(task.getTaskDate()==null || task.getTaskDate().equals(null)){
			errors.rejectValue("taskDate", "", "Task Date Requires");
		}
		
		if(task.getSubject() == null || task.getSubject().isEmpty()){
			errors.rejectValue("subject", "", "Please Enter Subject For The Task");
		}
	}

}
