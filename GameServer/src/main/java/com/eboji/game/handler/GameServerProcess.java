package com.eboji.game.handler;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.model.constant.Constant;
import com.eboji.model.message.mj.MjCreateMsg;
import com.eboji.model.message.mj.MjCreateResMsg;
import com.eboji.model.message.mj.MjJoinMsg;
import com.eboji.model.message.mj.MjJoinResMsg;
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
			createRoom(client, remoteAddress, uId);
		} else if(obj instanceof MjJoinMsg) {
			//加入房间处理逻辑
			MjJoinMsg joinMsg = (MjJoinMsg)obj;
			int deskId = joinMsg.getDeskId();
			String uId = joinMsg.getUid();
			joinRoom(client, remoteAddress, uId, deskId);
		}
	}
	
	protected static synchronized void createRoom(MemCacheClient client,
			String remoteAddress, String uId) {
		JSONObject json = new JSONObject();
		json.put(uId, remoteAddress);
		
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
		res.setDeskId(deskId);
		
		if(client.add(String.valueOf(deskId), json.toString())) {
			logger.info("USER[id= " + uId+ "] CREATE ROOM OK");
			res.setDeskId(deskId);
		} else {
			logger.error("USER[id= " + uId + "] CREATE ROOM FAILED");
		}
		
		GameServerClientMap.get(remoteAddress).writeAndFlush(res);
	}
	
	protected static synchronized void joinRoom(MemCacheClient client, String remoteAddress,
			String uId, int deskId) {
		Object mObj = client.get(String.valueOf(deskId));
		MjJoinResMsg joinResMsg = new MjJoinResMsg();
		if(mObj != null && !"".equals(((String)mObj))) {
			JSONObject jObj = JSONObject.parseObject((String)mObj);
			if(jObj.size() < 4) {
				jObj.put(uId, remoteAddress);
				client.replace(String.valueOf(deskId), jObj.toString());
				joinResMsg.setStatus(Constant.STATUS_SUCCESS);
			} else {
				joinResMsg.setStatus("FULL");
			}
		} else {
			joinResMsg.setStatus(Constant.STATUS_FAILED);
		}
		GameServerClientMap.get(remoteAddress).writeAndFlush(joinResMsg);
	}
}
