package com.eboji.data.handler;

import com.eboji.data.service.DataService;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.LoginMsg;
import com.eboji.model.message.LoginResMsg;
import com.eboji.model.message.dt.DtCreGGRoomMsg;
import com.eboji.model.message.mj.MjCreateResMsg;
import com.eboji.model.message.mj.MjJoinMsg;
import com.eboji.model.message.mj.MjJoinResMsg;
import com.eboji.persist.pojo.GgRoom;
import com.eboji.persist.pojo.GgRoomPlayer;
import com.eboji.persist.pojo.GuUser;

public class DataServerProcessor {
	private DataService dataService;
	
	public DataServerProcessor(DataService dataService) {
		this.dataService = dataService;
	}
	
	public void process(BaseMsg msg, String remoteAddress) {
		Object ret = null;
		if(msg instanceof DtCreGGRoomMsg) {
			ret = createRoom((DtCreGGRoomMsg)msg);
		} else if(msg instanceof LoginMsg) {
			GuUser user = login((LoginMsg)msg);
			LoginResMsg res = new LoginResMsg();
			res.setCid(msg.getCid());
			res.setGid(msg.getGid());
			res.setRas(msg.getRas());
			if(user != null) {
				res.setStatus("OK");
				res.setUid(String.valueOf(user.getId()));
				res.setUsername(user.getUsername());
			} else {
				res.setStatus("FAIL");
			}
			
			ret = res;
		} else if(msg instanceof MjJoinMsg) {
			MjJoinMsg obj = (MjJoinMsg)msg;
			GgRoomPlayer player = joinRoom(obj);
			MjJoinResMsg res = new MjJoinResMsg();
			res.setCid(obj.getCid());
			res.setGid(obj.getGid());
			res.setRas(obj.getRas());
			res.setRoomNo(obj.getRoomNo());
			res.setUid(obj.getUid());
			if(player != null) {
				if(player.getId() > 0) {
					res.setStatus(1);	//加入成功
				} else {
					res.setStatus(-1);	//满员
				}
			} else {
				res.setStatus(0);	//房间不存在
			}
			
			ret = res;
		}
		
		if(ret != null)
			DataServerClientMap.get(remoteAddress).writeAndFlush(ret);
	}
	
	protected Object createRoom(DtCreGGRoomMsg msg) {
		Object ret = null;
		GgRoom room = dataService.createRoom(Integer.parseInt(msg.getGid()), msg.getGameType(), 
				msg.getGamePrice(), Integer.parseInt(msg.getUid()));
		
		MjCreateResMsg retObj = new MjCreateResMsg();
		retObj.setRas(msg.getRas());
		retObj.setRoomNo(room.getRoomno());
		retObj.setGid(msg.getGid());
		retObj.setUid(msg.getUid());
		ret = retObj;
		
		return ret;
	}
	
	protected GuUser login(LoginMsg msg) {
		GuUser user = dataService.login(msg);
		return user;
	}
	
	protected GgRoomPlayer joinRoom(MjJoinMsg msg) {
		GgRoomPlayer player = dataService.joinRoom(Integer.parseInt(msg.getGid()), 
				msg.getRoomNo(), Integer.parseInt(msg.getUid()));
		return player;
	}
}
