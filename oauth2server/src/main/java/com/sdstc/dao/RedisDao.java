package com.sdstc.dao;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * @author cheng
 */
@Repository
public class RedisDao {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	public void setKey(String key, String value, long timeout) {
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		ops.set(key, value);
		stringRedisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
	}

	public void setKey(String key, Object value, long timeout) {
		ValueOperations<String, Object> ops = redisTemplate.opsForValue();
		ops.set(key, value);
		redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
	}

	public String getValue(String key) {
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		return ops.get(key);
	}

	public Object getValueObject(String key) {
		ValueOperations<String, Object> ops = redisTemplate.opsForValue();
		return ops.get(key);
	}

	public void delKey(String key) {
		redisTemplate.delete(key);
	}
}