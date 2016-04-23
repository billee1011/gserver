package com.eboji.data.bootstrap.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.commons.util.memcached.MemcachedConfiguration;
import com.eboji.data.util.ConfigUtil;

@Component("serverInitializingBean")
public class ServerInitializingBean implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		createMemCacheClient();
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
			MemCacheClient client = new MemCacheClient(new MemcachedConfiguration(), memcacheservers, weights, "loginServer");
			ConfigUtil.setClient(client);
		}
	}
}
