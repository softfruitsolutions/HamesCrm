package com.hames.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hames.service.CustomerService;
import com.hames.service.LeadService;
import com.hames.service.PotentialService;
import com.hames.service.ProjectDetailsService;

@Controller
public class DashboardView extends GenericView {
	
	@Autowired CustomerService customerService;
	@Autowired LeadService leadService;
	@Autowired ProjectDetailsService projectDetailsService;
	@Autowired PotentialService potentialService;
	
	@RequestMapping(value = "/dashboard")
	public String dashboard(Model model) {
		
		model.addAttribute("menu", "dashboard");
		
		/*model.addAttribute("customerCount", customerService.getCustomerCount());*/
		model.addAttribute("leadCount", leadService.getLeadCount());
		model.addAttribute("projectDeatailsCount", projectDetailsService.getProjectCount());
		model.addAttribute("potentialCount", potentialService.getPotentialCount());
		return "dashboard";
	}
	
}
