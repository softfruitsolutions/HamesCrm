package com.hames.view;


import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hames.bean.ProjectDetails;
import com.hames.enums.ProjectDetailsStatus;
import com.hames.service.PotentialService;
import com.hames.service.ProjectDetailsService;
import com.hames.service.impl.PotentialServiceImpl;
import com.hames.util.enums.EngineersName;
import com.hames.util.enums.SuccessCode;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;
import com.hames.util.model.JsonResponse;
import com.hames.util.model.SuccessNode;

@Controller
@RequestMapping("/project")
public class ProjectDetailsViewController extends GenericView{
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectDetailsViewController.class);
	
	@Autowired
	public ProjectDetailsService projectDetailsService;
	
	@Autowired
	public PotentialService potentialService;
	
	@RequestMapping("/list")
	public String listProjectDetails(Model model){
		
		return "project.list";
	}
	
	@RequestMapping("/view")
	public String viewProjectDetailsForm(Model model,@RequestParam(value="id",required=false)String id){
		
		ProjectDetails projectDetails = null;
		if(id == null || id.isEmpty()){
			if(!model.containsAttribute("projectDetails"));
			projectDetails = new ProjectDetails();
			model.addAttribute("projectDetails", projectDetails);
			projectDetails.setDate(new DateTime());
		}else{
			projectDetails = projectDetailsService.getProjectId(id);
			model.addAttribute("projectDetails", projectDetails);
		}
		model.addAttribute("potentialName", potentialService.getAllPotential());
		model.addAttribute("status", ProjectDetailsStatus.values());
		model.addAttribute("engineer", EngineersName.values());
		return "project.view";
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public JsonResponse save(Model model,@ModelAttribute ProjectDetails projectDetails){
		
		JsonResponse response;
		projectDetailsService.saveProjectDetails(projectDetails);
		response = new JsonResponse(Boolean.TRUE, new SuccessNode(SuccessCode.ENTITY_SAVED, "Project details Saved Successfully"));
		
		return response;
		
	}
	
	@RequestMapping("/datatable")
	public @ResponseBody DatatableResponse viewDataTable(@ModelAttribute DatatableRequest datatableRequest){
		return projectDetailsService.getDatatable(datatableRequest);
	}
}
