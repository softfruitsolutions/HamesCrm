package com.hames.bean.criteria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

import com.hames.bean.ProjectDetails;
import com.hames.util.model.QueryCriteria;

public class ProjectDetailsCriteria extends ProjectDetails implements QueryCriteria {

	@Override
	public Criteria queryCriteria() {
		List<Criteria> andCriterias = new ArrayList<Criteria>();
		
		if(getEngineer() != null || !getEngineer().isEmpty()){
			andCriterias.add(Criteria.where("engineer").is(getEngineer()));
		}
		
		if(andCriterias == null || andCriterias.size() <= 0){
			return null;
		}else{
			return new Criteria().andOperator(andCriterias.toArray(new Criteria[andCriterias.size()]));	
		}
	}

	@Override
	public void buildCriteria() {
		// TODO Auto-generated method stub
		
	}

}
