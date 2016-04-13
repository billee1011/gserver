package com.eboji.game.handler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.game.logic.mj.GameBaseLogic;
import com.eboji.game.server.transfer.facade.TransferFacade;
import com.eboji.game.util.ConfigUtil;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.dt.DtCreGGRoomMsg;
import com.eboji.model.message.mj.MjCreateMsg;
import com.eboji.model.message.mj.MjJoinMsg;

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
			MjCreateMsg createMsg = (MjCreateMsg)obj;
			createMsg.setRas(remoteAddress);
			createRoom(client, createMsg);
		} else if(obj instanceof MjJoinMsg) {
			//加入房间处理逻辑
			MjJoinMsg joinMsg = (MjJoinMsg)obj;
			joinMsg.setRas(remoteAddress);
			joinRoom(client, joinMsg);
		} else {
			//游戏处理逻辑总开关
			String gid = obj.getGid();
			gameMap.get(Integer.parseInt(gid)).process(obj);
		}
	}
	
	protected synchronized void createRoom(MemCacheClient client, Object object) {
		if(object instanceof MjCreateMsg) {
			MjCreateMsg mjMsg = (MjCreateMsg)object;
			DtCreGGRoomMsg msg = new DtCreGGRoomMsg();
			msg.setCid(mjMsg.getCid());
			msg.setGid(mjMsg.getGid());
			msg.setUid(mjMsg.getUid());
			msg.setGamePrice(mjMsg.getGamePrice());
			msg.setGameType(mjMsg.getGameType());
			msg.setRas(mjMsg.getRas());
			TransferFacade.facade(msg);
		}
	}
	
	protected synchronized void joinRoom(MemCacheClient client, Object object) {
		if(object instanceof MjJoinMsg) {
			MjJoinMsg msg = (MjJoinMsg)object;
			TransferFacade.facade(msg);
 		}
	}
}
