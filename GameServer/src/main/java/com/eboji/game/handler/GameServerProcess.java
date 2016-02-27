package com.eboji.game.handler;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.model.message.mj.MjCreateMsg;
import com.eboji.model.message.mj.MjCreateResMsg;
import com.eboji.model.message.mj.MjJoinMsg;
import com.eboji.model.message.mj.MjStartMsg;

public class GameServerProcess {
	private static final Logger logger = LoggerFactory.getLogger(GameServerProcess.class);
	
	//游戏逻辑处理入口分发类
	public static void process(MemCacheClient client, Object obj, String remoteAddress) {
		logger.debug("游戏逻辑处理开始");
		
		if(obj instanceof MjStartMsg) {
			//TODO 处理游戏开始逻辑
			
		} else if(obj instanceof MjCreateMsg) {
			//创建房间处理逻辑
			//1. 计算房间信息
			MjCreateMsg createMsg = (MjCreateMsg)obj;
			String uId = createMsg.getUid();
			JSONObject json = new JSONObject();
			json.put(uId, remoteAddress);
			randDeskIdAndFinishCreate(client, uId, remoteAddress, json.toString());
		} else if(obj instanceof MjJoinMsg) {
			//TODO 加入房间处理逻辑
		}
	}
	
	protected static synchronized void randDeskIdAndFinishCreate(MemCacheClient client,
			String uId, String remoteAddress, String value) {
		Random rand = new Random(System.currentTimeMillis());
		int deskId = 0;
		while(true) {
			deskId = rand.nextInt(99999);
			if(deskId > 10000 && client.get(String.valueOf(deskId)) == null) {
				break;
			}
		}
		
		MjCreateResMsg res = new MjCreateResMsg();
		res.setUid(uId);
		
		if(client.add(String.valueOf(deskId), value)) {
			logger.info("USER[id= " + uId+ "] CREATE ROOM OK");
			res.setDeskId(deskId);
		} else {
			logger.error("USER[id= " + uId + "] CREATE ROOM FAILED");
		}
		
		GameServerClientMap.get(remoteAddress).writeAndFlush(res);
	}
}
