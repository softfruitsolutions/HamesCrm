package com.hames.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import com.hames.bean.NewClient;
import com.hames.dao.ClientDao;
import com.hames.service.ClientService;
import com.hames.service.GenericService;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

@Service
public class ClientServiceImpl extends GenericService implements ClientService{

	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	@Autowired
	public ClientDao clientDao;
	
	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getEntityClass() {
		return NewClient.class;
	}

	
	@Override
	public void saveClient(NewClient newclient) {

	logger.debug("Saving entity :{},{}", getEntityClass(),newclient.toString());
	clientDao.save(newclient);
	logger.debug("Entity saved successfully");
	}

	@Override
	public DatatableResponse getDatatable(DatatableRequest request) {
		return clientDao.buildDatatableResponse(request);
	}

	@Override
	public NewClient getLeadId(String leadId) {
		return clientDao.findByLeadId(leadId);
	}

	@Override
	public long getLeadCount() {
		return clientDao.findCustomerCount();
	}

	@Override
	public List<NewClient> getAllClient() {
		return clientDao.findAllClient();
	}

}
