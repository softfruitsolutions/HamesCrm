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

import com.hames.bean.Potential;
import com.hames.dao.LeadDao;
import com.hames.enums.PotentialStatus;
import com.hames.service.LeadService;
import com.hames.service.PotentialService;
import com.hames.util.enums.SuccessCode;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;
import com.hames.util.model.JsonResponse;
import com.hames.util.model.SuccessNode;

@Controller
@RequestMapping("/potential")
public class PotentialViewController extends GenericView{

	private static final Logger logger = LoggerFactory.getLogger(PotentialViewController.class);
	
	@Autowired
	private PotentialService potentialService;
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/list")
	public String list(Model model){
		
		model.addAttribute("menu","potentialView" );
		
		return "potential.list";
	}
	
	@RequestMapping(value="/view")
	public String viewPotentialForm(Model model,@RequestParam(value="id",required=false)String id){
			
			activeMenu(model, "potential");
			
			Potential potential = null;
			if(id == null || id.isEmpty()){
				if(!model.containsAttribute("potential")){
					potential = new Potential();
					model.addAttribute("potential", potential);
					potential.setCurrentDate(new DateTime());
				}
			}
				else {
					potential = potentialService.getPotentialById(id);
					model.addAttribute("potential", potential);
				}
			model.addAttribute("leads", leadService.getAllLeads());
			model.addAttribute("status", PotentialStatus.values());
		return "potential.view";
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public JsonResponse save(Model model,@ModelAttribute Potential potential){
		
		JsonResponse response;
		
		potentialService.savePotential(potential);
		response = new JsonResponse(Boolean.TRUE, new SuccessNode(SuccessCode.ENTITY_SAVED, "Data saved successfully"));
		
		return response;
	}
	
	@RequestMapping("/datatable")
	public @ResponseBody DatatableResponse viewDatatble(@ModelAttribute DatatableRequest datatableRequest){
		return potentialService.getDatatable(datatableRequest);
	}
}
