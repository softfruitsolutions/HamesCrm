package com.hames.dao;

import java.util.List;

import com.hames.bean.NewLead;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

public interface LeadDao {

	/**
	 * Save Leads
	 */
	
	void save(NewLead newLead);
	
	/**
	 * Get datatable
	 */
	DatatableResponse buildDatatableResponse(DatatableRequest request);
	
	/**
	 * Is lead Id exists
	 */
	public boolean isLeadNoExists(String leadNo);
	
	/**
	 * Find all Lead
	 */
	List<NewLead> findAllLead();
	
	/**
	 * Find a lead
	 */
	NewLead findByLeadId(String leadId);
	
	/**
	 * Get Lead Count
	 */
	Long findLeadCount();
	
}
