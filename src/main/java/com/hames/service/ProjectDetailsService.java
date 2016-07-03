package com.hames.service;

import com.hames.bean.ProjectDetails;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

/**
 * 
 * @author raneef ibn ali nhelat
 *
 */
public interface ProjectDetailsService {
	
	/**
	 *save project details
	 * @param projectDetails
	 */
	public void saveProjectDetails(ProjectDetails projectDetails);

	/**
	 * get datatable
	 */
	public DatatableResponse getDatatable(DatatableRequest request);
	
	/**
	 * To find project Details through ID
	 * @param projectId
	 * @return
	 */
	public ProjectDetails getProjectId(String projectId);
	
	/**
	 * To get the count of total project
	 * @return
	 */
	public long getProjectCount();
}
