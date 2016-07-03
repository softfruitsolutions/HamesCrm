package com.hames.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import com.hames.bean.NewClient;
import com.hames.bean.NewLead;
import com.hames.dao.LeadDao;
import com.hames.db.Sequence;
import com.hames.db.SequenceDao;
import com.hames.exception.ValidationException;
import com.hames.service.GenericService;
import com.hames.service.LeadService;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;
import com.hames.validator.LeadValidator;

@Service
public class LeadServiceImpl extends GenericService implements LeadService {

	private static final Logger Logger = LoggerFactory.getLogger(LeadServiceImpl.class);
	
	@Autowired
	public LeadDao leadDao;
	@Autowired
	public SequenceDao sequenceDao;

	@Override
	public Validator getValidator() {
		return new LeadValidator();
	}

	@Override
	public Class<?> getEntityClass() {
		return NewLead.class;
	}

	@Override
	public void saveLead(NewLead newLead) {

		try{
			validate(newLead);
		}catch(ValidationException e){
			throw new ValidationException(e.getMessage());
		}

		newLead.setLeadNo(getNextLeadNo());
		sequenceDao.updateSequence(Sequence.LEAD_SEQUENCE);

		newLead.setAuditableDetails(newLead.getLeadId());
		Logger.debug("Saving Entity : {},{}", getEntityClass(),newLead.toString());
		leadDao.save(newLead);
		Logger.debug("Entity saved successfully");
	}

	@Override
	public DatatableResponse getDatatable(DatatableRequest request) {
		return leadDao.buildDatatableResponse(request);
	}

	@Override
	public String getNextLeadNo() {
		Long sequenceId = sequenceDao.findNextSequenceId(Sequence.LEAD_SEQUENCE);
		return "L"+sequenceId;
	}

	@Override
	public List<NewLead> getAllLeads() {
		return leadDao.findAllLead();
	}

	@Override
	public NewLead getLeadById(String leadId) {
		return leadDao.findByLeadId(leadId);
	}

	@Override
	public long getLeadCount() {
		return leadDao.findLeadCount();
	}

	@Override
	public NewClient getLeadForClient(String leadId) {
		return leadDao.fndLdFrClntId(leadId);
	}

		
}
