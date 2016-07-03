package com.hames.dao;

import com.hames.bean.InteriorProject;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

/**
 * 
 * @author Raneef ibn ali nhelat
 *
 */

public interface InteriorProjectDao {
	
	/**
	 * 
	 * function to save Details of interior project
	 */
	
	void save(InteriorProject interiorProject);
	
	/**
	 * Get the table values
	 * @param request
	 * @return
	 */
	DatatableResponse buildDataTableResponse(DatatableRequest request);
	
	/**
	 * To get the details of the project for editing purpose
	 * @param projectId
	 * @return
	 */
	InteriorProject findByProjectId(String projectId);
	
	/**
	 * To find the count of interior project
	 * @return
	 */
	Long interiorProjectCount();
}
