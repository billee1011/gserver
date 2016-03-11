package com.eboji.game.bootstrap.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.commons.util.memcached.MemcachedConfiguration;
import com.eboji.commons.util.redis.RedisClient;
import com.eboji.game.util.ConfigUtil;
import com.eboji.model.constant.Constant;

@Component("serverInitializingBean")
public class ServerInitializingBean implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		createMemCacheClient();
		createRedisClient();
	}
	
	/**
	 * 初始化缓存服务器的连接
	 */
	protected void createMemCacheClient() {
		String memcacheserversp = ConfigUtil.getProps("memcacheserver");
		String[] memcacheservers = memcacheserversp.split("\\|");
		Integer[] weights = new Integer[memcacheservers.length];
		for(int i = 0; i < memcacheservers.length; i++) {
			weights[i] = 3;
		}
		if(memcacheservers.length > 0) {
			MemCacheClient client = new MemCacheClient(new MemcachedConfiguration(), memcacheservers, weights, "gameServer");
			ConfigUtil.setClient(client);
		}
	}
	
	/**
	 * 初始化Redis缓存服务器的连接
	 */
	protected void createRedisClient() {
		String redisserversp = ConfigUtil.getProps("redisserver");
		String[] redisservers = redisserversp.split(Constant.STR_COLON);
		RedisClient client = new RedisClient(redisservers[0], Integer.parseInt(redisservers[1]), null);
		ConfigUtil.setRedisClient(client);
	}
}
