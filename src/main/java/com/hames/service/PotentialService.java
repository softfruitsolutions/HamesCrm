package com.hames.service;

import java.util.List;

import com.hames.bean.Potential;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

public interface PotentialService {

	/**
	 * Save potential
	 */
	
	public void savePotential(Potential potential);
	
	/**
	 * Get datatable 
	 */
	public DatatableResponse getDatatable(DatatableRequest request);
	
	/**
	 *Get all potential 
	 */
	public List<Potential> getAllPotential();
	
	/**
	 * Get a potential
	 */
	public Potential getPotentialById(String potentialId);
	
	/**
	 * get the potential count
	 * @return
	 */
	public long getPotentialCount();
}

