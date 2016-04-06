package com.hames.dao.impl;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hames.bean.Task;
import com.hames.dao.TaskDao;
import com.hames.db.GenericDao;
import com.hames.db.HamesDataStore;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

@Repository
public class TaskDaoImpl extends GenericDao implements TaskDao{

	private static final String COLLECTION_NAME = "task";
	
	public static final Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);
	
	@Autowired
	private HamesDataStore hamesDataStore;
	
	@PostConstruct
	public void CreateCollectionTask(){
		if(!hamesDataStore.collectionExists(COLLECTION_NAME)){
			hamesDataStore.createCollection(COLLECTION_NAME);
		}
	}
	
	@Override
	public void save(Task task) {

		if(!hamesDataStore.exists(task.getTaskId(), COLLECTION_NAME)){
			task.setTaskId(UUID.randomUUID().toString());
		}
		hamesDataStore.save(task, COLLECTION_NAME);
		logger.debug(task.getLeadName());
	}

	@Override
	public Class<?> getEntityClass() {
		return Task.class;
	}

	@Override
	public DatatableResponse buildDatatable(DatatableRequest request) {
		request.setClazz(getEntityClass());
		request.setMongoCollectionName(COLLECTION_NAME);
		return hamesDataStore.getDatatablePagedResult(request);
	}

	@Override
	public Task findByTaskId(String taskId) {
		return (Task) hamesDataStore.findById(taskId, getEntityClass(), COLLECTION_NAME);
	}

	
	
}
