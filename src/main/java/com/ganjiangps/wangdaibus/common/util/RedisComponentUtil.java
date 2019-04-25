package com.ganjiangps.wangdaibus.common.util;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * 
* @ClassName: RedisComponentUtil 
* @Description: TODO(Redis 工具类) 
* @author cjm
* @date 2018年4月21日 上午11:53:17 
*
 */
@Component
public class RedisComponentUtil implements Serializable{
 
	private static final long serialVersionUID = 1L;

	//过期时间
	@Value("${jwt.expiration}")
	private Long expiration;
	
	@Resource
	private RedisTemplate<String,Object> redisTemplate;
	
	/**
	 * 
	* @Title: setRedisKeyAndValue 
	* @Description: TODO(缓存) 
	* @param @param redisKey   缓存key
	* @param @param value    设定文件   obj
	* @return void    返回类型 
	* @throws
	 */
	public void setRedisKeyAndValue(String redisKey,Object value){
		getValueOperations().set(redisKey, value, expiration, TimeUnit.SECONDS);
 	}
	
	/**
	 * 
	* @Title: deleteRedisKey 
	* @Description: TODO(删除缓存) 
	* @param @param redisKey   缓存key
	* @param @param value    设定文件   obj
	* @return void    返回类型 
	* @throws
	 */
	public Boolean deleteRedisKey(String redisKey){
		return redisTemplate.delete(redisKey);
	}

	/**
	 * 
	* @Title: getRedisByKey 
	* @Description: TODO(根据key 获取缓存信息) 
	* @param @param redisKey
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	public Object getRedisByKey(String redisKey){
		Object object = getValueOperations().get(redisKey);
		return object;
	}

	/**
	 * 
	* @Title: setRedisKeyAndValue 
	* @Description: TODO(缓存) 
	* @param @param redisKey  缓存key
	* @param @param value      obj
	* @param @param timeout    时间  单位秒
	* @return void    返回类型 
	* @throws
	 */
	public void setRedisKeyAndValue(String redisKey,Object value,long timeout){
		getValueOperations().set(redisKey, value, timeout, TimeUnit.SECONDS);
	}
	 
	public ValueOperations<String, Object> getValueOperations(){
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		return operations;
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);

		// 使用Jackson2JsonRedisSerialize 替换默认序列化
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

		// 设置value的序列化规则和 key的序列化规则
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setKeySerializer(new StringRedisSerializer());

		redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

		redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setEnableDefaultSerializer(true);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
 }
