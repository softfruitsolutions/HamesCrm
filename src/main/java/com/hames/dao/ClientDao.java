package com.hames.dao;

import java.util.List;

import com.hames.bean.NewClient;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

/**
 * 
 * @author Raneef ibn ali nhelat
 * Client or customer
 */
public interface ClientDao {

	/**
	 * Saving function for client
	 * @param newClient
	 */
	void save(NewClient newClient);
	
	/**
	 * Datatable function for getting table value
	 * @param request
	 * @return
	 */
	DatatableResponse buildDatatableResponse(DatatableRequest request);
	
	/**
	 * To find the client which have to edit by using the id
	 * @param leadId
	 * @return
	 */
	NewClient findByLeadId(String leadId);
	
	/**
	 * To find the count of the customer
	 * @return
	 */
	Long findCustomerCount();
	
	List<NewClient> findAllClient();
}
