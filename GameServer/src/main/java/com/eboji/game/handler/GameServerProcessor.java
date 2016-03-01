package com.eboji.game.handler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.game.logic.mj.GameBaseLogic;
import com.eboji.game.util.ConfigUtil;
import com.eboji.model.constant.Constant;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.mj.MjCreateMsg;
import com.eboji.model.message.mj.MjCreateResMsg;
import com.eboji.model.message.mj.MjJoinMsg;
import com.eboji.model.message.mj.MjJoinResMsg;

public class GameServerProcessor {
	private static final Logger logger = LoggerFactory.getLogger(GameServerProcessor.class);
	
	protected Map<Integer, GameBaseLogic> gameMap = new HashMap<Integer, GameBaseLogic>();
	
	public GameServerProcessor() {
		try {
			Map<Integer, String> maps = ConfigUtil.getGameProps();
			Iterator<Entry<Integer, String>> iter = maps.entrySet().iterator();
			while(iter.hasNext()) {
				Entry<Integer, String> entry = iter.next();
				GameBaseLogic baseLogic = (GameBaseLogic)Class.forName(entry.getValue()).newInstance();
				gameMap.put(entry.getKey(), baseLogic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//游戏逻辑处理入口分发类
	public void process(MemCacheClient client, BaseMsg obj, String remoteAddress) {
		logger.debug("游戏逻辑处理开始");
		
		if(obj instanceof MjCreateMsg) {
			//创建房间处理逻辑
			//1. 计算房间信息
			MjCreateMsg createMsg = (MjCreateMsg)obj;
			String uId = createMsg.getUid();
			createRoom(client, remoteAddress, uId);
		} else if(obj instanceof MjJoinMsg) {
			//加入房间处理逻辑
			MjJoinMsg joinMsg = (MjJoinMsg)obj;
			String deskId = joinMsg.getDeskId();
			String gid = joinMsg.getGid();
			String uId = joinMsg.getUid();
			joinRoom(client, remoteAddress, uId, deskId, gid);
		} else {
			//游戏处理逻辑总开关
			String gid = obj.getGid();
			gameMap.get(Integer.parseInt(gid)).process(obj);
		}
	}
	
	protected synchronized void createRoom(MemCacheClient client,
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
		
		if(client.add(String.valueOf(deskId), json.toString())) {
			logger.info("USER[id= " + uId+ "] CREATE ROOM OK");
			res.setDeskId(String.valueOf(deskId));
		} else {
			logger.error("USER[id= " + uId + "] CREATE ROOM FAILED");
		}
		
		GameServerClientMap.get(remoteAddress).writeAndFlush(res);
	}
	
	protected synchronized void joinRoom(MemCacheClient client, String remoteAddress,
			String uId, String deskId, String gid) {
		try {
			Object mObj = client.get(deskId);
			MjJoinResMsg joinResMsg = new MjJoinResMsg();
			boolean isStart = false;
			if(mObj != null && !"".equals(((String)mObj))) {
				while(true) {
					if(client.add("vec-" + deskId, "1")) {
						JSONObject jObj = JSONObject.parseObject((String)mObj);
						if(jObj.size() < 4) {
							jObj.put(uId, remoteAddress);
							client.replace(String.valueOf(deskId), jObj.toString());
							
							client.add("U-" + uId, String.valueOf(deskId));
							
							if(jObj.size() == 4) {
								isStart = true;
							}
							joinResMsg.setStatus(Constant.STATUS_SUCCESS);
						} else {
							joinResMsg.setStatus("FULL");
						}
						break;
					}
					
					TimeUnit.SECONDS.sleep(1);
				}
			} else {
				joinResMsg.setStatus(Constant.STATUS_FAILED);
			}
			
			GameServerClientMap.get(remoteAddress).writeAndFlush(joinResMsg);
			
			if(isStart) {
				gameMap.get(Integer.parseInt(gid)).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
