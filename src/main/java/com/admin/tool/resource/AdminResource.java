package com.admin.tool.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.tool.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AdminResource {
	
	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin/script-launcher/{scriptName}")
	public @ResponseBody String scriptLauncher(@PathVariable("scriptName")String scriptName) {
		log.debug("in script launcher resource method..");
		try {
			return adminService.scriptLauncher(scriptName);
		} catch (Exception e) {
			log.error(e.getMessage(),e);			
			return "Failure";
		}
	}	

}
