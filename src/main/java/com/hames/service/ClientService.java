package com.hames.service;

import java.util.List;

import com.hames.bean.NewClient;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

public interface ClientService {
	
	/**
	 * Save client
	 * @param newclient
	 */
	public void saveClient(NewClient newclient);
	
	public DatatableResponse getDatatable(DatatableRequest request);
	
	public NewClient getLeadId(String leadId);
	
	public long getLeadCount();
	
	public List<NewClient> getAllClient();

}
