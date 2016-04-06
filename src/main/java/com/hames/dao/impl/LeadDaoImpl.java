package com.hames.dao.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hames.bean.NewLead;
import com.hames.dao.LeadDao;
import com.hames.db.GenericDao;
import com.hames.db.HamesDataStore;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

@Repository
public class LeadDaoImpl extends GenericDao implements LeadDao {

	private static final String COLLECTION_NAME = "lead";
	
	@Autowired
	private HamesDataStore hamesDataStore;
	
	@PostConstruct
	public void CreateCollectionLead(){
		if(!hamesDataStore.collectionExists(COLLECTION_NAME)){
			hamesDataStore.createCollection(COLLECTION_NAME);
		}
	}
	
	@Override
	public Class<?> getEntityClass() {
		return NewLead.class;
	}
	
	@Override
	public void save(NewLead newLead) {
		if(!hamesDataStore.exists(newLead.getLeadId(),COLLECTION_NAME)){
			newLead.setLeadId(UUID.randomUUID().toString());
		}
		hamesDataStore.save(newLead, COLLECTION_NAME);
	}

	@Override
	public DatatableResponse buildDatatableResponse(DatatableRequest request) {

		request.setClazz(getEntityClass());
		request.setMongoCollectionName(COLLECTION_NAME);
		return hamesDataStore.getDatatablePagedResult(request);
	}

	@Override
	public boolean isLeadNoExists(String leadNo) {
		Query query = new Query();
		query.addCriteria(Criteria.where("leadNo").is(leadNo));
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NewLead> findAllLead() {
		return (List<NewLead>) hamesDataStore.findAll(getEntityClass(), COLLECTION_NAME);
	}

	@Override
	public NewLead findByLeadId(String leadId) {
		return (NewLead) hamesDataStore.findById(leadId, getEntityClass(), COLLECTION_NAME);
	}

	@Override
	public Long findLeadCount() {
		return hamesDataStore.getCollection(COLLECTION_NAME).count();
	}

}
