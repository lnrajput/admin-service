package com.admin.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
//		ServerConnect sc = new ServerConnect();
//		try {
//			sc.connectServer("ubuntu", "3.0.10.200","hello");
//		} catch (JSchException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
