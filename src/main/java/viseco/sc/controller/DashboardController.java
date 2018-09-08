package viseco.sc.controller;/*
 * @author    : waqas kamran
 * @Date      : 17-Apr-18
 * @version   : ver. 1.0.0
 * 
 * ________________________________________________________________________________________________
 *
 *  Developer				Date		     Version		Operation		Description
 * ________________________________________________________________________________________________ 
 *	
 * 
 * ________________________________________________________________________________________________
 *
 * @Project   : HIS
 * @Package   : com.sd.his.*
 * @FileName  : UserAuthAPI
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import viseco.sc.Repository.PolicyRepository;

import java.util.Map;

@Controller
public class DashboardController {

    @Autowired
    PolicyRepository policyRepository;

    @RequestMapping("/")
    public String dashboard(Map<String, Object> model) {

        return "dashboard";
    }

    @RequestMapping("/application")
    public String application(Map<String, Object> model) {

        return "application";
    }

    @RequestMapping("/components")
    public String components(Map<String, Object> model) {

        return "components";
    }

    @RequestMapping("/resource")
    public String resource(Map<String, Object> model) {

        return "resource";
    }

    @RequestMapping("/activity")
    public String activity(Map<String, Object> model) {

        return "activity";
    }

    @RequestMapping("/account")
    public String account(Map<String, Object> model) {

        return "account";
    }

    @RequestMapping("/policymanagement")
    public String policymanagement(Model model) {
        model.addAttribute("policyList", policyRepository.findAll());
        return "policymanagement";
    }
    @RequestMapping("/addnewtemplate")
    public String applicationTemplate(Map<String, Object> model) {

        return "addnewtemplate";
    }
    @RequestMapping("/addnewpolicy")
    public String addPolicy(Map<String, Object> model) {

        return "addnewpolicy";
    }
    @RequestMapping("/uploadcomponents")
    public String uploadComponents(Map<String, Object> model) {

        return "uploadcomponents";
    }
    
}