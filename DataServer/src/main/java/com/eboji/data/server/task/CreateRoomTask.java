package com.eboji.data.server.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.Constant;
import com.eboji.commons.msg.CreateRoomMsg;
import com.eboji.commons.msg.CreateRoomResMsg;
import com.eboji.data.server.DataServerClientMap;
import com.eboji.data.service.DataService;
import com.eboji.persist.pojo.GgRoom;

/**
 * 创建房间任务
 * @author zhoucl
 */
public class CreateRoomTask extends BaseTask {
	private final Logger logger = LoggerFactory.getLogger(CreateRoomTask.class);
	
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
		retObj.setRas(msg.getRas());
		retObj.setGid(msg.getGid());
		retObj.setUid(msg.getUid());
		
		String gameServer = remoteAddress.substring(1, 
				remoteAddress.lastIndexOf(Constant.STR_COLON) + 1) + msg.getGamePort();
		try {
			GgRoom room = dataService.createRoom(Integer.parseInt(msg.getGid()), msg.getGameType(), 
					msg.getGamePrice(), Integer.parseInt(msg.getUid()), gameServer);
			retObj.setRoomNo(room.getRoomno());
		} catch (Exception e) {
			logger.error("Create Room Exception.");
		}
		
		return retObj;
	}
}
