package com.hames.dao;

import com.hames.bean.ProjectDetails;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

public interface ProjectDetailsDao {

	/**
	 * save project details
	 */
	void save(ProjectDetails projectDetails);
	
	/**
	 * get Datatable
	 */
	DatatableResponse buildDatatableResonse(DatatableRequest request);
	
	/**
	 * To get the project details for editing
	 * @param projectId
	 * @return
	 */
	ProjectDetails findByProjectId(String projectId);
	
	Long findProjectCount();
}
