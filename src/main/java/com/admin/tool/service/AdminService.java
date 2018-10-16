package com.admin.tool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.tool.server.ServerConnect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminService {
	
	@Autowired
	private ServerConnect serverConnect;
	
	public String scriptLauncher(String scriptName) throws Exception	 {
		log.debug("In Admin Service");
		serverConnect.connectServer("ubuntu", "3.0.10.200",scriptName);
		return "Successfully Sent";
	}

}
