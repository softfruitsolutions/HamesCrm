package com.hames.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hames.service.ClientService;
import com.hames.service.CustomerService;
import com.hames.service.InteriorProjectService;
import com.hames.service.LeadService;
import com.hames.service.ProjectDetailsService;
import com.hames.service.TaskService;

@Controller
public class DashboardView extends GenericView {
	
	@Autowired CustomerService customerService;
	@Autowired LeadService leadService;
	@Autowired ProjectDetailsService projectDetailsService;
	@Autowired TaskService taskService;
	@Autowired InteriorProjectService interiorProjectService;
	@Autowired ClientService clientService;
	
	@RequestMapping(value = "/dashboard")
	public String dashboard(Model model) {
		
		model.addAttribute("menu", "dashboard");
		
		/*model.addAttribute("customerCount", customerService.getCustomerCount());*/
		model.addAttribute("leadCount", leadService.getLeadCount());
		model.addAttribute("projectDeatailsCount", projectDetailsService.getProjectCount());
		model.addAttribute("taskCount", taskService.getTaskCount());
		model.addAttribute("interiorProject",interiorProjectService.getProjectCount());
		model.addAttribute("clientCount", clientService.getLeadCount());
		return "dashboard";
	}
	
}
