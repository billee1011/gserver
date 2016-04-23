package com.eboji.game.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.eboji.commons.Constant;
import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.commons.util.redis.RedisClient;

public class ConfigUtil {
	private static Properties props = null;
	private static MemCacheClient client = null;
	private static RedisClient redisClient = null;
	
	protected static Properties getProps() {
		return props;
	}

	public static void setProps(Properties props) {
		ConfigUtil.props = props;
	}

	public static String getProps(String key) {
		if(props != null) {
			return props.getProperty(key);
		} else {
			return null;
		}
	}
	
	public static Map<Integer, String> getGameProps() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Iterator<Entry<Object, Object>> iter = props.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Object, Object> entry = iter.next();
			String key = (String)entry.getKey();
			if(key.contains("game_")) {
				map.put(Integer.parseInt(key.split(Constant.STR_UNDERLINE)[1]), 
						(entry.getValue() == null ? "" : ((String)entry.getValue())));
			}
		}
		
		return map;
	}

	public static MemCacheClient getClient() {
		return client;
	}

	public static void setClient(MemCacheClient client) {
		ConfigUtil.client = client;
	}

	public static RedisClient getRedisClient() {
		return redisClient;
	}

	public static void setRedisClient(RedisClient redisClient) {
		ConfigUtil.redisClient = redisClient;
	}
}
