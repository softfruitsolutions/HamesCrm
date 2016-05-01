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
import com.hames.bean.UserContext;
import com.hames.bean.criteria.TaskCriteria;
import com.hames.enums.TaskStatus;
import com.hames.service.LeadService;
import com.hames.service.PotentialService;
import com.hames.service.StaffService;
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
	private StaffService staffService;
	@Autowired
	private LeadService leadService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private PotentialService potentialService;
	
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
	@RequestMapping(value="/leadTask",method=RequestMethod.GET)
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
		model.addAttribute("potential", potentialService.getAllPotential());
		model.addAttribute("status", TaskStatus.values());
		model.addAttribute("staffs", staffService.getAllActiveStaffs());
		return "task.lead.view";
	}
	
	/**
	 * Viewing page for potential to create task
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/potTask",method=RequestMethod.GET)
	public String viewTaskCreationPotential(Model model,@RequestParam(value="id",required=false)String id){
		
		Task task = null;
		if(id==null || id.isEmpty()){
			if(!model.containsAttribute("task")){
				task = new Task();
				model.addAttribute("task", task);
				task.setCurrentDate(new DateTime());
				task.setPotId(taskService.getNextPotId());
			}
		} else {
			task = taskService.getTaskById(id);
			model.addAttribute("task", task);
		}
		model.addAttribute("leads", leadService.getAllLeads());
		model.addAttribute("potential", potentialService.getAllPotential());
		model.addAttribute("staffs", staffService.getAllActiveStaffs());
		model.addAttribute("status", TaskStatus.values());
		
		return "task.potential.view";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewTaskForm(Model model,@RequestParam(value="id",required=false)String id){
		
			model.addAttribute("menu","createTask");
			
			Task task = null;
			if(id==null || id.isEmpty()){
				if(!model.containsAttribute("task")){
					task = new Task();
					model.addAttribute("task", task);
					task.setCurrentDate(new DateTime());
				}
			} else {
				model.addAttribute("task", task);
			}
			model.addAttribute("leads", leadService.getAllLeads());
			model.addAttribute("potential", potentialService.getAllPotential());
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
		TaskCriteria taskCriteria = new TaskCriteria();
		taskCriteria.setTaskOwner(UserContext.staff.getStaffId());
		datatableRequest.setCriteria(taskCriteria);
		return taskService.getDatatable(datatableRequest);
	}
}
