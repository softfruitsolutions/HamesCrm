package com.hames.service;

import java.util.List;

import com.hames.bean.NewClient;
import com.hames.bean.NewLead;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

public interface LeadService {

	/**
	 * Save New Lead
	 * @param newLead
	 */
	public void saveLead(NewLead newLead);
	
	/**
	 * Get datatable
	 */
	public DatatableResponse getDatatable(DatatableRequest request);
	
	/**
	 * Next lead no
	 */
	public String getNextLeadNo();
	
	/**
	 * Get All Lead
	 */
	public List<NewLead> getAllLeads();
	
	/**
	 * Get a lead
	 */
	public NewLead getLeadById(String leadId);
	
	public NewClient getLeadForClient(String leadId);
	/**
	 * Get Lead Count
	 */
	public long getLeadCount();
}
