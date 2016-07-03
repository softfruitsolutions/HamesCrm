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

import com.hames.bean.InteriorProject;
import com.hames.bean.ProjectDetails;
import com.hames.enums.ProjectDetailsStatus;
import com.hames.service.ClientService;
import com.hames.service.InteriorProjectService;
import com.hames.service.ProjectDetailsService;
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
	
	@Autowired public ProjectDetailsService projectDetailsService;
	@Autowired public InteriorProjectService interiorProjectService;
	@Autowired private ClientService clientService;
	
	/**
	 * Listing values of structural project
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String listProjectDetails(Model model){
		
		return "project.list";
	}
	
	
	/**
	 * Listing values of interior project
	 * @param model
	 * @return
	 */
	@RequestMapping("/interiorListing")
	public String listIteriorProject(Model model){
		
		return "project.listingInterior";
	}
	
	
	/**
	 * Viewing the form to add structural project
	 * @param model
	 * @param id
	 * @return
	 */
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
		model.addAttribute("clientName", clientService.getAllClient());
		model.addAttribute("status", ProjectDetailsStatus.values());
		model.addAttribute("engineer", EngineersName.values());
		return "project.view";
	}
	
	/**
	 * Viewing the form to add interior project
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/interior")
	public String viewInteriorProjectForm(Model model,@RequestParam(value="id",required=false)String id){
		
		InteriorProject interiorProject = null;
		if(id == null || id.isEmpty()){
			if(!model.containsAttribute("interiorProject"));
			interiorProject = new InteriorProject();
			model.addAttribute("interiorProject",interiorProject);
			interiorProject.setDate(new DateTime());
		}else{
			interiorProject = interiorProjectService.getProjectId(id);
			model.addAttribute("interiorProject",interiorProject);
		}
		model.addAttribute("clientName", clientService.getAllClient());
		model.addAttribute("status",ProjectDetailsStatus.values());
		model.addAttribute("engineer",EngineersName.values());
		return "project.interior";
	}
	
	/**
	 * Saving values of structural project
	 * @param model
	 * @param projectDetails
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public JsonResponse save(Model model,@ModelAttribute ProjectDetails projectDetails){
		
		JsonResponse response;
		projectDetailsService.saveProjectDetails(projectDetails);
		response = new JsonResponse(Boolean.TRUE, new SuccessNode(SuccessCode.ENTITY_SAVED, "Project details Saved Successfully"));
		
		return response;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/saveInterior",method=RequestMethod.POST)
	public JsonResponse saveInterior(Model model,@ModelAttribute InteriorProject interiorProject){
		
		JsonResponse response ;
		interiorProjectService.saveProjectDetails(interiorProject);
		response = new JsonResponse(Boolean.TRUE, new SuccessNode(SuccessCode.ENTITY_SAVED,"Interior Project Details Saved Successfully"));
		
		return response;
	}
	
	/**
	 * listing the values in the table
	 * @param datatableRequest
	 * @return
	 */
	@RequestMapping("/datatable")
	public @ResponseBody DatatableResponse viewDataTable(@ModelAttribute DatatableRequest datatableRequest){
		return projectDetailsService.getDatatable(datatableRequest);
	}
	
	/**
	 * listing the values in the table
	 * @param datatableRequest
	 * @return
	 */
	@RequestMapping("/interiorDatatable")
	public @ResponseBody DatatableResponse interiorDatatable(@ModelAttribute DatatableRequest datatableRequest){
		
		return interiorProjectService.getDatatable(datatableRequest);
	}
}
