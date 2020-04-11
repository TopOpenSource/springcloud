package com.sdstc.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service("redisService")
public class RedisService {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public void setKey(String key, String value,long timeout) {
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		ops.set(key, value);
		stringRedisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
	}

	public String getValue(String key) {
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		return ops.get(key);
	}
	
	public void delKey(String key) {
		stringRedisTemplate.delete(key);
	}
}