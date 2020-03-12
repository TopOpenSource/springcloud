package com.sdstc.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.stereotype.Component;

import com.sdstc.pub.snowflake.SnowflakeIdWorker;

@Component
public class Snowflake {
	@Autowired
	private Oauth2Service oauth2Service;
	
	@Autowired
	private Registration registration;
	
    public Long getId() {
    	String host=registration.getHost();
    	Long workerId=oauth2Service.getWorkerId(host);
    	SnowflakeIdWorker snowflakeIdWorker=new SnowflakeIdWorker(workerId);
    	return snowflakeIdWorker.nextId();
    }
}
