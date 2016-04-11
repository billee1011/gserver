package com.eboji.data.handler;

import com.eboji.data.service.DataService;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.dt.DtCreGGRoomMsg;
import com.eboji.model.message.dt.DtLoginMsg;
import com.eboji.model.message.mj.MjCreateResMsg;
import com.eboji.persist.pojo.GgRoom;

public class DataServerProcessor {
	private DataService dataService;
	
	public DataServerProcessor(DataService dataService) {
		this.dataService = dataService;
	}
	
	public void process(BaseMsg msg, String remoteAddress) {
		Object ret = null;
		if(msg instanceof DtCreGGRoomMsg) {
			ret = createRoom((DtCreGGRoomMsg)msg);
		} else if(msg instanceof DtLoginMsg) {
			login((DtLoginMsg)msg);
		}
		
		if(ret != null)
			DataServerClientMap.get(remoteAddress).writeAndFlush(ret);
	}
	
	protected Object createRoom(DtCreGGRoomMsg msg) {
		Object ret = null;
		GgRoom room = dataService.createRoom(Integer.parseInt(msg.getGid()), msg.getGameType(), 
				msg.getGamePrice(), Integer.parseInt(msg.getUid()));
		
		MjCreateResMsg retObj = new MjCreateResMsg();
		retObj.setRemoteAddress(msg.getRemoteAddress());
		retObj.setRoomNo(room.getRoomno());
		ret = retObj;
		
		return ret;
	}
	
	protected void login(DtLoginMsg msg) {
		dataService.addLogin(Integer.parseInt(msg.getUid()), msg.getCid());
	}
}
