package com.hames.bean.criteria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

import com.hames.bean.Task;
import com.hames.util.model.QueryCriteria;

public class TaskCriteria extends Task implements QueryCriteria {

	@Override
	public Criteria queryCriteria() {
		List<Criteria> andCriterias = new ArrayList<Criteria>();
		
		if(getTaskOwner() != null || !getTaskOwner().isEmpty()){
			andCriterias.add(Criteria.where("taskOwner").is(getTaskOwner()));
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
