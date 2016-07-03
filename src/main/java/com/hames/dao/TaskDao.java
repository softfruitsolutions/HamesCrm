package com.hames.dao;

import com.hames.bean.Task;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

public interface TaskDao {

	/**
	 * Save task
	 * @param task
	 */
	
	void save(Task task);
	
	/**
	 * Get Data Table
	 */
	DatatableResponse buildDatatable(DatatableRequest request);
	
	/**
	 * Find a task
	 */
	Task findByTaskId(String taskId);
	
	/**
	 * To find the count of the task
	 * @return
	 */
	Long findTaskCount();
}

