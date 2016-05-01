package com.hames.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import com.hames.bean.Staff;
import com.hames.bean.Task;
import com.hames.dao.TaskDao;
import com.hames.db.HamesDataStore;
import com.hames.db.Sequence;
import com.hames.db.SequenceDao;
import com.hames.exception.ValidationException;
import com.hames.service.GenericService;
import com.hames.service.StaffService;
import com.hames.service.TaskService;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;
import com.hames.validator.TaskValidator;

@Service
public class TaskServiceImpl extends GenericService implements TaskService{

	private static final Logger Logger = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Autowired
	private StaffService staffService;
	@Autowired
	public TaskDao taskdao;
	@Autowired
	public HamesDataStore hamesDataStore;
	@Autowired
	public SequenceDao sequenceDao;

	@Override
	public Validator getValidator() {
		return new TaskValidator();
	}

	@Override
	public Class<?> getEntityClass() {
		return Task.class;
	}

	@Override
	public void saveTask(Task task) {

		try{
			validate(task);
		}catch(ValidationException e) {
			throw new ValidationException(e.getMessage());
		}
		
		task.setLeadId(getNextLeadId());
		sequenceDao.updateSequence(Sequence.TASK_LEAD_SEQUENCE);
		
		task.setPotId(getNextPotId());
		sequenceDao.updateSequence(Sequence.TASK_POTENTIAL_SEQUENCE);

		Logger.debug("Saving Entity : {},{}",getEntityClass(),task.toString());
		taskdao.save(task);
		Logger.debug("Data saved successfully");
	}

	@Override
	public DatatableResponse getDatatable(DatatableRequest request) {
		DatatableResponse response = taskdao.buildDatatable(request);
		for (Object obj : response.getAaData()) {
			Task task = (Task) obj;
			Staff staff = staffService.getStaffById(task.getTaskOwner());
			if(staff != null){
				task.setTaskOwnerText(staff.getFullName());
			}
		}
		return response;
	}


	@Override
	public String getNextLeadId() {
		Long sequenceId = sequenceDao.findNextSequenceId(Sequence.TASK_LEAD_SEQUENCE);
		return "L"+sequenceId;
	}

	@Override
	public Task getTaskById(String taskId) {
		return taskdao.findByTaskId(taskId);
	}

	@Override
	public String getNextPotId() {
		Long sequenceId = sequenceDao.findNextSequenceId(Sequence.TASK_POTENTIAL_SEQUENCE);
		return "L"+sequenceId;
	}

}