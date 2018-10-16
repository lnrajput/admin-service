package com.admin.tool.server;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ServerConnect {

	public void connectServer(String username, String host, String scriptName) throws Exception {
		Session session=null;
		JSch jsch = new JSch();
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
		jsch.addIdentity("src/main/resources/laxmi-ec2-key.pem");
	
		session = jsch.getSession(username, host, 22);
		session.setConfig(config);
		session.connect();
		String command="/bin/bash /home/ubuntu/admintool/"+scriptName+".sh";
		
		Channel channel = session.openChannel("exec");
	    ((ChannelExec)channel).setCommand(command);
	    // This is commented out to see the output of shell script
	  	//channel.setInputStream(null);
	  	((ChannelExec)channel).setErrStream(System.err);
	  	InputStream in=channel.getInputStream();
	  	channel.connect();
        while(true){
        	//This code is to display output of shell script
        	byte[] tmp = new byte[1024];
		    while (in.available() > 0) {
		        int i = in.read(tmp, 0, 1024);
		        if (i < 0) break;
		        //log.debug(new String(tmp, 0, i));
		        System.out.println(new String(tmp, 0, i));
		    }
		    //This is End of displaying shell script output
	        if(channel.isClosed()){
	        	//log.debug("exit-status: "+channel.getExitStatus());
	        	 System.out.println("exit-status: "+channel.getExitStatus());
	          break;
	        }
	        try{Thread.sleep(1000);}catch(Exception ee){}
        }

      channel.disconnect();
      session.disconnect();		
	    
	 }

}
