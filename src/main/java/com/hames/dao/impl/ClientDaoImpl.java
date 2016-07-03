package com.hames.dao.impl;


import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hames.bean.NewClient;
import com.hames.dao.ClientDao;
import com.hames.db.GenericDao;
import com.hames.db.HamesDataStore;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

@Repository
public class ClientDaoImpl extends GenericDao implements ClientDao{

	private static final String COLLECTION_NAME = "client";
	
	@Autowired
	private HamesDataStore hamesDataStore;
	
	@PostConstruct
	public void createCollectionClient(){
		if(!hamesDataStore.collectionExists(COLLECTION_NAME)){
			hamesDataStore.createCollection(COLLECTION_NAME);
		}
	}
	
	@Override
	public Class<?> getEntityClass() {
		return NewClient.class;
	}

	
	@Override
	public void save(NewClient newClient) {
		if(!hamesDataStore.exists(newClient.getLeadId(), COLLECTION_NAME)){
			newClient.setLeadId(UUID.randomUUID().toString());
		}
		hamesDataStore.save(newClient,COLLECTION_NAME);
	}

	@Override
	public DatatableResponse buildDatatableResponse(DatatableRequest request) {
		request.setClazz(getEntityClass());
		request.setMongoCollectionName(COLLECTION_NAME);
		return hamesDataStore.getDatatablePagedResult(request);
	}

	@Override
	public NewClient findByLeadId(String leadId) {
		return (NewClient) hamesDataStore.findById(leadId, getEntityClass(), COLLECTION_NAME);
	}

	@Override
	public Long findCustomerCount() {
		return hamesDataStore.getCollection(COLLECTION_NAME).count();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NewClient> findAllClient() {
		return (List<NewClient>) hamesDataStore.findAll(getEntityClass(), COLLECTION_NAME);
	}


	
}
