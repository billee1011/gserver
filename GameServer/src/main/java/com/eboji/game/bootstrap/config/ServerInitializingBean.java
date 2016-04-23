package com.eboji.game.bootstrap.config;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.eboji.commons.Constant;
import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.commons.util.memcached.MemcachedConfiguration;
import com.eboji.commons.util.redis.RedisClient;
import com.eboji.game.logic.mj.GameBaseLogic;
import com.eboji.game.manager.GameServerManager;
import com.eboji.game.server.GameServerCfgMap;
import com.eboji.game.util.ConfigUtil;

@Component("serverInitializingBean")
public class ServerInitializingBean implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(ServerInitializingBean.class);
	
	@Override
	public void afterPropertiesSet() throws Exception {
		createMemCacheClient();
		createRedisClient();
		
		initGameLogicMap();
		initGameManager();
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
			MemCacheClient client = new MemCacheClient(
					new MemcachedConfiguration(), 
					memcacheservers, weights, "gameServer");
			ConfigUtil.setClient(client);
		}
	}
	
	/**
	 * 初始化Redis缓存服务器的连接
	 */
	protected void createRedisClient() {
		String redisserversp = ConfigUtil.getProps("redisserver");
		String[] redisservers = redisserversp.split(Constant.STR_COLON);
		RedisClient client = new RedisClient(redisservers[0], 
				Integer.parseInt(redisservers[1]), null);
		ConfigUtil.setRedisClient(client);
	}
	
	/**
	 * 初始化加载配置的游戏逻辑处理类
	 */
	protected void initGameLogicMap() {
		try {
			Map<Integer, String> maps = ConfigUtil.getGameProps();
			Iterator<Entry<Integer, String>> iter = maps.entrySet().iterator();
			while(iter.hasNext()) {
				Entry<Integer, String> entry = iter.next();
				GameBaseLogic baseLogic = 
						(GameBaseLogic)Class.forName(entry.getValue()).newInstance();
				GameServerCfgMap.getGameMap().put(entry.getKey(), baseLogic);
			}
		} catch (Exception e) {
			logger.error("Initial GameServerLogic " + 
					e.getMessage() + ", GameServer start failed!", e);
			System.exit(-1);
		}
	}
	
	protected void initGameManager() {
		try {
			GameServerManager gameManager = (GameServerManager)Class
					.forName(ConfigUtil.getProps("game.manager")).newInstance();
			GameServerCfgMap.setGameManager(gameManager);
		} catch (Exception e) {
			logger.error("Initial GameServerManager " +
					e.getMessage() + ", GameServer start failed!", e);
			System.exit(-1);
		}
	}
}
