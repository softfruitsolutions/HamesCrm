package com.hames.view;


import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hames.bean.Task;
import com.hames.enums.TaskStatus;
import com.hames.service.ClientService;
import com.hames.service.LeadService;
import com.hames.service.TaskService;
import com.hames.util.enums.SuccessCode;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;
import com.hames.util.model.JsonResponse;
import com.hames.util.model.SuccessNode;

@Controller
@RequestMapping("/task")
public class TaskController extends GenericView{
	
	@Autowired
	private LeadService leadService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ClientService clientService;
	
	/**
	 * Listing values form database
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("menu","taskView");
		return "task.list";
	}
	
	/**
	 * Viewing page for lead to create task
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewTaskCreationLead(Model model,@RequestParam(value="id",required=false)String id){
		
		Task task = null;
		if(id==null || id.isEmpty()){
			if(!model.containsAttribute("task")){
				task = new Task();
				model.addAttribute("task", task);
				task.setCurrentDate(new DateTime());
				task.setLeadId(taskService.getNextLeadId());
			}
		} else {
			task = taskService.getTaskById(id);
			model.addAttribute("task", task);
		}
		model.addAttribute("leads", leadService.getAllLeads());
		model.addAttribute("status", TaskStatus.values());
		model.addAttribute("clientName", clientService.getAllClient());
		return "task.view";
	}

	
	/**
	 * Saving values in DB
	 * @param model
	 * @param task
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public JsonResponse save(Model model,@ModelAttribute Task task){
		
		JsonResponse response;
		
		taskService.saveTask(task);
		response = new JsonResponse(Boolean.TRUE , new SuccessNode(SuccessCode.ENTITY_SAVED, "task saved successfully"));
		return response;
	}
	
	/**
	 * Creating datatable
	 * @param datatableRequest
	 * @return
	 */
	@RequestMapping("/datatable")
	public @ResponseBody DatatableResponse viewDatatable(@ModelAttribute DatatableRequest datatableRequest){
		return taskService.getDatatable(datatableRequest);
		
	}
}
