package com.hames.dao.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hames.bean.Potential;
import com.hames.dao.PotentialDao;
import com.hames.db.GenericDao;
import com.hames.db.HamesDataStore;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

@Repository
public class PotentialDaoImpl extends GenericDao implements PotentialDao{

	private static final String COLLECTION_NAME = "potential";
	private static final Logger logger = LoggerFactory.getLogger(PotentialDaoImpl.class);

	@Autowired
	private HamesDataStore hamesDataStore;
	
	@PostConstruct
	public void CreateCollection(){
		if(!hamesDataStore.collectionExists(COLLECTION_NAME)){
			hamesDataStore.createCollection(COLLECTION_NAME);
		}
	}
	
	@Override
	public void save(Potential potential) {

			if(!hamesDataStore.exists(potential.getPotentialId(), COLLECTION_NAME)){
				potential.setPotentialId(UUID.randomUUID().toString());	
			}
			hamesDataStore.save(potential, COLLECTION_NAME);
			
	}

	@Override
	public Class<?> getEntityClass() {
		return Potential.class;
	}

	@Override
	public DatatableResponse buildDatatable(DatatableRequest request) {
		
		request.setClazz(getEntityClass());
		request.setMongoCollectionName(COLLECTION_NAME);
		return hamesDataStore.getDatatablePagedResult(request);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Potential> findAllPotential() {
		return (List<Potential>) hamesDataStore.findAll(getEntityClass(), COLLECTION_NAME);
	}

	@Override
	public Potential findByPotentialId(String potentialId) {
		return (Potential) hamesDataStore.findById(potentialId, getEntityClass(),COLLECTION_NAME);
	}

	@Override
	public Long findPotentialCount() {
		return hamesDataStore.getCollection(COLLECTION_NAME).count();
	}

	
}
