package com.eboji.data.server;

import java.util.concurrent.Executors;

import com.eboji.commons.msg.BaseMsg;
import com.eboji.commons.msg.CreateRoomMsg;
import com.eboji.commons.msg.JoinRoomMsg;
import com.eboji.commons.msg.JoinRoomNoMemMsg;
import com.eboji.commons.msg.LoginMsg;
import com.eboji.data.server.task.BaseTask;
import com.eboji.data.server.task.CreateRoomTask;
import com.eboji.data.server.task.GetGameServerInfoTask;
import com.eboji.data.server.task.JoinRoomTask;
import com.eboji.data.server.task.LoginTask;
import com.eboji.data.service.DataService;

/**
 * 数据服务处理核心转发类
 * @author zhoucl
 *
 */
public class DataServerProcessor {
	private DataService dataService;
	
	public DataServerProcessor(DataService dataService, int poolSize) {
		this.dataService = dataService;
		DataServerExecutors.setService(Executors.
				newFixedThreadPool(poolSize));
	}
	
	/**
	 * 转发处理方法
	 * @param msg
	 * @param remoteAddress
	 */
	public void process(BaseMsg msg, String remoteAddress) {
		BaseTask task = null;
		if(msg instanceof CreateRoomMsg) {
			task = new CreateRoomTask(remoteAddress, 
					(CreateRoomMsg)msg, dataService);
		} else if(msg instanceof LoginMsg) {
			task = new LoginTask(remoteAddress, 
					(LoginMsg)msg, dataService);
		} else if(msg instanceof JoinRoomMsg) {
			task = new JoinRoomTask(remoteAddress, 
					(JoinRoomMsg)msg, dataService);
		} else if(msg instanceof JoinRoomNoMemMsg) {
			task = new GetGameServerInfoTask(remoteAddress, 
					(JoinRoomNoMemMsg)msg, dataService);
		}
		
		if(task != null) {
			DataServerExecutors.getService().submit(task);
		}
	}
}
