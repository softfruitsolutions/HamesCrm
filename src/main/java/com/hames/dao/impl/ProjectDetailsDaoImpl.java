package com.hames.dao.impl;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hames.bean.ProjectDetails;
import com.hames.dao.ProjectDetailsDao;
import com.hames.db.GenericDao;
import com.hames.db.HamesDataStore;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

@Repository
public class ProjectDetailsDaoImpl extends GenericDao implements ProjectDetailsDao{

	private static final String COLLECTION_NAME = "projectDetails";
	
	@Autowired
	private HamesDataStore hamesDataStore;
	
	@PostConstruct
	public void createCollection(){
		if(!hamesDataStore.collectionExists(COLLECTION_NAME)){
			hamesDataStore.createCollection(COLLECTION_NAME);
		}
	}
	
	@Override
	public void save(ProjectDetails projectDetails) {
		if(!hamesDataStore.exists(projectDetails.getProjectId(), COLLECTION_NAME)){
			projectDetails.setProjectId(UUID.randomUUID().toString());
		}
		hamesDataStore.save(projectDetails, COLLECTION_NAME);
	}

	@Override
	public Class<?> getEntityClass() {
		return ProjectDetails.class;
	}

	@Override
	public DatatableResponse buildDatatableResonse(DatatableRequest request) {
		request.setClazz(getEntityClass());
		request.setMongoCollectionName(COLLECTION_NAME);
		return hamesDataStore.getDatatablePagedResult(request);
	}

	@Override
	public ProjectDetails findByProjectId(String projectId) {
		return (ProjectDetails) hamesDataStore.findById(projectId, getEntityClass(), COLLECTION_NAME);
	}

	@Override
	public Long findProjectCount() {
		return hamesDataStore.getCollection(COLLECTION_NAME).count();
	}
	
	

}
