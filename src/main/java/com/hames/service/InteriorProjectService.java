package com.hames.service;

import com.hames.bean.InteriorProject;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

/**
 * 
 * @author Raneef ibn ali nhelat
 *
 */

public interface InteriorProjectService {

	/**saving the details of interior project
	 * @param interiorProject
	 */
	public void saveProjectDetails(InteriorProject interiorProject);
	
	/**
	 * To get the data from the database
	 * @param request
	 * @return
	 */
	public DatatableResponse getDatatable(DatatableRequest request);
	
	/**
	 * To edit the project details which find by project id
	 * @param projectId
	 * @return
	 */
	public InteriorProject getProjectId(String projectId);
	
	public long getProjectCount();
}
