package com.hames.service;

import com.hames.bean.Task;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

public interface TaskService {

	/**
	 * 
	 * @author Raneef
	 * save Task
	 */
	public void saveTask(Task task);
	
	/**
	 * Get Datatable
	 */
	public DatatableResponse getDatatable(DatatableRequest request);
	
	/**
	 * Get a task
	 */
	public Task getTaskById(String taskId);
	
	/**
	 * Next taskLead id
	 */
	public String getNextLeadId();
	
	/**
	 * Next potential Id
	 */
	public String getNextPotId();
	
	public long getTaskCount();
}
