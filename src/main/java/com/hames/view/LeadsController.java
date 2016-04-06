package com.hames.view;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.Permission;
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

import com.hames.bean.NewLead;
import com.hames.bean.UserContext;
import com.hames.enums.LeadStatus;
import com.hames.service.LeadService;
import com.hames.util.enums.SuccessCode;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;
import com.hames.util.model.JsonResponse;
import com.hames.util.model.SuccessNode;


@Controller
@RequestMapping("/leads")
public class LeadsController extends GenericView{

	private static final Logger logger =  LoggerFactory.getLogger(LeadsController.class);
	
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/list")
	public String list(Model model){
		
		model.addAttribute("staff",UserContext.staff);
		model.addAttribute("menu", "leadsView");
		
		return "leads.list";
		
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewLeadForm(Model model,@RequestParam(value="id",required=false)String id){
		
		model.addAttribute("menu", "createLead");
		
		NewLead newLead = null;
		if(id == null || id.isEmpty()){
			if(!model.containsAttribute("newLead")){
				newLead = new NewLead();
				newLead.setLeadNo(leadService.getNextLeadNo());
				/*newLead.setDateCreated(new DateTime());*/
			}
		}else{
			newLead = leadService.getLeadById(id);
			model.addAttribute("newLead", newLead);
		}
		model.addAttribute("newLead", newLead);
		model.addAttribute("leadStatus", LeadStatus.values());
		return "leads.view";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public JsonResponse save(Model model,@ModelAttribute NewLead newLead){
		
		JsonResponse response;
		
		leadService.saveLead(newLead);
		response= new JsonResponse(Boolean.TRUE, new SuccessNode(SuccessCode.ENTITY_SAVED,"lead saved successfully"));
		
		return response;
		
	}
	
	@RequestMapping("/datatable")
	public @ResponseBody DatatableResponse viewDatatable(@ModelAttribute DatatableRequest datatableRequest){
		return leadService.getDatatable(datatableRequest);
		
	}
}
