package com.sdstc.pub.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.stereotype.Component;

import com.sdstc.pub.snowflake.SnowflakeIdWorker;

@Component
public class Snowflake {
	@Autowired
	private Oauth2Service oauth2Service;
	
	private Long localWorkerId=-1L;
	
	@Autowired
	private Registration registration;
	
    public Long getId() {
    	Long workerId=null;
    	if(this.localWorkerId==-1L) {
    		String host=registration.getHost();
        	workerId=oauth2Service.getWorkerId(host);
        	this.localWorkerId=workerId;
    	}else {
    		workerId=this.localWorkerId;
    	}
    	
    	SnowflakeIdWorker snowflakeIdWorker=new SnowflakeIdWorker(workerId);
    	return snowflakeIdWorker.nextId();
    }
}
