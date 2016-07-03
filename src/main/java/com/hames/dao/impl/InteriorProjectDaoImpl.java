package com.hames.dao.impl;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hames.bean.InteriorProject;
import com.hames.dao.InteriorProjectDao;
import com.hames.db.GenericDao;
import com.hames.db.HamesDataStore;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

/**
 * 
 * @author Raneef ibn ali nhelat
 *
 */

@Repository
public class InteriorProjectDaoImpl extends GenericDao implements InteriorProjectDao{

	private static final String COLLECTION_NAME = "interiorProject";
	
	@Autowired
	private HamesDataStore hamesDataStore;
	
	/**
	 * Function for creating collection in database
	 */
	@PostConstruct
	public void createCollection(){
		if(!hamesDataStore.collectionExists(COLLECTION_NAME)){
			hamesDataStore.createCollection(COLLECTION_NAME);
		}
	}
	
	/**
	 * Save function 
	 */
	@Override
	public void save(InteriorProject interiorProject) {
		if(!hamesDataStore.exists(interiorProject.getProjectId(), COLLECTION_NAME)){
			interiorProject.setProjectId(UUID.randomUUID().toString());
		}
		hamesDataStore.save(interiorProject, COLLECTION_NAME);
	}

	@Override
	public Class<?> getEntityClass() {

		return InteriorProject.class;
	}

	/**
	 * data table function for table values
	 */
	@Override
	public DatatableResponse buildDataTableResponse(DatatableRequest request) {
		request.setClazz(getEntityClass());
		request.setMongoCollectionName(COLLECTION_NAME);
		return hamesDataStore.getDatatablePagedResult(request);
	}
	
	/**
	 * To edit the details of the project
	 */
	@Override
	public InteriorProject findByProjectId(String projectId) {
		return (InteriorProject) hamesDataStore.findById(projectId, getEntityClass(), COLLECTION_NAME);
	}

	/**
	 * To find the count of the interior project
	 */
	@Override
	public Long interiorProjectCount() {
		return hamesDataStore.getCollection(COLLECTION_NAME).count();
	}
	
}
