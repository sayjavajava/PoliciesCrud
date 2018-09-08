package viseco.sc.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import viseco.sc.Models.Policy;
import viseco.sc.Repository.PolicyRepository;


@Controller
public class PolicyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyController.class);
	
	private SimpMessageSendingOperations messagingTemplate;
	
	@Autowired
	public PolicyController(SimpMessageSendingOperations messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}

	@Autowired
	PolicyRepository policyRepository;

    @RequestMapping(value="/mano/{data}", method = RequestMethod.GET)
    public ResponseEntity<String> mano(HttpServletRequest request, @PathVariable("data")  String data) {
    	LOGGER.info("Received request from " + request.getRemoteAddr());
    	messagingTemplate.convertAndSend("/data/notification", data);
    	return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("policyList", policyRepository.findAll());
		return "policymanagement";
	}

	@RequestMapping("/delete/{id}")
	public String deletePolicy(
	            @PathVariable String id) {

    	policyRepository.deleteById(id);
	//	model.addAttribute("policyList", policyRepository.findAll());
		return "redirect:policymanagement";
	}

	@RequestMapping(value = "/addPolicy", method = RequestMethod.POST)
	public String addCar(@ModelAttribute Policy policy) {
		policyRepository.save(policy);
		return "redirect:policymanagement";
	}

/*	@RequestMapping(value = "/search")
	public String search(@RequestParam String search) {
		return "home";
	}*/


	
}
