package com.eboji.commons.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eboji.commons.type.MsgType;

public class JSONUtil {
	private static final Logger logger = LoggerFactory.getLogger(JSONUtil.class);
	
	public static Object JSONObject2Object(JSONObject obj, String type) {
		Object o = null;
		try {
			String clazzName = MsgType.valueOf(type).getClazz();
			Class<?> clazz = Class.forName(clazzName).newInstance().getClass();
			o = JSON.toJavaObject(obj, clazz);
		} catch (Exception e) {
			logger.error("json exception!!!", e);
		}
		return o;
	}
}
