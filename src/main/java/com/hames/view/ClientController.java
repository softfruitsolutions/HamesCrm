package com.hames.view;

import javax.jws.WebParam.Mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hames.bean.NewClient;
import com.hames.bean.NewLead;
import com.hames.enums.LeadStatus;
import com.hames.service.ClientService;
import com.hames.service.LeadService;
import com.hames.util.enums.SuccessCode;
import com.hames.util.model.DatatableRequest;
import com.hames.util.model.DatatableResponse;
import com.hames.util.model.JsonResponse;
import com.hames.util.model.SuccessNode;

@Controller
@RequestMapping("/client")
public class ClientController extends GenericView{

	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired 
	private LeadService leadService;
	@Autowired
	private ClientService clientService;

	private NewClient newclient;
	
	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("menu","clientView");
		return "client.list";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewLeadForm(Model model,@RequestParam(value="id",required=false)String id,@RequestParam(value="notes",required=false)String note){
		
		model.addAttribute("menu", "createLead");
		
		newclient = null;
		
		if(id == null || id.isEmpty()){
			if(!model.containsAttribute("newclient")){
				newclient  = new NewClient();
				newclient.setLeadNo(leadService.getNextLeadNo());
			}
		}else
		{
			newclient = leadService.getLeadForClient(id);
			model.addAttribute("newclient", newclient);
		}
		model.addAttribute("newclient", newclient);
		model.addAttribute("leadStatus", LeadStatus.values());
		return "client.view";
		
	}
	
	@RequestMapping(value="/viewEdit",method=RequestMethod.GET)
	public String viewClientForm(Model model,@RequestParam(value="id",required=false)String id){
		
		model.addAttribute("menu","createLead");
		
		NewClient newclient = null;
		if(id == null || id.isEmpty()){
			if(!model.containsAttribute("newclient")){
				newclient = new NewClient();
				newclient.setLeadNo(leadService.getNextLeadNo());
			}
					
		}else{
			newclient = clientService.getLeadId(id);
			model.addAttribute("newclient", newclient);
			
		}
		model.addAttribute("newclient", newclient);
		model.addAttribute("leadStatus", LeadStatus.values());
		return "client.edit";
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public JsonResponse save(Model model,@ModelAttribute NewClient newclient){
		JsonResponse res;
		clientService.saveClient(newclient);
		res = new JsonResponse(Boolean.TRUE, new SuccessNode(SuccessCode.ENTITY_SAVED, "Client Saved Successfully"));
		return res;
	}
	
	@RequestMapping("/datatable")
	public @ResponseBody DatatableResponse viewDatatable(@ModelAttribute DatatableRequest datatableRequest){
		return clientService.getDatatable(datatableRequest);
	}
}
