package com.eboji.data.handler.task;

import com.eboji.data.handler.DataServerClientMap;
import com.eboji.data.service.DataService;
import com.eboji.model.message.CreateRoomMsg;
import com.eboji.model.message.CreateRoomResMsg;
import com.eboji.persist.pojo.GgRoom;

/**
 * 创建房间任务
 * @author zhoucl
 */
public class CreateRoomTask extends BaseTask {
	private CreateRoomMsg msg;
	
	public CreateRoomTask(String remoteAddress, CreateRoomMsg msg, 
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
	
	protected Object createRoom(CreateRoomMsg msg) {
		CreateRoomResMsg retObj = new CreateRoomResMsg();
		GgRoom room = dataService.createRoom(Integer.parseInt(msg.getGid()), msg.getGameType(), 
				msg.getGamePrice(), Integer.parseInt(msg.getUid()));
		
		retObj.setRas(msg.getRas());
		retObj.setRoomNo(room.getRoomno());
		retObj.setGid(msg.getGid());
		retObj.setUid(msg.getUid());
		
		return retObj;
	}
}
