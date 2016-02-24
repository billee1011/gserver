package com.eboji.im.util;

import java.util.Properties;

import com.eboji.commons.util.memcached.MemCacheClient;

public class ConfigUtil {
	private static Properties props = null;
	private static MemCacheClient client = null;
	
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

	public static MemCacheClient getClient() {
		return client;
	}

	public static void setClient(MemCacheClient client) {
		ConfigUtil.client = client;
	}
}
