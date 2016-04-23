package com.eboji.data.server.task;

import com.eboji.commons.msg.JoinRoomMsg;
import com.eboji.commons.msg.JoinRoomResMsg;
import com.eboji.data.server.DataServerClientMap;
import com.eboji.data.service.DataService;
import com.eboji.persist.pojo.GgRoomPlayer;

public class JoinRoomTask extends BaseTask {
	private JoinRoomMsg msg;
	
	public JoinRoomTask(String remoteAddress, JoinRoomMsg msg,
			DataService dataService) {
		super(remoteAddress, dataService);
		this.msg = msg;
	}
	
	@Override
	public Boolean call() throws Exception {
		JoinRoomResMsg res = null;
		JoinRoomMsg obj = (JoinRoomMsg)this.msg;
		GgRoomPlayer player = joinRoom(obj);
		res = new JoinRoomResMsg();
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
		
		if(res != null)
			DataServerClientMap.get(remoteAddress).writeAndFlush(res);
		
		return true;
	}

	protected GgRoomPlayer joinRoom(JoinRoomMsg msg) {
		GgRoomPlayer player = dataService.joinRoom(Integer.parseInt(msg.getGid()), 
				msg.getRoomNo(), Integer.parseInt(msg.getUid()));
		return player;
	}
}
