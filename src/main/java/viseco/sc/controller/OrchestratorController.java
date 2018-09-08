package viseco.sc.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class OrchestratorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyController.class);
	
	private SimpMessageSendingOperations messagingTemplate;
	
	@Autowired
	public OrchestratorController(SimpMessageSendingOperations messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
	
    @RequestMapping(value="/orch/deploy/{nsd}", method = RequestMethod.GET)
    public ResponseEntity<String> mano(HttpServletRequest request, @PathVariable("nsd")  String data) {
    	LOGGER.info("NSD: " + data);
    	messagingTemplate.convertAndSend("/data/notification", "ID: " + data);
    	
    	//deploy
        RestTemplate restTemplate = new RestTemplate();
        String downStreamUrl="http://localhost:7751/nfvo/deploy/" + data;
        try {
        ResponseEntity<String> response = restTemplate.getForEntity(downStreamUrl, String.class);
        LOGGER.info(response.getBody());
        } catch (Exception ex) {
	    	   LOGGER.warn("Can not get data from " + downStreamUrl);
	    	   return new ResponseEntity<String>("ERROR", HttpStatus.SERVICE_UNAVAILABLE);
	    }       	
    	
    	return new ResponseEntity<String>("OK", HttpStatus.OK);
    }	
	
}
