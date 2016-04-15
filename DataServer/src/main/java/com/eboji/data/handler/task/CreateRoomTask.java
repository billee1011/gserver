package com.eboji.data.handler.task;

import com.eboji.data.handler.DataServerClientMap;
import com.eboji.data.service.DataService;
import com.eboji.model.message.dt.DtCreGGRoomMsg;
import com.eboji.model.message.mj.MjCreateResMsg;
import com.eboji.persist.pojo.GgRoom;

/**
 * 创建房间任务
 * @author zhoucl
 */
public class CreateRoomTask extends BaseTask {
	private DtCreGGRoomMsg msg;
	
	public CreateRoomTask(String remoteAddress, DtCreGGRoomMsg msg, 
			DataService dataService) {
		super(remoteAddress, dataService);
		this.msg = msg;
	}
	@Override
	public Boolean call() throws Exception {
		Object ret = createRoom(this.msg);
		if(ret != null)
			DataServerClientMap.get(remoteAddress).writeAndFlush(ret);
		
		return true;
	}
	
	protected Object createRoom(DtCreGGRoomMsg msg) {
		MjCreateResMsg retObj = new MjCreateResMsg();
		GgRoom room = dataService.createRoom(Integer.parseInt(msg.getGid()), msg.getGameType(), 
				msg.getGamePrice(), Integer.parseInt(msg.getUid()));
		
		retObj.setRas(msg.getRas());
		retObj.setRoomNo(room.getRoomno());
		retObj.setGid(msg.getGid());
		retObj.setUid(msg.getUid());
		
		return retObj;
	}
}
