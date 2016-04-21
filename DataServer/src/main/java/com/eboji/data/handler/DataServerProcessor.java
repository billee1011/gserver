package com.eboji.data.handler;

import java.util.concurrent.Executors;

import com.eboji.data.handler.task.BaseTask;
import com.eboji.data.handler.task.CreateRoomTask;
import com.eboji.data.handler.task.JoinRoomTask;
import com.eboji.data.handler.task.LoginTask;
import com.eboji.data.service.DataService;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.CreateRoomMsg;
import com.eboji.model.message.JoinRoomMsg;
import com.eboji.model.message.LoginMsg;

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
		}
		
		if(task != null) {
			DataServerExecutors.getService().submit(task);
		}
	}
}
