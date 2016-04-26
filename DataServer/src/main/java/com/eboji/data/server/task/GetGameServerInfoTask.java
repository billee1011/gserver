package com.eboji.data.server.task;

import com.eboji.commons.msg.JoinRoomNoMemMsg;
import com.eboji.commons.msg.JoinRoomNoMemResMsg;
import com.eboji.data.server.DataServerClientMap;
import com.eboji.data.service.DataService;
import com.eboji.persist.pojo.GgRoomMem;

public class GetGameServerInfoTask extends BaseTask {
	private JoinRoomNoMemMsg msg;
	
	public GetGameServerInfoTask(String remoteAddress, JoinRoomNoMemMsg msg,
			DataService dataService) {
		super(remoteAddress, dataService);
		this.msg = msg;
	}
	
	@Override
	public Boolean call() throws Exception {
		JoinRoomNoMemResMsg res = null;
		GgRoomMem mem = getGameHost(this.msg);
		
		if(mem != null) {
			res = new JoinRoomNoMemResMsg();
			res.setCid(msg.getCid());
			res.setGid(msg.getGid());
			res.setRas(msg.getRas());
			res.setRoomNo(msg.getRoomNo());
			res.setUid(msg.getUid());
			res.setGameHost(mem.getV());
		}
		
		if(res != null)
			DataServerClientMap.get(remoteAddress).writeAndFlush(res);
		
		return true;
	}

	protected GgRoomMem getGameHost(JoinRoomNoMemMsg msg) {
		GgRoomMem grm = dataService.selectGameInfo(msg);
		return grm;
	}
}
