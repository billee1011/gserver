package com.eboji.login.util;

import java.util.Properties;

public class ConfigUtil {
	private static Properties props = null;
	
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
}
