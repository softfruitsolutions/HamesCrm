package com.hames.dao;

import java.util.List;

import com.hames.bean.Potential;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;

public interface PotentialDao {

	/**
	 * Save potential
	 */
	
	void save(Potential potential);
	
	/**
	 * Get datatable
	 */
	DatatableResponse buildDatatable(DatatableRequest request);
	
	/**
	 * Find all potential
	 */
	List<Potential> findAllPotential();
	
	/**
	 * find a potential
	 */
	Potential findByPotentialId(String potentialId);
	
	/**
	 * To fing the count of potential
	 * @return
	 */
	Long findPotentialCount();
	
}
